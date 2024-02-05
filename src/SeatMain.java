package theater;
import java.util.Scanner;

public class SeatMain {
	Scanner in = new Scanner(System.in);
	BookingInfo[][] booking = new BookingInfo[3][10]; ///�¼��� 2�����迭�� ����
	Member nowUser = null; ///���� ���� ����� ������ �˰� �; ������ ������
	int[][] badSeatInfo = { { 0, 0, 0, 0, 1, 1 },
				            { 0, 1, 8, 9, 0, 9 } }; // �¼��� �ƴ� �� ���� ��ǥ

	SeatMain() { ///�����ڴ� ��ü�� ������� �� ó�� �� �ѹ� ����Ǵ� �޼���(��뿹, �޴��ҷ����� Ȥ�� �ʱ��������ÿ� ������ ��)
		///���⼭ init�� ����� ���� ��� �����̸� ������ ����/���� ���� �̸� �����ص� �� ���� ��ó��, �̸� ������ ��Ƶδ� �뵵��
		init();
	}
	///�ʱ�ȭ �۾��� �ϱ� ���� �޼���
	private void init() {  ///private�̴ϱ� SeatMainŬ���������� �� �� ����
		BookingInfo noSeat = new BookingInfo(); ///�� ��ü�� ���� �� ���� �ڸ��� �����صα� ���� ������
		noSeat.userName = "NOseat"; ///7�� ��ü �������
		for (int i = 0; i < badSeatInfo[0].length; i++) {
			booking[badSeatInfo[0][i]][badSeatInfo[1][i]] = noSeat;
		}
		noSeat = null;

	}
	///������Ȳ�� ��ȣ(�����׸� ��׸� ��ǥ)�� ǥ���ϱ� ���� �޼���
	public void prt() {
	    System.out.println("--------------- �¼� ���� �ȳ� ---------------");
	    System.out.println("���ŵ� �¼� : * ");
		System.out.print("���Ű��� : �� ");
		System.out.print("���źҰ� : �� ");
	    System.out.println("-----------------------------------------");

		System.out.print("��/��");
		for (int i = 0; i < booking[0].length; i++) {
			System.out.print((i) + " ");
		}
		System.out.println();
		for (int i = 0; i < booking.length; i++) {
			System.out.print("  " + i + " ");
			for (int j = 0; j < booking[0].length; j++) {
				if (booking[i][j] == null) {
					System.out.print("�� ");
				} else if (booking[i][j].userName.equals("NOseat")) {
					System.out.print("�� ");
				} else {
					System.out.print("* ");
				} 
			}
			System.out.println();
		}
	}
	///�α��� �������� Ȯ���Ͽ� �޴��� �����ϴ� �޼���
	public void menu(Member m) {
		nowUser = m;  //nowUser�� null�� �� ����
		boolean f = true;
		while (f) {
			System.out.println("1. ����");
			System.out.println("2. ����Ȯ��");
			System.out.println("3. ������������");
			System.out.println("4. ������������");
			System.out.println("5. ��ü ������Ȳ ����");
			System.out.println("6. �¼�����");
			System.out.println("7. ���� �������� ����");
			System.out.println("8. �α׾ƿ�");
			System.out.println(" �޴� ���� >> ");
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
	
	//�α����� ���� ���ų����� �����ִ� �޼���
	private void myBookingList() {
		if(nowUser != null) {
			nowUser.bookingInfo(); //�����ڸ�� ���Ž� �Է��� ��й�ȣ ����ϴ� �޼��� ȣ��			
		}
		myprt();
		in.nextLine();
	}
	
	///�¼� �����ϴ� �޼���
	private void changeSeat() {
		System.out.println("<�¼������� ������ Ȯ�� �� �̷�� ���ϴ�> \n ������ �̸� �Է�");
		String userName = in.nextLine();
		int[] idx = searchUserName(userName); ///�̸��� �Է��ϸ� �࿭��ȣ ���Ϲ���
		if (idx != null) {
			BookingInfo binfo = findUserBooking(idx[0], idx[1]); 
			//���ų������� ����̸����� �˻��ϸ� nullPointerException�� ���� �� �ڵ带 if�� ������ �ְ� �Ʒ� 135�� ���� �ּ�ó����
			prt(); ///��ü �¼���Ȳ �׸� �����
			System.out.println("�¼��� �����ϼ���.");
			System.out.println("��(����)�� ��(����)�� ���ʴ�� �Է��ϼ���. \n���Է�");
			int row = in.nextInt();
			in.nextLine();
			System.out.println("���� �Է��ϼ���");
			int col = in.nextInt();
			in.nextLine();
			if (findUserBooking(row, col) == null) { ///�� �ڸ��� ���ڸ����� Ȯ���ϴ� �ڵ�, ���ڸ��̹Ƿ� �¼����氡��
				binfo.row = row; //������ �¼� ���ȣ �߰�
				binfo.col = col; //������ �¼� ����ȣ �߰�
				booking[row][col] = binfo;
				booking[idx[0]][idx[1]] = null; ///���������ڸ��� ���ڸ��� ����
				System.out.println("�¼������� �Ϸ� �Ǿ����ϴ�");
			} else {
				System.out.println("�̹� ����� �ڸ��� ���� �� �� �����ϴ�.");
			}
			in.nextLine();
		}
//		binfo = null;
	}
	//���ų��� �����ϴ� �޼���
	private void del() {
		System.out.println("<���Ż���> ������ �̸��� �Է��ϼ���");
		String userName = in.nextLine();
		int[] idx = searchUserName(userName);
		if (idx == null) {
			System.out.println("���� ������ �����");
		} else {
			booking[idx[0]][idx[1]] = null; ///���೻�� ����
		}
		in.nextLine();
	}
	//���ų��� ����(�ڸ��̵�)�ϴ� �޼���
	private void mod() {
		System.out.println("<���ż���> ������ �̸��� �Է��ϼ���");
		String userName = in.nextLine();
		int[] idx = searchUserName(userName);
		if (idx == null) {
			System.out.println("���� ������ �����ϴ�");
		} else {
			BookingInfo binfo = findUserBooking(idx[0], idx[1]);
			System.out.println("<��й�ȣ�� �����ϼ���>");
			String pass = in.nextLine();
			binfo.userPass = pass;
		}
		in.nextLine();
	}
	///������Ȳ�� �����ִ� �޼���
	private void bookingPrt() {
		prt();
		System.out.println();
		for (int i = 0; i < booking.length; i++) {
			// System.out.print(" " + i + " ");
			for (int j = 0; j < booking[0].length; j++) {
				if (booking[i][j] == null) {
					System.out.println((i + "�� / " + j + "�� " + "[���డ��]"));
				} else if (booking[i][j] != null) {
					if (booking[i][j].userName.equals("NOseat")) {
					} else {
						String maskingName = booking[i][j].userName.charAt(0) + "**"; ///����ŷ
						System.out.print((i + "�� / " + j + "�� " + "[�����] " + maskingName + "��"));
						System.out.println();
					}
				}
			}
			System.out.println();
		}
		in.nextLine();
	}
	///���� �α����� ������� �ƴ��� üũ���ִ� �޼���
	private boolean loginCheck() {
		if (nowUser == null) {
			System.out.println("ȸ�� ���� �Դϴ� ");
			return false; ///ȸ���ƴ�
		}
		return true;  ///ȸ����
	}
	///�˻� ��� �޼���
	private void ser() { 
		System.out.println("<����Ȯ��> ������ �̸��� �Է��ϼ���");
		String userName = in.nextLine();
		int[] idx = searchUserName(userName);
		if (idx == null) {
			System.out.println("���� ������ �����");
		} else {
			///�����ڰ� ������, �ش�Ǵ� ��ġ�� �ּҰ��� ���Ϲ���
			BookingInfo binfo = findUserBooking(idx[0], idx[1]); 
			System.out.println(
					"�������� : �� " + idx[0] + "/ �� " + idx[1] + "(" + binfo.userName + "/" + binfo.userPass + ")");
		}
		in.nextLine();
	}
	///��� ���� ������ �������� ��ü�� ã���ִ� �޼���, �������� ��ü�ּҸ� �������� - ����, �˻������� ��밡��
	private BookingInfo findUserBooking(int row, int col) {
		if (booking[row][col] != null) {
			return booking[row][col];  //���ŵ� �ڸ��� �����ڸ� ����
		}
		return null; //���ڸ��� null�� ����

	}
	///����ڰ� �Է��� �̸��� ��ü�� ������ ���� �ִ��� ã���ִ� �޼���
	private int[] searchUserName(String userName) {
		int[] idx = null;
		for (int i = 0; i < booking.length; i++) {
			for (int j = 0; j < booking[0].length; j++) {
				if (booking[i][j] != null) {
					if (booking[i][j].userName.equals(userName)) {
						idx = new int[2];
						idx[0] = i; ///��
						idx[1] = j; ///��
						return idx; ///���ϰ��� �ϳ��ε� �������ϴ� �࿭ ������ �ΰ��� �迭�� ���� �ϳ��� ��� �ѱ��
									///�迭 ���� ��ü�� ���ϰ����� ������ �ȴ�...!
					}
				}
			}
		}
		return null;
	}
	///�����ϴ� �޼���
	private void add() {
		prt();
		System.out.println("��� ���� ���ʴ�� �Է��ϼ���. \n���Է�");
		int row = in.nextInt();
		in.nextLine();
		System.out.println("���� �Է��ϼ���");
		int col = in.nextInt();
		in.nextLine();

		if (findUserBooking(row, col) == null) { //�Է��� �¼��� ���ڸ���
			BookingInfo newBooking = new BookingInfo(); //��������(�����ڸ�,���,�¼��࿭��ȣ) ������ ��ü����
			System.out.println("������ ���� �Է��ϼ���");
			String userName = in.nextLine();
			int[] idx = searchUserName(userName); //�̹� ������ ������� üũ
			if (idx == null) { //������ ����� �ƴϸ�(null�̸�) - �̹� ���������� �¼����� �����ϹǷ� null���� �ƴ�
				System.out.println("��й�ȣ�� �Է��ϼ���");
				newBooking.userPass = in.nextLine();
				newBooking.userName = userName;
				newBooking.row = row; //������ �¼��� ���ȣ ����
				newBooking.col = col; //������ �¼��� ����ȣ ����
				booking[row][col] = newBooking;
				nowUser.inputBooking(newBooking); //nowUser��� Member���� �ȵ�. inputBooking�� ����޼��尡 �ƴϱ⶧��
				//nowUser�� SeatMainŬ�������� ����� Member�ڷ��� �����̹Ƿ� 
				// nowUser���� ������ inputBooking�޼����� ���ϰ��� mylist�迭�� ����� �α��� �� ȸ���� ������ ����(�����ڸ�, ���)  
			} else {
				System.out.println(userName + "���� �̹� ���� ������ �ֽ��ϴ�");
			}

		} else {
			System.out.println("������ �¼��� ���ų� �̹� ����� �¼��Դϴ�."); //�Է��� �¼��� ���ڸ��� �ƴϸ�(noSeat�̰ų� �̹̿���)
		}
		in.nextLine();
	}
	
	
	
	//���� ������ �ڸ��� ��Ʈ�� ǥ���ϴ� �޼���
	public void myprt() {
	    System.out.println("���� �����¼� : �� ");
	    System.out.println("�ٸ� ȸ���� �����¼� : * ");
	    System.out.println();
	    System.out.print("��/��");
	    for (int i = 0; i < booking[0].length; i++) {
	        System.out.print((i) + " ");
	    }
	    System.out.println();
	    for (int i = 0; i < booking.length; i++) {
	        System.out.print("  " + i + " ");
	        for (int j = 0; j < booking[0].length; j++) {
	            if (booking[i][j] == null) {
	                System.out.print("�� ");
	            } else if (booking[i][j].userName.equals("NOseat")) {
	                System.out.print("�� ");
	            } else if (nowUser != null && nowUser.mylist != null) {
	                for (int k = 0; k < nowUser.mylist.length; k++) {
	                    if (nowUser.mylist[k] != null && nowUser.mylist[k].row == i && nowUser.mylist[k].col == j) {
	                        System.out.print("�� ");
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
