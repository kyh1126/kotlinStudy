package _4_classObjectInterface._2_constructorProperty

open class SuperUser(val nickname: String) {}

// 기반 클래스를 초기화하려면 기반 클래스 이름 뒤에 괄호를 치고 생성자 인자를 넘긴다.
// 클래스 정의 시 별도로 생성자를 정의히지 않으면 컴파일러가 자동으로 아무 일도 하지 않는 인자가 없는 디폴트 생성자를 만들어준다.
class TwitterUser(nickname: String) : SuperUser(nickname) {}
