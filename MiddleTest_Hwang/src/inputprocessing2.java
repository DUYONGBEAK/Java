import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

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
