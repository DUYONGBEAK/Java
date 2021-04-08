import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// 게임을 운영하기 위한 클래스 
public class GameManager {

	public void play() {
		
		// 플레이어나 적의 배열인덱스를 특정하기 위한 변수 초기화 생성 
		int attackTarget = 0;
		
		// 플레이어와 적 배열 생성
		Player[] player = { new PlayerType1("임시진(딜러)"), new PlayerType3("백두용(탱커)"), new PlayerType4("김승현(딜러)"),
				new PlayerType2("최성운(힐러)") };
		Enemy[] enemy = { new EnemyType1("자바"), new EnemyType2("파이썬"), new EnemyType3("리눅스"),
				new EnemyType4("자바스크립트") };

		Random r = new Random();
		Scanner s = new Scanner(System.in);
		
		//무한반복을 피하는 반복문 생성
		for (int i = 0; i < 99999; i++) {
			// 1턴 부터 차례로 출력함
			System.out.println("\n\n" + (i + 1) + "턴\n\n");

			// 사용자에게 String타입으로 입력받아서 적을 지정함.
			System.out.println("공격할 적을 선택해주세요 :" + Arrays.toString(enemy));
			String userInPut = s.nextLine();

			// 각 적에 해당하는 배열의 인덱스번호를 맵핑함
			if (userInPut.equals("자바")) {
				attackTarget = 0;
			} else if (userInPut.equals("파이썬")) {
				attackTarget = 1;
			} else if (userInPut.equals("리눅스")) {
				attackTarget = 2;
			} else if (userInPut.equals("자바스크립트")) {
				attackTarget = 3;
			} else {
				// 생성하지 않은 적을 입력하면 해당 차례 턴을 초기화함. 
				System.out.println("다시 입력해주세요!!!!");
				i = i - 1;
				continue;
			}

			// 입력한 적이 죽었을 경우 해당 차례 턴을 초기화함.
			if (!enemy[attackTarget].isLive()) {
				System.out.println("이미 파괴된 적입니다.");
				i = i - 1;
				continue;
			}

			// 플레이어 턴
			for (int playerIndex = 0; playerIndex < player.length; playerIndex++) {

				// 공격하는 플레이어와 공격당하는 적이 모두 살아있을 경우 공격을 진행함
				if (player[playerIndex].isLive() && enemy[attackTarget].isLive()) {
					player[playerIndex].attack(enemy[attackTarget]);
					System.out.println();
				}
				// 공격하는 플레이어가 힐러일 경우 해당 조건문으로 들어감
				if (player[playerIndex] == player[3]) {
					// 반복문을 통해 플레이어 전원에게 힐을 해줌.
					for (int k = 0; k < player.length; k++) {
						// 죽은 플레이어는 힐을 하지 않고 스킵.
						if (!player[k].isLive()) {
							continue;
						}
						//힐러가 살아있을 때
						if (player[playerIndex].isLive()) {
							player[3].heal(player[k]);
							System.out.println(player[3].toString() + "은(는)" + player[k].name + " 에게"
									+ player[3].heal + "만큼의 회복을 했습니다.");
							System.out.println();
						} //힐러가 죽었을 때 
						else if (!player[playerIndex].isLive()) {
							System.out.println("힐러는 죽었습니다.");
							System.out.println("");
							break;
						}

					}

				}
			}

			// 적 턴
			for (int enemyIndex = 0; enemyIndex < enemy.length; enemyIndex++) {
				// 랜덤으로 공격할 숫자를 받아서 배열의 인덱스를 맵핑함.
				attackTarget = r.nextInt(player.length);
				// 만약 죽은 플레이어의 인덱스가 선택되면, 선택되지 않고 다시 반복하기 위해 -1을 하는 조건문 생성
				if(!player[attackTarget].isLive()) {
					enemyIndex = enemyIndex - 1;
				}
				// 선택된 플레이어가 죽지 않았을 경우 공격을 진행
				else if (enemy[enemyIndex].isLive() && player[attackTarget].isLive()) {
					enemy[enemyIndex].attack(player[attackTarget]);
					System.out.println();
				}
			}

			// 게임 종료여부 확인
			// player의 생존여부 확인
			boolean isPlayer = false;
			for (int playerIndex = 0; playerIndex < player.length; playerIndex++) {
				if (player[playerIndex].isLive()) {
					isPlayer = true;
				}
			}

			//enemy의 생존여부 확인
			boolean isEnemyLive = false;
			for (int enemyIndex = 0; enemyIndex < enemy.length; enemyIndex++) {
				if (enemy[enemyIndex].isLive()) {
					isEnemyLive = true;
				}
			}
			
			if (isPlayer && !isEnemyLive) {
				System.out.println("플레이어 승리");
				break;
			} else if (!isPlayer && isEnemyLive) {
				System.out.println("적 승리");
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

			}
			// 큰 반복문이 한번 돌고 플레이어 전원의 체력을 출력함
			for (int life = 0; life < player.length; life++) {
				System.out.println("플레이어의 " + player[life].name + "체력은 : " + player[life].hp);
			}
		}
	}
}
