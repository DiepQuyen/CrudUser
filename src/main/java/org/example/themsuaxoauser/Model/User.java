package org.example.themsuaxoauser.Model;

import jakarta.persistence.*;

import java.util.List;

//model dữ liệu
@Entity
@Table(name = "users")
public class User {
    @Id// primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)// giá trị tự tăng dần
    private Long id;

    private String name;
    private String email;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts;

    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}