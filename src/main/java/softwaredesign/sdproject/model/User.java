package softwaredesign.sdproject.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "system_dev_exam_app", catalog = "")
public class User {
    private int userId;
    private String email;
    private String password;
    private String permission;

public User(){}
public User(int userId,String email,String password,String permission){
    this.userId=userId;
    this.email=email;
    this.password=password;
    this.permission=permission;
}
    @Id
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 70)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 20)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "permission", nullable = true, length = 15)
    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(permission, user.permission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, email, password, permission);
    }
}
