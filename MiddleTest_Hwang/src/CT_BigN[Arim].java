import java.util.Arrays;
import java.util.Scanner;
/* 수열의 길이 :N
 * 수가 더해지는 횟수 : M
 * 특정 숫ㅈ가 더해지는 최대 횟수 : K
 * 주어진 입력조건에서 가장 큰 수를 출력하시오.
 * 입력
 * 5 5 2
 * 1 2 3 4 5
 *
 * 출력
 * 24
 */
public class Mission_Four {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 수열의 길이
		int N = sc.nextInt();
		// 수가 더해지는 횟수
		int M = sc.nextInt();
		// 특정 숫자가 더해지는 횟수
		int K = sc.nextInt();

		int[] arr = new int[N];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		// 오름차순 정렬
		Arrays.sort(arr);

		int first = arr[N - 1];
		int second = arr[N - 2];
		int sum = 0;
		
		for (int i = 1; i < M+1; i++) {
			if (i % (K+1) == 0) {
				sum += second;
			} else {
				sum += first;
			}
		}
		System.out.println(sum);
	}
}
