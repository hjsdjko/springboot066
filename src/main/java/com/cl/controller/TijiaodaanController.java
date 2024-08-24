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

import com.cl.entity.TijiaodaanEntity;
import com.cl.entity.view.TijiaodaanView;

import com.cl.service.TijiaodaanService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 提交答案
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-08 23:12:05
 */
@RestController
@RequestMapping("/tijiaodaan")
public class TijiaodaanController {
    @Autowired
    private TijiaodaanService tijiaodaanService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TijiaodaanEntity tijiaodaan,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			tijiaodaan.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiaoshi")) {
			tijiaodaan.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<TijiaodaanEntity> ew = new EntityWrapper<TijiaodaanEntity>();

		PageUtils page = tijiaodaanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tijiaodaan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TijiaodaanEntity tijiaodaan, 
		HttpServletRequest request){
        EntityWrapper<TijiaodaanEntity> ew = new EntityWrapper<TijiaodaanEntity>();

		PageUtils page = tijiaodaanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tijiaodaan), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TijiaodaanEntity tijiaodaan){
       	EntityWrapper<TijiaodaanEntity> ew = new EntityWrapper<TijiaodaanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tijiaodaan, "tijiaodaan")); 
        return R.ok().put("data", tijiaodaanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TijiaodaanEntity tijiaodaan){
        EntityWrapper< TijiaodaanEntity> ew = new EntityWrapper< TijiaodaanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tijiaodaan, "tijiaodaan")); 
		TijiaodaanView tijiaodaanView =  tijiaodaanService.selectView(ew);
		return R.ok("查询提交答案成功").put("data", tijiaodaanView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TijiaodaanEntity tijiaodaan = tijiaodaanService.selectById(id);
		tijiaodaan = tijiaodaanService.selectView(new EntityWrapper<TijiaodaanEntity>().eq("id", id));
        return R.ok().put("data", tijiaodaan);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TijiaodaanEntity tijiaodaan = tijiaodaanService.selectById(id);
		tijiaodaan = tijiaodaanService.selectView(new EntityWrapper<TijiaodaanEntity>().eq("id", id));
        return R.ok().put("data", tijiaodaan);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增提交答案")
    public R save(@RequestBody TijiaodaanEntity tijiaodaan, HttpServletRequest request){
    	tijiaodaan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tijiaodaan);
        tijiaodaanService.insert(tijiaodaan);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增提交答案")
    @RequestMapping("/add")
    public R add(@RequestBody TijiaodaanEntity tijiaodaan, HttpServletRequest request){
    	tijiaodaan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tijiaodaan);
        tijiaodaanService.insert(tijiaodaan);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改提交答案")
    public R update(@RequestBody TijiaodaanEntity tijiaodaan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tijiaodaan);
        tijiaodaanService.updateById(tijiaodaan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除提交答案")
    public R delete(@RequestBody Long[] ids){
        tijiaodaanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
