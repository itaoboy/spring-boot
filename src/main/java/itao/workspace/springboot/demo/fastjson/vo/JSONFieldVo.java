package itao.workspace.springboot.demo.fastjson.vo;

import com.alibaba.fastjson.annotation.JSONField;
import itao.workspace.springboot.demo.fastjson.serializer.ModelValueSerializer;

import java.util.Date;

/**
 * @Description TODO
 * @Author itao
 * @Date 2019/4/1 22:25
 */
public class JSONFieldVo {
    //使用name配置名称
    @JSONField(name = "ID",ordinal = 2)
    private int id;
    //使用format配置日期格式化
    @JSONField(name = "birthday",format = "yyyy-MM-dd",ordinal = 3)
    public Date date;
    //使用serialize配置是否进行序列化
    @JSONField(serialize = false)
    private String name;
    //使用ordinal指定字段顺序
    @JSONField(ordinal = 1)
    private int age;
    //JSONField支持新的定制化配置serializeUsing，可以单独对某一个类的某个属性定制序列化
    @JSONField(serializeUsing =  ModelValueSerializer.class,ordinal = 4)
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
