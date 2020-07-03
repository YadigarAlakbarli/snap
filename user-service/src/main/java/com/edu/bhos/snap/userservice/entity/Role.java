package com.edu.bhos.snap.userservice.entity;

import com.edu.bhos.snap.userservice.entity.abstracts.Base;
import com.edu.bhos.snap.userservice.entity.abstracts.IEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@Entity
public class Role extends Base implements IEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List< User > users;


}
