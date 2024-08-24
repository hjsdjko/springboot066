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

import com.cl.entity.ZuoyetijiaoEntity;
import com.cl.entity.view.ZuoyetijiaoView;

import com.cl.service.ZuoyetijiaoService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 作业提交
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-08 23:12:04
 */
@RestController
@RequestMapping("/zuoyetijiao")
public class ZuoyetijiaoController {
    @Autowired
    private ZuoyetijiaoService zuoyetijiaoService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZuoyetijiaoEntity zuoyetijiao,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			zuoyetijiao.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiaoshi")) {
			zuoyetijiao.setJiaoshigonghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZuoyetijiaoEntity> ew = new EntityWrapper<ZuoyetijiaoEntity>();

		PageUtils page = zuoyetijiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuoyetijiao), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZuoyetijiaoEntity zuoyetijiao, 
		HttpServletRequest request){
        EntityWrapper<ZuoyetijiaoEntity> ew = new EntityWrapper<ZuoyetijiaoEntity>();

		PageUtils page = zuoyetijiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zuoyetijiao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZuoyetijiaoEntity zuoyetijiao){
       	EntityWrapper<ZuoyetijiaoEntity> ew = new EntityWrapper<ZuoyetijiaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zuoyetijiao, "zuoyetijiao")); 
        return R.ok().put("data", zuoyetijiaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZuoyetijiaoEntity zuoyetijiao){
        EntityWrapper< ZuoyetijiaoEntity> ew = new EntityWrapper< ZuoyetijiaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zuoyetijiao, "zuoyetijiao")); 
		ZuoyetijiaoView zuoyetijiaoView =  zuoyetijiaoService.selectView(ew);
		return R.ok("查询作业提交成功").put("data", zuoyetijiaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZuoyetijiaoEntity zuoyetijiao = zuoyetijiaoService.selectById(id);
		zuoyetijiao = zuoyetijiaoService.selectView(new EntityWrapper<ZuoyetijiaoEntity>().eq("id", id));
        return R.ok().put("data", zuoyetijiao);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZuoyetijiaoEntity zuoyetijiao = zuoyetijiaoService.selectById(id);
		zuoyetijiao = zuoyetijiaoService.selectView(new EntityWrapper<ZuoyetijiaoEntity>().eq("id", id));
        return R.ok().put("data", zuoyetijiao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    @SysLog("新增作业提交")
    public R save(@RequestBody ZuoyetijiaoEntity zuoyetijiao, HttpServletRequest request){
    	zuoyetijiao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zuoyetijiao);
        zuoyetijiaoService.insert(zuoyetijiao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @SysLog("新增作业提交")
    @RequestMapping("/add")
    public R add(@RequestBody ZuoyetijiaoEntity zuoyetijiao, HttpServletRequest request){
    	zuoyetijiao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zuoyetijiao);
        zuoyetijiaoService.insert(zuoyetijiao);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改作业提交")
    public R update(@RequestBody ZuoyetijiaoEntity zuoyetijiao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zuoyetijiao);
        zuoyetijiaoService.updateById(zuoyetijiao);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除作业提交")
    public R delete(@RequestBody Long[] ids){
        zuoyetijiaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
