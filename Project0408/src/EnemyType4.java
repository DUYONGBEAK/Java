
//김승현
public class EnemyType4 extends Enemy {
	public EnemyType4(String name) {
		this.hp = 50;
		this.power = 30;
		this.name = name;
		this.defense = 1;

	}

	@Override
	public void attack(Base player) {
		// TODO Auto-generated method stub
		int damage = this.power - player.defense;
		player.hp = player.hp - damage;

		System.out.println(this.name + "은(는)" + player.name + "에게" + damage + "의 피해를 입혔다.");
		System.out.println(player.name + "의 남은 체력은" + player.hp + "입니다.");
		if (!player.isLive()) {
			System.out.println(this.name + "은(는) " + player.name + "을(를) 파괴했다.");
		}
	}
	@Override
	public String toString() {
		return this.name;
	}
}
