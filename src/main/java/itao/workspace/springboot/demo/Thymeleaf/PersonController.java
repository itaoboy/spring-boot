package itao.workspace.springboot.demo.Thymeleaf;/**
 * @author itao
 * @create 2019-03-14 23:24
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author itao
 * @Date 2019/3/14 23:24
 */
@Controller
public class PersonController {

    @RequestMapping("/")
    public String index(Model model){
        Person singel = new Person("aa",11);
        List<Person> personList = new ArrayList<>();
        Person p1 = new Person("xx",11);
        Person p2 = new Person("yy",22);
        Person p3 = new Person("zz",33);
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);

        model.addAttribute("singelPerson",singel);
        model.addAttribute("personList",personList);

        return "/thymeleafDemo/index";
    }

}
