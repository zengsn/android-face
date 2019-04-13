package com.gdp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdp.base.BaseServiceImpl;
import com.gdp.entity.Announcement;
import com.gdp.mapper.AnnouncementMapper;
import com.gdp.service.AnnouncementService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

@Service("announcementService")
public class AnnouncementServiceImpl extends BaseServiceImpl<AnnouncementMapper, Announcement> implements AnnouncementService {

	@Autowired
	private AnnouncementMapper announcementMapper;

	@Override
	public List<Announcement> selectAllWithOrder() {
        Example example = new Example(Announcement.class);
        example.setOrderByClause("priority asc, createtime desc");
        return this.announcementMapper.selectByExample(example);
	}
	
	@Override
	public List<Announcement> listAnnouncementByPriority(Integer priority) {
		Example example = new Example(Announcement.class);
		Criteria criteria = example.createCriteria();
		example.setOrderByClause("createtime desc");
		
		// property 是实体类的属性名, value 是属性值
        criteria.andEqualTo("priority", priority);
        return this.announcementMapper.selectByExample(example);
	}



	
}
