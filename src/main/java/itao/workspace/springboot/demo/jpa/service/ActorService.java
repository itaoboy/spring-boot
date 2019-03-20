package itao.workspace.springboot.demo.jpa.service;

import itao.workspace.springboot.jpa.entity.sakila.Actor;
import itao.workspace.springboot.jpa.repository.sakila.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Author itao
 * @Date 2019/3/17 22:22
 */
@Service
public class ActorService {

    @Autowired
    ActorRepository actorRepository;

    public List<Actor> findAll(){
        return actorRepository.findAll();
    }

}
