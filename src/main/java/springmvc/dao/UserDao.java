package springmvc.dao;

import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public int saveUser(User user){

        return (int) hibernateTemplate.save(user);
    }

    @Transactional
    public User getUser(String email){

        String q = "from User where email = :email";

        Query query = hibernateTemplate.getSessionFactory().getCurrentSession().createQuery(q);

        query.setParameter("email",email);


        return (User) query.uniqueResult();
    }


}
