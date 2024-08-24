package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZuoyefafangEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZuoyefafangView;


/**
 * 作业发放
 *
 * @author 
 * @email 
 * @date 2024-04-08 23:12:05
 */
public interface ZuoyefafangService extends IService<ZuoyefafangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZuoyefafangView> selectListView(Wrapper<ZuoyefafangEntity> wrapper);
   	
   	ZuoyefafangView selectView(@Param("ew") Wrapper<ZuoyefafangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZuoyefafangEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<ZuoyefafangEntity> wrapper);

}

