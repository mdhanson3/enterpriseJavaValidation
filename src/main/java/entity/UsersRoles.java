package entity;

import javax.persistence.*;

/**
 * Created by student on 12/12/16.
 */

@Entity
@Table(name = "user_roles", schema="individualWebApp")

public class UsersRoles {
    private String userName;
    private String roleName;

    @Id
    @Column(name = "user_name", nullable = false, length = 255)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "role_name", nullable = false, length = 255)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
