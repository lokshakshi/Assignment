package com.mindbowser.demo;



import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DBConfiguration {

	
	@Bean
    public DataSource getDataSource() 
    {
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
//        dataSourceBuilder.url("jdbc:mysql://192.168.1.54:3306/project_db");
//        dataSourceBuilder.username("lokshakshi");
//        dataSourceBuilder.password("Singla@123");
//        return dataSourceBuilder.build();
		return DataSourceBuilder.create()
//		          .driverClassName("com.mysql.cj.jdbc.Driver")
//		          .url("jdbc:mysql://192.168.1.54:3306/project_db")
//		          .username("lokshakshi")
//		          .password("Singla@123")
		          .build(); 
    }
}
