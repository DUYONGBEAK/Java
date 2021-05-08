import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class InfoManage {
	public static void main(String[] args) {

		// 유권자 정보를 위한 리스트
		ArrayList<People> people = new ArrayList<People>();
		// 정당별 선호도를 입력하기위한 리스트
		ArrayList<Party> party = new ArrayList<Party>();
		Scanner sc = new Scanner(System.in);

		// 메뉴
		for (int i = 0; i < 999; i++) {
			System.out.println("메뉴를 선택해 주세요.");
			System.out.println("1 : 유권자 정보입력");
			System.out.println("2 : 전체 유권자 출력");
			System.out.println("3 : 유권자 기본통계 출력");
			System.out.println("4 : 선호 정당 입력");
			System.out.println("5 : 선호 정당 통계 출력");
			System.out.println("종료를 원하시면 :q 를 입력하세요.");
			String userInput = sc.nextLine();

			// 유권자 정보 입력
			if (userInput.equals("1")) {

				// 메소드를 사용하기 위해 클래스를 생성
				People po = new People();
				System.out.println("key값을 입력하세요. 당신의 key값은 " + i + " 입니다.");
				// 키값을 입력하는 메소드를 불러옴
				po.keyValue();
				// 지정한 키값이 아니면 continue함. 따라서 리스트에 포함되지 않음
				if (po.key != i) {
					System.out.println("잘못입력하셨습니다.");
					System.out.println("메뉴로 돌아갑니다.");
					System.out.println();
					continue;
				}
				// 유권자 정보를 입력하는 메소드 실행
				po.basicData();
				// 정보를 리스트에 추가함
				people.add(po);
				System.out.println();
				
			} else if (userInput.equals("2")) { // 유권자 정보 출력
				System.out.println("전체 유권자 목록");
				// 리스트의 사이즈만큼 반복문을 돌면서 출력함
				for (int j = 0; j < people.size(); j++) {
					System.out.println(people.get(j));
				}
				System.out.println();
				System.out.println("선호정당을 입력한 유권자 목록");
				// 반복문을 돌면서 리스트의 선호정당의 값이 존재하는지 확인하고, 해당 리스트를 출력 
				for (int j = 0; j < people.size(); j++) {
					if (!people.get(j).partyName.equals("")) {
						System.out.println(people.get(j));
					}
				}
				System.out.println();
				
			} else if (userInput.equals("3")) { // 유권자 기본통계 출력
				// 전체 유권자 수 출력
				System.out.println("전체 유권자 수 : " + people.size());
				
				// 리스트안에 있는 모든 age데이터를 합하는 변수를 생성 
				double sumAge = 0;
				for (int j = 0; j < people.size(); j++) {
					sumAge += people.get(j).age;
				}
				System.out.println("유권자의 평균나이 : " + (double) sumAge / people.size());

				// 유권자 별 연령을 카운트하기 위한 배열을 생성.
				int[] cntAge = new int[5];
				// 유권자의 사이즈만큼 반복문을 돌면서 해당 연령대에 만족하면 해당 배열을 카운트함
				for (int j = 0; j < people.size(); j++) {
					if (people.get(j).age >= 20 && people.get(j).age < 30) {
						cntAge[2]++;
					} else if (people.get(j).age >= 30 && people.get(j).age < 40) {
						cntAge[3]++;
					} else if (people.get(j).age >= 40 && people.get(j).age < 50) {
						cntAge[4]++;
					}
				}
				// 연령별 유권자 출력
				for (int j = 2; j < cntAge.length; j++) {
					System.out.println("" + j + "0대의 유권자 수는 " + cntAge[j]);
				}
				System.out.println();

			} else if (userInput.equals("4")) { // 선호정당 입력
				System.out.println("선호 정당을 입력하려는 분의 key값을 입력하세요.");
				// 키값이 int형으로 변환되어 있기 때문에 입력값을 int로 받아옴
				int userKey = sc.nextInt();
				// 선호정당을 입력하기 위한 메소드 사용을 위해 클래스 생성
				People po = new People();
				
				// 유권자 수 만큼 반복문을 돌면서 입력받은 키값과 유권자의 키값이 일치하는 리스트가 있는지 확인함
				for (int j = 0; j < people.size(); j++) {
					if (userKey == people.get(j).key) {
						// 키 값이 일치한다면 선호정당 입력 메소드를 실행
						people.get(j).partyDate();
					} else {
						System.out.println("입력 가능한 유권자가 없습니다.");
					}
				}
				System.out.println();
				
			} else if (userInput.equals("5")) { // 선호 정당 통계 출력
				int cnt = 0;
				// 유권자 수 만큼 반복문을 돌면서 선호정당이 빈칸이 아닌 유권자만 카운트 함
				for (int j = 0; j < people.size(); j++) {
					if (!people.get(j).partyName.equals("")) {
						cnt++;
					}
				}
				System.out.println("선호정당 입력 비율 : " + (double) cnt / people.size());
				System.out.println();
				
				// Party클래스의 객체 데이터를 사용하기 위해 클래스를 생성
				Party pt = new Party("");
				// 유권자 수 만큼 반복문을 돌면서 선호정당 조건이 일치하면 해당 객체데이터를 카운트 해줌
				for (int j = 0; j < people.size(); j++) {
					if (people.get(j).partyName.equals("A")) {
						pt.favoriteA++;
					} else if (people.get(j).partyName.equals("B")) {
						pt.favoriteB++;
					} else if (people.get(j).partyName.equals("C")) {
						pt.favoriteC++;
					}
				}
				System.out.println("A당 선호자 수는 : " + pt.favoriteA);
				System.out.println("A당 선호자 비율 : " + (double) pt.favoriteA / people.size());
				System.out.println("B당 선호자 수는 : " + pt.favoriteB);
				System.out.println("B당 선호자 비율 : " + (double) pt.favoriteB / people.size());
				System.out.println("C당 선호자 수는 : " + pt.favoriteC);
				System.out.println("C당 선호자 비율 : " + (double) pt.favoriteC / people.size());
				System.out.println();
				
				// Party클래스의 생성자를 이용해서 클래스를 생성해줌.(각 클래스별로 변수명이 다르다는 것은 메모리가 따로 할당되어 있다는 뜻)
				Party aParty = new Party("A");
				Party bParty = new Party("B");
				Party cParty = new Party("C");

				// 유권자 수 만큼 반복문을 돌면서 연령별 선호정당을 카운트 함
				for (int j = 0; j < people.size(); j++) {
					// 해당 유권자의 선호 정당이 A라면 조건문을 들어온다.
					if (people.get(j).partyName.equals("A")) {
						if (people.get(j).age >= 20 && people.get(j).age < 30) {
							// Party클래스의 객체데이터를 불러와서 20대선호도를 카운트
							aParty.favorite20Count++;
						} else if (people.get(j).age >= 30 && people.get(j).age < 40) {
							aParty.favorite30Count++;
						} else if (people.get(j).age >= 40 && people.get(j).age < 50) {
							aParty.favorite40Count++;
						}
					} else if (people.get(j).partyName.equals("B")) {
						if (people.get(j).age >= 20 && people.get(j).age < 30) {
							bParty.favorite20Count++;
						} else if (people.get(j).age >= 30 && people.get(j).age < 40) {
							bParty.favorite30Count++;
						} else if (people.get(j).age >= 40 && people.get(j).age < 50) {
							bParty.favorite40Count++;
						}
					} else if (people.get(j).partyName.equals("C")) {
						if (people.get(j).age >= 20 && people.get(j).age < 30) {
							cParty.favorite20Count++;
						} else if (people.get(j).age >= 30 && people.get(j).age < 40) {
							cParty.favorite30Count++;
						} else if (people.get(j).age >= 40 && people.get(j).age < 50) {
							cParty.favorite40Count++;
						}
					}
				}
				System.out.println(aParty);
				System.out.println(bParty);
				System.out.println(cParty);
			} else if (userInput.equals(":q")) {
				System.out.println("프로그램 종료");
				break;
			}

		}
	}
}
