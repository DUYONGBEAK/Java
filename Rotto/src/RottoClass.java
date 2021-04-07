import java.util.Arrays;
import java.util.Random;

public class RottoClass {
	public static void main(String[] args) {
		int[] arr = new int[6];
		Random r = new Random();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(45) + 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] == arr[j]) {
					i = i - 1;
				}
			}

		}
		for (int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				if(arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}

		System.out.println(Arrays.toString(arr));
	}

}

