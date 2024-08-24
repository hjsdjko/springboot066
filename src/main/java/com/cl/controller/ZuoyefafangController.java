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

import com.cl.entity.ZuoyefafangEntity;
import com.cl.entity.view.ZuoyefafangView;

import com.cl.service.ZuoyefafangService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 作业发放
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-08 23:12:05
 */
@RestController
@RequestMapping("/zuoyefafang")
public class ZuoyefafangController {
    @Autowired
    private ZuoyefafangService zuoyefafangService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZuoyefafangEntity zuoyefafang,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			zuoyefafang.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiaoshi")) {
			zuoyefafang.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZuoyefafangEntity> ew = new EntityWrapper<ZuoyefafangEntity>();

		PageUtils page = zuoyefafangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuoyefafang), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZuoyefafangEntity zuoyefafang, 
		HttpServletRequest request){
        EntityWrapper<ZuoyefafangEntity> ew = new EntityWrapper<ZuoyefafangEntity>();

		PageUtils page = zuoyefafangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuoyefafang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZuoyefafangEntity zuoyefafang){
       	EntityWrapper<ZuoyefafangEntity> ew = new EntityWrapper<ZuoyefafangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zuoyefafang, "zuoyefafang")); 
        return R.ok().put("data", zuoyefafangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZuoyefafangEntity zuoyefafang){
        EntityWrapper< ZuoyefafangEntity> ew = new EntityWrapper< ZuoyefafangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zuoyefafang, "zuoyefafang")); 
		ZuoyefafangView zuoyefafangView =  zuoyefafangService.selectView(ew);
		return R.ok("查询作业发放成功").put("data", zuoyefafangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZuoyefafangEntity zuoyefafang = zuoyefafangService.selectById(id);
		zuoyefafang = zuoyefafangService.selectView(new EntityWrapper<ZuoyefafangEntity>().eq("id", id));
        return R.ok().put("data", zuoyefafang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZuoyefafangEntity zuoyefafang = zuoyefafangService.selectById(id);
		zuoyefafang = zuoyefafangService.selectView(new EntityWrapper<ZuoyefafangEntity>().eq("id", id));
        return R.ok().put("data", zuoyefafang);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增作业发放")
    public R save(@RequestBody ZuoyefafangEntity zuoyefafang, HttpServletRequest request){
    	zuoyefafang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zuoyefafang);
        zuoyefafangService.insert(zuoyefafang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增作业发放")
    @RequestMapping("/add")
    public R add(@RequestBody ZuoyefafangEntity zuoyefafang, HttpServletRequest request){
    	zuoyefafang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zuoyefafang);
        zuoyefafangService.insert(zuoyefafang);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改作业发放")
    public R update(@RequestBody ZuoyefafangEntity zuoyefafang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zuoyefafang);
        zuoyefafangService.updateById(zuoyefafang);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除作业发放")
    public R delete(@RequestBody Long[] ids){
        zuoyefafangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
