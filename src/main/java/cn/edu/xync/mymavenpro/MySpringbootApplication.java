package cn.edu.xync.mymavenpro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //标识当前类是SpringBoot应用的启动类
@MapperScan(basePackages = "cn.edu.xync.mymavnepro.dao")
public class MySpringbootApplication {

    public static void main(String[] args){

        //运行当前的SpringBoot应用程序
        SpringApplication.run(MySpringbootApplication.class);
        System.out.println("hello");
    }
}
