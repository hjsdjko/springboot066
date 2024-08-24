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


import com.cl.dao.PigaixinxiDao;
import com.cl.entity.PigaixinxiEntity;
import com.cl.service.PigaixinxiService;
import com.cl.entity.view.PigaixinxiView;

@Service("pigaixinxiService")
public class PigaixinxiServiceImpl extends ServiceImpl<PigaixinxiDao, PigaixinxiEntity> implements PigaixinxiService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<PigaixinxiEntity> wrapper) {
		Page<PigaixinxiView> page =new Query<PigaixinxiView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PigaixinxiEntity> page = this.selectPage(
                new Query<PigaixinxiEntity>(params).getPage(),
                new EntityWrapper<PigaixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PigaixinxiEntity> wrapper) {
		  Page<PigaixinxiView> page =new Query<PigaixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<PigaixinxiView> selectListView(Wrapper<PigaixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PigaixinxiView selectView(Wrapper<PigaixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
