package _4_classObjectInterface._1_interface

// 클래스 이름 뒤에 콜론을 붙이고 인터페이스/클래스 이름을 적어 클래스 확장과 인터페이스 구현을 모두 처리한다.
class Button2 : ClickableWithDefault, Focusable {
    override fun click() = println("I was clicked")

    // 어떤 상위 타입의 멤버 메소드를 호출할지 지정할 수 있다.
    override fun showOff() {
        super<Focusable>.showOff()
    }
}