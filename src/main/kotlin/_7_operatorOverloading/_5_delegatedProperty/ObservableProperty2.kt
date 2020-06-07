package _7_operatorOverloading._5_delegatedProperty

import java.beans.PropertyChangeSupport
import kotlin.reflect.KProperty

class ObservableProperty2(var propValue: Int, val changeSupport: PropertyChangeSupport) {
    // getValue, setValue 함수에도 operator 변경자가 붙는다.
    // KProperty 타입의 객체를 사용해 프로퍼티를 표현한다. 그래서 name 프로퍼티를 없앨 수 있다.
    operator fun getValue(p: PersonSalary3, prop: KProperty<*>): Int = propValue

    operator fun setValue(p: PersonSalary3, prop: KProperty<*>, newValue: Int) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }
}