package com.luo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author luohaoyu
 */
@SpringBootApplication
@MapperScan("com.luo.mapper")
public class Application {
	
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
