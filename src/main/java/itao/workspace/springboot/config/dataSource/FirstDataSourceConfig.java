package itao.workspace.springboot.config.dataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

/**
 * sakila的数据源配置类
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryPrimary",
        transactionManagerRef = "transactionManagerPrimary",
        basePackages = { "itao.workspace.springboot.jpa.repository.sakila" }) //设置Repository所在位置
public class FirstDataSourceConfig {

    @Autowired
    @Qualifier("firstDataSource")
    private DataSource firstDataSource;

    @Primary
    @Bean(name = "entityManagerPrimary")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryPrimary(builder).getObject().createEntityManager();
    }

    /**
     * @param builder 接收EntityManagerFactoryBuilder类型的参数
     * @return 返回LocalContainerEntityManagerFactoryBean类型的对象
     */
    @Primary
    @Bean(name = "entityManagerFactoryPrimary")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(firstDataSource)
                .packages("itao.workspace.springboot.jpa.entity.sakila") //设置实体类所在位置
                .persistenceUnit("primaryPersistenceUnit")
                .build();

    }

    /**
     * @param builder 接受EntityManagerFactoryBuilder类型的参数
     * @return 返回PlatformTransactionManager类型的对象
     */
    @Primary
    @Bean(name = "transactionManagerPrimary")
    public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryPrimary(builder).getObject());
    }

}
