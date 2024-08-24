package com.cl.entity.view;

import com.cl.entity.KechengxuexiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 课程学习
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-08 23:12:05
 */
@TableName("kechengxuexi")
public class KechengxuexiView  extends KechengxuexiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public KechengxuexiView(){
	}
 
 	public KechengxuexiView(KechengxuexiEntity kechengxuexiEntity){
 	try {
			BeanUtils.copyProperties(this, kechengxuexiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
