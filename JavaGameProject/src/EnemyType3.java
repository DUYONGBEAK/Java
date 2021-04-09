
//백두용
// Enemy클래스를 상속받는 1번 플레이어 클래스 생성
public class EnemyType3 extends Enemy {

	// Base클래스에서 생성한 프로퍼티에 값을 지정하고 name은 GameManager메소드에서 받아옴
	public EnemyType3(String name) {
		this.hp = 50;
		this.power = 30;
		this.name = name;
		this.defense = 1;

	}

	// 부모클래스에 있는 추상화 메소드를 Override하기 위한 메소드
	@Override
	public void attack(Base player) {
		// enemy의 power에서 player의 defense를 차감한 값을 damage에 넣어준다.
		// player를 Base클래스타입으로 생성했기 때문에 defense값은 player에서 받아오게 된다.
		int damage = this.power - player.defense;
		// damage로 player의 체력을 차감한다.
		player.hp = player.hp - damage;

		// 결과 출력
		System.out.println(this.name + "은(는)" + player.name + "에게" + damage + "의 피해를 입혔다.");
		System.out.println(player.name + "의 남은 체력은" + player.hp + "입니다.");
		// player가 체력이 1미만이 되면 그 대상을 파괴되었다고 출력한다.
		if (!player.isLive()) {
			System.out.println(this.name + "은(는) " + player.name + "을(를) 파괴했다.");
		}
	}

	// 배열을 출력하기 위해 Object메소드를 Override함
	@Override
	public String toString() {
		return this.name;
	}
}
