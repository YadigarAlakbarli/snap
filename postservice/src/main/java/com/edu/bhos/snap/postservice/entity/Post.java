package com.edu.bhos.snap.postservice.entity;

import com.edu.bhos.snap.postservice.entity.abstracts.Base;
import com.edu.bhos.snap.postservice.entity.abstracts.IEntity;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Post extends Base implements IEntity {

    @NotBlank(message = "Title field is mandatory")
    @Size(min =2,max = 100,message = "Title size range must be 2-100 range")
    private String title;

    @NotBlank(message = "Body field is mandatory")
    private String body;

    private LocalDateTime postDate=LocalDateTime.now();
    
    private LocalDateTime releaseDate;
    
    private LocalDateTime updateDate;

    private boolean status=true;

    @NotBlank(message = "Author's id field is mandatory")
    private int authorsId;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] img;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "post_categorys",
            joinColumns = {@JoinColumn(name = "post_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id", referencedColumnName = "id")})
    private List<Category> categories;
}
