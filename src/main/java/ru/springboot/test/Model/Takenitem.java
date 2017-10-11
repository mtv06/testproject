package ru.springboot.test.Model;

import javax.persistence.*;

@Entity
@Table(name = "takenitem")
public class Takenitem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int idUser;

    @Column
    private int idDisk;

    @Column
    private int idUserTake;

    public Takenitem() {}

    public Takenitem(int idUser, int idDisk, int idUserTake) {
        this.idUser = idUser;
        this.idDisk = idDisk;
        this.idUserTake = idUserTake;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdDisk() {
        return idDisk;
    }

    public void setIdDisk(int idDisk) {
        this.idDisk = idDisk;
    }

    public int getIdUserTake() {
        return idUserTake;
    }

    public void setIdUserTake(int idUserTake) {
        this.idUserTake = idUserTake;
    }

    @Override
    public String toString() {
        return "Takenitem{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", idDisk=" + idDisk +
                ", idUserTake=" + idUserTake +
                '}';
    }
}
