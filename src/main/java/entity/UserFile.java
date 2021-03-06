package entity;

import com.sun.management.VMOption;

import javax.persistence.*;

/**
 * This class represents the data of a user file
 *
 * @author Mitchell Hanson
 */

@Entity
@Table(name = "USER_FILES", schema = "individualWebApp")
public class UserFile {
    private int id;
    //private int userId;
    private String originalFileLocation;
    private String modifiedFileContent;
    private String fileName;
    private int isDeleted;
    private User user;

    public UserFile(){}

    public UserFile(int id, /*int userId,*/ String originalFileLocation, String modifiedFileContent, String fileName, int isDeleted, User user){
        this.id = id;
        //this.userId = userId;
        this.originalFileLocation = originalFileLocation;
        this.modifiedFileContent = modifiedFileContent;
        this.fileName = fileName;
        this.isDeleted = isDeleted;
        this.user = user;
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

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @Basic
    @Column(name = "original_file_location", nullable = true)
    public String getOriginalFileLocation() {
        return originalFileLocation;
    }
    public void setOriginalFileLocation(String originalFileLocation) {
        this.originalFileLocation = originalFileLocation;
    }

    @Basic
    @Column(name = "modified_file_content", nullable = true)
    public String getModifiedFileContent() {
        return modifiedFileContent;
    }
    public void setModifiedFileContent(String modifiedFileContent) {
        this.modifiedFileContent = modifiedFileContent;
    }

    @Basic
    @Column(name = "file_name", nullable = true)
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Basic
    @Column(name = "is_deleted", nullable = true)
    public int getIsDeleted() {
        return isDeleted;
    }
    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }



}
