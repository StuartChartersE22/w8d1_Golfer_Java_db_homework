package db;

import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class DBGeneric {

    private static Session session;
    private static Transaction transaction;

    public static <T extends Object> void save(T object){
        session = HibernateUtil.getSessionFactory().openSession();

        try{transaction = session.beginTransaction();
            session.save(object);
            transaction.commit();
        } catch (Throwable e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
