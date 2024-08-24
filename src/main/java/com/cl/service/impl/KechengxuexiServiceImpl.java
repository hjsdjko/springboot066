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


import com.cl.dao.KechengxuexiDao;
import com.cl.entity.KechengxuexiEntity;
import com.cl.service.KechengxuexiService;
import com.cl.entity.view.KechengxuexiView;

@Service("kechengxuexiService")
public class KechengxuexiServiceImpl extends ServiceImpl<KechengxuexiDao, KechengxuexiEntity> implements KechengxuexiService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<KechengxuexiEntity> wrapper) {
		Page<KechengxuexiView> page =new Query<KechengxuexiView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KechengxuexiEntity> page = this.selectPage(
                new Query<KechengxuexiEntity>(params).getPage(),
                new EntityWrapper<KechengxuexiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KechengxuexiEntity> wrapper) {
		  Page<KechengxuexiView> page =new Query<KechengxuexiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<KechengxuexiView> selectListView(Wrapper<KechengxuexiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KechengxuexiView selectView(Wrapper<KechengxuexiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<KechengxuexiEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<KechengxuexiEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<KechengxuexiEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
