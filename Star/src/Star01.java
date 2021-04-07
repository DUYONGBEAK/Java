import java.util.Scanner;

public class Star01 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자를 입력하세요 : ");
		int userIn = scanner.nextInt();
		// userIn은 줄 개수를 지정해준다.
		
/*	     *
	    ***
	   *****
	  *******
	 *********   */
		
		for (int i = 0; i < userIn; i++) {
			// i를 더해주는 이유는 빈칸을 처음에는 많이찍다가 점점 줄이기 위함이다.
			for (int j = 0; j < (userIn + i); j++) {
				// 마지막에 false를 만들어서 별을 찍기위해 -1을 해준다.
				System.out.print(j < (userIn - 1 - i) ? " " : "*");
			}
			System.out.println();
		}

		System.out.println();
		
/*		*
		**
		***
		**
		*      */
		
		// userIn은 줄 개수를 지정해준다.
		for (int i = 0, j = 0; i < userIn; i++) {
			// 기본적으로 별 하나를 찍고 시작한다.
			System.out.print("*");
			// 별이 늘어났다가 줄어들기 위해서 k를 j와 비교한다.
			for (int k = 0; k < j; k++) {
				System.out.print("*");
			}
			// userIn의 중간지점이 지나면 j가 줄어들어서 별이 적게 찍히게 한다.
			if (i < userIn / 2) {
				j++;
			} else {
				j--;
			}
			System.out.println();
		}

		System.out.println();
		
/*		*****
		 ***
		  *
		 ***
		*****      */
		
		// userIn은 줄 개수를 지정해준다.
		for (int i = 0, j = 0; i < userIn; i++) {
			// userIn에서 j를 빼주는 것은 j가 커지면 적게 빼서 별을 많이 찍고, j가 작아지면 다시 많이 찍히기 위함이다.
			for (int k = 0; k < userIn - j; k++) {
				// 아래 if문에서 중간까지는 j가 늘어나기 때문에 빈칸이 늘어나다가 줄어든다.
				System.out.print(k < j ? " " : "*");
			}
			if (i < userIn / 2) {
				j++;
			} else {
				j--;
			}
			System.out.println();
		}

		System.out.println();

	}
}
