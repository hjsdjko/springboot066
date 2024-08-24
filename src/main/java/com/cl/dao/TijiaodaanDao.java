package com.cl.dao;

import com.cl.entity.TijiaodaanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TijiaodaanView;


/**
 * 提交答案
 * 
 * @author 
 * @email 
 * @date 2024-04-08 23:12:05
 */
public interface TijiaodaanDao extends BaseMapper<TijiaodaanEntity> {
	
	List<TijiaodaanView> selectListView(@Param("ew") Wrapper<TijiaodaanEntity> wrapper);

	List<TijiaodaanView> selectListView(Pagination page,@Param("ew") Wrapper<TijiaodaanEntity> wrapper);
	
	TijiaodaanView selectView(@Param("ew") Wrapper<TijiaodaanEntity> wrapper);
	
	List<TijiaodaanView> selectGroupBy(Pagination page,@Param("ew") Wrapper<TijiaodaanEntity> wrapper);

}
