import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
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
public class RabitHunter {

	static int N;
	static int AnswerN;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src\\input.txt"));

		/*
		 * 표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);

		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			/*
			 * 각 테스트 케이스를 표준 입력에서 읽어옵니다.
			 */

			N = sc.nextInt();
			int foxX = sc.nextInt();
			int foxY = sc.nextInt();

			int[][] E = new int[N][2]; // 그냥 배열로 해도댐

			for (int i = 0; i < N; i++) {
				E[i][0] = sc.nextInt(); // 토끼의 x 축
				E[i][1] = sc.nextInt(); // 토끼의 y 축

				// 여우와 토끼의 위치가 같을 경우
				if (foxX == E[i][0] && foxY == E[i][1]) {
					AnswerN = AnswerN + 1;
					continue;
				}

				// 가로 세로 토끼 잡기
				if (foxX == E[i][0] || foxY == E[i][1]) {
					AnswerN = AnswerN + 1;
				}

				// 우하향 대각선 왼쪽 & 우상향 대각선 왼쪽
				for (int j = 0, k = 0; k < 20; k++) {
					if (j == E[i][0] && k == E[i][1]) {
						AnswerN = AnswerN + 1;
					}
					if (j < foxY) {
						j++;
					} else {
						j--;
					}
				}

				// 우하향 대각선 오른쪽 & 우상향 대각선 오른쪽
				for (int j = 20, k = 20; k > 0; k--) {
					if (j == E[i][0] && k == E[i][1]) {
						AnswerN = AnswerN + 1;
					}
					if (j > foxY) {
						j--;
					} else {
						j++;
					}
				}

			}

			System.out.println("#" + test_case + " : " + "총 " + N + "마리의 토끼중에 " + " " + AnswerN + "마리를 잡았다.");
			AnswerN = 0;
		}
	}
}
