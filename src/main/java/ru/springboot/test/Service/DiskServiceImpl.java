package ru.springboot.test.Service;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import ru.springboot.test.HibernateConfig;
import ru.springboot.test.Model.Disk;
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
        transaction.commit();
        return query.list();
    }

    @Override
    public List<Disk> getFreeDisk() {
        session = OpenSession();
        String hql = "SELECT d.name, d.description FROM Disk d inner join Takenitem t on d.id=t.idDisk where t.idUser=t.idUserTake";
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
    public void addDisk(Integer userId, Disk disk) {
        session = OpenSession();
        session.save(disk);
        User user = (User)session.get(User.class, userId);
        user.getDisks().add(disk);
        session.save(user);
        transaction.commit();
        session.close();
    }

}
