package com.example.specargresolverdemo

import net.kaczmarzyk.spring.data.jpa.web.SpecificationArgumentResolver
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@SpringBootApplication
class SpecArgResolverDemoApplication : WebMvcConfigurer {
	fun main(args: Array<String>) {
		runApplication<SpecArgResolverDemoApplication>(*args)
	}

	override fun addArgumentResolvers(resolvers: MutableList<HandlerMethodArgumentResolver>) {
		resolvers.add(SpecificationArgumentResolver())
	}
}
