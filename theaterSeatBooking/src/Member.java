package theater;

public class Member {
	String name=null;
	String addr=null;
	int age=0;
	BookingInfo[] mylist = new BookingInfo[3]; //예매한 사람의 이름과 비밀번호 저장하는 배열 선언
	
	public void prt() {
		System.out.println(" 회원명 "+name.charAt(0)+"**");
		//System.out.println(" ADDR "+addr);
		//System.out.println(" A GE "+age);
	}
	public void bookingInfo() {
		int cnt = 0; //총 예매횟수 카운팅
		for(int i=0; i<mylist.length; i++) {
			if(mylist[i] != null) {
				System.out.println("예매자명 : "+mylist[i].userName);
				cnt++;
			}
		}
		System.out.println("총 "+cnt+"건의 예매내역이 있습니다.");
	}
	public void inputBooking(BookingInfo binfo) {
		for(int i=0; i<mylist.length; i++) {
			if(mylist[i] == null) {
				mylist[i] = binfo;
				break;
			}
		}
	}	
}
