package inser.spring.spring_simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.Serializable;

@SpringBootApplication
public class Spring_simple implements Serializable {

    public static void main(String[] args) {
        SpringApplication.run(Spring_simple.class, args);
    }

}
