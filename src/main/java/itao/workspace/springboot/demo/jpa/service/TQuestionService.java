package itao.workspace.springboot.demo.jpa.service;

import itao.workspace.springboot.jpa.entity.dwsurvey.TQuestion;
import itao.workspace.springboot.jpa.repository.dwsurvey.TQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @Description TODO
 * @Author itao
 * @Date 2019/3/17 22:22
 */
@Service
public class TQuestionService {

    @Autowired
    TQuestionRepository tQuestionRepository;

    public List<TQuestion> findAll(){
        return tQuestionRepository.findAll();
    }

}
