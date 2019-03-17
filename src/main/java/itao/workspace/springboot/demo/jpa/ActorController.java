package itao.workspace.springboot.demo.jpa;

import itao.workspace.springboot.jpa.entity.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description TODO
 * @Author itao
 * @Date 2019/3/17 22:22
 */
@Controller
@RequestMapping("actor")
public class ActorController {

    @Autowired
    ActorService actorService;

    @RequestMapping("findAll")
    @ResponseBody
    public List<Actor> findAll(){
        return actorService.findAll();
    }

}
