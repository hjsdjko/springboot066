package com.cl.dao;

import com.cl.entity.ZuoyetijiaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZuoyetijiaoView;


/**
 * 作业提交
 * 
 * @author 
 * @email 
 * @date 2024-04-08 23:12:04
 */
public interface ZuoyetijiaoDao extends BaseMapper<ZuoyetijiaoEntity> {
	
	List<ZuoyetijiaoView> selectListView(@Param("ew") Wrapper<ZuoyetijiaoEntity> wrapper);

	List<ZuoyetijiaoView> selectListView(Pagination page,@Param("ew") Wrapper<ZuoyetijiaoEntity> wrapper);
	
	ZuoyetijiaoView selectView(@Param("ew") Wrapper<ZuoyetijiaoEntity> wrapper);
	
	List<ZuoyetijiaoView> selectGroupBy(Pagination page,@Param("ew") Wrapper<ZuoyetijiaoEntity> wrapper);

}
