package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.PigaixinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.PigaixinxiView;


/**
 * 批改信息
 *
 * @author 
 * @email 
 * @date 2024-04-08 23:12:05
 */
public interface PigaixinxiService extends IService<PigaixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PigaixinxiView> selectListView(Wrapper<PigaixinxiEntity> wrapper);
   	
   	PigaixinxiView selectView(@Param("ew") Wrapper<PigaixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PigaixinxiEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<PigaixinxiEntity> wrapper);

}

