package _4_classObjectInterface._1_interface

private class PossibleTalkativeButton : TalkativeButton() {
    fun a(){
        whisper();
    }
}

// public:
// 클래스멤버 : 모든 곳에서 볼 수 있다. / 최상위 선언 : 모든 곳에서 볼 수 있다.
// internal:
// 클래스멤버 : 같은 모듈 안에서만 볼 수 있다. / 최상위 선언 : 같은 모듈 안에서만 볼 수 있다.
// protected:
// 클래스멤버 : 하위 클래스 안에서만 볼 수 있다. / 최상위 선언 : 최상위 선언에 적용할 수 없다.
// private:
// 클래스멤버 : 같은 클래스 안에서만 볼 수 있다. / 최상위 선언 : 같은 파일 안에서만 볼 수 있다.
private fun PossibleTalkativeButton.giveSpeech() {
//    yell()    // incorrect, TalkativeButton 의 private 멤버임
//    whisper() // incorrect, TalkativeButton 의 protected 멤버임 확장에서..
    internalFun()
}

fun main(args: Array<String>) {
//    TalkativeButton().giveSpeech()
    val talkButton = PossibleTalkativeButton()
    talkButton.giveSpeech()
}