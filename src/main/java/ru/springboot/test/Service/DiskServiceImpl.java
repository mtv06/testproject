package ru.springboot.test.Service;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import ru.springboot.test.HibernateConfig;
import ru.springboot.test.Model.Disk;
import ru.springboot.test.Model.Takenitem;
import ru.springboot.test.Model.User;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DiskServiceImpl implements DiskService {

    private Transaction transaction;
    private Session session;

    @Override
    public Session OpenSession() {
        session = HibernateConfig.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        return session;
    }

    @Override
    public List<Disk> getAllDisk() {
        session = OpenSession();
        String hql = "from Disk";
        Query query = session.createQuery(hql);
//        Query query = session.createSQLQuery("select * from disk");
        List<Disk> result = query.list();
        transaction.commit();
        System.out.println(result);
        session.close();
        return result;
    }

    @Override
    public List<Disk> getFreeDisk() {
        session = OpenSession();
        String hql = "SELECT d.name, d.description FROM Disk d inner join Takenitem t on d.id=t.idDisk where t.idUser=t.idUserTake";
//        Query query = session.createQuery(hql);
        Query query = session.createSQLQuery(hql);
        List<Disk> result = query.list();
        transaction.commit();
        session.close();
        return result;
    }

    @Override
    public List<Disk> getDiskTakenByUser() {
        return null;
    }

    @Override
    public List<Disk> getDiskTakenFromUser() {
        return null;
    }

    @Override
    public void addDisk(Disk disk) {
//        session = OpenSession();
////        Disk d = new Disk();
////        d.setName(disk.getName());
////        d.setDescription(disk.getDescription());
////        session.save(d);
//        Set<Disk> userDisks = new HashSet<Disk>();
//        userDisks.add(new Disk( disk.getName(), disk.getDescription()));
//        session.save(userDisks);
//        transaction.commit();
//        session.close();
        try {
            session = OpenSession();

            Set<Disk> userDisk = new HashSet<Disk>();
            userDisk.add(new Disk("house","32354353"));
            userDisk.add(new Disk("mobile","9889343423"));

            User user = new User("Eswar", userDisk);
            session.save(user);

            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
