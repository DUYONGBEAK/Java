import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerManage {
	public static void main(String[] args) {

		List<Customer> customer = new ArrayList<Customer>();
		List<StarScore> starScore = new ArrayList<StarScore>();
		Scanner s = new Scanner(System.in);

		for (int i = 0; i < 999; i++) {
			System.out.println("메뉴를 선택하세요.");
			System.out.println("1 : 명부 작성");
			System.out.println("2 : 명부 전체출력");
			System.out.println("3 : 명부 삭제");
			System.out.println("종료를 원하시면 :q를 입력하세요.");
			String userInput = s.nextLine();

			if (userInput.equals("1")) {
				System.out.println("이름이 입력하세요.");
				String userName = s.nextLine();
				System.out.println("연락처를 입력하세요.");
				String userPhone = s.nextLine();
				customer.add(new Customer(userName, userPhone));
				System.out.println("별점을 입력하시겠습니까?[y : n]");
				String userString = s.nextLine();

				if (userString.equals("y")) {
					System.out.println("1 ~ 5점 입력하세요.");
					String starPoint = s.nextLine();
					int star = Integer.parseInt(starPoint);
					if (1 < star || star > 6) {
						for (int j = 0; j < 999; j++) {
							System.out.println("1 ~ 5점을 입력하세요.");
							starPoint = s.nextLine();
							star = Integer.parseInt(starPoint);
							if (star >= 1 && star <= 5) {
								break;
							}
						}
					}
					starScore.add(new StarScore(userName, userPhone, star));

				} else if (userString.equals("n")) {
					System.out.println("별점 입력을 하지 않습니다.");
				} else {
					System.out.println("숫자를 입력하지 않으셨습니다. 별점입력은 명단 삭제 후 다시 진행해주세요.");
				}
				System.out.println();

			} else if (userInput.equals("2")) {
				for (int j = 0; j < customer.size(); j++) {
					System.out.println("" + (j + 1) + customer.get(j).name + ", " + customer.get(j).phone);
				}
				System.out.println();
				int totalStar = 0;
				for (int j = 0; j < starScore.size(); j++) {
					System.out.println("" + starScore.get(j).name + "(" + starScore.get(j).star + "점)");
					totalStar = totalStar + starScore.get(j).star;
				}

				System.out.println("총점 : " + totalStar + "점, 평균 : " + ((double) totalStar / starScore.size()));

				System.out.println();
			} else if (userInput.equals("3")) {
				System.out.println("연락처를 입력하세요.(삭제되었습니다가 떠야 정상적으로 실행이 된 것입니다.)");
				String userphone = s.nextLine();
				for (int j = 0; j < customer.size(); j++) {
					if(customer.get(j).phone == userphone) {
						customer.remove(j);
					}
				}
				System.out.println("삭제되었습니다.");
				System.out.println();
			} else if (userInput.equals(":q")) {
				break;
			} else {
				System.out.println("잘못 입력했습니다.");
			}
		}
	}
}
