package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 课程学习
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-08 23:12:05
 */
@TableName("kechengxuexi")
public class KechengxuexiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public KechengxuexiEntity() {
		
	}
	
	public KechengxuexiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 课程名称
	 */
					
	private String kechengmingcheng;
	
	/**
	 * 课程分类
	 */
					
	private String kechengfenlei;
	
	/**
	 * 课程简介
	 */
					
	private String kechengjianjie;
	
	/**
	 * 课程大纲
	 */
					
	private String kechengdagang;
	
	/**
	 * 课程重点
	 */
					
	private String kechengzhongdian;
	
	/**
	 * 课程难点
	 */
					
	private String kechengnandian;
	
	/**
	 * 进度安排
	 */
					
	private String jinduanpai;
	
	/**
	 * 学习时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date xuexishijian;
	
	/**
	 * 用户账号
	 */
					
	private String yonghuzhanghao;
	
	/**
	 * 用户姓名
	 */
					
	private String yonghuxingming;
	
	/**
	 * 学习时长
	 */
					
	private Double xuexishizhang;
	
	/**
	 * 教师工号
	 */
					
	private String jiaoshigonghao;
	
	/**
	 * 教师姓名
	 */
					
	private String jiaoshixingming;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：课程名称
	 */
	public void setKechengmingcheng(String kechengmingcheng) {
		this.kechengmingcheng = kechengmingcheng;
	}
	/**
	 * 获取：课程名称
	 */
	public String getKechengmingcheng() {
		return kechengmingcheng;
	}
	/**
	 * 设置：课程分类
	 */
	public void setKechengfenlei(String kechengfenlei) {
		this.kechengfenlei = kechengfenlei;
	}
	/**
	 * 获取：课程分类
	 */
	public String getKechengfenlei() {
		return kechengfenlei;
	}
	/**
	 * 设置：课程简介
	 */
	public void setKechengjianjie(String kechengjianjie) {
		this.kechengjianjie = kechengjianjie;
	}
	/**
	 * 获取：课程简介
	 */
	public String getKechengjianjie() {
		return kechengjianjie;
	}
	/**
	 * 设置：课程大纲
	 */
	public void setKechengdagang(String kechengdagang) {
		this.kechengdagang = kechengdagang;
	}
	/**
	 * 获取：课程大纲
	 */
	public String getKechengdagang() {
		return kechengdagang;
	}
	/**
	 * 设置：课程重点
	 */
	public void setKechengzhongdian(String kechengzhongdian) {
		this.kechengzhongdian = kechengzhongdian;
	}
	/**
	 * 获取：课程重点
	 */
	public String getKechengzhongdian() {
		return kechengzhongdian;
	}
	/**
	 * 设置：课程难点
	 */
	public void setKechengnandian(String kechengnandian) {
		this.kechengnandian = kechengnandian;
	}
	/**
	 * 获取：课程难点
	 */
	public String getKechengnandian() {
		return kechengnandian;
	}
	/**
	 * 设置：进度安排
	 */
	public void setJinduanpai(String jinduanpai) {
		this.jinduanpai = jinduanpai;
	}
	/**
	 * 获取：进度安排
	 */
	public String getJinduanpai() {
		return jinduanpai;
	}
	/**
	 * 设置：学习时间
	 */
	public void setXuexishijian(Date xuexishijian) {
		this.xuexishijian = xuexishijian;
	}
	/**
	 * 获取：学习时间
	 */
	public Date getXuexishijian() {
		return xuexishijian;
	}
	/**
	 * 设置：用户账号
	 */
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
	/**
	 * 设置：用户姓名
	 */
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
	/**
	 * 设置：学习时长
	 */
	public void setXuexishizhang(Double xuexishizhang) {
		this.xuexishizhang = xuexishizhang;
	}
	/**
	 * 获取：学习时长
	 */
	public Double getXuexishizhang() {
		return xuexishizhang;
	}
	/**
	 * 设置：教师工号
	 */
	public void setJiaoshigonghao(String jiaoshigonghao) {
		this.jiaoshigonghao = jiaoshigonghao;
	}
	/**
	 * 获取：教师工号
	 */
	public String getJiaoshigonghao() {
		return jiaoshigonghao;
	}
	/**
	 * 设置：教师姓名
	 */
	public void setJiaoshixingming(String jiaoshixingming) {
		this.jiaoshixingming = jiaoshixingming;
	}
	/**
	 * 获取：教师姓名
	 */
	public String getJiaoshixingming() {
		return jiaoshixingming;
	}

}
