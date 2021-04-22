import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayDeduplicationP {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/inputBS.txt"));
		Scanner s = new Scanner(System.in);

		// 전체 반복문을 몇번 돌건지를 정해줌
		int T = s.nextInt();

		for (int testCase = 0; testCase < T; testCase++) {

			// 숫자가 몇개 들어오는지 정해줌
			int R = s.nextInt();
			// 중복값을 제외하고 출력하기 위해 들어오는 숫자를 체크해줄 배열을 생성
			int[] cnt = new int[11];
			int[] arr = new int[R];

//			System.out.println(R);

			// arr배열에는 평소대로 숫자가 들어가고, cnt배열에는 들어오는 숫자에 해당하는 인덱스가 하나 늘어난다.
			for (int i = 0; i < arr.length; i++) {
				arr[i] = s.nextInt();
				cnt[arr[i]]++;
			}

//			System.out.println(Arrays.toString(arr));
//			System.out.println(Arrays.toString(cnt));

			// cnt배열에 숫자가 하나라도 들어왔으면 그 위치를 출력해준다.
			for (int i = 0; i < cnt.length; i++) {
				if (cnt[i] > 0) {
					System.out.print(i);

//					//중복제거 없이 오름차순 출력 
//					if(cnt[i]>0) {
//						for(int j=0; j < cnt[i]; j++) {
//							System.out.print(i);
//						}
//					}
				}
			}
			System.out.println();

		}
	}
}
