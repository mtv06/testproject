package ru.springboot.test.Service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import ru.springboot.test.HibernateConfig;
import ru.springboot.test.Model.Disk;


import java.util.List;

@Service
public class DiskServiceImpl implements DiskService {

    @Override
    public Session OpenSession() {
        Session session = HibernateConfig.getSessionFactory().openSession();
        session.beginTransaction();
        return session;
    }

    @Override
    public List<Disk> getAllDisk() {
        Session session = OpenSession();
        String hql = "from Disk";
        Query query = session.createQuery(hql);
//        Query query = session.createSQLQuery("select * from disk");
        List<Disk> result = query.list();
        session.getTransaction().commit();
        System.out.println(result);
        session.close();
        return result;
    }

    @Override
    public List<Disk> getFreeDisk() {
        return null;
    }

    @Override
    public List<Disk> getDiskTakenByUser() {
        return null;
    }

    @Override
    public List<Disk> getDiskTakenFromuser() {
        return null;
    }

    @Override
    public void addDisk(Disk disk) {
        Session session = OpenSession();
        Disk d = new Disk();
        d.setName(disk.getName());
        d.setDescription(disk.getDescription());
        session.save(d);
//        String name = disk.getName();
//        System.out.println("name - " + name);
//        String description = disk.getDescription();
//        System.out.println("description - " + description);
////        String hql = "insert into Disk (name, description) values (\"disk name\",\"disk description\")";
//        String hql = "insert into Disk (id, name, description)";
//        System.out.println("hql - " + hql);
//        Query query = session.createQuery(hql);
        session.getTransaction().commit();
        session.close();
    }

}
