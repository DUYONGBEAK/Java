import java.util.Arrays;

public class StudentGradePrint_Sort {

	public static void main(String[] args) {

		// 1번
		// 3행5열 배열생성
		int grade[][] = { { 10, 33, 44, 0, 0 }, { 27, 5, 98, 0, 0 }, { 0, 0, 0, 0, 0 } };

		int i = 0, j = 0;

		// 반복문을 통해 이중배열 합과 평균을 구함
		for (i = 0; i < grade[i].length - 3; i++) {
			for (j = 0; j < grade[i].length - 2; j++) {

				// 0, 1번째 행 가로 합과 평균 연산과정
				grade[i][grade[i].length - 2] = grade[i][grade[i].length - 2] + grade[i][j];
				grade[i][grade[i].length - 1] = grade[i][grade[i].length - 2] / (grade[i].length - 2);

				// 2번째 행 세로 합 연산
				grade[grade[i].length - 3][j] = grade[grade[i].length - 3][j] + grade[i][j];
			}

		}
		for (int k = 0; k < grade.length; k++) {
			// 결과출력
			System.out.println(Arrays.toString(grade[k]));
		}

		// 2번
		// 새로운 배열 생성
		int score[][] = new int[2][4];

		// 배열 복사
		for (i = 0; i < score.length; i++) {
			System.arraycopy(grade[i], 0, score[i], 0, 4);
			System.out.println(Arrays.toString(score[i]));
		}

		// 3번
		// 선택정렬을 이용한 내림차순 정열
		for (i = 0; i < 2; i++) {
			for (j = i + 1; j < 4; j++) {

				if (score[i][i] < score[i][j]) {
					int temp = score[i][i];
					score[i][i] = score[i][j];
					score[i][j] = temp;
				}
			}
		}
		for (int k = 0; k < score.length; k++) {
			// 결과출력
			System.out.println(Arrays.toString(score[k]));
		}
	}
}
