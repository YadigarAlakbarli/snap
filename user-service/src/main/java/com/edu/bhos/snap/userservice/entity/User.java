package com.edu.bhos.snap.userservice.entity;
import com.edu.bhos.snap.userservice.entity.abstracts.Base;
import com.edu.bhos.snap.userservice.entity.abstracts.IEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Data
@Entity
@Table(name="users")
@ApiModel(value ="User Model Properties")
public class User extends Base implements IEntity {

    @ApiModelProperty(value ="User name must be min 3 characters and not null ")
    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 35, message = "Name must be 2-35 characters long.")
    @Column(nullable=false)
    private String firstName;

    @Column(nullable=false)
    @NotBlank(message = "Last name is mandatory")
    @Size(min = 2, max = 35, message = "Surname must be 2-35 characters long.")
    @ApiModelProperty(value ="Last name must be min 3 characters and not null")
    private String lastName;

    @ApiModelProperty(value ="Email must be valid email addres")
    @Email(message = "Enter a valid email address.")
    @Column(nullable=false, unique=true)
    private String email;

    @ApiModelProperty("Phone number of User optional")
    private String mobile;

    @Column(nullable=false)
    private String password;

    @ApiModelProperty(value = "User Starte 0 or 1 ")
    boolean state=true;

    boolean active=true;

    private String info;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] img;

    private LocalDateTime registeredAt=LocalDateTime.now();

    private LocalDateTime lastLogin;

    @ManyToMany
    /*@JoinTable(
            name="users_roles",
            joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="role_id", referencedColumnName="id")})*/
    private List<Role> roles;

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                ", state=" + state +
                ", active=" + active +
                ", info='" + info + '\'' +
                ", img=" + Arrays.toString(img) +
                ", registeredAt=" + registeredAt +
                ", lastLogin=" + lastLogin +
                ", roles=" + roles +
                '}';
    }
}
