package polymorphism;

import org.springframework.stereotype.Component;

@Component("samsungtv")
public class SamsungTV implements TV{

	/*
	 * public void initMethod() { System.out.println("객체 초기화 작업 처리"); }
	 * 
	 * public void destroyMethod() { System.out.println("객체 삭제 전에 처리할 로직 처리"); }
	 */
	
	//private SonySpeaker speaker;
	private Speaker speaker;
	private int price;
	
	
	//ctrl+space 기본생성자, 묵시적생성자
	public SamsungTV() {
		System.out.println("========> SamsungTV1 객체 생성");
	}
	
	/*
	//명시적생성자
	public SamsungTV(Speaker speaker) {
		System.out.println("========> SamsungTV2 객체 생성");
		this.speaker = speaker;
	}

	

	public SamsungTV(Speaker speaker, int price) {
		System.out.println("========> SamsungTV3 객체 생성");
		this.speaker = speaker;
		this.price = price;
	}
*/

	public void setSpeaker(Speaker speaker) {
		System.out.println("===> setSpeaker() 호출");
		this.speaker = speaker;
	}


	public void setPrice(int price) {
		System.out.println("===> setPrice() 호출");
		this.price = price;
	}
	
	@Override
	public void powerOn() {
		System.out.println("SamsungTV---전원 켠다. (가격 : " + price + ")");
		
	}


	@Override
	public void powerOff() {
		System.out.println("SamsungTV---전원 끈다.");
		
	}

	@Override
	public void volumeUp() {
		//speaker = new SonySpeaker();
		speaker.volumeUp();
		
		//System.out.println("SamsungTV---소리 올린다.");
		
	}

	@Override
	public void volumeDown() {
		//speaker = new SonySpeaker();
		speaker.volumeDown();
		
		//System.out.println("SamsungTV---소리 내린다.");
		
	}

	/*
	public void powerOn() {
		
		System.out.println("SamsungTV---전원 켠다.");
	}
	
	public void powerOff() {
		System.out.println("SamsungTV---전원 끈다.");
	}
	
	public void volumeUp() {
		System.out.println("SamsungTV---소리 올린다.");
	}
	
	public void volumeDown() {
		System.out.println("SamsungTV---소리 내린다.");
	}
	*/
	
	
}
