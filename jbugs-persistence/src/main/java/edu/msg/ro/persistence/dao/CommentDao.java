package edu.msg.ro.persistence.dao;

import edu.msg.ro.persistence.entity.Comment;

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
public class CommentDao {
    @PersistenceContext(unitName = "jbugs-persistence")
    private EntityManager em;

    public Comment createComment(Comment c){
        em.persist(c);
        em.flush();
        return c;
    }
//    public List<Comment> getCommentsByUser(User user){
//        return em.createNamedQuery("User.findComment",Comment.class).setParameter("id",user.getId()).getResultList();
//    }

}
