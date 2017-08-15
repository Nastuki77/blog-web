package com.nastuki.blog.entity;

import javax.persistence.*;

@Entity
@Table(name ="B_USER")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "SID")
    private Long sid;

    @Column(name = "USER_NAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "AGE")
    private Integer age;

    public User() {
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
