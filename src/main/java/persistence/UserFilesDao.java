package persistence;

import entity.User;
import entity.UserFile;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by student on 12/13/16.
 */
public class UserFilesDao {

    private final Logger log = Logger.getLogger(this.getClass());


    public int addUserFile(UserFile userFile) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = null;
        Integer userFileId = null;
        log.info("User file id before save: " + userFile );

        try {
            transaction = session.beginTransaction();
            userFileId = (Integer) session.save(userFile);
            //session.save(user);
            log.info("UserFile after session save: " + userFileId);
            //session.save(createUserRole(user));
            transaction.commit();

            log.info("Added new userFile: " + userFile + " with id of: " + userFileId);

        } catch (HibernateException e) {
            if (transaction!=null) transaction.rollback();
            log.error(e);
        } finally {
            session.close();
        }

        //return userFileId;
        return 0;
    }
}
