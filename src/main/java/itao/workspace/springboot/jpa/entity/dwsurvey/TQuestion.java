package itao.workspace.springboot.jpa.entity.dwsurvey;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_question")
public class TQuestion {

    @Id
    private String id;
    @Column(name = "answer_input_row")
    private Integer answerInputRow;
    @Column(name = "copy_from_id")
    private String copyFromId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAnswerInputRow() {
        return answerInputRow;
    }

    public void setAnswerInputRow(Integer answerInputRow) {
        this.answerInputRow = answerInputRow;
    }

    public String getCopyFromId() {
        return copyFromId;
    }

    public void setCopyFromId(String copyFromId) {
        this.copyFromId = copyFromId;
    }
}
