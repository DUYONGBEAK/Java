// 최상위 부모 클래스 생성
public class Base {
	
	//사용할 프로퍼티 생성
	int hp;
	int power;
	int defense;
	String name;
	int heal;
	
	//살았는지 죽었는지 확인하는 메소드
	public boolean isLive() {
		if(this.hp < 1) {
			return false;
		}
		return true;
	}
}
