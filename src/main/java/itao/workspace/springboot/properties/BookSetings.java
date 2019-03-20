package itao.workspace.springboot.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Description 将指定properties文件中的内容转换为对象
 * @author itao
 * @since 2019/03/13 20:38
 */
@Component
@PropertySource("classpath:config/book.properties")
@ConfigurationProperties(prefix = "book")
public class BookSetings {
    private String author;
    private String name;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
