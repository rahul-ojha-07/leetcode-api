package in.rahulojha.leetcodeapi.configs;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "leetcode")
public class LeetCodeConfig {

    // run code when the properties are loaded after bean creation



    private String cookie;
    private String url;
    private String username;
    private String graphqlUrl;
    private String csrftoken;
}
