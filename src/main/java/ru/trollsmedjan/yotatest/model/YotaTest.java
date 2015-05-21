package ru.trollsmedjan.yotatest.model;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.trollsmedjan.yotatest.model.helpers.ExtendedSAXParser;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

/**
 * Created by syachin on 21.05.2015.
 */
//@EnableAutoConfiguration
//@ComponentScan
//@Configuration
@SpringBootApplication
public class YotaTest implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(YotaTest.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        ExtendedSAXParser extendedSAXParser = new ExtendedSAXParser();

        parser.parse(new File("c:\\dev\\test.xml"), extendedSAXParser);




    }
}
