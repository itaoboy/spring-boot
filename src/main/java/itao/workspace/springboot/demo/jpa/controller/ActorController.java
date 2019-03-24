package itao.workspace.springboot.demo.jpa.controller;

import itao.workspace.springboot.demo.jpa.service.ActorService;
import itao.workspace.springboot.jpa.entity.sakila.Actor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description TODO
 * @Author itao
 * @Date 2019/3/17 22:22
 */
@RestController
@RequestMapping("actor")
public class ActorController {

    Logger logger = LoggerFactory.getLogger(ActorController.class);

    @Autowired
    ActorService actorService;

    @RequestMapping("findAll")
    public List<Actor> findAll(){
        return actorService.findAll();
    }

    @RequestMapping(value = "findByFirstName",method = RequestMethod.POST)
    public List<Actor> findByFirstName(@RequestParam("firstName") String firstName){
        return actorService.findByFirstName(firstName);
    }

    @RequestMapping(value = "findByLastName",method = RequestMethod.POST)
    public List<Actor> findByLastName(@RequestParam("lastName")String lastName){
        return actorService.findByLastName(lastName);
    }

    @RequestMapping(value = "updateFirstNameById",method = RequestMethod.POST)
    public int updateFirstNameById(@RequestParam("actor_id")int actor_id,@RequestParam("firstName")String firstName){
        return actorService.updateFirstNameById(actor_id,firstName);
    }

    @RequestMapping(value = "findDynamicConditions",method = RequestMethod.POST)
    public List<Actor> findDynamicConditions(@RequestBody Actor actor){
        return actorService.findDynamicConditions(actor);
    }

    @RequestMapping(value = "findAllByPageAndSort",method = RequestMethod.POST)
    public Page<Actor> findAllByPageAndSort(@RequestParam("pageNumber")int pageNumber, @RequestParam("pageSize")int pageSize){
        logger.info("参数:{},{}",pageNumber,pageSize);
        return actorService.findAllByPageAndSort(pageNumber,pageSize);
    }


}
