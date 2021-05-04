import java.util.ArrayList;
import java.util.Scanner;

public class ExecClass {
	public static void main(String[] args) {

		ArrayList<HumanManage> human = new ArrayList<HumanManage>();
		Scanner sc = new Scanner(System.in);

		// 메뉴 입력
		for (int i = 0; i < 999; i++) {
			System.out.println("메뉴를 선택해주세요.");
			System.out.println("1 : 직원 정보 입력");
			System.out.println("2 : 직원 정보 출력");
			System.out.println("3 : 직원 통계 출력");
			System.out.println("종료하시려면 :q를 입력하세요.");
			String userInput = sc.nextLine();

			// 직원 정보를 입력
			if (userInput.equals("1")) {
				HumanManage h1 = new HumanManage();
				
				// 직원마다 고유값을 주기위해 key값을 입력함
				System.out.println("key값을 입력하세요. 당신의 key값은 " + i + " 입니다.");
				h1.keyValue();
				// key값이 잘못 입력되었을 경우 
				if (h1.key != i) {
					System.out.println("잘못입력하셨습니다.");
					System.out.println("메뉴로 돌아갑니다.");
					System.out.println();
					continue;
				}
				// 정보 입력 메소드 사용
				h1.inData();
				// 입력한 정보를 리스트에 넣기
				human.add(h1);
			} else if (userInput.equals("2")) { // 사원 전체 목록 출력
				
				// 반복문을 돌면서 빈칸이 있는 직원은 출력하지 않음
				for (int j = 0; j < human.size(); j++) {
					try {
						if (!human.get(j).department.equals("") && !human.get(j).spot.equals("")) {
							System.out.println(human.get(j));
						}
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				System.out.println();
			} else if (userInput.equals("3")) { // 사원 통계 출력
				int eSum = 0;
				// 반복문을 돌면서 정보가 하나라도 비어있는 직원들은 사원 수에 포함하지 않음 
				for (int j = 0; j < human.size(); j++) {
					try {
						if (!human.get(j).department.equals("") && !human.get(j).spot.equals("")) {
							eSum++;
						}
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				System.out.println("전체 사원 수 : " + eSum);

				int oSum = 0;
				int dSum = 0;
				int hSum = 0;
				try {
					for (int j = 0; j < human.size(); j++) {
						if (human.get(j).department.equals("영업팀") && !human.get(j).spot.equals("")) {
							oSum++;
						} else if (human.get(j).department.equals("개발팀") && !human.get(j).spot.equals("")) {
							dSum++;
						} else if (human.get(j).department.equals("인사팀") && !human.get(j).spot.equals("")) {
							hSum++;
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				System.out.println("영업팀 : " + oSum + "명");
				System.out.println("개발팀 : " + dSum + "명");
				System.out.println("인사팀 : " + hSum + "명");

				int tSum = 0;
				int mSum = 0;
				try {
					for (int j = 0; j < human.size(); j++) {
						if (human.get(j).spot.equals("팀장")) {
							tSum++;
						} else if (human.get(j).spot.equals("사원")) {
							mSum++;
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				System.out.println("팀장 : " + tSum + "명");
				System.out.println("사원 : " + mSum + "명");

			} else if (userInput.equals(":q")) {
				break;
			}
		}
	}
}
