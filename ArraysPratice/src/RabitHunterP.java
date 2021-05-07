
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.lang.Math;
/* 20*20 배열에 여우 한마리와 토끼 n마리가 배치되어 있고,
 * 여우는 가로 세로 대각선에 위치한 토끼를 모구 잡아먹을 수 있습니다.
 * 잡아먹을 수 있는 토끼 수를 세는 문제입니다.
 * 입력 예 : 3 10 10 1 5 6 8 2 17
 * 제일 앞 숫자는 토끼 수
 * 두번째 세번째는 여우 좌표(10,10)
 * 그 뒤부터 토끼좌표
 * 입력
 * 3   
 * 3 10 10 1 5 6 8 2 17
 * 4 3 3 2 1 4 2 5 3 4 5
 * 1 3 3 1 1
 * 
 * 출력
 * 0
 * 1
 * 2
 */
public class RabitHunterP {

	static int N;
	static int AnswerN;

	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("src/input.txt"));

		/*
		 * 표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);

		int T;
		int N = 20;
		int numberOfRabbit;
		int fox_X, fox_Y;
		T = sc.nextInt();
		sc.nextLine();

		for (int test_case = 1; test_case <= T; test_case++) {

			// 21x21 배열 생성
			int[][] map = new int[N + 1][N + 1];
			numberOfRabbit = sc.nextInt();

			// 여우 위치 배열에 넣
			fox_X = sc.nextInt();
			fox_Y = sc.nextInt();
			map[fox_X][fox_Y] = 2; // 여우는 맵에서 2로 표시

			// 토끼 위치 배열에 넣기
			for (int i = 1; i <= numberOfRabbit; i++) {
				int rabbit_x = sc.nextInt();
				int rabbit_y = sc.nextInt();
				map[rabbit_x][rabbit_y] = 1; // 토끼는 맵에서 1로 표시
			}

			// 토끼 잡기
			int cnt = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (map[i][j] == 1) {
						// 가로 토끼잡음
						if (i == fox_X) {
							cnt++;
							// 세로 토끼 잡음
						} else if (j == fox_Y) {
							cnt++;
							// 대각선 토끼 잡음
						} else if (Math.abs((double) (i - fox_X) / (double) (j - fox_Y)) == 1.0) {
							cnt++;
						}

					}
				}
			}
			AnswerN = cnt;

			System.out.println("#" + test_case + ": " + AnswerN);

			// Arrays.stream(map).forEach(x -> Arrays.fill(x, 0)); // use this line only
			// when you want to reset map[][] to 0
		}
	}
}
