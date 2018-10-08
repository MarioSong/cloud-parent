package cn.itter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description: TODO
 * @Author: Mario.Song
 * @Date: Create in 2018/10/8 16:15
 */
@SpringBootApplication
@EnableEurekaClient
public class DeptConsumer80_App {
    public static void main(String[] args)
    {
        SpringApplication.run(DeptConsumer80_App.class, args);
    }
}
