package com.formssubmits.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.formssubmits.domian.EntInfos;

/**
 * 
 * 
 * @ClassName:  EntInfosBean
 * @Description: entInfos   
 * @author: gongrunz
 * @date:   2019-12-30 20:45:46
 *
 */
@Mapper
public interface EntInfosMapper {

	
	/**
	 * 提醒：
	 * Mapper命名规范(注意和service里面的方法区分)
	 * 增加用insert	 	如insertUserInfo
	 * 删除用delete		如deleteUserById
	 * 修改用update		如updateUserInfo
	 * 查询用select  	如selectAllUser
	 */
	List<EntInfos> findAll();
}
