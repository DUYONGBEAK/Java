import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;
/* 주어지는 N줄의 문자열을 읽어 들여서,
 * 각 행을 오름차순으로 출력하는 프로그램을 작성하시오.
 * 입력의 첫 줄에는 테스트 케이스의 갯수가 주어진다.
 * 입력
 * 5
 * 1 2 3 4 5 6 7 8 9 10
 * 7 5 2 1 2
 * 4 5 2
 * 2 6 4 8 10
 * 1 3 7 5 9
 * 
 * 출력
 * 1 2 3 4 5 6 7 8 9 10
 * 1 2 2 5 7
 * 2 4 5
 * 2 4 6 8 10
 * 1 3 5 7 9
 */
public class inputprocessing2 {

	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("src/inputTest2.txt"));
		Scanner sc = new Scanner(System.in);

		// 몇 줄을 입력받는지 정하는 변수를 초기화
		int T = sc.nextInt();

		// 개행문자를 제거하기 위해 엔터를 추가
		sc.nextLine();

		for (int i = 0; i < T; i++) {

			// 문자열을 띄어쓰기로 스플릿해서 배열에 한번에 받아옴
			String[] E = sc.nextLine().split(" ");

			// stream배열을 int로 형변환해서 새로운 배열에 담아줌
			// for, if문을 줄이기 위해 stream을 사용함
			// 하지만 상황에 따라 stream이 더 느릴 수 있다.
			int[] intArray = Stream.of(E).mapToInt(Integer::parseInt).toArray();
			// 배열을 정렬함
			Arrays.sort(intArray);

			// 이것도 출력방법
//			 Arrays.stream(intArray).forEach(System.out::print);

			// 하나씩 출력함
			Arrays.stream(intArray).forEach(x -> {
				System.out.print(x + " ");
			});

			// 이것도 출력방법
//			 for(int k: intArray){
//			    System.out.print(k+" ");
//			 }
			System.out.println();
		}

	}
}
