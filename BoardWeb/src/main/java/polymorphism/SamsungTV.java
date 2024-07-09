package polymorphism;

import org.springframework.stereotype.Component;

@Component("samsungtv")
public class SamsungTV implements TV{

	/*
	 * public void initMethod() { System.out.println("��ü �ʱ�ȭ �۾� ó��"); }
	 * 
	 * public void destroyMethod() { System.out.println("��ü ���� ���� ó���� ���� ó��"); }
	 */
	
	//private SonySpeaker speaker;
	private Speaker speaker;
	private int price;
	
	
	//ctrl+space �⺻������, ������������
	public SamsungTV() {
		System.out.println("========> SamsungTV1 ��ü ����");
	}
	
	/*
	//�����������
	public SamsungTV(Speaker speaker) {
		System.out.println("========> SamsungTV2 ��ü ����");
		this.speaker = speaker;
	}

	

	public SamsungTV(Speaker speaker, int price) {
		System.out.println("========> SamsungTV3 ��ü ����");
		this.speaker = speaker;
		this.price = price;
	}
*/

	public void setSpeaker(Speaker speaker) {
		System.out.println("===> setSpeaker() ȣ��");
		this.speaker = speaker;
	}


	public void setPrice(int price) {
		System.out.println("===> setPrice() ȣ��");
		this.price = price;
	}
	
	@Override
	public void powerOn() {
		System.out.println("SamsungTV---���� �Ҵ�. (���� : " + price + ")");
		
	}


	@Override
	public void powerOff() {
		System.out.println("SamsungTV---���� ����.");
		
	}

	@Override
	public void volumeUp() {
		//speaker = new SonySpeaker();
		speaker.volumeUp();
		
		//System.out.println("SamsungTV---�Ҹ� �ø���.");
		
	}

	@Override
	public void volumeDown() {
		//speaker = new SonySpeaker();
		speaker.volumeDown();
		
		//System.out.println("SamsungTV---�Ҹ� ������.");
		
	}

	/*
	public void powerOn() {
		
		System.out.println("SamsungTV---���� �Ҵ�.");
	}
	
	public void powerOff() {
		System.out.println("SamsungTV---���� ����.");
	}
	
	public void volumeUp() {
		System.out.println("SamsungTV---�Ҹ� �ø���.");
	}
	
	public void volumeDown() {
		System.out.println("SamsungTV---�Ҹ� ������.");
	}
	*/
	
	
}
