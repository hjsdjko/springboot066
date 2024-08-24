package com.cl.dao;

import com.cl.entity.KechengfenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KechengfenleiView;


/**
 * 课程分类
 * 
 * @author 
 * @email 
 * @date 2024-04-08 23:12:04
 */
public interface KechengfenleiDao extends BaseMapper<KechengfenleiEntity> {
	
	List<KechengfenleiView> selectListView(@Param("ew") Wrapper<KechengfenleiEntity> wrapper);

	List<KechengfenleiView> selectListView(Pagination page,@Param("ew") Wrapper<KechengfenleiEntity> wrapper);
	
	KechengfenleiView selectView(@Param("ew") Wrapper<KechengfenleiEntity> wrapper);
	
	List<KechengfenleiView> selectGroupBy(Pagination page,@Param("ew") Wrapper<KechengfenleiEntity> wrapper);

}
