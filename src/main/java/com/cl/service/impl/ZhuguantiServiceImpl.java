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


import com.cl.dao.ZhuguantiDao;
import com.cl.entity.ZhuguantiEntity;
import com.cl.service.ZhuguantiService;
import com.cl.entity.view.ZhuguantiView;

@Service("zhuguantiService")
public class ZhuguantiServiceImpl extends ServiceImpl<ZhuguantiDao, ZhuguantiEntity> implements ZhuguantiService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<ZhuguantiEntity> wrapper) {
		Page<ZhuguantiView> page =new Query<ZhuguantiView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhuguantiEntity> page = this.selectPage(
                new Query<ZhuguantiEntity>(params).getPage(),
                new EntityWrapper<ZhuguantiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhuguantiEntity> wrapper) {
		  Page<ZhuguantiView> page =new Query<ZhuguantiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ZhuguantiView> selectListView(Wrapper<ZhuguantiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhuguantiView selectView(Wrapper<ZhuguantiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
