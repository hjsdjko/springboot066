package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ExampaperEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ExampaperView;


/**
 * 在线考试
 *
 * @author 
 * @email 
 * @date 2024-04-08 23:12:04
 */
public interface ExampaperService extends IService<ExampaperEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ExampaperView> selectListView(Wrapper<ExampaperEntity> wrapper);
   	
   	ExampaperView selectView(@Param("ew") Wrapper<ExampaperEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ExampaperEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<ExampaperEntity> wrapper);

}

