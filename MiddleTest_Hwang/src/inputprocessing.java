import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class inputprocessing {
	static int N;
	static int AnswerN;

	public static void main(String args[]) throws Exception {
		
		// for, if문을 줄이기 위해 stream을 사용함
		// 하지만 상황에 따라 stream이 더 느릴 수 있다.
		System.setIn(new FileInputStream("src/inputTest.txt"));
		Scanner sc = new Scanner(System.in);
		
		// 몇 줄을 입력받는지 정하는 변수를 초기화
		int T; 
		T = sc.nextInt();
		
		// 개행문자를 제거하기 위해 엔터를 추가
		sc.nextLine();

		 // 합계변수를 생성함
		 int sum;
		 for(int i=0; i < T; i++) {
			 
			 // 합계변수를 0초기화함
			 sum = 0;
			 // 문자열이 들어옴
			 char[] c = sc.nextLine().toCharArray();

			 // 문자열을 검사해서 A가 있으면 합계변수를 카운트해줌
			 for(int j=0; j < c.length ; j++) {
				 if(c[j] == 'A') sum++;
			 }
			 // 출력
			 System.out.println(sum);

		 }

		
		
	}
}
