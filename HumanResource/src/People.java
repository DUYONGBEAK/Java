// 사원의 정보를 담을 클래스를 생성
public class People {
	
	// 객체 데이터를 생성
	String name;
	String position;
	String work;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name + " : " + this.position + "(" + this.work + ")";
	}
	
}
