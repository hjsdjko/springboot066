package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.KechengfenleiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.KechengfenleiView;


/**
 * 课程分类
 *
 * @author 
 * @email 
 * @date 2024-04-08 23:12:04
 */
public interface KechengfenleiService extends IService<KechengfenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KechengfenleiView> selectListView(Wrapper<KechengfenleiEntity> wrapper);
   	
   	KechengfenleiView selectView(@Param("ew") Wrapper<KechengfenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KechengfenleiEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<KechengfenleiEntity> wrapper);

}

