package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XuexiziyuanEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XuexiziyuanView;


/**
 * 学习资源
 *
 * @author 
 * @email 
 * @date 2024-04-08 23:12:04
 */
public interface XuexiziyuanService extends IService<XuexiziyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XuexiziyuanView> selectListView(Wrapper<XuexiziyuanEntity> wrapper);
   	
   	XuexiziyuanView selectView(@Param("ew") Wrapper<XuexiziyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XuexiziyuanEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<XuexiziyuanEntity> wrapper);

}

