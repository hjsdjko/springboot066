package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.SyslogEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.SyslogView;


/**
 * 操作日志
 *
 * @author 
 * @email 
 * @date 2024-04-08 23:12:04
 */
public interface SyslogService extends IService<SyslogEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<SyslogView> selectListView(Wrapper<SyslogEntity> wrapper);
   	
   	SyslogView selectView(@Param("ew") Wrapper<SyslogEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<SyslogEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<SyslogEntity> wrapper);

}

