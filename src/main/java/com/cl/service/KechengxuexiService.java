package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.KechengxuexiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KechengxuexiView;


/**
 * 课程学习
 *
 * @author 
 * @email 
 * @date 2024-04-08 23:12:05
 */
public interface KechengxuexiService extends IService<KechengxuexiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KechengxuexiView> selectListView(Wrapper<KechengxuexiEntity> wrapper);
   	
   	KechengxuexiView selectView(@Param("ew") Wrapper<KechengxuexiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KechengxuexiEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<KechengxuexiEntity> wrapper);

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<KechengxuexiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<KechengxuexiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<KechengxuexiEntity> wrapper);



}

