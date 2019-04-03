package itao.workspace.springboot.demo.fastjson.vo;

import com.alibaba.fastjson.annotation.JSONType;

import java.util.Date;

/**
 * @Description TODO
 * @Author itao
 * @Date 2019/4/1 23:01
 */
public class JSONTypeVo {
    private int age;
    private String name;
    private Date date;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
