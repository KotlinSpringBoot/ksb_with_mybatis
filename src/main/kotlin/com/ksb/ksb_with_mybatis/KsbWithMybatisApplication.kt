package com.ksb.ksb_with_mybatis

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@MapperScan("com.ksb.ksb_with_mybatis.dao")
class KsbWithMybatisApplication

fun main(args: Array<String>) {
    runApplication<KsbWithMybatisApplication>(*args)
}
