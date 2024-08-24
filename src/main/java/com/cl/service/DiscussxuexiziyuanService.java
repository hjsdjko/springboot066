package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussxuexiziyuanEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussxuexiziyuanView;


/**
 * 学习资源评论表
 *
 * @author 
 * @email 
 * @date 2024-04-08 23:12:05
 */
public interface DiscussxuexiziyuanService extends IService<DiscussxuexiziyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussxuexiziyuanView> selectListView(Wrapper<DiscussxuexiziyuanEntity> wrapper);
   	
   	DiscussxuexiziyuanView selectView(@Param("ew") Wrapper<DiscussxuexiziyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussxuexiziyuanEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<DiscussxuexiziyuanEntity> wrapper);

}

