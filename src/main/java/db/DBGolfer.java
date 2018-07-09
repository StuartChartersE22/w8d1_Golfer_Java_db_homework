package db;

import models.Golfer;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;

import java.util.List;

public class DBGolfer extends DBGeneric {

    public static List<Golfer> getAll(){
        List<Golfer> results = null;
        session = HibernateUtil.getSessionFactory().openSession();

        try {
            Criteria cr = session.createCriteria(Golfer.class);
            results = cr.list();
        } catch(HibernateException e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }
}
