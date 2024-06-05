package org.example.spartatodolist

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.EnableAspectJAutoProxy

@EnableAspectJAutoProxy
@SpringBootApplication
class SpartaToDoListApplication

fun main(args: Array<String>) {
    runApplication<SpartaToDoListApplication>(*args)
}
