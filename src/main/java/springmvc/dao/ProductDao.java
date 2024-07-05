package springmvc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springmvc.model.Product;

import java.util.List;

@Repository
public class ProductDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public void createProduct(Product product){

        hibernateTemplate.saveOrUpdate(product);
    }

    public List<Product> getAllProduct(){
        return hibernateTemplate.loadAll(Product.class);
    }

    public Product getProduct(int pid){
        return hibernateTemplate.get(Product.class,pid);
    }

    @Transactional
    public void deleteProduct(int pid){
        Product p = hibernateTemplate.load(Product.class,pid);
        hibernateTemplate.delete(p);
    }

}
