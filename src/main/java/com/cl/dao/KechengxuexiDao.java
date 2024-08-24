package com.cl.dao;

import com.cl.entity.KechengxuexiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KechengxuexiView;


/**
 * 课程学习
 * 
 * @author 
 * @email 
 * @date 2024-04-08 23:12:05
 */
public interface KechengxuexiDao extends BaseMapper<KechengxuexiEntity> {
	
	List<KechengxuexiView> selectListView(@Param("ew") Wrapper<KechengxuexiEntity> wrapper);

	List<KechengxuexiView> selectListView(Pagination page,@Param("ew") Wrapper<KechengxuexiEntity> wrapper);
	
	KechengxuexiView selectView(@Param("ew") Wrapper<KechengxuexiEntity> wrapper);
	
	List<KechengxuexiView> selectGroupBy(Pagination page,@Param("ew") Wrapper<KechengxuexiEntity> wrapper);

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<KechengxuexiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<KechengxuexiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<KechengxuexiEntity> wrapper);



}
