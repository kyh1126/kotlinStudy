package _10_annotationAndReflection._1_annotation

// 애노테이션 클래스는 오직 선언이나 식과 관련 있는 메타데이터의 구조를 정의하기 때문에 내부에 아무 코드도 들어있을 수 없다.
// 컴파일러는 애노테이션 클래스에서 본문을 정의하지 못하게 막는다.
annotation class JsonExclude2

// 파라미터가 있는 애노테이션을 정의하려면 애노테이션 클래스의 주 생성자에 파라미터를 선언해야 한다.
// 애노테이션 클래스에서는 모든 파라미터 앞에 val 을 붙여야만 한다.
annotation class JsonName2(val name: String)

// 자바에선 이를 JsonName3 과 같이 표시할 수 있다.