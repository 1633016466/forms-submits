package com.formssubmits.controller;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.formssubmits.domian.EntInfos;
import com.formssubmits.domian.User;
import com.formssubmits.servcie.EntInfosService;
import com.formssubmits.utils.Results;



/**
 * 
 * 
 * @ClassName:  LoginController
 * @Description: 登录逻辑
 * @author: gongrunz
 * @date:   2019年12月30日20:38:04
 *
 */
@Controller
public class LoginController {
	
	@Autowired
	EntInfosService entInfosService;

	/**
	 * @description 查询全部
	 * @return
	 */
	@RequestMapping("/queryList")
	public String findEntInfo(Model model){
		List<EntInfos> entInfosList = entInfosService.findAll();
		model.addAttribute("entInfosList", entInfosList);
		return "entInfo/entInfo_list";
	}
	
	/**
	 * @description 数据+文件上传提交
	 * @param user
	 * @param file
	 * @return
	 */
	@RequestMapping("/submit")
	@ResponseBody
	public Results<?> addSubmit(User user,@RequestParam("file") MultipartFile file) {
		if(!file.isEmpty()){
            //设置文件的保存路径
            String filePath = "D:\\MultipartFile\\" + file.getOriginalFilename();
            //转存文件
            try {
                file.transferTo(new File(filePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//		System.out.println(user.getName());
//		System.out.println(file.getOriginalFilename());
		return Results.success();
	}
	
	@RequestMapping(value = "/admin/login1",method = RequestMethod.GET)
	public String page_login1(){
		return "main/login";
	}
	
//  	@RequestMapping(value = "admin/login",method = RequestMethod.POST)
//	@ResponseBody
//	public String page(@RequestParam("username")String username,@RequestParam("password")String password){
//		Subject subject = SecurityUtils.getSubject();
//        CustomUsernamePasswordToken usernamePasswordToken = new CustomUsernamePasswordToken(username,password);
//        subject.login(usernamePasswordToken);
//		 /*catch (UnknownAccountException e) {
//			return ResultInfoUtil.fail( "没有该用户");
//		} catch (DisabledAccountException e){
//			return ResultInfoUtil.fail("账号已禁用");
//		} catch (IncorrectCredentialsException  e){
//			return ResultInfoUtil.fail("密码错误");
//		} catch (Exception e){
//			e.printStackTrace();
//			return ResultInfoUtil.error("系统异常，请联系管理员");
//		}*/
//		return ResultInfoUtil.success("登录成功");
//	}
  	
//  	@RequestMapping(value = "admin/logout",method = RequestMethod.GET)
//  	public String logout(){
//  		Subject subject = SecurityUtils.getSubject();
//  		subject.logout();
//  		return "redirect:admin/login";
//  	}
	
	
}
