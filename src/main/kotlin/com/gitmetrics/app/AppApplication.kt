package com.gitmetrics.app

import org.springframework.boot.runApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class AppApplication

fun main(args: Array<String>) {
	runApplication<AppApplication>(*args) {

	}
}
