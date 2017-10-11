package ru.springboot.test.Service;

import org.hibernate.Session;
import ru.springboot.test.Model.Disk;

import java.util.List;

public interface DiskService {

    public Session OpenSession();
    public List<Disk> getAllDisk();
    public List<Disk> getFreeDisk();
    public List<Disk> getDiskTakenByUser();
    public List<Disk> getDiskTakenFromUser();
    public void addDisk(Disk disk);

}
