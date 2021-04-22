import java.util.Scanner;

public class HanoiTower {
	
	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in); 

        int N=sc.nextInt();
		
		Hanoi(N,1,2,3);
		//123
		//132
		//312
		
	}
	
	public static void Hanoi(int n, int start, int mid, int target) {
				
		if(n < 1) { 
			return ;
		}
		Hanoi(n - 1,start, target, mid);
		System.out.println("" + start + " -> " + target);
		Hanoi(n - 1,mid, start, target);
	}
}
