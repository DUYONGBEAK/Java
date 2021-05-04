import java.util.Scanner;

public class HumanManage {
	int key;
	String name;
	String department;
	String spot;
	String task;

	// 정보를 입력하는 메소드
	public void inData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("직원 이름을 입력하세요.");
		String userName = sc.nextLine();
		this.name = userName;

		System.out.println("부서명을 입력하세요.[영업팀, 개발팀, 인사팀]");
		String userDepartment = sc.nextLine();
		if (userDepartment.equals("영업팀") || userDepartment.equals("개발팀") || userDepartment.equals("인사팀")) {
			this.department = userDepartment;
		} else {
			System.out.println("없는 부서입니다.");
			System.out.println();
			return;
		}
		System.out.println("직급을 입력하세요.[팀장, 사원]");
		String userSpot = sc.nextLine();
		if (userSpot.equals("팀장") || userSpot.equals("사원")) {
			this.spot = userSpot;
		} else {
		System.out.println("없는 직급입니다.");
		System.out.println();
		return;
		}
		System.out.println("담당업무를 입력하세요.");
		String userTask = sc.nextLine();
		this.task = userTask;
		System.out.println();
	}

	// 고유값을 입력하는 메소드
	public void keyValue() {
		Scanner sc = new Scanner(System.in);
		String userKey = sc.nextLine();
		try {
			this.key = Integer.parseInt(userKey);
		} catch (Exception e) {
			System.out.println("숫자가 아닙니다.");
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.key + " " + department + " : " + this.name + " " + this.spot + " (" + this.task + ")";
	}
}
