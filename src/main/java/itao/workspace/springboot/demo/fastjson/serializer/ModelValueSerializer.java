package itao.workspace.springboot.demo.fastjson.serializer;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @Description TODO
 * @Author itao
 * @Date 2019/4/1 22:48
 */
public class ModelValueSerializer implements ObjectSerializer {

    @Override
    public void write(JSONSerializer jsonSerializer, Object object, Object fieldName, Type type, int i) throws IOException {
        Integer value = (Integer) object;
        String text = value + "元";
        jsonSerializer.write(text);
    }
}
