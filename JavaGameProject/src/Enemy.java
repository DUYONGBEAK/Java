// 최상위 부모 클래스를 상속받는 Enemy 추상클래스 생성
public abstract class Enemy extends Base {

	// 각 보스가 공격하기 위해 사용할 메소드
	// Base클래스 타입으로 player변수 생성
	public abstract void attack(Base player);
}
