package com.cl.dao;

import com.cl.entity.DiscusskechengxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscusskechengxinxiView;


/**
 * 课程信息评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-08 23:12:05
 */
public interface DiscusskechengxinxiDao extends BaseMapper<DiscusskechengxinxiEntity> {
	
	List<DiscusskechengxinxiView> selectListView(@Param("ew") Wrapper<DiscusskechengxinxiEntity> wrapper);

	List<DiscusskechengxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusskechengxinxiEntity> wrapper);
	
	DiscusskechengxinxiView selectView(@Param("ew") Wrapper<DiscusskechengxinxiEntity> wrapper);
	
	List<DiscusskechengxinxiView> selectGroupBy(Pagination page,@Param("ew") Wrapper<DiscusskechengxinxiEntity> wrapper);

}
