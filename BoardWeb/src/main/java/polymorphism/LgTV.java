package polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV implements TV{
	//@Autowired
	//@Qualifier("apple")
	
	@Resource(name="apple")
	private Speaker speaker;
	

	//ctrl+space �⺻������
	public LgTV() {
		System.out.println("========> LgTV ��ü ����");
	}
	
	@Override
	public void powerOn() {
		System.out.println("LgTV---���� �Ҵ�.");
		
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV---���� ����.");
		
	}

	@Override
	public void volumeUp() {
		speaker.volumeUp();
		System.out.println("LgTV---�Ҹ� �ø���.");
		
	}

	@Override
	public void volumeDown() {
		speaker.volumeDown();
		System.out.println("LgTV---�Ҹ� ������.");
		
	}

	/*
	public void turnOn() {
		System.out.println("LgTV---���� �Ҵ�.");
	}
	
	public void turnOff() {
		System.out.println("LgTV---���� ����.");
	}
	
	public void soundUp() {
		System.out.println("LgTV---�Ҹ� �ø���.");
	}
	
	public void soundDown() {
		System.out.println("LgTV---�Ҹ� ������.");
	}
	*/
	
	
}
