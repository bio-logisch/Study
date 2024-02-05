package theater;
import java.util.Scanner;

public class MemberMain {

	Scanner in = new Scanner(System.in);
	Member[] mlist = new Member[100];
	Member m = null; 
	
	public static MemberMain mm = null; //public:누구나 접근가능, static:공용변수로서 객체생성없이 접근가능
	//접근제어자는 public, private, default 등이 있다. 
	//이 코드 대신에 public static MemberMain mm = new MemberMain(); 으로 선언해도 되긴함. 하지만 굳이..
	
	
	//싱글톤 : 객체를 하나만 만들겠다는 의미. 다른 사람이 객체를 못만들도록 하는 방법.
	//객체 하나만 만드는데 2개이상 못만들게 하기 위해서는 접근제어자를 public static으로 둔 getInstance 메서드를 만들어서
	//나에게 요청하면 내 주소를 주면 된다. 자기 자신은 여러개 만들어도 괜찮으니까..
	
	private MemberMain() { //접근제어자를 private로 선언하면 같은 클래스 내에서만 접근이 가능하다.

	}
	
	//자기자신의 객체를 만들었음
	public static MemberMain getInstance() {
		if(mm == null) {
			mm = new MemberMain();
		}
		return mm;
		
	}

	public void init() {
		boolean f = true;
		while (f) {
			menu();
			System.out.println(" 메뉴 선택 >> ");
			int selMenu = in.nextInt();
			in.nextLine();
			if (selMenu == 1) {
				add();
			} else if (selMenu == 2) {
				viewList();
			} else if (selMenu == 3) {
				ser();
			} else if (selMenu == 4) {
				mod();
			} else if (selMenu == 5) {
				del();
			} else if (selMenu == 6) {
				f = false;
			}
		}
	}

	private void del() {
		System.out.println("회원탈퇴 페이지입니다.");
		System.out.println("본인 확인을 위해 이름을 입력하세요 >>");
		String name = in.nextLine();
		for (int i = 0; i < mlist.length; i++) {
			if (mlist[i] != null) {
				if (mlist[i].name.equals(name)) {
					mlist[i] = null;
					break;
				}
			}
		}

	}

	private void mod() {
		System.out.println("회원정보 수정 페이지입니다. 주소만 수정가능.");
		System.out.println("본인 확인을 위해 이름을 입력하세요 >>");
		String name = in.nextLine();
		for (int i = 0; i < mlist.length; i++) {
			if (mlist[i] != null) {
				if (mlist[i].name.equals(name)) {
					System.out.println(" 수정 주소 입력");
					String newaddr = in.nextLine();
					mlist[i].addr = newaddr;
					break;
				}
			}
		}

	}

	public void ser() {
		System.out.println("회원검색 페이지입니다.");
		System.out.println(" 검색할 회원의 이름을 입력하세요");
		String name = in.nextLine();
		for (int i = 0; i < mlist.length; i++) {
			if (mlist[i] != null) { 
				if (mlist[i].name.equals(name)) { 
					mlist[i].prt();
					break;
				}
			}
		}

	}

	public Member findUser(String name) {
		for (int i = 0; i < mlist.length; i++) {
			if (mlist[i] != null) { ///회원 이름 저장된 배열의 값이 null이 아니고
				if (mlist[i].name.equals(name)) { //매개변수로 받은 값이 회원이름배열의 어떤 값과 같을 때 회원이름 리턴
					return mlist[i];
				}
			}
		}
		return null;

	}

	public void menu() {
		System.out.println("1.신규가입  2.전체보기  3.검색하기  4.수정하기  5. 삭제하기   6. 종료하기");
		System.out.println("로그인을 하시려면 6을 입력하세요.");
	}

	public void add() {
	    System.out.println("신규가입입니다 ..... ");
	    Member m = new Member();
	    
	    System.out.println("이름을 입력하세요 <특수문자 1개 이상 필수>");
	    String name = in.nextLine();
	    m.name = name;

	    System.out.println("주소를 입력하세요:");
	    String addr = in.nextLine();
	    m.addr = addr;

	    System.out.println("나이를 입력하세요:");
	    int age = in.nextInt();
	    m.age = age;

	    for (int i = 0; i < mlist.length; i++) {
	        if (mlist[i] == null) {
	            mlist[i] = m;
	            break;
	        }
	    }
	}

	public void viewList() {
	    System.out.println("전체 회원 조회 페이지입니다.");
	    int cnt = 0;
		for (int i = 0; i < mlist.length; i++) {
			if (mlist[i] != null) {
				System.out.print(i+"번 회원 >> " );
				mlist[i].prt();
			}
		}
	}

}
