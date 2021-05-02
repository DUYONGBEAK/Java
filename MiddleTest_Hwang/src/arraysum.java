import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class arraysum1 {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/inputArraySum.txt"));
		
		// 사용할 변수와 배열을 생성함
		int n, m, k, sum = 0;
		int[][] map;
		Scanner sc = new Scanner(System.in);
		
		// 행을 받아옴
		n = sc.nextInt();
		// 열을 받아옴
		m = sc.nextInt();
		// 받아온 행과 열로 배열의 크기를 정해줌
		// 한칸을 더 늘려준 이유는 이후에 받아올 행렬계산에 사람과 PC의 인덱스 개념이 다르기 때문
		map  = new int[n+1][m+1];
		
		// 배열에 값을 넣어줌
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		// 계산을 진행할 반복횟수를 지정함
		k = sc.nextInt();
		
		for(int i=0; i < k;i++) {
			
			// 합을 계산할 변수를 생성함
			int rowsum = 0;
			int colsum = 0;
			
			// 계산할 행과 열을 받아옴
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();

			// 행의 합을 구함
			for(int row = 0; row < map.length; row++) {
				rowsum += map[row][y1];
			}
			
			// 열의 합을 구함
			for(int col = 0; col < map[x1].length; col++) {
				colsum += map[x1][col];
			}
			
			// 출력
			System.out.println(rowsum+" "+colsum);
		}
		
		
	}

}
