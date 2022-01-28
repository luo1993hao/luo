package org.luo.arithmetic.designpattern.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象中介者类
 *
 */
public abstract class Mediator {
	// 用于添加储存 "房东"角色
	protected List<Person> landlordList = new ArrayList<>();
	
	// 用于添加储存 "求租者"角色
	protected List<Person> renterList = new ArrayList<>();
	
	/**
	 * 中介者注册房东信息
	 * @param landlord 房东实体
	 */
	public void registerLandlord(Person landlord){
		landlordList.add(landlord);
	}
	
	/**
	 * 中介者注册 求租者信息
	 * @param landlord 房东实体
	 */
	public void registerRenter(Person landlord){
		renterList.add(landlord);
	}
	
	
	/**
	 * 声明抽象方法 由具体中介者子类实现 消息的中转和协调
	 */
	public abstract void operation(Person person, String message);
 
}