package com.formssubmits.utils;

/**
 * Description: 
 * @author gongrunz
 *
 */
public class CodeMsg {
	
	private int resultCode;
	private String message;
	
	//通用异常
	private static CodeMsg codeMsg_SUCCESS = new CodeMsg(1,"请求成功");
	private static CodeMsg codeMsg_SERVER_EXCEPTION = new CodeMsg(500100,"服务端异常");
	private static CodeMsg codeMsg_PARAMETER_ISNULL = new CodeMsg(500101,"输入参数为空");
	
	//业务异常
	private static CodeMsg codeMsg_USER_NOT_EXSIST = new CodeMsg(500102,"用户不存在");
	private static CodeMsg codeMsg_ONLINE_USER_OVER = new CodeMsg(500103,"在线用户数超出允许登录的最大用户限制");
	private static CodeMsg codeMsg_SESSION_NOT_EXSIST = new CodeMsg(500104,"不存在离线session数据");
	private static CodeMsg codeMsg_NOT_FIND_DATA = new CodeMsg(500105,"查找不到对应数据");
	
	public CodeMsg(int resultCode,String message) {
		this.resultCode = resultCode;
		this.message = message;
	}

	public int getResultCode() {
		return resultCode;
	}

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
