package msg.user.entity.dao;

import msg.user.entity.UserEntity;
import msg.user.entity.dto.UserLoginDTO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * The DAO for the User Entities.
 *
 * @author msg systems AG;
 * @since 19.1.2
 */
@Stateless
public class UserDAO {

    @PersistenceContext(unitName = "persistenceUnit")
    private EntityManager em;

    /**
     * Checks if a email address of a user is in use.
     *
     * @param email the email to check for. mandatory
     * @return <code>true</code> if the input email is associated with a user.
     */
    public boolean existsEmail(String email) {
        long count = em.createNamedQuery(UserEntity.USER_FIND_BY_EMAIL, Long.class)
                .setParameter(UserEntity.EMAIL, email)
                .getSingleResult();
        return (count > 0);
    }

    /**
     * Persists a user entity.
     *
     * @param user the input entity to be saved.
     * @return the persisted entity.
     */
    public UserEntity createUser(UserEntity user) {
        em.persist(user);
        return user;
    }

    public UserEntity updateUser(UserEntity user) {
        em.merge(user);
        return user;

    }




    public UserEntity getUserByEmail(String email) {
        return em.createNamedQuery(UserEntity.USER_GET_BY_EMAIL, UserEntity.class)
                .setParameter(UserEntity.EMAIL, email)
                .getSingleResult();
    }

    public boolean loginUser(UserLoginDTO userLoginDTO) {
        long count = em.createNamedQuery(UserEntity.USER_FIND_BY_USERNAME_AND_PASSWORD, Long.class)
                .setParameter(UserEntity.USERNAME, userLoginDTO.getUsername())
                .setParameter(UserEntity.PASSWORD, userLoginDTO.getPassword())
                .getSingleResult();
        return (count > 0);
    }

    public UserEntity getUserByUsername(String username) throws Exception {
        return em.createNamedQuery(UserEntity.USER_FIND_BY_USERNAME, UserEntity.class)
                .setParameter("username", username)
                .getSingleResult();
    }

    public List<UserEntity> getAll() {
        return em.createNamedQuery(UserEntity.USER_FIND_ALL, UserEntity.class)
                .getResultList();
    }

    public UserEntity getUserById(long id) throws Exception{
        return em.createNamedQuery(UserEntity.USER_FIND_BY_ID, UserEntity.class)
                .setParameter("id", id)
                .getSingleResult();
    }


}
