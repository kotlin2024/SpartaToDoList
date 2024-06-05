package org.example.spartatodolist.infra.Aop

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.util.StopWatch

@Aspect // 이 클래스가 Aspect로 사용됨을 나타냄
@Component //이 크래스가 Spring의 컴포넘트 스캔에 의해 자동으로 빈으로 등록됨을 나타냄
class StopWatchAspect {

    private val logger= LoggerFactory.getLogger("Execution Time Logger") // 로깅을 위해 로거 설정

    //이 경우 stopWatch 어노테이션이 붙은 전후에 실행되도록 하는 어노테이션이 @Around
    @Around("@annotation(org.example.spartatodolist.infra.Aop.StopWatch)") // @StopWatch라는 어노테이션을 달앗을때 run함수를 수행!!!!
    fun run(joinPoint: ProceedingJoinPoint) {
        val stopWatch = StopWatch()

        stopWatch.start()
        joinPoint.proceed() // ProceedingJoinPoint는 현재 실행중인 메소드 , 즉 현재 실행중인 메소드를 실행시키는 코드
        stopWatch.stop()

        val methodName=joinPoint.signature.name //signature는 현재 실행중인 함수의 메타데이터를 포함
        val methodArguments = joinPoint.args.joinToString(","){arg->arg?.toString() ?:"null"} // 현재 실행중인 함수에 전달된 매개변수를 배열 형태로 반환

        val timeElapsedMs= stopWatch.totalTimeMillis // 측정시간을 밀리초 단위로 변환
        logger.info("Method Name: $methodName | Arguments: ${methodArguments}  | Execution Time: ${timeElapsedMs}ms")

    }
}
