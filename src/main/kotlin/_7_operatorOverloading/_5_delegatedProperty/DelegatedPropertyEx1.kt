package _7_operatorOverloading._5_delegatedProperty

// backing property 를 이용한 지연 초기화 방식 : 스레드 안전하지 않음.
//class Person(val name: String) {
//    // 데이터를 저장하고 emails 의 위임 객체 역할을 하는 프로퍼티 (backing property)
//    private var _emails: List<Email>? = null
//
//    val emails: List<Email>
//        get() {
//            if (_emails == null) {
//                _emails = loadEmails(this)
//            }
//            return _emails!!
//        }
//
//}

// 위임 프로퍼티는 backing property 와 값이 오직 한 번만 초기화됨을 보장하는 게터 로직을 함께 캡슐화해준다.
// lazy 를 by 키워드와 함께 사용해 위임 프로퍼티를 만들 수 있다. lazy 함수의 인자는 값을 초기화할 때 호출할 람다다.
// lazy 함수는 기본적으로 스레드 안전하다. 필요에 따라 동기화에 사용할 락을 lazy 함수에 전닳할 수도 있고,
// 다중스레드 환경에서 사용하지 않을 프로퍼티를 위해 lazy 함수가 동기화를 하지 못하게 막을 수도 있다.
// lazy : 위임 객체를 반환하는 표준 라이브러리 함수.
class Person(val name: String){
    val emails by lazy { loadEmails(this) }
}

fun loadEmails(person: Person): List<Email>? {
    println("${person.name}의 이메일을 가져옴")
    return listOf(Email())
}

fun main(args: Array<String>) {
    val p = Person("Jenny")
    // 최초로 emails 를 읽을 때 단 한 번만 이메일을 가져온다.
    p.emails
    p.emails
}