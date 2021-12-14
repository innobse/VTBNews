package ru.learnup.vtb.news.entities;

import javax.persistence.*;

/**
 * Description
 *
 * @author bse71
 * Created on 14.12.2021
 * @since
 */

@Entity
@Table(name = "comments")
public class CommentEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "text")
    private String text;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity post;

    public CommentEntity() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return String.format("%s (%d)", text, id);
    }
}
