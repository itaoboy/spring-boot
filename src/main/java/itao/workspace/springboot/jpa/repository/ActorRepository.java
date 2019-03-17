package itao.workspace.springboot.jpa.repository;

import itao.workspace.springboot.jpa.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description Actor表对应Repository
 * @Author itao
 * @Date 2019/3/17 22:16
 */
@Repository
public interface ActorRepository extends JpaRepository<Actor,Integer> {
}
