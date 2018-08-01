package com.st.trade.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-07-27 10:33:23
 */
@TableName("c_user")
public class CUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId(value = "ids",type = IdType.INPUT)
	private String ids;
	/**
	 * 
	 */
	private String name;

	/**
	 * 设置：
	 */
	public void setIds(String ids) {
		this.ids = ids;
	}
	/**
	 * 获取：
	 */
	public String getIds() {
		return ids;
	}
	/**
	 * 设置：
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：
	 */
	public String getName() {
		return name;
	}
}
