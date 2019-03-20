package itao.workspace.springboot.jpa.repository.dwsurvey;

import itao.workspace.springboot.jpa.entity.dwsurvey.TQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description TQuestion表对应Repository
 * @Author itao
 * @Date 2019/3/17 22:16
 */
public interface TQuestionRepository extends JpaRepository<TQuestion,Integer> {
}
