package itao.workspace.springboot.demo.Thymeleaf;/**
 * @author itao
 * @create 2019-03-14 23:09
 */

/**
 * @Description TODO
 * @Author itao
 * @Date 2019/3/14 23:09
 */
public class Person {

    private String name;
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
