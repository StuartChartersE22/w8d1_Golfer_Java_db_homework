package db;

import models.Golfer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DBGolfer {

    private static Session session;
    private static Transaction transaction;

    public static void save(Golfer golfer){
        session = HibernateUtil.getSessionFactory().openSession();

        try{transaction = session.beginTransaction();
            session.save(golfer);
            transaction.commit();
        } catch (Throwable e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
