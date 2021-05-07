import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/* 수학여행을 위해 학생 N명을 배차해야 한다.
 * 버스는 45인승 25인승이 준비되어 있다.
 * 각 버스의 배차 비용은 각각 45만원과 25만원이다.
 * 가장 적은비용으로 버스를 배차하고자 할 때 45인승 버스와 25인승 버스의  수를 출력하시오.
 * 입력 : 출력
 * 25 : 0 1
 * 50 : 0 2
 * 55 : 1 1
 * 60 : 1 1
 * 70 : 1 1
 * 75 : 0 3
 * 80 : 2 0
 * 95 : 1 2
 * 125 : 0 5
 * 160 : 3 1
 * 350 : 0 14
 */
public class busallocation {
	public static void main(String[] args) throws IOException {
		// 버퍼클래스 생성함. 아래 세문장을 합친것임
		// InputStream in = System.in
		// InputStreamReader reader = new InputStreamReader(in);
		// BufferedReader br = new BufferedReader(reader);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 읽어온 문자열을 int형으로 변환해서 변수에 넣음
		int number = Integer.parseInt(br.readLine());

		// 버스 가격 지정
		// final이 들어가면 변수를 바꿀 수 없음(초기화는 가능)
		final int bus45 = 45;
		final int bus25 = 25;

		// 각 버스의 배차 대수를 카운트할 변수 생성
		int res45 = 0;
		int res25 = 0;

		// 처음 들어온 학생 수가 25로 나누어 떨어지면 바로 리턴
		if (number % bus25 == 0) {
			System.out.println(res45 + " " + number / bus25);
			return;
		}

		// while문을 사용해서 학생 수가 0이하가 될때까지 계산함
		while (true) {

			// 학생 수가 45보다 크면 45를 한번 빼줌
			if (number >= bus45) {
				number -= bus45;
				res45++;

				// 학생 수가 25로 나누어 떨어지면 break;
				if (number % bus25 == 0) {
					System.out.println(res45 + " " + number / bus25);
					break;
				}

				// 삼항 연산자를 사용
				// 학생 수가 26 ~ 45일 때 45인승을 카운트함
				// 학생 수가 0 ~ 25일 때 25인승버스를 카운트함
			} else {
				int temp = (number <= bus25) ? res25++ : res45++;
				System.out.println(res45 + " " + res25);
				break;
			}
		}

	}

}
