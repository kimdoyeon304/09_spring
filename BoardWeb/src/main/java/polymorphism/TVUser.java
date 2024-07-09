package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		
		AbstractApplicationContext factory =
				new GenericXmlApplicationContext("applicationContext.xml");
		
		TV tv1 = (TV)factory.getBean("tv");
		//TV tv2 = (TV)factory.getBean("tv");
		//TV tv3 = (TV)factory.getBean("tv");
		
		tv1.powerOn();
		tv1.volumeUp();
		tv1.volumeDown();
		tv1.powerOff();
	
		/*
		 * tv2.powerOn(); tv2.volumeUp(); tv2.volumeDown(); tv2.powerOff();
		 * 
		 * tv3.powerOn(); tv3.volumeUp(); tv3.volumeDown(); tv3.powerOff();
		 */
		factory.close();
		
		
		/*
		BeanFactory factory = new BeanFactory();
		TV tv = (TV)factory.getBean(args[0]);
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		*/
		
		/*
		TV tv = new SamsungTV();
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		*/
		
		/*
		SamsungTV tv = new SamsungTV();
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		*/
	}
}
