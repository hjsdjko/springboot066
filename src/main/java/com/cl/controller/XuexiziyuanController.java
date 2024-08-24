package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;
import com.cl.annotation.SysLog;

import com.cl.entity.XuexiziyuanEntity;
import com.cl.entity.view.XuexiziyuanView;

import com.cl.service.XuexiziyuanService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 学习资源
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-08 23:12:04
 */
@RestController
@RequestMapping("/xuexiziyuan")
public class XuexiziyuanController {
    @Autowired
    private XuexiziyuanService xuexiziyuanService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XuexiziyuanEntity xuexiziyuan,
		HttpServletRequest request){
        EntityWrapper<XuexiziyuanEntity> ew = new EntityWrapper<XuexiziyuanEntity>();

		PageUtils page = xuexiziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xuexiziyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XuexiziyuanEntity xuexiziyuan, 
		HttpServletRequest request){
        EntityWrapper<XuexiziyuanEntity> ew = new EntityWrapper<XuexiziyuanEntity>();

		PageUtils page = xuexiziyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xuexiziyuan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XuexiziyuanEntity xuexiziyuan){
       	EntityWrapper<XuexiziyuanEntity> ew = new EntityWrapper<XuexiziyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xuexiziyuan, "xuexiziyuan")); 
        return R.ok().put("data", xuexiziyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XuexiziyuanEntity xuexiziyuan){
        EntityWrapper< XuexiziyuanEntity> ew = new EntityWrapper< XuexiziyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xuexiziyuan, "xuexiziyuan")); 
		XuexiziyuanView xuexiziyuanView =  xuexiziyuanService.selectView(ew);
		return R.ok("查询学习资源成功").put("data", xuexiziyuanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XuexiziyuanEntity xuexiziyuan = xuexiziyuanService.selectById(id);
		xuexiziyuan = xuexiziyuanService.selectView(new EntityWrapper<XuexiziyuanEntity>().eq("id", id));
        return R.ok().put("data", xuexiziyuan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XuexiziyuanEntity xuexiziyuan = xuexiziyuanService.selectById(id);
		xuexiziyuan = xuexiziyuanService.selectView(new EntityWrapper<XuexiziyuanEntity>().eq("id", id));
        return R.ok().put("data", xuexiziyuan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增学习资源")
    public R save(@RequestBody XuexiziyuanEntity xuexiziyuan, HttpServletRequest request){
    	xuexiziyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xuexiziyuan);
        xuexiziyuanService.insert(xuexiziyuan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增学习资源")
    @RequestMapping("/add")
    public R add(@RequestBody XuexiziyuanEntity xuexiziyuan, HttpServletRequest request){
    	xuexiziyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xuexiziyuan);
        xuexiziyuanService.insert(xuexiziyuan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改学习资源")
    public R update(@RequestBody XuexiziyuanEntity xuexiziyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xuexiziyuan);
        xuexiziyuanService.updateById(xuexiziyuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除学习资源")
    public R delete(@RequestBody Long[] ids){
        xuexiziyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
