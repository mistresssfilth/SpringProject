package com.mistressfilth.spring.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    /*@ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;*/

    public Message() {
    }

    public Message(Long id, String text) {
        this.id = id;
        this.text = text;
        //this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    /*public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }*/
}
