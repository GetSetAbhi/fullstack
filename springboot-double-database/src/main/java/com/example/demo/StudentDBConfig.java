package com.example.demo;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.demo.student.model.Student;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  entityManagerFactoryRef = "studentEntityManagerFactory",
  transactionManagerRef = "studentTransactionManager",
  basePackages = { "com.example.demo.student" }
)
public class StudentDBConfig {
	
	
	@Bean(name="studentDataSourceProperties")
	@Primary
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSourceProperties studentDataSourceProperties() {
		return new DataSourceProperties();
	}
	
	@Bean(name="studentDataSource")
	@Primary
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource studentDataSource(@Qualifier("studentDataSourceProperties") DataSourceProperties studentDataSourceProperties) {
	    return studentDataSourceProperties
	    		.initializeDataSourceBuilder()
	    		.type(HikariDataSource.class).build();
	}

	@Primary
	@Bean(name = "studentEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean studentEntityManagerFactory(EntityManagerFactoryBuilder builder, 
			@Qualifier("studentDataSource") DataSource studentDataSource) {
		return builder
				.dataSource(studentDataSource)
				.packages(Student.class)
				.build();
	}

	@Bean(name = "studentTransactionManager")
	@Primary
	public PlatformTransactionManager primaryTransactionManager(
			@Qualifier("studentEntityManagerFactory") EntityManagerFactory studentEntityManagerFactory) {
		return new JpaTransactionManager(studentEntityManagerFactory);
	}

}
