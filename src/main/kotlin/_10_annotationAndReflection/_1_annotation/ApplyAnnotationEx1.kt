package _10_annotationAndReflection._1_annotation

// 애노테이션 : @ + 애노테이션 이름
// 코틀린에서는 replaceWith 로 옛 버전을 대신할 수 있는 패턴을 제시할 수 있다.
// ex>  @Deprecated("Use removeAt(index) instead.", ReplaceWith("removeAt(index)"))
//      fun remove(index: Int)

// 1. 클래스를 애노테이션 인자로 지정할 때는 @MyAnnotation(MyClass::class) 처럼 ::class 를 클래스 이름 뒤에 넣어야 한다.
// 2. 다른 애노테이션을 인자로 지정할 때는 인자로 들어가는 애노테이션의 이름 앞에 @를 넣지 않아야 한다. 위의 ReplaceWith 는 애노테이션이다. 하지만 인자로 들어가 @를 사용하지 않는다.
// 3. 배열을 인자로 지정하려면 @RequestMapping(path=arrayOf("/foo","/bar")) 처럼 arrayOf 함수를 사용한다.
//    자바에서 선언한 애노테이션 클래스를 사용한다면 arrayOf 함수를 쓰지 않아도 된다. @JavaAnnotationWithArrayValue("abc","foo","bar") 처럼 value 라는 이름의 파라미터가 자동으로 가변길이 인자로 변환된다.