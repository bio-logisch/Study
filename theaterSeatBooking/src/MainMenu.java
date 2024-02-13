package theater;
import java.util.Scanner;

public class MainMenu {
	Scanner in = new Scanner(System.in);
//	MemberMain memberMain = new MemberMain(); ///고객관리 객체를 MainMenu가 만든 것임, 싱글톤으로 바꾸기 위해 주석처리
	MemberMain memberMain = MemberMain.getInstance(); //싱글톤을 위해 해당 객체 새로 생성
	
	SeatMain seatMain = new SeatMain(); ///예약 객체를 MainMenu가 만든 것임
	Member nowUser = null; ///null이니까 로그인 한 사람이 없다는 의미임(로그인 한 사람 정보)
	MainMenu() { 
		// 메뉴선택하기.. ///생성자에 메뉴기능을 정의함. 객체를 생성하자마자(프로그램 실행하자마자) 메뉴를 띄운다는게 의도
		boolean f = true;
		while (f) {
			System.out.println(" **** 영화 좌석 예매 시스템 **** ");
			menu();
			System.out.println(" 메뉴 선택 >> ");
			int selMenu = in.nextInt();
			in.nextLine();
			if (selMenu == 1) {
				join();
			} else if (selMenu == 2) {
				login();
			} else if (selMenu == 3) {
				booking();
			} 
		}
	}
	
	private void booking() {
		seatMain.menu(null); ///로그인 정보를 SeatMain 클래스에 넘김 
	}

	private void login() {
		System.out.println("이름을 입력하세요");
		String name = in.nextLine();
		nowUser = memberMain.findUser(name);
		if(nowUser != null) {
			seatMain.menu(nowUser); ///로그인 정보를 SeatMain 클래스에 넘김
		}
		
	}

	private void join() {
		memberMain.init(); 
	}

	public void menu() {
		System.out.println("1.회원페이지  2.로그인  3.비회원서비스");
	}
}
