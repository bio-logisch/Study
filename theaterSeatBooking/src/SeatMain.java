package theater;
import java.util.Scanner;

public class SeatMain {
	Scanner in = new Scanner(System.in);
	BookingInfo[][] booking = new BookingInfo[3][10]; ///좌석을 2차원배열로 선언
	Member nowUser = null; ///현재 들어온 사람의 정보를 알고 싶어서 선언한 변수임
	int[][] badSeatInfo = { { 0, 0, 0, 0, 1, 1 },
				            { 0, 1, 8, 9, 0, 9 } }; // 좌석이 아닌 곳 정보 좌표

	SeatMain() { ///생성자는 객체가 만들어질 때 처음 딱 한번 실행되는 메서드(사용예, 메뉴불러오기 혹은 초기정보세팅용 등으로 씀)
		///여기서 init의 기능은 예를 들어 게임이면 유저의 점수/정보 등을 미리 세팅해둘 때 쓰는 것처럼, 미리 전제로 깔아두는 용도임
		init();
	}
	///초기화 작업을 하기 위한 메서드
	private void init() {  ///private이니까 SeatMain클래스에서만 쓸 수 있음
		BookingInfo noSeat = new BookingInfo(); ///이 객체는 앉을 수 없는 자리를 지정해두기 위해 생성함
		noSeat.userName = "NOseat"; ///7번 객체 만들어짐
		for (int i = 0; i < badSeatInfo[0].length; i++) {
			booking[badSeatInfo[0][i]][badSeatInfo[1][i]] = noSeat;
		}
		noSeat = null;

	}
	///예약현황을 기호(검정네모 빈네모 별표)로 표시하기 위한 메서드
	public void prt() {
	    System.out.println("--------------- 좌석 정보 안내 ---------------");
	    System.out.println("예매된 좌석 : * ");
		System.out.print("예매가능 : □ ");
		System.out.print("예매불가 : ■ ");
	    System.out.println("-----------------------------------------");

		System.out.print("행/열");
		for (int i = 0; i < booking[0].length; i++) {
			System.out.print((i) + " ");
		}
		System.out.println();
		for (int i = 0; i < booking.length; i++) {
			System.out.print("  " + i + " ");
			for (int j = 0; j < booking[0].length; j++) {
				if (booking[i][j] == null) {
					System.out.print("□ ");
				} else if (booking[i][j].userName.equals("NOseat")) {
					System.out.print("■ ");
				} else {
					System.out.print("* ");
				} 
			}
			System.out.println();
		}
	}
	///로그인 유무까지 확인하여 메뉴를 제공하는 메서드
	public void menu(Member m) {
		nowUser = m;  //nowUser는 null이 들어간 상태
		boolean f = true;
		while (f) {
			System.out.println("1. 예매");
			System.out.println("2. 예매확인");
			System.out.println("3. 예매정보수정");
			System.out.println("4. 예매정보삭제");
			System.out.println("5. 전체 예매현황 보기");
			System.out.println("6. 좌석변경");
			System.out.println("7. 나의 예매정보 보기");
			System.out.println("8. 로그아웃");
			System.out.println(" 메뉴 선택 >> ");
			int selMenu = in.nextInt();
			in.nextLine();
			if (selMenu == 1) {
				if (loginCheck()) {
					add();
				}
			} else if (selMenu == 2) {
				if (loginCheck()) {
					ser();
				}
			} else if (selMenu == 3) {
				if (loginCheck()) {
					mod();
				}
			} else if (selMenu == 4) {
				if (loginCheck()) {
					del();
				}
			} else if (selMenu == 5) {
				bookingPrt();
			} else if (selMenu == 6) {
				if (loginCheck()) {
					changeSeat();
				}
			} else if (selMenu == 7) {
				if (loginCheck()) {
					myBookingList();
				}
			} else if (selMenu == 8) {
				f = false;
				nowUser = null;
			}	
		}
	}
	
	//로그인한 나의 예매내역만 보여주는 메서드
	private void myBookingList() {
		if(nowUser != null) {
			nowUser.bookingInfo(); //예매자명과 예매시 입력한 비밀번호 출력하는 메서드 호출			
		}
		myprt();
		in.nextLine();
	}
	
