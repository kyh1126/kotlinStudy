package _8_highOrderFunction._2_inlineFunction

// https://kotlinlang.org/docs/reference/inline-functions.html#inline-functions

// Inline  : Instead of creating a function object for the parameter and generating a call, the compiler could emit the following code
//inline fun <T> lock(lock: Lock, body: () -> T): T { ... }
// ->
//l.lock()
//try { foo() } finally { l.unlock() }
// The inline modifier affects both the function itself and the lambdas passed to it: all of those will be inlined into the call site.
// Inlining may cause the generated code to grow; however, if we do it in a reasonable way (i.e. avoiding inlining large functions),
// it will pay off in performance, especially at "megamorphic" call-sites inside loops.

// noinline : Only some of the lambdas passed to an inline function to be inlined, you can mark some of your function parameters with the noinline modifier
//inline fun foo(inlined: () -> Unit, noinline notInlined: () -> Unit) { ... }
// Inlinable lambdas can only be called inside the inline functions or passed as inlinable arguments,
// but noinline ones can be manipulated in any way we like: stored in fields, passed around etc.
// 만약 인라인 함수가 인라인 가능한 함수 파라미터나 실체화한 타입 파라미터가 없으면 컴파일러에서 경고하는데 이게 필요하다면 경고 없앨수 있다. @Suppress("NOTHING_TO_INLINE")).
// (그 모듈이ㅣ나 라이브러리 밖에서 사용할 수 있다. 자바에서도 인라인 함수를 호출할 수 있다.)

fun main(args: Array<String>) {
    // 코틀린에서 filter 함수는 인라인 함수다.
    println((0..5).filter { it > 3 })

    // 위의 인라인 함수는 아래와 같이 컴파일된 바이트코드로 생성된다.
    // 컬렉션에 대해 연산 성능에 신경안써도 된다.
    var result = mutableListOf<Int>()
    for(i in (0..5)){
        if(i > 3) result.add(i)
    }
    println(result)

    // 처리할 원소가 많아지면 중간 리스트를 사용하는 부가 비용도 커진다.
    // asSequence 는 각 람다를 필드에 저장하는 객체로 표현해서 최종 연산 때 여럴 람다를 연쇄 호출하여 중간 리스트 부가 비용은 줄어든다.
    // 시퀀스는 람다를 저장해야 하므로 람다를 인라인하지 않는다. 시퀀스를 통해 성능을 향상시킬 수 있는 경우는 컬렉션 크기가 큰 경우뿐이다.
    // 지연 계산을 통해 성능을 향상시키려는 이유로 모든 컬렉션 연산에 asSequence 를 붙여대면 안된다. 람다가 인라이닝 되지 않기 때문에 ...

    // 함수를 인라인으로
    // 선언하지 말아야 하는 경우 :
    // 일반 함수 호출의 경우 JVM 은 바이트코드를 기계어 코드로 번역하는 JIT 과정에서 인라인 처리, 코틀린은 호출 지점을 함수 본문으로 대치해 코드 중복이 생긴다.
    // 함수를 직접 호출해야 스택 트레이스가 더 깔끔해진다.
    // 선언해야 하는 경우 :
    // 람다를 인자로 받는 함수. 함수 호출 비용, 람다를 표현하는 클래스, 람다 인스턴스에 해당하는 객체 만들필요 없어진다.
    // JVM 은 함수 호출과 람다 인라이닝 못한다. 인라이닝 사용 시 일반 람다에서는 사용할 수 없는 넌로컬 반환 사용 가능. 코드 크기가 작을 때 사용해야 한다.
}