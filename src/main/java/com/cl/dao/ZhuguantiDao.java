package com.cl.dao;

import com.cl.entity.ZhuguantiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhuguantiView;


/**
 * 主观题
 * 
 * @author 
 * @email 
 * @date 2024-04-08 23:12:05
 */
public interface ZhuguantiDao extends BaseMapper<ZhuguantiEntity> {
	
	List<ZhuguantiView> selectListView(@Param("ew") Wrapper<ZhuguantiEntity> wrapper);

	List<ZhuguantiView> selectListView(Pagination page,@Param("ew") Wrapper<ZhuguantiEntity> wrapper);
	
	ZhuguantiView selectView(@Param("ew") Wrapper<ZhuguantiEntity> wrapper);
	
	List<ZhuguantiView> selectGroupBy(Pagination page,@Param("ew") Wrapper<ZhuguantiEntity> wrapper);

}
