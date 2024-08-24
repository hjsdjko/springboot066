package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZhuguantiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZhuguantiView;


/**
 * 主观题
 *
 * @author 
 * @email 
 * @date 2024-04-08 23:12:05
 */
public interface ZhuguantiService extends IService<ZhuguantiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhuguantiView> selectListView(Wrapper<ZhuguantiEntity> wrapper);
   	
   	ZhuguantiView selectView(@Param("ew") Wrapper<ZhuguantiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhuguantiEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<ZhuguantiEntity> wrapper);

}

