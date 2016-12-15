package entity;

import com.sun.javafx.beans.IDProperty;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

/**
 * This class represents the data of a user
 *
 * @author Mitchell Hanson
 */
@Entity
@Table(name = "USERS_WITH_ID", schema = "individualWebApp")
public class User {
    private int id;
    private String userName;
    private String password;

    public User() {

    }

    public User(int id, String name, String password) {
        this.id = id;
        this.userName = name;
        this.password = password;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_name", nullable = true, length = 255)
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_pass", nullable = true, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
