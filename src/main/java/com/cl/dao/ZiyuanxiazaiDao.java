package com.cl.dao;

import com.cl.entity.ZiyuanxiazaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZiyuanxiazaiView;


/**
 * 资源下载
 * 
 * @author 
 * @email 
 * @date 2024-04-08 23:12:04
 */
public interface ZiyuanxiazaiDao extends BaseMapper<ZiyuanxiazaiEntity> {
	
	List<ZiyuanxiazaiView> selectListView(@Param("ew") Wrapper<ZiyuanxiazaiEntity> wrapper);

	List<ZiyuanxiazaiView> selectListView(Pagination page,@Param("ew") Wrapper<ZiyuanxiazaiEntity> wrapper);
	
	ZiyuanxiazaiView selectView(@Param("ew") Wrapper<ZiyuanxiazaiEntity> wrapper);
	
	List<ZiyuanxiazaiView> selectGroupBy(Pagination page,@Param("ew") Wrapper<ZiyuanxiazaiEntity> wrapper);

}
