package org.sboot.buildsboot;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@SpringBootApplication
public class BuildSBootApplication {

//    @Autowired
//    private Environment env;
//
//    @Bean
//    public DataSource getDataSource() {
//        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setUrl(env.getProperty("spring.datasource.url"));
//        druidDataSource.setUsername(env.getProperty("spring.datasource.username"));
//        druidDataSource.setPassword(env.getProperty("spring.datasource.password"));
//        druidDataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
//        return druidDataSource;
//    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSource getDataSource() {
        return new DruidDataSource();
    }


    public static void main(String[] args) {
        SpringApplication.run(BuildSBootApplication.class);
    }
}
