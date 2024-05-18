package in.rahulojha.leetcodeapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LeetcodeApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeetcodeApiApplication.class, args);
    }

    /**
     * Bean definition for creating an ObjectMapper instance.
     *
     * @return A new instance of ObjectMapper.
     */
    @Bean
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }

}
