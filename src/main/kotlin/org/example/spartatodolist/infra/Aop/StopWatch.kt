package org.example.spartatodolist.infra.Aop

@Target(AnnotationTarget.FUNCTION) // 이 어노테이션은 함수에 적용이 된다! .annotaionTarget.class라고 지정하면 클래스에 적용이 되는식!!
@Retention(AnnotationRetention.RUNTIME) //런타임은 디폴트값 , 이 어노테이션의 언제까지 유지될지를 설정, RUNTIME이라고 설정하면 런타임 동안에도 이 어노테이션 정보가 유지됨을 의미한다
annotation class StopWatch() // StopWatch라는 커스텀 어노테이션을 정의


