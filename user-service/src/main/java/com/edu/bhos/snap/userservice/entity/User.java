package com.edu.bhos.snap.userservice.entity;

import com.edu.bhos.snap.userservice.entity.abstracts.IEntity;
import com.edu.bhos.snap.userservice.entity.abstracts.Person;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@ApiModel(value = "User Model Properties")
public class User extends Person implements IEntity {


    @ApiModelProperty(value = "Email must be valid email addres")
    @Email(message = "input a valid email address.")
    @Column(nullable = false, unique = true)
    private String email;


    @Column(nullable = false)
    private String password;

    @ApiModelProperty(value = "User State 0 or 1 ")
    boolean state = true;

    boolean active = true;

    private String info;


    private LocalDateTime registeredAt = LocalDateTime.now();

    private LocalDateTime lastLogin;

    @ManyToMany(cascade = CascadeType.PERSIST)
    /*@JoinTable(
            name="users_roles",
            joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="role_id", referencedColumnName="id")})*/
    private List<Role> roles;

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + getMobile() + '\'' +
                ", password='" + password + '\'' +
                ", state=" + state +
                ", active=" + active +
                ", info='" + info + '\'' +
                ", registeredAt=" + registeredAt +
                ", lastLogin=" + lastLogin +
                ", roles=" + roles +
                '}';
    }
}
