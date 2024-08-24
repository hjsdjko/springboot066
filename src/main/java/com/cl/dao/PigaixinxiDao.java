package com.cl.dao;

import com.cl.entity.PigaixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.PigaixinxiView;


/**
 * 批改信息
 * 
 * @author 
 * @email 
 * @date 2024-04-08 23:12:05
 */
public interface PigaixinxiDao extends BaseMapper<PigaixinxiEntity> {
	
	List<PigaixinxiView> selectListView(@Param("ew") Wrapper<PigaixinxiEntity> wrapper);

	List<PigaixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<PigaixinxiEntity> wrapper);
	
	PigaixinxiView selectView(@Param("ew") Wrapper<PigaixinxiEntity> wrapper);
	
	List<PigaixinxiView> selectGroupBy(Pagination page,@Param("ew") Wrapper<PigaixinxiEntity> wrapper);

}
