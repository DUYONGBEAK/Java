import java.util.Scanner;

public class People {

	// 사용할 객체 데이터 생성
	int key;
	String name;
	String adress;
	int age;
	String partyName = ""; // 선호정당 선택을 하지 않은 유권자는 빈칸으로 놔두기 위함

	
	public void basicData() {
		// 유권자 정보 입력
		System.out.println("유권자 정보입력");
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력해주세요.");
		this.name = sc.nextLine();
		System.out.println("주소를 입력해주세요.");
		this.adress = sc.nextLine();
		System.out.println("나이를 입력해주세요.[투표 가능 나이는 20세 ~ 49세]");
		String userAge = sc.nextLine();
		// 입력값이 숫자가 아니라면 error를 출력
		try {
			this.age = Integer.parseInt(userAge);
		} catch (Exception e) {
			System.out.println("error");
		}

	}
	
	// 고유값을 맵핑하기 위한 메소드
	public void keyValue() {
		Scanner sc = new Scanner(System.in);
		String userKey = sc.nextLine();
		// 입력값이 숫자가 아니라면 error를 출력
		try {
			this.key = Integer.parseInt(userKey);
		} catch (Exception e) {
			System.out.println("error");
		}
	}
	
	// 선호정당을 입력하기 위한 메소드
	public void partyDate() {
		Scanner sc = new Scanner(System.in);
		System.out.println("선호 정당을 입력해주세요.[A, B, C 중 하나 선택]");
		String userInput = sc.nextLine();
		// 목록에 있는 선호정당으로 입력하면 선호정당을 맵핑함
		if (userInput.equals("A") || userInput.equals("B") || userInput.equals("C")) {
			this.partyName = userInput;
		}else {
			System.out.println("입력이 취소 되었습니다.");
			userInput = "";
		}
	}
	@Override
	public String toString() {
		return this.key + " : " + this.name + " " + this.adress + "(" + this.age + ")" + "(" + this.partyName + ")";
	}
}
