package msg.comment.entity.dao;

import msg.comment.entity.CommentEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Document me.
 *
 * @author msg systems AG; User Name.
 * @since 19.1.2
 */
@Stateless
public class CommentDAO {
    @PersistenceContext(unitName = "persistenceUnit")
    private EntityManager em;

    public CommentEntity createComment(CommentEntity c) {
        em.persist(c);
        em.flush();
        return c;
    }
//    public List<CommentEntity> getCommentsByUser(User user){
//        return em.createNamedQuery("User.findComment",CommentEntity.class).setParameter("id",user.getId()).getResultList();
//    }

}
