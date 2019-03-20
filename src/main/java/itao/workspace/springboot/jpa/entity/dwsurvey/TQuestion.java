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
    /*@Column(name = "answer_input_width")
    private int answerInputWidth;
    @Column(name = "belong_id")
    private String belongId;
    @Column(name = "cell_count")
    private int cellCount;
    @Column(name = "check_type")
    private int checkType;
    @Column(name = "contacts_attr")
    private int contactsAttr;*/
    /*@Column(name = "contacts_field")
    private String contactsField;
    @Column(name = "create_date")
    private java.sql.Timestamp createDate;
    @Column(name = "hv")
    private long hv;
    @Column(name = "is_required")
    private long isRequired;
    @Column(name = "keywords")
    private String keywords;
    @Column(name = "order_by_id")
    private long orderById;
    @Column(name = "param_int01")
    private long paramInt01;
    @Column(name = "param_int02")
    private long paramInt02;
    @Column(name = "parent_qu_id")
    private String parentQuId;
    @Column(name = "qu_name")
    private String quName;
    @Column(name = "qu_note")
    private String quNote;
    @Column(name = "qu_tag")
    private long quTag;
    @Column(name = "qu_title")
    private String quTitle;
    @Column(name = "qu_type")
    private long quType;
    @Column(name = "rand_order")
    private long randOrder;
    @Column(name = "tag")
    private long tag;
    @Column(name = "visibility")
    private long visibility;
    @Column(name = "yesno_option")
    private long yesnoOption;*/



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
