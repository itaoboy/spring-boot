package itao.workspace.springboot.config.dataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

/**
 * dwsurvey的数据源配置类
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactorySecond",
        transactionManagerRef = "transactionManagerSecond",
        basePackages = { "itao.workspace.springboot.jpa.repository.dwsurvey" }) //设置Repository所在位置
public class SecondDataSourceConfig {

    @Autowired
    @Qualifier("secondDataSource")
    private DataSource secondDataSource;

    @Bean(name = "entityManagerSecond")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactorySecond(builder).getObject().createEntityManager();
    }

    /**
     * @param builder 接收EntityManagerFactoryBuilder类型的参数
     * @return 返回LocalContainerEntityManagerFactoryBean类型的对象
     */
    @Bean(name = "entityManagerFactorySecond")
    public LocalContainerEntityManagerFactoryBean entityManagerFactorySecond(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(secondDataSource)
                .packages("itao.workspace.springboot.jpa.entity.dwsurvey") //设置实体类所在位置
                .persistenceUnit("secondPersistenceUnit")
                .build();

    }

    /**
     * @param builder 接受EntityManagerFactoryBuilder类型的参数
     * @return 返回PlatformTransactionManager类型的对象
     */
    @Bean(name = "transactionManagerSecond")
    public PlatformTransactionManager transactionManagerSecond(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactorySecond(builder).getObject());
    }

}
