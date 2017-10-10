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
        String hsq = "from Disk";
        Query query = session.createQuery("from Disk");
//        Query query = session.createSQLQuery("select * from disk");
        List<Disk> result = query.list();
        session.getTransaction().commit();
        System.out.println(result);
        session.close();
        return result;
    }
}
