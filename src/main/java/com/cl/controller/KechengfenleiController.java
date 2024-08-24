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

import com.cl.entity.KechengfenleiEntity;
import com.cl.entity.view.KechengfenleiView;

import com.cl.service.KechengfenleiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 课程分类
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-08 23:12:04
 */
@RestController
@RequestMapping("/kechengfenlei")
public class KechengfenleiController {
    @Autowired
    private KechengfenleiService kechengfenleiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KechengfenleiEntity kechengfenlei,
		HttpServletRequest request){
        EntityWrapper<KechengfenleiEntity> ew = new EntityWrapper<KechengfenleiEntity>();

		PageUtils page = kechengfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kechengfenlei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KechengfenleiEntity kechengfenlei, 
		HttpServletRequest request){
        EntityWrapper<KechengfenleiEntity> ew = new EntityWrapper<KechengfenleiEntity>();

		PageUtils page = kechengfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kechengfenlei), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KechengfenleiEntity kechengfenlei){
       	EntityWrapper<KechengfenleiEntity> ew = new EntityWrapper<KechengfenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kechengfenlei, "kechengfenlei")); 
        return R.ok().put("data", kechengfenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KechengfenleiEntity kechengfenlei){
        EntityWrapper< KechengfenleiEntity> ew = new EntityWrapper< KechengfenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kechengfenlei, "kechengfenlei")); 
		KechengfenleiView kechengfenleiView =  kechengfenleiService.selectView(ew);
		return R.ok("查询课程分类成功").put("data", kechengfenleiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KechengfenleiEntity kechengfenlei = kechengfenleiService.selectById(id);
		kechengfenlei = kechengfenleiService.selectView(new EntityWrapper<KechengfenleiEntity>().eq("id", id));
        return R.ok().put("data", kechengfenlei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KechengfenleiEntity kechengfenlei = kechengfenleiService.selectById(id);
		kechengfenlei = kechengfenleiService.selectView(new EntityWrapper<KechengfenleiEntity>().eq("id", id));
        return R.ok().put("data", kechengfenlei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增课程分类")
    public R save(@RequestBody KechengfenleiEntity kechengfenlei, HttpServletRequest request){
    	kechengfenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kechengfenlei);
        kechengfenleiService.insert(kechengfenlei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增课程分类")
    @RequestMapping("/add")
    public R add(@RequestBody KechengfenleiEntity kechengfenlei, HttpServletRequest request){
    	kechengfenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kechengfenlei);
        kechengfenleiService.insert(kechengfenlei);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改课程分类")
    public R update(@RequestBody KechengfenleiEntity kechengfenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kechengfenlei);
        kechengfenleiService.updateById(kechengfenlei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除课程分类")
    public R delete(@RequestBody Long[] ids){
        kechengfenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
