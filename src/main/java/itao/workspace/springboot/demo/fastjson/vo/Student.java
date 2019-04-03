package itao.workspace.springboot.demo.fastjson.vo;

/**
 * @Description TODO
 * @Author itao
 * @Date 2019/4/1 22:00
 */
public class Student {

    private Long   id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
