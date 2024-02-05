package theater;
import java.util.Scanner;

public class MemberMain {

	Scanner in = new Scanner(System.in);
	Member[] mlist = new Member[100];
	Member m = null; 
	
	public static MemberMain mm = null; //public:������ ���ٰ���, static:���뺯���μ� ��ü�������� ���ٰ���
	//���������ڴ� public, private, default ���� �ִ�. 
	//�� �ڵ� ��ſ� public static MemberMain mm = new MemberMain(); ���� �����ص� �Ǳ���. ������ ����..
	
	
	//�̱��� : ��ü�� �ϳ��� ����ڴٴ� �ǹ�. �ٸ� ����� ��ü�� �����鵵�� �ϴ� ���.
	//��ü �ϳ��� ����µ� 2���̻� ������� �ϱ� ���ؼ��� ���������ڸ� public static���� �� getInstance �޼��带 ����
	//������ ��û�ϸ� �� �ּҸ� �ָ� �ȴ�. �ڱ� �ڽ��� ������ ���� �������ϱ�..
	
	private MemberMain() { //���������ڸ� private�� �����ϸ� ���� Ŭ���� �������� ������ �����ϴ�.

	}
	
	//�ڱ��ڽ��� ��ü�� �������
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
			System.out.println(" �޴� ���� >> ");
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
		System.out.println("ȸ��Ż�� �������Դϴ�.");
		System.out.println("���� Ȯ���� ���� �̸��� �Է��ϼ��� >>");
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
		System.out.println("ȸ������ ���� �������Դϴ�. �ּҸ� ��������.");
		System.out.println("���� Ȯ���� ���� �̸��� �Է��ϼ��� >>");
		String name = in.nextLine();
		for (int i = 0; i < mlist.length; i++) {
			if (mlist[i] != null) {
				if (mlist[i].name.equals(name)) {
					System.out.println(" ���� �ּ� �Է�");
					String newaddr = in.nextLine();
					mlist[i].addr = newaddr;
					break;
				}
			}
		}

	}

	public void ser() {
		System.out.println("ȸ���˻� �������Դϴ�.");
		System.out.println(" �˻��� ȸ���� �̸��� �Է��ϼ���");
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
			if (mlist[i] != null) { ///ȸ�� �̸� ����� �迭�� ���� null�� �ƴϰ�
				if (mlist[i].name.equals(name)) { //�Ű������� ���� ���� ȸ���̸��迭�� � ���� ���� �� ȸ���̸� ����
					return mlist[i];
				}
			}
		}
		return null;

	}

	public void menu() {
		System.out.println("1.�ű԰���  2.��ü����  3.�˻��ϱ�  4.�����ϱ�  5. �����ϱ�   6. �����ϱ�");
		System.out.println("�α����� �Ͻ÷��� 6�� �Է��ϼ���.");
	}

	public void add() {
	    System.out.println("�ű԰����Դϴ� ..... ");
	    Member m = new Member();
	    
	    System.out.println("�̸��� �Է��ϼ��� <Ư������ 1�� �̻� �ʼ�>");
	    String name = in.nextLine();
	    m.name = name;

	    System.out.println("�ּҸ� �Է��ϼ���:");
	    String addr = in.nextLine();
	    m.addr = addr;

	    System.out.println("���̸� �Է��ϼ���:");
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
	    System.out.println("��ü ȸ�� ��ȸ �������Դϴ�.");
	    int cnt = 0;
		for (int i = 0; i < mlist.length; i++) {
			if (mlist[i] != null) {
				System.out.print(i+"�� ȸ�� >> " );
				mlist[i].prt();
			}
		}
	}

}
