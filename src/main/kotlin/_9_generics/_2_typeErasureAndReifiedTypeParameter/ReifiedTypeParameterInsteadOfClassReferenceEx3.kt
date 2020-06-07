package _9_generics._2_typeErasureAndReifiedTypeParameter

import java.security.Provider
import java.util.*


// Reified Type Parameter :
// support run-time access to types passed to functions, as if they were reified (currently limited to inline functions only).
// 사용가능 case
//  타입 검사와 캐스팅 (x is T, x !is T, x as T, x as? T)
//  reflection access on T: javaClass<T>(), T::class (when supported)
//  코틀린 타입에 대응하는 java.lang.Class 얻기 (::class.java)
//  다른 함수를 호출할 때 타입 인자로 사용

// 사용불가 case
//  타입 파라미터 클래스(T)의 인스턴스 생성하기
//  타입 파라미터 클래스(T)의 동반 객체 메소드 호출하기
//  실체화한 타입 파라미터를 요구하는 함수를 호출하면서 실체화하지 않은 타입 파라미터로 받은 타입을 타입 인자로 넘기기
//  클래스, 프로퍼티, 인라인 함수가 아닌 함수의 타입 파라미터를 reified 로 지정하기 (Only a type parameter of an inline function can be marked reified)
//  (람다를 인라이닝 할 수 없는 상황이거나 성능 문제로 인라이닝 하고 싶지 않은 경우 noinline 변경자를 함수 타입 파라미터에 붙여서 인라이닝을 금지할 수 있다.)

inline fun <reified T> loadService(): ServiceLoader<T> {
    // T::class 로 타입 파라미터의 클래스를 가져온다.
    return ServiceLoader.load(T::class.java)
}

fun main(args: Array<String>) {
    val serviceImpl = ServiceLoader.load(Provider.Service::class.java)
    // 위의 코드를 reified type parameter 를 사용하면 아래와 같다.
    val serviceImpl2 = loadService<Provider.Service>()
}