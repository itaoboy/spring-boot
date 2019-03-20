package itao.workspace.springboot.demo.jpa.controller;

import itao.workspace.springboot.demo.jpa.service.TQuestionService;
import itao.workspace.springboot.jpa.entity.dwsurvey.TQuestion;
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
@RequestMapping("tquestion")
public class TQuestionController {

    @Autowired
    TQuestionService tQuestionService;

    @RequestMapping("findAll")
    @ResponseBody
    public List<TQuestion> findAll(){
        return tQuestionService.findAll();
    }

}
