package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZuoyetijiaoEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZuoyetijiaoView;


/**
 * 作业提交
 *
 * @author 
 * @email 
 * @date 2024-04-08 23:12:04
 */
public interface ZuoyetijiaoService extends IService<ZuoyetijiaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZuoyetijiaoView> selectListView(Wrapper<ZuoyetijiaoEntity> wrapper);
   	
   	ZuoyetijiaoView selectView(@Param("ew") Wrapper<ZuoyetijiaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZuoyetijiaoEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<ZuoyetijiaoEntity> wrapper);

}

