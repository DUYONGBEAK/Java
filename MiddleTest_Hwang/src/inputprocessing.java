import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class inputprocessing {
	static int N;
	static int AnswerN;

	public static void main(String args[]) throws Exception {
		
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
			 
//			 System.out.println(Arrays.toString(c));

			 // 문자열을 검사해서 A가 있으면 합계변수를 카운트해줌
			 for(int j=0; j < c.length ; j++) {
				 if(c[j] == 'A') sum++;
			 }
			 // 출력
			 System.out.println(sum);

		 }

		
		
	}
}
