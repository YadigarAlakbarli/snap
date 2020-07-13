package com.edu.bhos.snap.commentservice.entity;

import com.edu.bhos.snap.commentservice.entity.abstracts.Base;
import com.edu.bhos.snap.commentservice.entity.abstracts.IEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@ApiModel(value = "Comment model documentations")
@Data
@Entity
public class Comment extends Base implements IEntity {

    @NotBlank(message = "Message field must be min 1 character")
    private String message;

    @NotBlank(message = "Author's id mandatory")
    private int authorId;

    @NotBlank(message = "Post'id  mandatory")
    private int postId;

    private boolean status=true;

    private LocalDateTime releaseAt=LocalDateTime.now();

    private LocalDateTime updateAt;
}
