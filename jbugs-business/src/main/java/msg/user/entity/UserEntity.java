package msg.user.entity;

import msg.base.BaseEntity;
import msg.bug.entity.BugEntity;
import msg.comment.entity.CommentEntity;
import msg.role.entity.RoleEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * The User entity.
 *
 * @author msg systems AG; UserEntity Name.
 * @since 19.1.2
 */
@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = UserEntity.USER_FIND_BY_EMAIL, query = "SELECT count(u) from UserEntity u where u.email = :" + UserEntity.EMAIL),
        @NamedQuery(name = UserEntity.USER_COUNT_BY_USERNAME, query = "SELECT count(u) from UserEntity u where u.username = :username"),

        @NamedQuery(name = UserEntity.USER_FIND_ALL, query = "SELECT u from UserEntity u"),
        @NamedQuery(name = UserEntity.USER_FIND_BY_ID, query = "SELECT u from UserEntity u where u.id = :id"),
        @NamedQuery(name = UserEntity.USER_FIND_BY_USERNAME, query = "SELECT u from UserEntity u where u.username = :username"),
        @NamedQuery(name = UserEntity.USER_GET_BY_EMAIL, query = "SELECT u from UserEntity u where u.email = :" + UserEntity.EMAIL)
})
        
public class UserEntity extends BaseEntity<Long> {
    public static final String USER_FIND_BY_EMAIL = "UserEntity.findByEmail";
    public static final String USER_GET_BY_EMAIL = "UserEntity.getByEmail";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String USER_COUNT_BY_USERNAME = "UserEntity.countByUsername";
    public static final String USER_FIND_ALL = "UserEntity.findAll";
    public static final String USER_FIND_BY_ID = "UserEntity.findById";
    public static final String USER_FIND_BY_USERNAME = "UserEntity.findByUsername";


    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "email", nullable = false)//todo: @Pattern
    private String email;
    @Column(name = "mobile_number", nullable = false)
    private String mobileNumber;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "counter")
    private int counter;
    @Column(name = "status")
    private boolean status;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    )
    private List<RoleEntity> roles = new ArrayList<>();

    public UserEntity() {
    }

    public Set<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(Set<CommentEntity> comments) {
        this.comments = comments;
    }

    @OneToMany(mappedBy = "userEntity")
    Set<CommentEntity> comments;
    @OneToMany(mappedBy = "assignedTo")
    Set<BugEntity> assigned;
    @OneToMany(mappedBy = "createdBy")
    Set<BugEntity> created;

    public Set<BugEntity> getCreated() {
        return created;
    }

    public void setCreated(Set<BugEntity> created) {
        this.created = created;
    }

    public Set<BugEntity> getAssigned() {
        return assigned;
    }

    public void setAssigned(Set<BugEntity> assigned) {
        this.assigned = assigned;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity userEntity = (UserEntity) o;
        return counter == userEntity.counter &&
                Objects.equals(firstName, userEntity.firstName) &&
                Objects.equals(lastName, userEntity.lastName) &&
                Objects.equals(email, userEntity.email) &&
                Objects.equals(mobileNumber, userEntity.mobileNumber) &&
                Objects.equals(username, userEntity.username) &&
                Objects.equals(password, userEntity.password) &&
                Objects.equals(status, userEntity.status);
    }


    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, mobileNumber, username, password, counter, status);
    }
}
