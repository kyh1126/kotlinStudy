package _4_classObjectInterface._2_constructorProperty

// 어떤 클래스를 클래스 외부에서 인스턴스화하지 못하게 막고 싶으면 모든 생성자를 private 으로 만들면 된다.
// 다음과 같이 주 생성자에 private 변경자를 붙일 수 있다.
class Secretive private constructor() {}