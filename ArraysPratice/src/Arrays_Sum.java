import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Arrays_Sum {
	// 사용할 변수들을 초기화
	static int R;
	static int C;
	static int num;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src\\inputAS.txt"));

		Scanner s = new Scanner(System.in);
		// 계산할 행과 열을 받아옴
		R = s.nextInt();
		C = s.nextInt();
		System.out.println("" + R + " " + C);

		// 배열을 생성함
		int[][] arr = new int[R][C];

		// 생성한 배열에 값을 넣어줌
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][j] = s.nextInt();
			}
		}

		// 배열 출력
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

		// 연산을 진행할 횟수를 지정함
		num = s.nextInt();
		System.out.println(num);

		// 연산 지정 횟수만큼 반복함
		for (int caseTest = 0; caseTest < num; caseTest++) {

			// 각각 시작위치의 행렬부터 끝위치의 행렬을 맵핑
			int R1 = s.nextInt();
			int C1 = s.nextInt();
			int R2 = s.nextInt();
			int C2 = s.nextInt();

			int RCsum = 0;

			System.out.println("" + R1 + " " + C1 + " " + R2 + " " + C2);

			// 범위에 맞는 합연산을 진행
			for (int i = R1 - 1; i < R2; i++) {
				for (int j = C1 - 1; j < C2; j++) {
					RCsum = RCsum + arr[i][j];
				}
			}

			System.out.println(RCsum);

		}

	}
}
