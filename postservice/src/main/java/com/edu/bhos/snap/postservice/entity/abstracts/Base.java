package com.edu.bhos.snap.postservice.entity.abstracts;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public class Base {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

 public int getId() {
  return id;
 }

 public void setId(int id) {
  this.id = id;
 }
}
