package comm.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class configserver {

    public static void main(String[] args) {
        SpringApplication.run(configserver.class, args);
    }

}
