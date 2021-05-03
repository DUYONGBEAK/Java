import java.util.Arrays;
import java.util.Scanner;

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
