package itao.workspace.springboot.demo.fastjson.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author itao
 * @Date 2019/4/1 22:00
 */
public class Grade {

    private Long id;
    private String name;
    private List<Student> users = new ArrayList<Student>();

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

    public List<Student> getUsers() {
        return users;
    }

    public void setUsers(List<Student> users) {
        this.users = users;
    }

    public void addStudent(Student student) {
        users.add(student);
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", users=" + users +
                '}';
    }
}
