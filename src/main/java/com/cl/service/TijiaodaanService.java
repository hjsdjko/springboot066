package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.TijiaodaanEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.TijiaodaanView;


/**
 * 提交答案
 *
 * @author 
 * @email 
 * @date 2024-04-08 23:12:05
 */
public interface TijiaodaanService extends IService<TijiaodaanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TijiaodaanView> selectListView(Wrapper<TijiaodaanEntity> wrapper);
   	
   	TijiaodaanView selectView(@Param("ew") Wrapper<TijiaodaanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TijiaodaanEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<TijiaodaanEntity> wrapper);

}

