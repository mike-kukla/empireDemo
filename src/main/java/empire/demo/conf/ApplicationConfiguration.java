package empire.demo.conf;

import java.net.URI;
import java.net.URISyntaxException;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("empire.demo.services")
@EnableTransactionManagement
public class ApplicationConfiguration {

	  @Bean
	  public DataSource dataSource() {

		  URI dbUri = null;
		try {
			dbUri = new URI(System.getenv("DATABASE_URL"));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	        String username = dbUri.getUserInfo().split(":")[0];
	        String password = dbUri.getUserInfo().split(":")[1];
	        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

	        BasicDataSource basicDataSource = new BasicDataSource();
	        basicDataSource.setUrl(dbUrl);
	        basicDataSource.setDriverClassName("org.postgresql.Driver");
	        basicDataSource.setUsername(username);
	        basicDataSource.setPassword(password);
	        return (DataSource) basicDataSource;

//	    EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//	    return builder
//	    	.setType(EmbeddedDatabaseType.H2)
//	    	.addScripts("create-providers.sql", "inserts.sql")
//	    	.build();
	  }

	  @Bean
	  public EntityManagerFactory entityManagerFactory() {

	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    vendorAdapter.setGenerateDdl(true);

	    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	    factory.setJpaVendorAdapter(vendorAdapter);
	    factory.setPackagesToScan("empire.demo.model");
	    factory.setDataSource(dataSource());
	    factory.afterPropertiesSet();

	    return factory.getObject();
	  }
	
	  @Bean
	  public PlatformTransactionManager transactionManager() {

	    JpaTransactionManager txManager = new JpaTransactionManager();
	    txManager.setEntityManagerFactory(entityManagerFactory());
	    return txManager;
	  }
}
