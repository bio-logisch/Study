package theater;

public class Member {
	// �����ڸ� �ۼ����� ������ �ڹٴ� �ڵ����� �����ڸ� ������ �ش�.
	/**
	 *   //�Ʒ� �����ڴ� ������ �����ϴ�.
	 *   Member() {
	 *   } 
	 */
	String name=null;
	String addr=null;
	int age=0;
	BookingInfo[] mylist = new BookingInfo[3]; //������ ����� �̸��� ��й�ȣ �����ϴ� �迭 ����
	
	public void prt() {
		System.out.println(" ȸ���� "+name.charAt(0)+"**");
		//System.out.println(" ADDR "+addr);
		//System.out.println(" A GE "+age);
	}

	//���������� Member Ŭ������ ������ ���� �����Ƿ� Member Ŭ������ �Ʒ� �޼��� �߰�
	public void bookingInfo() {
		int cnt = 0; //�� ����Ƚ�� ī����
		for(int i=0; i<mylist.length; i++) {
			if(mylist[i] != null) {
				System.out.println("�����ڸ� : "+mylist[i].userName);
				cnt++;
			}
		}
		System.out.println("�� "+cnt+"���� ���ų����� �ֽ��ϴ�.");
	}
	//���� �� BookingInfo �ڷ���(�����ڸ�, ���, �¼��࿭ ��ȣ)�� ��ü �ּҸ� �Ű������� �����ϸ� inputBooking �޼����
	//�Ű������� ���� �ּҰ��� �ڽ��� �迭�� �߰��Ѵ�. ���� SeatMain Ŭ����>add�޼��忡�� ���� ������ MemberŬ������ 
	//inputBooking�޼��忡�� �Ѱ��ֵ��� �ϸ� �ȴ�.
	public void inputBooking(BookingInfo binfo) {
		for(int i=0; i<mylist.length; i++) {
			if(mylist[i] == null) {
				mylist[i] = binfo;
				break;
			}
		}
	}
	
}
