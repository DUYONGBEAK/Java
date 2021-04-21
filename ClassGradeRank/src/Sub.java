
public class Sub {

	// 반의 이름을 받아올 변수와 프로퍼티가 있는 Student를 사용하기 위해 해당타입으로 배열생성
	String name;
	Student[] subClass;

	// 반의 이름과 그 반학생들의 정보가 담겨있는 배열을 받아오기 위해 생성자를 만듦
	Sub(String name, Student[] subClass) {
		this.name = name;
		this.subClass = subClass;
	}

	// 학생 개인별 총합과 평균을 구함
	public void Sum() {
		for (int i = 0; i < subClass.length; i++) {
			subClass[i].sumScore();
		}
	}

	// 학생 개인별 총점과 평균을 출력
	public void sumOutput() {
		System.out.println();
		for (int i = 0; i < subClass.length; i++) {
			System.out.println(
					subClass[i].name + "(총점 : " + subClass[i].totalScore + ", 평균 : " + subClass[i].avgScore + ")");
		}
	}

	// 학생 개인별 순위를 위한 정렬
	public void calssSort() {

		for (int i = 0; i < subClass.length; i++) {
			for (int j = i + 1; j < subClass.length; j++) {
				if (subClass[i].totalScore < subClass[j].totalScore) {
					Student temp = subClass[i];
					subClass[i] = subClass[j];
					subClass[j] = temp;
				}
			}
		}
	}

	// 학생 개인별 순위를 출력
	public void SortOutput() {
		System.out.println();
		for (int i = 0; i < subClass.length; i++) {
			System.out.println(subClass[i].name + "(총점 : " + subClass[i].totalScore + ", 평균 : " + subClass[i].avgScore
					+ ")" + "[" + (i + 1) + "등]");
		}
	}

	int calssTotal = 0;
	double calssAvg = 0;

	// 반별 총점과 평균을 구함
	public void Calc() {
		for (int i = 0; i < subClass.length; i++) {
			this.calssTotal = this.calssTotal + subClass[i].totalScore;
		}
		calssAvg = (double) calssTotal / subClass.length;
	}

	// 반별 총점과 평균을 출력함
	public void ClassOutput() {
		System.out.println();
		System.out.println("반 총점 : " + this.calssTotal);
		System.out.println("반 평균 : " + this.calssAvg);
	}
}
