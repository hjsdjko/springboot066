package com.cl.dao;

import com.cl.entity.ZuoyefafangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZuoyefafangView;


/**
 * 作业发放
 * 
 * @author 
 * @email 
 * @date 2024-04-08 23:12:05
 */
public interface ZuoyefafangDao extends BaseMapper<ZuoyefafangEntity> {
	
	List<ZuoyefafangView> selectListView(@Param("ew") Wrapper<ZuoyefafangEntity> wrapper);

	List<ZuoyefafangView> selectListView(Pagination page,@Param("ew") Wrapper<ZuoyefafangEntity> wrapper);
	
	ZuoyefafangView selectView(@Param("ew") Wrapper<ZuoyefafangEntity> wrapper);
	
	List<ZuoyefafangView> selectGroupBy(Pagination page,@Param("ew") Wrapper<ZuoyefafangEntity> wrapper);

}
