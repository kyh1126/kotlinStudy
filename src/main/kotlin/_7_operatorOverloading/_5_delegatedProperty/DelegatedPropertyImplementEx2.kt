package _7_operatorOverloading._5_delegatedProperty

import java.beans.PropertyChangeListener

// PropertyChangeSupport 클래스는 리스너의 목록을 관리
// PropertyChangeEvent 이벤트가 들어오면 목록의 모든 리스너에게 이벤트를 통지

// PropertyChangeSupport 인스턴스를 changeSupport 필드에 저장하고 프로퍼티 변경 리스너를 추적해주는 도우미 클래스 생성
// :: PropertyChangeAware

fun main(args: Array<String>) {
    val listener =
        PropertyChangeListener { println("Property ${it.propertyName} changed from ${it.oldValue} to ${it.newValue}") }

    val p = PersonSalary("Jenny", 27, 3000)
    // 프로퍼티 변경 리스너 추가
    p.addPropertyChangeListener(listener)
    p.age = 35
    p.salary = 10000

    // 컴파일러는 위임 객체 인스턴스를 <delegate> 라는 감춰진 프로퍼티에 저장한다.
    // 또한, 컴파일러는 프로퍼티를 표현하기 위해 KProperty 타입의 <property> 객체를 사용한다.
    // val x = c.prop -> val x = <delegate>.getValue(c, <property>)
    // c.prop = x -> <delegate>.setValue(c, <property>, x)
    val delegatedP = PersonSalary3("Jenny", 27, 3000)
    delegatedP.addPropertyChangeListener(listener)
    delegatedP.age = 35
}