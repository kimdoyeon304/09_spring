package com.springbook.ioc.injection;

import java.util.Properties;

//import java.util.Map;
//import java.util.List;
//import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {

	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		CollectionBean bean = (CollectionBean)factory.getBean("collectionBean");
		//List<String> addressList = bean.getAddressList();
		//Set<String> addressList = bean.getAddressList();
		//Map<String, String> addressList = bean.getAddressList();
		Properties addressList = bean.getAddressList();
		
//		for(String address : addressList) {
//			System.out.println(address.toString());
//		}
		
//		for(Map.Entry<String, String> entry: addressList.entrySet()) {
//			System.out.println(entry.toString());
//		}
		System.out.println(addressList);
		
		factory.close();
	}
}
