import java.util.ArrayList;
import java.util.Scanner;

public class ClientManage {
	public static void main(String[] args) {

		// 기본 고객관리 명단 리스트
		ArrayList<Client> c = new ArrayList<Client>();
		// 선택적으로 별점입력을 위한 고객관리 명단 리스트
		ArrayList<StarPoint> p = new ArrayList<StarPoint>();
		Scanner s = new Scanner(System.in);
		
		// 메뉴 선택
		for (int i = 0; i < 9999999; i++) {
			System.out.println();
			System.out.println("원하시는 메뉴를 선택해주세요.");
			System.out.println("1. : 방문자 새로 입력");
			System.out.println("2. : 방문자 전체 목록 출력");
			System.out.println("작업이 완료되셨으면 exit를 입력하세요.");
			String userInputString = s.nextLine();
			
			// 이름과 연락처 기입
			if (userInputString.equals("1")) {
				System.out.println();
				System.out.println("이름과 연락처를 차례로 입력하세요.");
				
				// 입력받는 변수들을 별점입력할 때 동일하게 가져가기 위해 변수에 담음
				String username = s.nextLine();
				String userphone = s.nextLine();
				c.add(new Client(username, userphone));
				System.out.println();
				
				// 별점 입력 부분
				System.out.println("별점을 입력하시겠습니까? [네 : 1 , 아니오 : 2]");
				String userInputString2 = s.nextLine();
				if (userInputString2.equals("1")) {
					
					// 위에서 입력받은 이름과 연락처는 그대로 가져오고 지금 입력하는 별점만 추가해서 새로운 리스트에 담음
					System.out.println("1 ~ 5점 중에 숫자로 입력하세요.");
					String userstar = s.nextLine();
					// 별점의 평균을 구하기 위해 형변환을 진행
					int star = Integer.parseInt(userstar);
					p.add(new StarPoint(username, userphone, star));
				
				// 아니오를 누르면 초기화면으로 돌아감	
				}else if(userInputString2.equals("2")){
					continue;
				}else {
					System.out.println("올바르게 입력해 주세요.");
				}
				
				// 전체목록 출력
			} else if (userInputString.equals("2")) {
				System.out.println();
				// 아름과 연락처 출력
				for (int j = 0; j < c.size(); j++) {
					System.out.println("" + (j + 1) + "번 고객 :" + c.get(j).name + " (" + c.get(j).phone + ")");
				}
				System.out.println();
				// 별점 입력한 목록 출력
				int totalScore = 0;
				for (int k = 0; k < p.size(); k++) {
					System.out.println("" + (k + 1) + "번 고객 :" + p.get(k).username + " (" + p.get(k).star + "점)");
					totalScore = totalScore + p.get(k).star;
				}
				// 별점 평균 출력
				System.out.println();
				System.out.println("고객 평균 별점 : " + ((double)totalScore / p.size()));
				System.out.println();
			} else if (userInputString.equals("exit")) {
				break;
			} else {
				System.out.println("올바르게 입력해 주세요.");
			}
		}

	}
}
