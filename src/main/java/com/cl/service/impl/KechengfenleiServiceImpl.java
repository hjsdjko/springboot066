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


import com.cl.dao.KechengfenleiDao;
import com.cl.entity.KechengfenleiEntity;
import com.cl.service.KechengfenleiService;
import com.cl.entity.view.KechengfenleiView;

@Service("kechengfenleiService")
public class KechengfenleiServiceImpl extends ServiceImpl<KechengfenleiDao, KechengfenleiEntity> implements KechengfenleiService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<KechengfenleiEntity> wrapper) {
		Page<KechengfenleiView> page =new Query<KechengfenleiView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KechengfenleiEntity> page = this.selectPage(
                new Query<KechengfenleiEntity>(params).getPage(),
                new EntityWrapper<KechengfenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KechengfenleiEntity> wrapper) {
		  Page<KechengfenleiView> page =new Query<KechengfenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<KechengfenleiView> selectListView(Wrapper<KechengfenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KechengfenleiView selectView(Wrapper<KechengfenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
