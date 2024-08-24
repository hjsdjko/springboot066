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


import com.cl.dao.TijiaodaanDao;
import com.cl.entity.TijiaodaanEntity;
import com.cl.service.TijiaodaanService;
import com.cl.entity.view.TijiaodaanView;

@Service("tijiaodaanService")
public class TijiaodaanServiceImpl extends ServiceImpl<TijiaodaanDao, TijiaodaanEntity> implements TijiaodaanService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<TijiaodaanEntity> wrapper) {
		Page<TijiaodaanView> page =new Query<TijiaodaanView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TijiaodaanEntity> page = this.selectPage(
                new Query<TijiaodaanEntity>(params).getPage(),
                new EntityWrapper<TijiaodaanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TijiaodaanEntity> wrapper) {
		  Page<TijiaodaanView> page =new Query<TijiaodaanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<TijiaodaanView> selectListView(Wrapper<TijiaodaanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TijiaodaanView selectView(Wrapper<TijiaodaanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
