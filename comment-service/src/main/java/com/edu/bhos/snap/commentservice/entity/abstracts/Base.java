package com.edu.bhos.snap.commentservice.entity.abstracts;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public class Base {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    
}
