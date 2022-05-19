package in.co.ocha.bean;

import java.io.Serializable;


import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import in.co.util.DataUtility;

/**
 * Parent class of all Beans in application. It contains generic attributes.
 * 
 * @author Nalin
 * @version 1.0
 * @Copyright (c) Nalin Patel
 * 
 */



public abstract class BaseBean implements Serializable, Comparable<BaseBean>, DropdownListBean {

	/**
	 * Non Business primary key
	 */
	protected long id;

	/**
	 * Created by User
	 */
	protected String createdBy;

	/**
	 * Modified by User
	 */
	protected String modifiedBy;

	/**
	 * Contains Created Timestamp of database record
	 */
	protected Timestamp createdDatetime;

	/**
	 * Contains Modified Timestamp of database record
	 */
	protected Timestamp modifiedDatetime;

	/**
	 * accessor
	 */
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getCreatedDatetime() {
		return createdDatetime;
	}

	public void setCreatedDatetime(Timestamp createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	public Timestamp getModifiedDatetime() {
		return modifiedDatetime;
	}

	public void setModifiedDatetime(Timestamp modifiedDatetime) {
		this.modifiedDatetime = modifiedDatetime;
	}

	public int compareTo(BaseBean next) {
		return (int) (id - next.getId());
	}
	
	public BaseBean populateBean(HttpServletRequest request) {
		return null;
		}
}
