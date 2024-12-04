package com.edmondsinc.wishlist.configs

import com.edmondsinc.wishlist.models.User
import com.edmondsinc.wishlist.repositories.UserRepo
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.lang.Exception


@Configuration
class LoadDatabase {
    private val log: Logger = LoggerFactory.getLogger(LoadDatabase::class.java)

    /**
     * just initializing the database with at least 2 users for testing purposes.
     */
    @Bean
    fun initDatabase(userRepo: UserRepo) = CommandLineRunner{
        try {
            log.info("Preloading: "+userRepo.save(User("Tyler", "Edmonds", "email1@gmail.com", null)))
            log.info("Preloading: "+userRepo.save(User("Brittany", "Edmonds", "email2@gmail.com", null)))
        }catch (e:Exception){
            log.error(e.message)
        }
    }
}