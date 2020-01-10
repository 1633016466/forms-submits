package com.formssubmits.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.RequestContext;

import com.formssubmits.domian.User;
import com.formssubmits.servcie.EntInfosService;



/**
 * 
 * 
 * @ClassName:  UploadFilesController
 * @Description: 文件相关(上传等等)
 * @author: gongrunz
 * @date:   2020年1月8日14:38:20
 *
 */
@Controller
public class UploadFilesController {
	
	@Autowired
	EntInfosService entInfosService;

	
	/**
	 * @description 数据+文件上传提交
	 * @param user
	 * @param file
	 * @return
	 */
	@RequestMapping("/upload")
	@ResponseBody
	public void addSubmit(User user,@RequestParam("file") MultipartFile file,HttpServletRequest request,HttpServletResponse response) throws Exception{
		String message = "";
		try {
			String savePath = request.getServletContext().getRealPath("/WEB-INF/upload");
			String tmpPath = request.getServletContext().getRealPath("/WEB-INF/temp");
			File files = new File(savePath);
			if(!files.exists() && !files.isDirectory()) {
				System.out.println(savePath + "目录不存在，需要创建");
				files.mkdir();
			}
			File tmpFile = new File(tmpPath);
			if(!tmpFile.exists() && !tmpFile.isDirectory()) {
				System.out.println(tmpPath + "目录不存在，需要创建");
				tmpFile.mkdir();
			}
			
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//缓冲区大小设置
			factory.setSizeThreshold(1024 * 100);
			factory.setRepository(tmpFile);
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setProgressListener((pBytesRead,pContentLength,args2) -> System.out.println("文件大小为：" + pContentLength + ",当前已处理：" + pBytesRead));
			upload.setHeaderEncoding("UTF-8");
			if(!ServletFileUpload.isMultipartContent(request)) {
				//按照传统方式获取数据
				return;
			}
			//设置上传单个文件的大小的最大值，目前是设置为1024 * 1024 字节，也就是1MB
			upload.setFileSizeMax(1024*1024*10);
			//设置上传文件总量的最大值，最大值 = 同时上传的多个文件的大小的最大值的和，目前设置为10MB
			upload.setSizeMax(1024 * 1024 * 10);
			
			List<FileItem> list = upload.parseRequest((org.apache.tomcat.util.http.fileupload.RequestContext) new RequestContext(request));
			for(FileItem item : list) {
				if(item.isFormField()) {
					String name = item.getFieldName();
					String value=item.getString("UTF-8");
					//form表单提交过的enctype="multipart/form-data"
					request.setAttribute(name, value);
					System.out.println(name+"="+value);
				}else {
					String filename=item.getName();
					System.out.println(filename);
					if(filename == null || "".equals(filename.trim())) {
						continue;
					}
					filename=filename.substring(filename.lastIndexOf(File.separator)+1);
					InputStream in=item.getInputStream();
					FileOutputStream out = new FileOutputStream(savePath+File.separator+filename);
					byte[] buffer=new byte[1024];
					int len;
					while((len=in.read(buffer))>0) {
						out.write(buffer,0,len);
					}
					in.close();
					out.close();
					//删除处理文件上传时生成的临时文件
					item.delete();
				}
			}
		} catch (FileUploadBase.FileSizeLimitExceededException e) {
			message="单个文件超出最大值";
			System.out.println(message);
			request.setAttribute("message", message);
			request.getRequestDispatcher("/WEB-IF/page/message.jsp").forward(request, response);
		} catch(FileUploadBase.SizeLimitExceededException e) {
			message="上传文件总大小超出最大值";
			System.out.println(message);
			request.setAttribute("message", message);
			request.getRequestDispatcher("/WEB-IF/page/message.jsp").forward(request, response);
		} catch(FileUploadException e) {
			message="上传文件失败";
			System.out.println(message);
			request.setAttribute("message", message);
			request.getRequestDispatcher("/WEB-IF/page/message.jsp").forward(request, response);
		}
		request.getRequestDispatcher("/WEB-IF/page/file_upload_result.jsp").forward(request, response);
	}
}
