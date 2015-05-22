//
//package ru.trollsmedjan.yotatest;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//@EnableAutoConfiguration
//@SpringBootApplication
//public class YotaTest {
//
//    public static void main(String[] args) {
//        SpringApplication.run(YotaTest.class, args);
//    }
//
//
//}


package ru.trollsmedjan.yotatest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class YotaTest extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(applicationClass, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(applicationClass);
    }

    private static Class<YotaTest> applicationClass = YotaTest.class;

}


