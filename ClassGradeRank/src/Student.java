public class Student {

	// 사용할 변수 생성
	String name;
	int midScore;
	int finScore;
	int totalScore;
	double avgScore;

	// 이름과 점수를 배열에 받아올 생성자를 만들어줌
	Student(String name, int midScore, int finScore) {
		this.name = name;
		this.midScore = midScore;
		this.finScore = finScore;
	}

	// 개인별 총점과 평균을 계산하는 메소드
	public void sumScore() {
		this.totalScore = this.finScore + this.midScore;
		this.avgScore = this.totalScore / 4;
	}

	// 배열을 출력하기 위한 Override
	public String toString() {
		return this.name + "(중간 : " + this.midScore + ", 기말 : " + this.finScore + ")";
	}
}
