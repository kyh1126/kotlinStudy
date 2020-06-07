package _7_operatorOverloading._5_delegatedProperty

// ObservableProperty2 사용한 버전
class PersonSalary3(val name: String, age: Int, salary: Int) : PropertyChangeAware() {
    // 위임 객체를 지정하면 직접 코드를 짜야 했던 여러 작업을 by 키워드를 사용해 코틀린 컴파일러가 자동으로 처리.
    // by 오른쪽에 오는 객체를 위임객체 라고 부른다.
    // 위임 객체를 감춰진 프로퍼티에 저장하고, 주 객체의 프로퍼티를 읽거나 쓸 때마다 위임 객체의 getValue, setValue 를 호출해준다.
    var age: Int by ObservableProperty2(age, changeSupport)

    var salary: Int by ObservableProperty2(salary, changeSupport)
}