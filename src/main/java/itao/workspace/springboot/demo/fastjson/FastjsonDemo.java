package itao.workspace.springboot.demo.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.*;
import itao.workspace.springboot.demo.fastjson.vo.Grade;
import itao.workspace.springboot.demo.fastjson.vo.JSONFieldVo;
import itao.workspace.springboot.demo.fastjson.vo.Student;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description TODO
 * @Author itao
 * @Date 2019/4/1 21:58
 */
public class FastjsonDemo {

    public static void main(String[] args) {
        FastjsonDemo demo = new FastjsonDemo();
        //序列化和反序列化
        //demo.common();
        //SerializerFeature使用
        //demo.serializerFeature();
        //使用JSONField定制序列化
        //demo.jsonField();
        //使用filter定制序列化
        /**
         * 通过Serilizer定制序列化：
         * PropertyPreFilter 根据PropertyName判断是否序列化
         * PropertyFilter 根据PropertyName和PropertyValue来判断是否序列化
         * NameFilter 修改Key，如果需要修改Key,process返回值则可
         * ValueFilter 修改Value
         * BeforeFilter 序列化时在最前添加内容
         * AfterFilter 序列化时在最后添加内容
         */
        //demo.propertyPreFilter();
        //demo.nameFilter();
        //demo.valueFilter();
        //demo.beforeFilter();
        //demo.afterFilter();

        //fastjson 如何处理超大对象和超大JSON文本:https://github.com/alibaba/fastjson/wiki/Stream-api
    }

    /**
     * 1、对象转换为json字符串  -- 序列号
     * 2、json字符串转换为对象 -- 反序列化
     */
    public  void common(){
        Grade group = new Grade();
        group.setId(0L);
        group.setName("admin");

        Student student = new Student();
        student.setId(2L);
        student.setName("guest");

        Student rootUser = new Student();
        rootUser.setId(3L);
        rootUser.setName("root");

        group.addStudent(student);
        group.addStudent(rootUser);

        String jsonStr = JSON.toJSONString(group);
        System.out.println(jsonStr);
        Grade grade = JSON.parseObject(jsonStr,Grade.class);
        System.out.println(grade);
    }

    /**
     * SerializerFeature使用
     * 默认缺省，缺省是不输出空值的。无论Map中的null和对象属性中的null，序列化的时候都会被忽略不输出，这样会减少产生文本的大小
     */
    public void serializerFeature(){
        Grade group = new Grade();
        group.setId(0L);

        Student student = new Student();
        student.setName("guest");
        group.addStudent(student);
        //默认缺省
        System.out.println(JSON.toJSONString(group));
        //设置多个SerializerFeature
        System.out.println(JSON.toJSONString(group,SerializerFeature.WriteNullStringAsEmpty ,
                SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullListAsEmpty));
    }

    /**
     * 定制序列化：
     * 通过@JSONField定制序列化
     */
    public void jsonField(){
        JSONFieldVo vo = new JSONFieldVo();
        vo.setId(213);
        vo.setDate(new Date());
        vo.setName("fastjson");
        vo.setValue(100);
        System.out.println(JSON.toJSONString(vo));
    }

    //PropertyPreFilter是否序列化
    public void propertyPreFilter(){
        PropertyPreFilter filter = new PropertyPreFilter() {
            @Override
            public boolean apply(JSONSerializer jsonSerializer, Object o, String s) {
                System.out.println(o+"--"+s);
                if ("id".equals(s)) {
                   Student student = (Student) o;
                    Long id  = student.getId();
                    return id >= 100;
                }else{
                   return true;
               }
            }
        };
        System.out.println(JSON.toJSONString(getList(),filter));
    }

    //修改Key，如果需要修改Key,process返回值则可
    public void nameFilter(){
        NameFilter filter = new NameFilter(){
            @Override
            public String process(Object o, String s, Object o1) {
                System.out.println(o+"--"+s+"--"+o1);
                if(s.equals("id")) {
                    return "ID";
                } else {
                    return s;
                }
            }
        };
        System.out.println(JSON.toJSONString(getList(),filter));
    }

    //修改value
    public void valueFilter(){
        ValueFilter filter = new ValueFilter() {
            @Override
            public Object process(Object o, String s, Object o1) {
                if(s.equals("name")){
                    return "my_name_is:"+o1;
                } else {
                    return o1;
                }
            }
        };
        System.out.println(JSON.toJSONString(getList(),filter));
    }

    //BeforeFilter 序列化时在最前添加内容
    public void beforeFilter(){
        BeforeFilter filter = new BeforeFilter() {
            @Override
            public void writeBefore(Object o) {
                Student student = (Student) o;
                student.setName("pre_name："+student.getName());
                student.setId(student.getId()+20L);
                writeKeyValue("age",10);
            }
        };
        System.out.println(JSON.toJSONString(getList(),filter));
    }

    //AfterFilter 序列化时在最后添加内容
    public void afterFilter(){
        AfterFilter filter = new AfterFilter() {
            @Override
            public void writeAfter(Object o) {
                writeKeyValue("work","code");
            }
        };
        System.out.println(JSON.toJSONString(getList(),filter));
    }

    public List<Student> getList(){
        List<Student> list = new ArrayList<>();
        Student student = new Student();
        student.setId(101L);
        student.setName("joe");

        Student student1 = new Student();
        student1.setId(10L);
        student1.setName("jof");
        list.add(student);
        list.add(student1);
        return list;
    }


}
