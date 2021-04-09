
// 임시진
// Player클래스를 상속받는 1번 플레이어 클래스 생성
public class PlayerType1 extends Player {

	// Base클래스에서 생성한 프로퍼티에 값을 지정하고 name은 GameManager메소드에서 받아옴
	public PlayerType1(String name) {
		this.hp = 20;
		this.power = 20;
		this.name = name;
		this.defense = 10;
	}

	// 부모클래스에 있는 추상화 메소드를 Override하기 위한 메소드
	@Override
	public void attack(Base enemy) {
		// player의 power에서 enemy의 defense를 차감한 값을 damage에 넣어준다.
		// enemy를 Base클래스타입으로 생성했기 때문에 defense값은 enemy에서 받아오게 된다.
		int damage = this.power - enemy.defense;
		// damage로 enemy의 체력을 차감한다.
		enemy.hp = enemy.hp - damage;

		// 결과 출력
		System.out.println(this.name + "은(는)" + enemy.name + "에게" + damage + "의 피해를 입혔다.");
		System.out.println(enemy.name + "의 남은 체력은" + enemy.hp + "입니다.");

		// enemy가 체력이 1미만이 되면 그 대상을 파괴되었다고 출력한다.
		if (!enemy.isLive()) {
			System.out.println();
			System.out.println(this.name + "은(는) " + enemy.name + "을(를) 파괴했다.");
		}
	}

	// 부모클래스에 추상화 클래스가 존재하기 때문에 적어줌.
	@Override
	public void heal(Base player) {

	}

	// 배열을 출력하기 위해 Object메소드를 Override함
	@Override
	public String toString() {
		return this.name;
	}

}
