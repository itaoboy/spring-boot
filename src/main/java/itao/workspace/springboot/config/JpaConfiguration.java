package itao.workspace.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @Description TODO
 * @Author itao
 * @Date 2019/3/17 22:01
 */
@Configuration
@EnableJpaRepositories("itao.workspace.springboot.jpa.repository")
public class JpaConfiguration {

}
