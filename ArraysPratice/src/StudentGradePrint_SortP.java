import java.util.Arrays;
import java.util.Comparator;

public class StudentGradePrint_SortP {
	public static void main(String[] args) {

		// 기본 배열 선언
		int arr[][] = { { 10, 33, 44 }, { 27, 5, 98 } };

		// 학생 이름을 담아줄 변수 선언
		String name = "";

		System.out.println("Name         Quiz1  Quiz2  Quiz3  sum  avg");
		System.out.println("-------------------------------------------");

		// 큰틀에서는 배열을 출력하기 위한 반복문
		for (int i = 0; i < arr.length; i++) {

			// name변수에 이름을 맵핑하기 위한 정규화
			name = (i == 0) ? "student1" : "student2";
			System.out.print("" + name + "    ");

			// 배열의 행안에서 반복하기 위한 반복문
			for (int j = 0; j < arr[i].length; j++) {

				// 배열행의 길이를 맵핑함(평균을 구할때 나눠주기위해서 만듦)
				int temp = arr[i].length;
				// 기본 배열을 출력함
				System.out.print("" + arr[i][j] + "     ");

				// 한 행의 줄을 다 출력했을 때 총점과 평균을 계산함
				if (j == arr[i].length - 1) {
					int sum = 0;
					double avg = 0.0f;
					for (int k = 0; k < arr[i].length; k++) {
						sum = sum + arr[i][k];
					}

					// 평균을 출력할 때는 소수점 첫째자리에서 반올림함.
					avg = (double) sum / temp;
					System.out.print(sum + "   " + String.format("%.1f", avg));
				}
			}
			System.out.println();
		}
		System.out.println("-------------------------------------------");
		System.out.print("tot        ");

		// 퀴즈별 총점을 구하기 위해 배열을 생성
		int[] sum = new int[3];

		// 퀴즈별 총점을 맵핑하고 배열을 출력함
		for (int i = 0; i < sum.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				sum[i] = sum[i] + arr[j][i];
			}
		}
		System.out.print(sum[0] + "   " + sum[1] + "   " + sum[2]);
		System.out.println("\n");

		// 기본배열을 복사하기 위해 새로운 배열 생성
		int[][] score = new int[2][4];

		// 복사배열을 출력하기 위한 이중 반복문
		for (int i = 0; i < arr.length; i++) {

			// 총점을 구하기 위한 변수 초기화
			int sum1 = 0;

			// 기본배열의 0번째 열부터 3개의 값을 복사배열에 0번째 열부터 복사함
			System.arraycopy(arr[i], 0, score[i], 0, 3);
			for (int j = 0; j < score[i].length; j++) {
				sum1 = sum1 + score[i][j];
			}
			// 구해진 총합을 i행 3열에 맵핑함
			score[i][3] = sum1;
			System.out.println(Arrays.toString(score[i]));
		}

		// 배열을 정렬하기 위한 과정
		Arrays.sort(score, new Comparator<int[]>() {

			// 비교를 위한 배열 생성
			public int compare(int[] o1, int[] o2) {
				// 만약 두 배열의 길이가 같다면
				if (o1[3] == o2[3]) {
					// 내림차순 정렬
					return o2[0] - o1[0];
				} else {
					return o2[0] - o1[0];
				}
			}
		});

		// 정렬된 배열을 출력
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length; j++) {
				System.out.print(score[i][j] + " ");
			}
			System.out.println();
		}

	}
}
