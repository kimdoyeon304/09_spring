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
	

	//ctrl+space 기본생성자
	public LgTV() {
		System.out.println("========> LgTV 객체 생성");
	}
	
	@Override
	public void powerOn() {
		System.out.println("LgTV---전원 켠다.");
		
	}

	@Override
	public void powerOff() {
		System.out.println("LgTV---전원 끈다.");
		
	}

	@Override
	public void volumeUp() {
		speaker.volumeUp();
		System.out.println("LgTV---소리 올린다.");
		
	}

	@Override
	public void volumeDown() {
		speaker.volumeDown();
		System.out.println("LgTV---소리 내린다.");
		
	}

	/*
	public void turnOn() {
		System.out.println("LgTV---전원 켠다.");
	}
	
	public void turnOff() {
		System.out.println("LgTV---전원 끈다.");
	}
	
	public void soundUp() {
		System.out.println("LgTV---소리 올린다.");
	}
	
	public void soundDown() {
		System.out.println("LgTV---소리 내린다.");
	}
	*/
	
	
}