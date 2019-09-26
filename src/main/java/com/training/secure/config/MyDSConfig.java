package com.training.secure.config;

import java.beans.PropertyVetoException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;



@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages="com.training.secure")
@PropertySource(value = { "classpath:database.properties" })
public class MyDSConfig {
	
	//Autowire for dependency
	@Autowired
	private Environment env;
	
	
	//expose bean for View Resolver
	@Bean
	public ViewResolver viewResolver() {
		//explicity initiate a view Resolver
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		//inject dependency
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	
	//expose a bean for dataSource
	@Bean
	public DataSource securityDataSource() {
		//initiate Connection Pool DataSource
				ComboPooledDataSource dataSource=new ComboPooledDataSource();
				
				//set the jdbc connection param
				
				try {
					dataSource.setDriverClass(this.env.getProperty("driver"));
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				dataSource.setJdbcUrl(this.env.getProperty("url"));
				dataSource.setUser(this.env.getProperty("dbuser"));
				dataSource.setPassword(this.env.getProperty("jdbc.password"));
				
				//set connection pool prop
				dataSource.setInitialPoolSize(Integer.parseInt(this.env.getProperty("initialPoolSize")));
				dataSource.setMaxPoolSize(Integer.parseInt(this.env.getProperty("maxPoolSize")));
				dataSource.setMinPoolSize(Integer.parseInt(this.env.getProperty("minPoolSize")));
				dataSource.setMaxIdleTime(Integer.parseInt(this.env.getProperty("initialPoolSize")));
				
				return dataSource;
	}
	//helper method to assemble hibernate prop
		private Properties getHibernateProperties() {
			
			Properties props=new Properties();
			
			props.setProperty("hibernate.dialect", this.env.getProperty("hibernate.dialect"));
			props.setProperty("hibernate.show_sql", this.env.getProperty("hibernate.show_sql"));
			
			return props;
		}
		
		
		//Create a method to configure and expose sessionFactory as bean
		@Bean
		public LocalSessionFactoryBean sessionFactory() {
			
			//create SessionFactory
			LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
			
			//configure the SessionFactory
			
			//1. set the dataSource
			sessionFactory.setDataSource(this.securityDataSource());
			
			//2. set the hibernate prop
			sessionFactory.setHibernateProperties(this.getHibernateProperties());
			
			//3. set entity package
			sessionFactory.setPackagesToScan(this.env.getProperty("hibernate.packagesToScan"));
			
			
			return sessionFactory;
			
		}
		
		//method to configure and expose the tx-manager as bean (used my spring framework)
		@Bean
		@Autowired
		public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
			
			//set Tx-manager based on SessionFactory
			HibernateTransactionManager txManager=new HibernateTransactionManager();
			
			txManager.setSessionFactory(sessionFactory);
			
			return txManager;
		}
}











