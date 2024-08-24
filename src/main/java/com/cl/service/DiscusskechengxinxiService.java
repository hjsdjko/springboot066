package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscusskechengxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscusskechengxinxiView;


/**
 * 课程信息评论表
 *
 * @author 
 * @email 
 * @date 2024-04-08 23:12:05
 */
public interface DiscusskechengxinxiService extends IService<DiscusskechengxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusskechengxinxiView> selectListView(Wrapper<DiscusskechengxinxiEntity> wrapper);
   	
   	DiscusskechengxinxiView selectView(@Param("ew") Wrapper<DiscusskechengxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusskechengxinxiEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<DiscusskechengxinxiEntity> wrapper);

}

