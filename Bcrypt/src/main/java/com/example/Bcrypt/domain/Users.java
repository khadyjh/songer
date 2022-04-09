package com.example.Bcrypt.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@JsonIgnoreProperties({"posts"})
@Entity
public class Users {
    @Id
    @GeneratedValue
    private int id;

    private String userName;
    private String password;

    protected Users() {
    }

    public Users( String userName, String password) {

        this.userName = userName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(mappedBy = "user")
    List<Post> posts;
}
