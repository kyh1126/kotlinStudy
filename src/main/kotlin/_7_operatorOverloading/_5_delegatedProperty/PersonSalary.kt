package _7_operatorOverloading._5_delegatedProperty

// setter 부분에 중복이 보이는 버전
class PersonSalary(val name: String, age: Int, salary: Int) : PropertyChangeAware() {
    var age: Int = age
        set(newValue) {
            // backing field 에 접근할 때 field 식별자 사용
            val oldValue = field
            field = newValue
            // 프로퍼티 변경을 리스너에게 통지
            changeSupport.firePropertyChange("age", oldValue, newValue)
        }

    var salary: Int = salary
        set(newValue) {
            val oldValue = field
            field = newValue
            changeSupport.firePropertyChange("salary", oldValue, newValue)
        }
}