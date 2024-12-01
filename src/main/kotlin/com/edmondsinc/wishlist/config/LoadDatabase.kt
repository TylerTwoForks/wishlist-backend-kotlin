package com.edmondsinc.wishlist.config

import com.edmondsinc.wishlist.models.User
import com.edmondsinc.wishlist.repositories.UserRepo
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.lang.Exception


@Configuration
class LoadDatabase(private val userRepo: UserRepo) {
    private val log: Logger = LoggerFactory.getLogger(LoadDatabase::class.java)

    @Bean
    fun initDatabase(userRepo: UserRepo) = CommandLineRunner{
        try {
            log.info("Preloading: "+userRepo.save(User("Tyler", "Edmonds", "email1@gmail.com")))
            log.info("Preloading: "+userRepo.save(User("Brittany", "Edmonds", "email2@gmail.com")))
        }catch (e:Exception){
            log.error(e.message)
        }
    }
}