package com.teamsparta.hoop

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class HoopApplication

fun main(args: Array<String>) {
    runApplication<HoopApplication>(*args)
}
