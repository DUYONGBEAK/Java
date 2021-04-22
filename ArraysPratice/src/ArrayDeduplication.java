import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ArrayDeduplication {
	// 사용할 변수들을 초기화
	static int range;
	static int N;
	static int num;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src\\inputBS.txt"));

		Scanner scan = new Scanner(System.in);

		// 정렬을 할 총 횟수를 지정함
		N = scan.nextInt();
		System.out.println(N);

		// 지정된 횟수만큼 반복함
		for (int caseTest = 0; caseTest < N; caseTest++) {

			// 배열의 범위를 지정함
			range = scan.nextInt();
			System.out.print(range + " ");

			// 정렬할 배열을 생성함
			int[] arr = new int[range];

			// 생성한 배열에 값을 입력함
			for (int i = 0; i < range; i++) {
				arr[i] = scan.nextInt();
				System.out.print(arr[i] + " ");
			}

			// 선택정렬을 이용해서 오름차순으로 정렬함
			for (int i = 0; i < arr.length; i++) {
				for (int j = i + 1; j < arr.length; j++) {
					if (arr[i] > arr[j]) {
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
			}
			System.out.println(" - 정렬 전");

			// 정렬된 배열 중 중복값이 있다면 제외하고 출력함
			for (int i = 0; i < range; i++) {
				if (i == 0) {
					System.out.print(arr[i] + " ");
					continue;
				} else if (arr[i] > arr[i - 1]) {
					System.out.print(arr[i] + " ");
				} else if (arr[i] == arr[i - 1]) {
					continue;
				}
			}
			System.out.println(" - 정렬 후");
		}

	}

}
