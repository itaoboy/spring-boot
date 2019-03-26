package itao.workspace.springboot.demo.jpa.service;

import itao.workspace.springboot.jpa.entity.dwsurvey.TQuestion;
import itao.workspace.springboot.jpa.repository.dwsurvey.TQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @Description TODO
 * @Author itao
 * @Date 2019/3/17 22:22
 * @CacheConfig和@Cacheable 用于redis数据缓存
 */
@Service
@CacheConfig(cacheNames = "t_question")
public class TQuestionService {

    @Autowired
    TQuestionRepository tQuestionRepository;

    @Cacheable
    public List<TQuestion> findAll(){
        return tQuestionRepository.findAll();
    }

}
