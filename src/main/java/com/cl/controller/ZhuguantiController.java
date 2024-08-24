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

import com.cl.entity.ZhuguantiEntity;
import com.cl.entity.view.ZhuguantiView;

import com.cl.service.ZhuguantiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 主观题
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-08 23:12:05
 */
@RestController
@RequestMapping("/zhuguanti")
public class ZhuguantiController {
    @Autowired
    private ZhuguantiService zhuguantiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZhuguantiEntity zhuguanti,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("jiaoshi")) {
			zhuguanti.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZhuguantiEntity> ew = new EntityWrapper<ZhuguantiEntity>();

		PageUtils page = zhuguantiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhuguanti), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZhuguantiEntity zhuguanti, 
		HttpServletRequest request){
        EntityWrapper<ZhuguantiEntity> ew = new EntityWrapper<ZhuguantiEntity>();

		PageUtils page = zhuguantiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zhuguanti), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZhuguantiEntity zhuguanti){
       	EntityWrapper<ZhuguantiEntity> ew = new EntityWrapper<ZhuguantiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zhuguanti, "zhuguanti")); 
        return R.ok().put("data", zhuguantiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZhuguantiEntity zhuguanti){
        EntityWrapper< ZhuguantiEntity> ew = new EntityWrapper< ZhuguantiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zhuguanti, "zhuguanti")); 
		ZhuguantiView zhuguantiView =  zhuguantiService.selectView(ew);
		return R.ok("查询主观题成功").put("data", zhuguantiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZhuguantiEntity zhuguanti = zhuguantiService.selectById(id);
		zhuguanti = zhuguantiService.selectView(new EntityWrapper<ZhuguantiEntity>().eq("id", id));
        return R.ok().put("data", zhuguanti);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZhuguantiEntity zhuguanti = zhuguantiService.selectById(id);
		zhuguanti = zhuguantiService.selectView(new EntityWrapper<ZhuguantiEntity>().eq("id", id));
        return R.ok().put("data", zhuguanti);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增主观题")
    public R save(@RequestBody ZhuguantiEntity zhuguanti, HttpServletRequest request){
    	zhuguanti.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhuguanti);
        zhuguantiService.insert(zhuguanti);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增主观题")
    @RequestMapping("/add")
    public R add(@RequestBody ZhuguantiEntity zhuguanti, HttpServletRequest request){
    	zhuguanti.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zhuguanti);
        zhuguantiService.insert(zhuguanti);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改主观题")
    public R update(@RequestBody ZhuguantiEntity zhuguanti, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zhuguanti);
        zhuguantiService.updateById(zhuguanti);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除主观题")
    public R delete(@RequestBody Long[] ids){
        zhuguantiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
