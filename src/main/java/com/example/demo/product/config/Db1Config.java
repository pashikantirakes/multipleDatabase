package com.example.demo.product.config;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		 entityManagerFactoryRef = "db1EntityManagerFactory",
		 transactionManagerRef = "db1TransactionManager",
		 basePackages = "com.example.demo.repo"
		  
		)
public class Db1Config {
	
	//datsource
	@Bean
	@ConfigurationProperties(prefix="db1.datasource")
	public DataSource db1Database() {
		return DataSourceBuilder.create().build()
				;
	}
	
	//EntityManagerFactory(Interface)
	   // impl. LocalContainerEntityMAnegerFactoryBean
	@Bean 
	public LocalContainerEntityManagerFactoryBean  db1EntityManagerFactory(
			EntityManagerFactoryBuilder emfb
			) {
		HashMap<String,Object> prop=new HashMap<>();
		prop.put("hibernate.hbm2ddl.auto", "create");
		prop.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		
		return emfb.dataSource(db1Database())
				.packages("com.example.demo.model.product")
				.properties(prop).build();
	}
	
	//TransactionManager
	@Bean
	public PlatformTransactionManager db1TransactionManager(
		@Qualifier("db1EntityManagerFactory")
		EntityManagerFactory emf
			) {
		
		return new JpaTransactionManager(emf);
	}

}
