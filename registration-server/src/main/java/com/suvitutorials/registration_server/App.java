package com.suvitutorials.registration_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class App 
{
    public static void main( String[] args )
    {
        //System.setProperty("spring.config.name", "registration-server");
    	System.out.println("**********This is Registration Server***********");
        SpringApplication.run(App.class, args);
    }
}
