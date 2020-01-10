package com.formssubmits.servcie;

import java.util.List;

import com.formssubmits.domian.EntInfos;

/**
 * 
 * 
 * @ClassName:  EntInfos
 * @Description: entInfos   
 * @author: gongrunz
 * @date:   2019-12-30 20:45:46
 *
 */
public interface EntInfosService {

	
	/**
	 * 提醒：
	 * Service命名规范(注意和Mapper里面的方法区分)
	 * 增加用save	 	如saveUserInfo
	 * 删除用remove		如removeUserById
	 * 修改用modity		如modityUserInfo
	 * 查询用find  		如findAllUser
	 */
	List<EntInfos> findAll();
}
