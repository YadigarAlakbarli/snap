package com.edu.bhos.snap.userservice.entity;
import com.edu.bhos.snap.userservice.entity.abstracts.Base;
import com.edu.bhos.snap.userservice.entity.abstracts.IEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="users")
public class User extends Base implements IEntity {

    @Column(nullable=false)
    private String firstName;

    @Column(nullable=false)
    private String lastName;

    @Column(nullable=false, unique=true)
    private String email;

    private String mobile;

    @Column(nullable=false)
    private String password;

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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
