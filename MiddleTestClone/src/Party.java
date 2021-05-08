import java.util.Scanner;

public class Party {

	String name;
	int favoriteA = 0;
	int favoriteB = 0;
	int favoriteC = 0;

	int favorite20Count = 0;
	int favorite30Count = 0;
	int favorite40Count = 0;

	Party(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		String userPrint = "" + this.name + "당 20대 선호수는 " + this.favorite20Count + "입니다.\n" + this.name + "당 30대 선호수는 "
				+ this.favorite30Count + "입니다.\n" + this.name + "당 40대 선호수는 " + this.favorite40Count + "입니다.\n";

		return userPrint;

	}
}
