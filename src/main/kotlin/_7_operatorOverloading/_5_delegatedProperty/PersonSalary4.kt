package _7_operatorOverloading._5_delegatedProperty

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

// 프로퍼티 값 변경 통지할 때 PropertyChangeSupport 사용방법 알려주는 람다를 표준 라이브러리 클래스에 넘기는 방식
class PersonSalary4(val name: String, age: Int, salary: Int) : PropertyChangeAware() {
    private val observer = { prop: KProperty<*>, oldValue: Int, newValue: Int ->
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }

    // by 오른쪽 식이 꼭 새 인스턴스를 만들 필요는 없다.
    // 다만 우항을 계산한 결과인 객체는 컴파일러가 호출할 수 있는 올바른 타입의 getValue, setValue 를 반드시 제공해야 한다.
    var age: Int by Delegates.observable(age, observer)

    var salary: Int by Delegates.observable(salary, observer)
}