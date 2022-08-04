package com.example.demo;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.demo.teacher.model.Teacher;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  entityManagerFactoryRef = "teacherEntityManagerFactory",
  transactionManagerRef = "teacherTransactionManager",
  basePackages = { "com.example.demo.teacher" }
)
public class TeacherDBConfig {
	
	@Bean(name="teacherDataSourceProperties")
	@ConfigurationProperties(prefix="spring.teacher-datasource")
	public DataSourceProperties teacherDataSourceProperties() {
		return new DataSourceProperties();
	}
	
	@Bean(name="teacherDataSource")
	@ConfigurationProperties(prefix="spring.teacher-datasource")
	public DataSource teacherDataSource(@Qualifier("teacherDataSourceProperties") DataSourceProperties teacherDataSourceProperties) {
	    return teacherDataSourceProperties
	    		.initializeDataSourceBuilder()
	    		.type(HikariDataSource.class).build();
	}

	@Bean(name = "teacherEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean primaryEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("teacherDataSource") DataSource teacherDataSource) {
		return builder
				.dataSource(teacherDataSource)
				.packages(Teacher.class)
				.build();
	}

	@Bean(name = "teacherTransactionManager")
	public PlatformTransactionManager primaryTransactionManager(
			@Qualifier("teacherEntityManagerFactory") EntityManagerFactory teacherEntityManagerFactory) {
		return new JpaTransactionManager(teacherEntityManagerFactory);
	}

}
