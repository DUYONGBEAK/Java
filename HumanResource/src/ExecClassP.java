import java.util.HashMap;
import java.util.Scanner;

public class ExecClassP {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 부서별로 메모리할당
//		Part[] part = { new Part("인사팀"), new Part("개발팀"), new Part("영업팀") };

		// map은 키를 가져야 하므로 제네릭에 키값의 타입과 인스턴스의 타입을 모두 정의해 주어야 한다.
		HashMap<String, Part> part = new HashMap<String, Part>();
		// 키를 설정하고, 그 키에 해당하는 클래스를 생성해줌
		part.put("인사팀", new Part("인사팀"));
		part.put("개발팀", new Part("개발팀"));
		part.put("영업팀", new Part("영업팀"));

		for (int i = 0; i < 999; i++) {
			System.out.println("메뉴를 선택해주세요.");
			System.out.println("1 : 직원 정보 입력");
			System.out.println("2 : 직원 정보 출력");
			System.out.println("3 : 직원 정보 수정");
			System.out.println("종료하시려면 :q를 입력하세요.");
			String userInput = sc.nextLine();

			if (userInput.equals("1")) { // 직원 정보를 입력
				// 임시 저장공간에 입력값을 넣기 위해 클래스를 새로 생성
				People tempPeople = new People();

				System.out.println("이름을 입력해주세요.");
				tempPeople.name = sc.nextLine();
				System.out.println("직위를 입력해주세요.");
				tempPeople.position = sc.nextLine();
				System.out.println("담당업무를 입력해주세요.");
				tempPeople.work = sc.nextLine();

				System.out.println("담당 부서를 선택해 주세요.");
				System.out.println("1 : 인사팀");
				System.out.println("2 : 개발팀");
				System.out.println("3 : 영업팀");

				String selectNumber = sc.nextLine();
				if (selectNumber.equals("1")) {
					// part[0]의 member라는 이름을 가진 ArrayList안에 tempPeople에 임시로 담은 객체데이터를 넣는다.
//					part[0].member.add(tempPeople);
					// part HashMap의 키값이 인사팀인 ArrayList안에 tempPeople에 임시로 담은 객체데이터를 넣는다.
					part.get("인사팀").member.add(tempPeople);
				} else if (selectNumber.equals("2")) {
//					part[1].member.add(tempPeople);
					part.get("개발팀").member.add(tempPeople);
				} else if (selectNumber.equals("3")) {
//					part[2].member.add(tempPeople);
					part.get("영업팀").member.add(tempPeople);
				}
			} else if (userInput.equals("2")) { // 직원정보 출력

				// 직원 정보를 반복문을 돌려서 출력
//				for (int j = 0; j < part.length; j++) { // 부서개수만큼 반복함
//					System.out.println("" + part[j].name + "정보출력");
//					for (int k = 0; k < part[j].member.size(); k++) { // 해당 부서의 직원 수 만큼 반복함
//						System.out.println(part[j].member.get(k));
//					}
//				}
				
				// 키값의 리스트크기만큼 반복문을 돌려서 출력함
				for (int j = 0; j < part.get("인사팀").member.size(); j++) {
					System.out.println(part.get("인사팀").member.get(j));
					
				}
				for (int j = 0; j < part.get("개발팀").member.size(); j++) {
					System.out.println(part.get("개발팀").member.get(j));
					
				}
				for (int j = 0; j < part.get("영업팀").member.size(); j++) {
					System.out.println(part.get("영업팀").member.get(j));
					
				}
			} else if (userInput.equals("3")) { // 직원 정보 수정 메뉴

				System.out.println("수정할 이름을 입력하세요.");
				String targetName = sc.nextLine();
				System.out.println("수정할 인원이 속한 부서를 선택해주세요.");
				System.out.println("1 : 인사팀");
				System.out.println("2 : 개발팀");
				System.out.println("3 : 영업팀");
				String selectNumber = sc.nextLine();
				// 해당부서의 정보 전체가 들어갈 변수를 생성
				Part selectPart = null;
				
				if (selectNumber.equals("1")) {
//					selectPart = part[0];
					selectPart = part.get("인사팀");
				} else if (selectNumber.equals("2")) {
//					selectPart = part[1];
					selectPart = part.get("개발팀");
				} else if (selectNumber.equals("3")) {
//					selectPart = part[2];
					selectPart = part.get("영업팀");
				}
				// 참 거짓을 판단할 플래그 변수 선언
				// 변수안에 값이 들어가야 하기 때문에 클래스타입의 변수로 생성
				People selectPeople = null;

				// 선택된 부서리스트의 사이즈만큼 반복문을 돌려서 targetName과 같은 직원을 찾아서 플래스변수에 값을 맵핑함
				for (int j = 0; j < selectPart.member.size(); j++) {
					if (selectPart.member.get(j).name.equals(targetName)) {
						selectPeople = selectPart.member.get(j);
					}
				}

				try {
					// 플래그 변수에 값이 들어 있다면 해당하는 사람의 정보를 수정함
					if (selectPeople != null) {
						System.out.println("수정할 직위를 입력해주세요.");
						selectPeople.position = sc.nextLine();
						System.out.println("수정할 담당 업무를 입력해주세요.");
						selectPeople.work = sc.nextLine();
					}
				} catch (Exception e) {
					// TODO: handle exception
				}

			} else if (userInput.equals(":q")) { // 종료
				break;
			}
		}
	}
}
