package ru.springboot.test.Model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Disk {

    private int id;

    @Column
    private String name;

    @Column
    private String description;


}
