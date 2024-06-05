package org.example.spartatodolist.infra.Aop

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component

//@Aspect
//@Component
//class TestAop {
//
//    @Around("execution(* org.example.spartatodolist.domain.card.service.CardService.getCardById(..))")
//    fun thisIsAdvice(joinPoint: ProceedingJoinPoint) {
//        println("Aop start!!!!!!!")
//
//        joinPoint.proceed()
//
//        println("Aop end!!!!!!!")
//    }
//}