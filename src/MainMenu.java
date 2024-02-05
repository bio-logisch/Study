package theater;
import java.util.Scanner;

public class MainMenu {
	Scanner in = new Scanner(System.in);
//	MemberMain memberMain = new MemberMain(); ///������ ��ü�� MainMenu�� ���� ����, �̱������� �ٲٱ� ���� �ּ�ó��
	MemberMain memberMain = MemberMain.getInstance(); //�̱����� ���� �ش� ��ü ���� ����
	
	SeatMain seatMain = new SeatMain(); ///���� ��ü�� MainMenu�� ���� ����
	Member nowUser = null; ///null�̴ϱ� �α��� �� ����� ���ٴ� �ǹ���(�α��� �� ��� ����)
	MainMenu() { ///�޼��忡 ���� �ּ��� �� ���� �Ϲ������� �޼��� �ٷ� ���� �ּ��� �ܴ�.
		// �޴������ϱ�.. ///�����ڿ� �޴������ ������. ��ü�� �������ڸ���(���α׷� �������ڸ���) �޴��� ���ٴ°� �ǵ�
		boolean f = true;
		while (f) {
			System.out.println(" **** ��ȭ �¼� ���� �ý��� **** ");
			menu();
			System.out.println(" �޴� ���� >> ");
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
		seatMain.menu(null); ///�α��� ������ SeatMain Ŭ������ �ѱ� - �Ű������� �Ѱ��ִ� ���� ���Ѵ�.
	}

	private void login() {
		System.out.println("�̸��� �Է��ϼ���");
		String name = in.nextLine();
		nowUser = memberMain.findUser(name);
		if(nowUser != null) {
			seatMain.menu(nowUser); ///�α��� ������ SeatMain Ŭ������ �ѱ�
		}
		
	}

	private void join() {
		memberMain.init(); 
		///MemberMain�� ��ü�� �ϳ��� �־�� �ؼ� ���⿡ new�����ڷ� �����Ѱ� �ƴ϶� �ʵ�(�������)�� �ѹ� ��ü������
		///��������� Ŭ���� ���� ������ ���Ǹ� Ŭ������ ����� �� �ѹ� ����ȴ�(�ѹ� �Ҵ�ȴ�).
	}

	public void menu() {
		System.out.println("1.ȸ��������  2.�α���  3.��ȸ������");
	}
}