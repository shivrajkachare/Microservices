package com.UserService.UserService;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Getter
@Setter
@Table(name="Users")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;


    @Column(unique = true, nullable = false, length = 20)
    @Size(min=7, max=20)
    private String userName;

    @Column(nullable = false, length = 20)
    private String name;

    @Min(1)
    @Max(150)
    private int age;

    @Size(min=4, max=20)
    private String password;

    protected User() {}
    protected User(String name,String userNamename, int age, String password){
        this.name=name;
        this.userName = userName;
        this.age = age;
        this.password = password;
    }
}
