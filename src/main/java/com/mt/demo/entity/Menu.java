package com.mt.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Menu {
	/**
	 *id.
	 */
	@Id
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/**
	 *menuName. 
	 */
	private String menuName;
	
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public long getCost() {
		return cost;
	}
	public void setCost(long cost) {
		this.cost = cost;
	}
	/**
	 *cost. 
	 */
	private long cost;
	/**
	 *description.
	 */
	private String description;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
