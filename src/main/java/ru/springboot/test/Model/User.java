package ru.springboot.test.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nameF;

    @Column
    private String nameI;

    @Column
    private String nameO;

    @Column
    private String login;

    @Column
    private String pass;

    @OneToMany
    private Set<Disk> disks;

    public User(){}

    public User(String nameF, String nameI, String nameO, String login, String pass, Set<Disk> disks) {
        this.nameF = nameF;
        this.nameI = nameI;
        this.nameO = nameO;
        this.login = login;
        this.pass = pass;
        this.disks = disks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameF() {
        return nameF;
    }

    public void setNameF(String nameF) {
        this.nameF = nameF;
    }

    public String getNameI() {
        return nameI;
    }

    public void setNameI(String nameI) {
        this.nameI = nameI;
    }

    public String getNameO() {
        return nameO;
    }

    public void setNameO(String nameO) {
        this.nameO = nameO;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Set<Disk> getDisks() {
        return disks;
    }

    public void setDisks(Set<Disk> disks) {
        this.disks = disks;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nameF='" + nameF + '\'' +
                ", nameI='" + nameI + '\'' +
                ", nameO='" + nameO + '\'' +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
