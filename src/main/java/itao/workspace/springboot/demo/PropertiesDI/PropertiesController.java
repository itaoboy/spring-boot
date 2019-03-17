package itao.workspace.springboot.demo.PropertiesDI;

import itao.workspace.springboot.properties.BookSetings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author itao
 * @Date 2019/3/14 23:22
 */
@RestController
public class PropertiesController {
    //属性注入方式一：使用@Value
    @Value("${book.author}")
    private String bookAuthor;
    @Value("${book.name}")
    private String bookName;

    //属性注入方式二：注入为对象
    @Autowired
    BookSetings bookSetings;

    @RequestMapping("/properties_one")
    public String proerties_one(){
        return "hello "+bookAuthor+"-"+bookName;
    }

    @RequestMapping("/properties_two")
    public String proerties_two(){
        return "hello "+bookSetings.getAuthor()+"-"+bookSetings.getName();
    }
}
