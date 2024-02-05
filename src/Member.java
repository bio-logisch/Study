package theater;

public class Member {
	// 생성자를 작성하지 않으면 자바는 자동으로 생성자를 생성해 준다.
	/**
	 *   //아래 생성자는 생략이 가능하다.
	 *   Member() {
	 *   } 
	 */
	String name=null;
	String addr=null;
	int age=0;
	BookingInfo[] mylist = new BookingInfo[3]; //예매한 사람의 이름과 비밀번호 저장하는 배열 선언
	
	public void prt() {
		System.out.println(" 회원명 "+name.charAt(0)+"**");
		//System.out.println(" ADDR "+addr);
		//System.out.println(" A GE "+age);
	}

	//예약정보는 Member 클래스가 변수를 갖고 있으므로 Member 클래스에 아래 메서드 추가
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
	//예매 시 BookingInfo 자료형(예매자명, 비번, 좌석행열 번호)의 객체 주소를 매개변수로 전달하면 inputBooking 메서드는
	//매개변수로 받은 주소값을 자신의 배열에 추가한다. 이후 SeatMain 클래스>add메서드에서 예매 정보를 Member클래스의 
	//inputBooking메서드에게 넘겨주도록 하면 된다.
	public void inputBooking(BookingInfo binfo) {
		for(int i=0; i<mylist.length; i++) {
			if(mylist[i] == null) {
				mylist[i] = binfo;
				break;
			}
		}
	}
	
}