	///좌석 변경하는 메서드
	private void changeSeat() {
		System.out.println("<좌석변경은 예약자 확인 후 이루어 집니다> \n 예약자 이름 입력");
		String userName = in.nextLine();
		int[] idx = searchUserName(userName); ///이름을 입력하면 행열번호 리턴받음
		if (idx != null) {
			BookingInfo binfo = findUserBooking(idx[0], idx[1]); 
			//예매내역없는 사람이름으로 검색하면 nullPointerException이 떠서 위 코드를 if문 안으로 넣고 아래 135번 라인 주석처리함
			prt(); ///전체 좌석현황 그림 띄워줌
			System.out.println("좌석을 선택하세요.");
			System.out.println("행(세로)과 열(가로)을 차례대로 입력하세요. \n행입력");
			int row = in.nextInt();
			in.nextLine();
			System.out.println("열을 입력하세요");
			int col = in.nextInt();
			in.nextLine();
			if (findUserBooking(row, col) == null) { ///그 자리가 빈자리인지 확인하는 코드, 빈자리이므로 좌석변경가능
				binfo.row = row; //변경할 좌석 행번호 추가
				binfo.col = col; //변경할 좌석 열번호 추가
				booking[row][col] = binfo;
				booking[idx[0]][idx[1]] = null; ///기존예약자리는 빈자리로 변경
				System.out.println("좌석변경이 완료 되었습니다");
			} else {
				System.out.println("이미 예약된 자리는 선택 할 수 없습니다.");
			}
			in.nextLine();
		}
//		binfo = null;
	}
	//예매내역 삭제하는 메서드
	private void del() {
		System.out.println("<예매삭제> 예약자 이름을 입력하세요");
		String userName = in.nextLine();
		int[] idx = searchUserName(userName);
		if (idx == null) {
			System.out.println("예약 내역이 없어요");
		} else {
			booking[idx[0]][idx[1]] = null; ///예약내역 삭제
		}
		in.nextLine();
	}
	//예매내역 수정(자리이동)하는 메서드
	private void mod() {
		System.out.println("<예매수정> 예약자 이름을 입력하세요");
		String userName = in.nextLine();
		int[] idx = searchUserName(userName);
		if (idx == null) {
			System.out.println("예약 내역이 없습니다");
		} else {
			BookingInfo binfo = findUserBooking(idx[0], idx[1]);
			System.out.println("<비밀번호를 수정하세요>");
			String pass = in.nextLine();
			binfo.userPass = pass;
		}
		in.nextLine();
	}
	///예약현황을 보여주는 메서드
	private void bookingPrt() {
		prt();
		System.out.println();
		for (int i = 0; i < booking.length; i++) {
			// System.out.print(" " + i + " ");
			for (int j = 0; j < booking[0].length; j++) {
				if (booking[i][j] == null) {
					System.out.println((i + "행 / " + j + "열 " + "[예약가능]"));
				} else if (booking[i][j] != null) {
					if (booking[i][j].userName.equals("NOseat")) {
					} else {
						String maskingName = booking[i][j].userName.charAt(0) + "**"; ///마스킹
						System.out.print((i + "행 / " + j + "열 " + "[예약됨] " + maskingName + "님"));
						System.out.println();
					}
				}
			}
			System.out.println();
		}
		in.nextLine();
	}
	///현재 로그인한 사람인지 아닌지 체크해주는 메서드
	private boolean loginCheck() {
		if (nowUser == null) {
			System.out.println("회원 서비스 입니다 ");
			return false; ///회원아님
		}
		return true;  ///회원임
	}
	///검색 기능 메서드
	private void ser() { 
		System.out.println("<예매확인> 예약자 이름을 입력하세요");
		String userName = in.nextLine();
		int[] idx = searchUserName(userName);
		if (idx == null) {
			System.out.println("예약 내역이 없어요");
		} else {
			///예약자가 있으면, 해당되는 위치의 주소값을 리턴받음
			BookingInfo binfo = findUserBooking(idx[0], idx[1]); 
			System.out.println(
					"예약정보 : 행 " + idx[0] + "/ 열 " + idx[1] + "(" + binfo.userName + "/" + binfo.userPass + ")");
		}
		in.nextLine();
	}
	///행과 열의 정보로 예약자의 객체를 찾아주는 메서드, 예약자의 객체주소를 리턴해줌 - 수정, 검색용으로 사용가능
	private BookingInfo findUserBooking(int row, int col) {
		if (booking[row][col] != null) {
			return booking[row][col];  //예매된 자리면 예매자명 리턴
		}
		return null; //빈자리면 null로 리턴

	}
	///사용자가 입력한 이름의 객체가 어디행과 열에 있는지 찾아주는 메서드
	private int[] searchUserName(String userName) {
		int[] idx = null;
		for (int i = 0; i < booking.length; i++) {
			for (int j = 0; j < booking[0].length; j++) {
				if (booking[i][j] != null) {
					if (booking[i][j].userName.equals(userName)) {
						idx = new int[2];
						idx[0] = i; ///행
						idx[1] = j; ///열
						return idx; ///리턴값은 하나인데 보내야하는 행열 정보가 두개라서 배열로 만들어서 하나로 묵어서 넘기기
									///배열 말고 객체를 리턴값으로 보내도 된다...!
					}
				}
			}
		}
		return null;
	}
	///예매하는 메서드
	private void add() {
		prt();
		System.out.println("행과 열을 차례대로 입력하세요. \n행입력");
		int row = in.nextInt();
		in.nextLine();
		System.out.println("열을 입력하세요");
		int col = in.nextInt();
		in.nextLine();

		if (findUserBooking(row, col) == null) { //입력한 좌석이 빈자리면
			BookingInfo newBooking = new BookingInfo(); //예매정보(예매자명,비번,좌석행열번호) 저장할 객체생성
			System.out.println("예약자 명을 입력하세요");
			String userName = in.nextLine();
			int[] idx = searchUserName(userName); //이미 예약한 사람인지 체크
			if (idx == null) { //예약한 사람이 아니면(null이면) - 이미 예약했으면 좌석정보 리턴하므로 null값이 아님
				System.out.println("비밀번호를 입력하세요");
				newBooking.userPass = in.nextLine();
				newBooking.userName = userName;
				newBooking.row = row; //예매한 좌석의 행번호 대입
				newBooking.col = col; //예매한 좌석의 열번호 대입
				booking[row][col] = newBooking;
				nowUser.inputBooking(newBooking); //nowUser대신 Member쓰면 안됨. inputBooking이 공용메서드가 아니기때문
				//nowUser는 SeatMain클래스에서 선언된 Member자료형 변수이므로 
				// nowUser에서 참조한 inputBooking메서드의 리턴값은 mylist배열에 저장된 로그인 한 회원의 예매한 내역(예매자명, 비번)  
			} else {
				System.out.println(userName + "님은 이미 예약 정보가 있습니다");
			}

		} else {
			System.out.println("선택한 좌석은 없거나 이미 예약된 좌석입니다."); //입력한 좌석이 빈자리가 아니면(noSeat이거나 이미예매)
		}
		in.nextLine();
	}
	
	
	
	//내가 예매한 자리를 하트로 표시하는 메서드
	public void myprt() {
	    System.out.println("나의 예매좌석 : ♥ ");
	    System.out.println("다른 회원의 예매좌석 : * ");
	    System.out.println();
	    System.out.print("행/열");
	    for (int i = 0; i < booking[0].length; i++) {
	        System.out.print((i) + " ");
	    }
	    System.out.println();
	    for (int i = 0; i < booking.length; i++) {
	        System.out.print("  " + i + " ");
	        for (int j = 0; j < booking[0].length; j++) {
	            if (booking[i][j] == null) {
	                System.out.print("□ ");
	            } else if (booking[i][j].userName.equals("NOseat")) {
	                System.out.print("■ ");
	            } else if (nowUser != null && nowUser.mylist != null) {
	                for (int k = 0; k < nowUser.mylist.length; k++) {
	                    if (nowUser.mylist[k] != null && nowUser.mylist[k].row == i && nowUser.mylist[k].col == j) {
	                        System.out.print("♥ ");
	                        break;
	                    } else {
	                        System.out.print("* ");
	                        break;
	                    }
	                }
	            }
	        }
	        System.out.println();
	    }
	}

}
