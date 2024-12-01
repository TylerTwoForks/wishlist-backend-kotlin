package com.edmondsinc.wishlist

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
class WishlistApplication

fun main(args: Array<String>) {
	runApplication<WishlistApplication>(*args)

}
