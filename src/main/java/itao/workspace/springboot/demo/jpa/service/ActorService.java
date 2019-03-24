package itao.workspace.springboot.demo.jpa.service;

import itao.workspace.springboot.jpa.entity.sakila.Actor;
import itao.workspace.springboot.jpa.repository.sakila.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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
    //查询一： jpa自带方法
    public List<Actor> findAll(){
        return actorRepository.findAll();
    }
    //查询方式二
    public List<Actor> findByFirstName(String firstName){
        return actorRepository.findByFirstName(firstName);
    }
    //查询方式三
    public List<Actor> findByLastName(String lastName){
        return actorRepository.findByLastName(lastName);
    }
    //更新或删除
    public int updateFirstNameById(int actor_id,String firstName){
        return actorRepository.updateFirstNameById(actor_id,firstName);
    }

    /*** 动态条件查询样例 */
    public List<Actor> findDynamicConditions(Actor actor){
        return actorRepository.findAll(getSpecification(actor));
    }

    /**
     * JPA提供了基于准则查询(Specification)的方式
     * 可实现动态条件查询
     * 具体使用参考CriteriaBuilder API
     */
    public Specification<Actor> getSpecification(Actor actor){
        return new Specification<Actor>() {
            @Override
            public Predicate toPredicate(Root<Actor> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                List<Predicate> predicateList = new ArrayList<>();
                if(actor.getActorId() != null){
                    predicateList.add(cb.equal(root.get("actorId"), actor.getActorId() ));
                }
                if(actor.getFirstName()!=null && actor.getFirstName() != ""){
                    predicateList.add(cb.equal(root.get("firstName"), actor.getFirstName()));
                }
                if(actor.getLastName()!=null && actor.getLastName() != ""){
                    predicateList.add(cb.equal(root.get("lastName"), actor.getLastName()));
                }
                return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
    }

    //分页和排序
    public Page<Actor>findAllByPageAndSort(int pageNumber,int pageSize){
        Sort sort = new Sort(Sort.Direction.ASC, "firstName");
        Pageable page = PageRequest.of(pageNumber,pageSize,sort);
        return actorRepository.findAll(page);
    }
}
