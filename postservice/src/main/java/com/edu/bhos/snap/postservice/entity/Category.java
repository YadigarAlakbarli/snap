package com.edu.bhos.snap.postservice.entity;

import com.edu.bhos.snap.postservice.entity.abstracts.Base;
import com.edu.bhos.snap.postservice.entity.abstracts.IEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Category extends Base implements IEntity {

    @NotBlank(message = "Category's name field is mandatory")
    private String name;
    private boolean status=true;
    private LocalDateTime createAt=LocalDateTime.now();
    private  LocalDateTime updateAt;

    @ManyToMany(mappedBy ="categories")
    private List<Post> posts;
}
