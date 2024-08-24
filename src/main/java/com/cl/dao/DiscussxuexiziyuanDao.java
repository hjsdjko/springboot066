package com.cl.dao;

import com.cl.entity.DiscussxuexiziyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussxuexiziyuanView;


/**
 * 学习资源评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-08 23:12:05
 */
public interface DiscussxuexiziyuanDao extends BaseMapper<DiscussxuexiziyuanEntity> {
	
	List<DiscussxuexiziyuanView> selectListView(@Param("ew") Wrapper<DiscussxuexiziyuanEntity> wrapper);

	List<DiscussxuexiziyuanView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussxuexiziyuanEntity> wrapper);
	
	DiscussxuexiziyuanView selectView(@Param("ew") Wrapper<DiscussxuexiziyuanEntity> wrapper);
	
	List<DiscussxuexiziyuanView> selectGroupBy(Pagination page,@Param("ew") Wrapper<DiscussxuexiziyuanEntity> wrapper);

}
