package com.edu.bhos.snap.userservice.entity.abstracts;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Setter
@Getter
@MappedSuperclass
public class Person  extends Base{

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

    @ApiModelProperty("Phone number of User optional")
    private String mobile;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] img;
}
