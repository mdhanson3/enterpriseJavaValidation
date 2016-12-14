package persistence;

import entity.User;
import entity.UserFile;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 *
 */
public class UserFilesDao {

    private final Logger log = Logger.getLogger(this.getClass());

    public UserFile getUserFile(int id) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        UserFile userFile = (UserFile) session.get(UserFile.class, id);
        return userFile;
    }

    public List<UserFile> getFilesByUserId(User user) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(UserFile.class);

        List<UserFile> fileList = (List<UserFile>) criteria.add(Restrictions.eq("user", user)).add(Restrictions.eq("isDeleted", 0)).list();
        return fileList;
    }

    public void deleteUserFile(UserFile userFile) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = null;
        userFile.setIsDeleted(1);

        try {
            transaction = session.beginTransaction();
            session.update(userFile);
            transaction.commit();

        } catch (HibernateException e) {
            if (transaction!=null) transaction.rollback();
            log.error(e);
        } finally {
            session.close();
        }
    }

    public int addUserFile(UserFile userFile) {
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction transaction = null;
        Integer userFileId = null;
        log.info("User file id before save: " + userFile );

        try {
            transaction = session.beginTransaction();
            userFileId = (Integer) session.save(userFile);
            log.info("UserFile after session save: " + userFileId);
            transaction.commit();

            log.info("Added new userFile: " + userFile + " with name of: " + userFile.getFileName() + ". Id: " + userFileId);

        } catch (HibernateException e) {
            if (transaction!=null) transaction.rollback();
            log.error(e);
        } finally {
            session.close();
        }

        return userFileId;

    }
}
