
// 최상위 부모 클래스를 상속받는 Player 추상클래스 생성
public abstract class Player extends Base {
	
	// 각 플레이어가 공격하기 위해 사용할 메소드
	// Base클래스 타입으로 enemy변수 생성
	public abstract void attack(Base enemy);
	
	// 각 플레이어게 힐을 해주기위해 사용할 메소드
	// 힐은 플레이어에게 들어가므로 Base클래스 타입으로 player변수 생성
	public abstract void heal(Base player);
	

}
