package com.formssubmits.servcie.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formssubmits.domian.EntInfos;
import com.formssubmits.mapper.EntInfosMapper;
import com.formssubmits.servcie.EntInfosService;

/**
 * 
 * 
 * @ClassName:  EntInfosBean
 * @Description: entInfos   
 * @author: gongrunz
 * @date:   2019-12-30 20:45:46
 *
 */
@Service
public class EntInfosServiceImpl  implements EntInfosService{

	@Autowired
	EntInfosMapper entInfosMapper;
	
	@Override
	public List<EntInfos> findAll() {
		return entInfosMapper.findAll();
	}
	
	
}
