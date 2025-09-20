package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
    "demo",       // seu pacote principal
    "controller", // onde estão os controllers
    "service",    // onde estão os services
    "repository", // onde estão os repositories
    "dto",         // se tiver componentes nesse pacote
    "model"       // onde estão os modelos
})
public class ProjetoPooSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProjetoPooSpringApplication.class, args);
    }
}