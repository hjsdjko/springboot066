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


import com.cl.dao.ZuoyefafangDao;
import com.cl.entity.ZuoyefafangEntity;
import com.cl.service.ZuoyefafangService;
import com.cl.entity.view.ZuoyefafangView;

@Service("zuoyefafangService")
public class ZuoyefafangServiceImpl extends ServiceImpl<ZuoyefafangDao, ZuoyefafangEntity> implements ZuoyefafangService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<ZuoyefafangEntity> wrapper) {
		Page<ZuoyefafangView> page =new Query<ZuoyefafangView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZuoyefafangEntity> page = this.selectPage(
                new Query<ZuoyefafangEntity>(params).getPage(),
                new EntityWrapper<ZuoyefafangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZuoyefafangEntity> wrapper) {
		  Page<ZuoyefafangView> page =new Query<ZuoyefafangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ZuoyefafangView> selectListView(Wrapper<ZuoyefafangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZuoyefafangView selectView(Wrapper<ZuoyefafangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
