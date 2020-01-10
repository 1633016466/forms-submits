package com.formssubmits.domian;

/**
 * 
 * 
 * @ClassName:  User
 * @Description: user   
 * @author: 龚润忠
 * @date:   2019-12-30 20:39:45
 *
 */
public class User {

	/** 主键ID **/
	private Long id;
	/** name **/
	private String name;
	/** age **/
	private Integer age;
	/** 外键 **/
	private Long entId;
	
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	public Long getEntId() {
		return entId;
	}
	
	public void setEntId(Long entId) {
		this.entId = entId;
	}
	
	
}
