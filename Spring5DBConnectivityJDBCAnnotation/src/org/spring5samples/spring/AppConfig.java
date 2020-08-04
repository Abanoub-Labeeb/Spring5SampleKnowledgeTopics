package org.spring5samples.spring;

import javax.sql.DataSource;

import org.spring5samples.DAOs.SecurityDAOImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class AppConfig {

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/springsamplesschema?useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		return dataSource;
	}
	       
	@Bean(name = "SecurityDAOBean")
	public SecurityDAOImpl getSecurityDAOImpl() {
		return new SecurityDAOImpl(getDataSource());
	}
}
