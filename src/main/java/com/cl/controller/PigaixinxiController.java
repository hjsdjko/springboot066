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

import com.cl.entity.PigaixinxiEntity;
import com.cl.entity.view.PigaixinxiView;

import com.cl.service.PigaixinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 批改信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-08 23:12:05
 */
@RestController
@RequestMapping("/pigaixinxi")
public class PigaixinxiController {
    @Autowired
    private PigaixinxiService pigaixinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PigaixinxiEntity pigaixinxi,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			pigaixinxi.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiaoshi")) {
			pigaixinxi.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<PigaixinxiEntity> ew = new EntityWrapper<PigaixinxiEntity>();

		PageUtils page = pigaixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, pigaixinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,PigaixinxiEntity pigaixinxi, 
		HttpServletRequest request){
        EntityWrapper<PigaixinxiEntity> ew = new EntityWrapper<PigaixinxiEntity>();

		PageUtils page = pigaixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, pigaixinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PigaixinxiEntity pigaixinxi){
       	EntityWrapper<PigaixinxiEntity> ew = new EntityWrapper<PigaixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( pigaixinxi, "pigaixinxi")); 
        return R.ok().put("data", pigaixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(PigaixinxiEntity pigaixinxi){
        EntityWrapper< PigaixinxiEntity> ew = new EntityWrapper< PigaixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( pigaixinxi, "pigaixinxi")); 
		PigaixinxiView pigaixinxiView =  pigaixinxiService.selectView(ew);
		return R.ok("查询批改信息成功").put("data", pigaixinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PigaixinxiEntity pigaixinxi = pigaixinxiService.selectById(id);
		pigaixinxi = pigaixinxiService.selectView(new EntityWrapper<PigaixinxiEntity>().eq("id", id));
        return R.ok().put("data", pigaixinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PigaixinxiEntity pigaixinxi = pigaixinxiService.selectById(id);
		pigaixinxi = pigaixinxiService.selectView(new EntityWrapper<PigaixinxiEntity>().eq("id", id));
        return R.ok().put("data", pigaixinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增批改信息")
    public R save(@RequestBody PigaixinxiEntity pigaixinxi, HttpServletRequest request){
    	pigaixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(pigaixinxi);
        pigaixinxiService.insert(pigaixinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增批改信息")
    @RequestMapping("/add")
    public R add(@RequestBody PigaixinxiEntity pigaixinxi, HttpServletRequest request){
    	pigaixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(pigaixinxi);
        pigaixinxiService.insert(pigaixinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改批改信息")
    public R update(@RequestBody PigaixinxiEntity pigaixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(pigaixinxi);
        pigaixinxiService.updateById(pigaixinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除批改信息")
    public R delete(@RequestBody Long[] ids){
        pigaixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
