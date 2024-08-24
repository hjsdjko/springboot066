package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.DiscussxuexiziyuanDao;
import com.cl.entity.DiscussxuexiziyuanEntity;
import com.cl.service.DiscussxuexiziyuanService;
import com.cl.entity.view.DiscussxuexiziyuanView;

@Service("discussxuexiziyuanService")
public class DiscussxuexiziyuanServiceImpl extends ServiceImpl<DiscussxuexiziyuanDao, DiscussxuexiziyuanEntity> implements DiscussxuexiziyuanService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<DiscussxuexiziyuanEntity> wrapper) {
		Page<DiscussxuexiziyuanView> page =new Query<DiscussxuexiziyuanView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussxuexiziyuanEntity> page = this.selectPage(
                new Query<DiscussxuexiziyuanEntity>(params).getPage(),
                new EntityWrapper<DiscussxuexiziyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussxuexiziyuanEntity> wrapper) {
		  Page<DiscussxuexiziyuanView> page =new Query<DiscussxuexiziyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussxuexiziyuanView> selectListView(Wrapper<DiscussxuexiziyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussxuexiziyuanView selectView(Wrapper<DiscussxuexiziyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
