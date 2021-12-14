package ru.learnup.vtb.news.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Description
 *
 * @author bse71
 * Created on 14.12.2021
 * @since
 */

@Entity
@Table(name = "posts")
public class PostEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @OneToMany(mappedBy = "post")
    private List<CommentEntity> comments;

    public PostEntity() {

    }

    public PostEntity(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public PostEntity(Integer id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return String.format("%s (%d)\n%s\n%s\n", title, id, text, comments);
    }
}
