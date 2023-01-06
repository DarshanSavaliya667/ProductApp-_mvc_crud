package productcurdapp.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import productcurdapp.model.Product;

@Component
public class ProductDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public void createProduct(Product product) {
		
		
		this.hibernateTemplate.saveOrUpdate(product);
	}
	//get all product
	public List<Product> getProducts(){
		List<Product> Products= this.hibernateTemplate.loadAll(Product.class);
		return Products;
	}
	//delete the singale product
	@Transactional
	public void deleteProduct(int pid) {
		Product p=	this.hibernateTemplate.load(Product.class,pid);
		this.hibernateTemplate.delete(p);
	}
	//get the single product
	public Product getProduct(int pid) {
		return this.hibernateTemplate.get(Product.class, pid);
	}
	
}
