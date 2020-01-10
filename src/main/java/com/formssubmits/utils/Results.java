package com.formssubmits.utils;

/**
 * Description: 
 * @author gongrunz
 *
 */
public class Results<T> {
	
	private int resultCode;
	private String message;
	private T data;
	
	public Results(T data) {
		this.resultCode = 1;
		this.message = "请求成功";
		this.data = data;
	}
	
	private Results(CodeMsg codeMsg) {
		if(codeMsg == null) {
			return;
		}
		this.resultCode = codeMsg.getResultCode();
		this.message = codeMsg.getMessage();
	}
	
	/**
	 * @Description 成功时候的调用
	 * @return 
	 */
	public static <T> Results<T> success(T data){
		return new Results<>(data);
	}
	
	/**
	 * @Description 成功 - 不需要传入参数
	 * @return 
	 */
	@SuppressWarnings("unchecked")
	public static <T> Results<T> success(){
		return (Results<T>) success("");
	}
	
	/**
	 * @Description 失败的时候调用
	 * @return 
	 */
	public static <T> Results<T> error(CodeMsg codeMsg){
		return new Results<T>(codeMsg);
	}
	
	/**
	 * @Description 失败的时候调用-扩展消息参数
	 * @param codeMsg
	 * @param message
	 * @return
	 */
	public static <T> Results<T> error(CodeMsg codeMsg,String message){
		codeMsg.setMessage(codeMsg.getMessage()+"--"+message);
		return new Results<T>(codeMsg);
	}
	
	public T getData() {
		return data;
	}
	
	public String getMessage() {
		return message;
	}
	
	public int getResultCode() {
		return resultCode;
	}
}
