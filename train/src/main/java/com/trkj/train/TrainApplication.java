package com.trkj.train;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("com.trkj.train.mapper")
@MapperScan("com.trkj.train.config.dto.mapper")
public class TrainApplication {

    public static void main(String[] args) {
        //允许一次执行多条sql
        System.setProperty("druid.wall.multiStatementAllow","true");
        SpringApplication.run(TrainApplication.class, args);
    }
}
