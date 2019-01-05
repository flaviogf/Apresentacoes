package br.com.flaviogf.apikotlinblog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ApiKotlinBlogApplication

fun main(args: Array<String>) {
    runApplication<ApiKotlinBlogApplication>(*args)
}
