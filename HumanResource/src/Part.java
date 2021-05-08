import java.util.ArrayList;

// 부서별로 사원을 정리할 클래스를 만듦
public class Part {
	
	// 부서이름을 맵핑할 프로퍼티를 정의
	String name;
	// 제네릭이 People 클래스타입인 List를 만들어줌
	ArrayList<People> member;
	
	// 부서명을 받아올 생성자를 만들어줌
	Part(String name){
		this.name = name;
		this.member = new ArrayList<People>();
	}
}
