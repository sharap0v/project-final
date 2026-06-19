package com.javarush.jira;

import com.javarush.jira.common.internal.config.AppProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
@EnableCaching
public class JiraRushApplication {

    public static void main(String[] args) {
        SpringApplication.run(JiraRushApplication.class, args);
    }
    @Bean
    public Object checkEnv(
            @Value("${DB_URL:NOT_SET}") String dbUrl,
            @Value("${GITHUB_CLIENT_ID:NOT_SET}") String githubClientId,
            @Value("${MAIL_USER_NAME:NOT_SET}") String mailUserName) {

        System.out.println("=== CHECK ENV VARIABLES ===");
        System.out.println("DB_URL: " + dbUrl);
        System.out.println("GITHUB_CLIENT_ID: " + githubClientId);
        System.out.println("MAIL_USER_NAME: " + mailUserName);
        System.out.println("============================");
        return new Object();
    }
}
