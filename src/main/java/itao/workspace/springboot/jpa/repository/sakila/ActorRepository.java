package itao.workspace.springboot.jpa.repository.sakila;

import itao.workspace.springboot.jpa.entity.sakila.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Description Actor表对应Repository
 * @Author itao
 * @Date 2019/3/17 22:16
 *
 * JpaSpecificationExecutor 基准查询
 * PagingAndSortingRepository 分页和排序
 */
public interface ActorRepository extends JpaRepository<Actor,Long>
        ,JpaSpecificationExecutor<Actor> ,PagingAndSortingRepository<Actor,Long> {
    //根据属性名查询
    List<Actor> findByFirstName(String firstName);

    //使用@Query  nativeQuery = true表示执行原生SQL;如果没有则执行HQL
    @Query( value="SELECT * FROM Actor  WHERE last_name=:lastName",nativeQuery = true)
    List<Actor> findByLastName(@Param("lastName") String lastName);

    //更新查询
    @Modifying
    @Transactional
    @Query("UPDATE Actor SET first_name=:firstName WHERE actor_id=:actor_id")
    int updateFirstNameById(@Param("actor_id") int actor_id,@Param("firstName")String firstName);

}
