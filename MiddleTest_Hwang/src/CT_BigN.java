import java.util.Arrays;
import java.util.Scanner;

public class CT_BigN {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 배열을 생성해서 5 5 2를 한번에 받아옴
		String[] E = sc.nextLine().split(" ");
		
		// 배열에 있는 값을 int로 형변환해서 순차적으로 변수에 담아줌 
		int n = Integer.parseInt(E[0]);
		int m = Integer.parseInt(E[1]);
		int k = Integer.parseInt(E[2]);
		
		// 숫자가 들어올 만큼의 배열을 생성
		int[] data = new int[n];
		
		// 숫자를 담음
		for(int i=0; i < n; i++) {
			data[i] = sc.nextInt();
		}

		// 배열을 오름차순으로 정렬함
		Arrays.sort(data);
		
		// 배열의 가장 큰 값과 두 번째로 큰 값을 변수로 지정함
		int first = data[n-1];
		int second = data[n-2];
		
		// 결과값 변수를 생성함
		int result = 0;
		// 하나의 숫자가 최대로 더해질 수 있는 횟수를 카운트 변수에 넣어줌
		int tempK = k;
		
		for(int i=0; i < m; i++) {

			// k가 0일 때 두번째로 큰 값을 더해준다.
		    if (tempK == 0) {
		        result = result  + (second);
		        // 카운트 변수를 K로 초기화함
		        tempK = k;
		    }
		    
		    // k가 0이 아닐때는 가장 큰 값을 더해준다.
		    else {
		        result = result + (first);
		        tempK = tempK - 1;
		    }
		}
		
		// 출력
		System.out.println(result);
		
	}

}
