public class ExecClass {
	public static void main(String[] args) {

		// 클래스 3개를 생성
		Student[] student1 = { new Student("임시진", 60, 70), new Student("최성운", 90, 90), new Student("백두용", 50, 50),
				new Student("김승현", 70, 70) };
		Student[] student2 = { new Student("이지효", 50, 70), new Student("이경륜", 90, 90), new Student("김하나", 50, 50),
				new Student("박성철", 70, 70) };
		Student[] student3 = { new Student("장준영", 90, 70), new Student("김재민", 90, 90), new Student("김정연", 50, 50),
				new Student("김남덕", 70, 70) };

		// 클래스별 총점을 계산해서 순위를 출력하기 위해 새로운 배열을 만듦
		Sub[] sub = { new Sub("1반", student1), new Sub("2반", student2), new Sub("3반", student3) };

		// 학생 개인별 총점과 클래스내에서의 순위를 계산하고 출력.
		for (int i = 0; i < sub.length; i++) {
			sub[i].Sum();
			sub[i].sumOutput();
			sub[i].calssSort();
			sub[i].SortOutput();
		}

		// 반별 총점과 평균을 출력
		for (int i = 0; i < sub.length; i++) {
			System.out.println();
			System.out.println("" + (i + 1) + "반");
			sub[i].Calc();
			sub[i].ClassOutput();
		}

		// 반별 순위 계산을 위한 정렬
		for (int i = 0; i < sub.length; i++) {
			for (int j = i + 1; j < sub.length; j++) {
				if (sub[i].calssTotal < sub[j].calssTotal) {
					Sub temp = sub[i];
					sub[i] = sub[j];
					sub[j] = temp;
				}
			}
		}

		// 반별 순위를 출력
		for (int i = 0; i < 3; i++) {
			System.out.println("" + (i + 1) + "등) " + sub[i].name);
		}
	}
}
