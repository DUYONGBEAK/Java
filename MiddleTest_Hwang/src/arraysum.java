import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class arraysum {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("src/inputArraySum.txt"));
		
		// �궗�슜�븷 蹂��닔�� 諛곗뿴�쓣 �깮�꽦�븿
		int n, m, k, sum = 0;
		int[][] map;
		Scanner sc = new Scanner(System.in);
		
		// �뻾�쓣 諛쏆븘�샂
		n = sc.nextInt();
		// �뿴�쓣 諛쏆븘�샂
		m = sc.nextInt();
		// 諛쏆븘�삩 �뻾怨� �뿴濡� 諛곗뿴�쓽 �겕湲곕�� �젙�빐以�
		// �븳移몄쓣 �뜑 �뒛�젮以� �씠�쑀�뒗 �씠�썑�뿉 諛쏆븘�삱 �뻾�젹怨꾩궛�뿉 �궗�엺怨� PC�쓽 �씤�뜳�뒪 媛쒕뀗�씠 �떎瑜닿린 �븣臾�
		map  = new int[n+1][m+1];
		
		// 諛곗뿴�뿉 媛믪쓣 �꽔�뼱以�
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		// 怨꾩궛�쓣 吏꾪뻾�븷 諛섎났�슏�닔瑜� 吏��젙�븿
		k = sc.nextInt();
		
		for(int i=0; i < k;i++) {
			
			// �빀�쓣 怨꾩궛�븷 蹂��닔瑜� �깮�꽦�븿
			int rowsum = 0;
			int colsum = 0;
			
			// 怨꾩궛�븷 �뻾怨� �뿴�쓣 諛쏆븘�샂
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();

			// �뻾�쓽 �빀�쓣 援ы븿
			for(int row = 0; row < map.length; row++) {
				rowsum += map[row][y1];
			}
			
			// �뿴�쓽 �빀�쓣 援ы븿
			for(int col = 0; col < map[x1].length; col++) {
				colsum += map[x1][col];
			}
			
			// 異쒕젰
			System.out.println(rowsum+" "+colsum);
		}
		
		
	}

}
