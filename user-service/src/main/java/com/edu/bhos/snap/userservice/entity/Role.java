package com.edu.bhos.snap.userservice.entity;

import com.edu.bhos.snap.userservice.entity.abstracts.Base;
import com.edu.bhos.snap.userservice.entity.abstracts.IEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Entity
public class Role extends Base implements IEntity {

    @ApiModelProperty(value ="role name must be min 3 characters and not null ")
    @NotBlank(message = "role name is mandatory")
    @Size(min = 2, max = 35, message = "role name must be 2-35 characters long.")
    @Column(nullable=false)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List< User > users;
}
