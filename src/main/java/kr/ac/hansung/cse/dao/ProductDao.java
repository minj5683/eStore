package kr.ac.hansung.cse.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.hansung.cse.model.Product;

// jdbc -> spring jdbc -> hibernate 
//spring과정 다 지우셔서 남기긴함 jdbc는 ... 몰겠음

@Repository
@Transactional
public class ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Product getProductById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Product product = (Product) session.get(Product.class, id);

		return product;
	}

	/*
	 * spring jdbc 버전
	 *  private JdbcTemplate jdbcTemplate;
	 * 
	 * @Autowired public void setDataSource(DataSource dataSource) { jdbcTemplate =
	 * new JdbcTemplate(dataSource); }
	 */

	public List<Product> getProducts() {

		Session session = sessionFactory.getCurrentSession();
		String hql = "from Product";

		Query<Product> query = session.createQuery(hql, Product.class);
		List<Product> productList = query.getResultList();

		return productList;

		/*
		 * spring jdbc 버전 
		 * String sqlStatement = "select * from product";
		 * 
		 * return jdbcTemplate.query(sqlStatement, new RowMapper<Product>() {
		 * 
		 * @Override public Product mapRow(ResultSet rs, int rowNum) throws SQLException
		 * {
		 * 
		 * Product product = new Product();
		 * 
		 * product.setId(rs.getInt("id")); product.setName(rs.getString("name"));
		 * product.setCategory(rs.getString("category"));
		 * product.setPrice(rs.getInt("price"));
		 * product.setManufacturer(rs.getString("manufacturer"));
		 * product.setUnitInStock(rs.getInt("unitInStock"));
		 * product.setDescription(rs.getString("description"));
		 * 
		 * return product; }
		 * 
		 * });
		 */
	}

	public void addProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();

		/*
		 * spring jdbc 버전
		 *  int id = product.getId(); String name = product.getName();
		 * String category = product.getCategory(); int price = product.getPrice();
		 * String manufacturer = product.getManufacturer(); int unitInStock =
		 * product.getUnitInStock(); String description = product.getDescription();
		 * 
		 * String sqlStatement =
		 * "insert into product (id, name, category, price, manufacturer, unitInStock, description) "
		 * + "values (?,?,?,?,?,?,?)";
		 * 
		 * return (jdbcTemplate.update(sqlStatement, new Object[] { id, name, category,
		 * price, manufacturer, unitInStock, description }) == 1);
		 */
	}

	public void deleteProduct(Product product) {
        
		Session session = sessionFactory.getCurrentSession();
        session.delete(product);
        session.flush();
		/*
		 * spring jdbc 버전 
		 * String sqlStatement = "delete from product where id=?";
		 * 
		 * return(jdbcTemplate.update(sqlStatement, new Object[]{id}) == 1);
		 */
	}
	
	
	/*
	 * spring jdbc 버전 
	public void getProductById(Product product) {	
		 * String sqlStatement = "select * from product where id=?";
		 * 
		 * return jdbcTemplate.queryForObject(sqlStatement, new Object[]{id}, new
		 * RowMapper<Product>() {
		 * 
		 * @Override public Product mapRow(ResultSet rs, int rowNum) throws SQLException
		 * {
		 * 
		 * Product product = new Product();
		 * 
		 * product.setId(rs.getInt("id")); product.setName(rs.getString("name"));
		 * product.setCategory(rs.getString("category"));
		 * product.setPrice(rs.getInt("price"));
		 * product.setManufacturer(rs.getString("manufacturer"));
		 * product.setUnitInStock(rs.getInt("unitInStock"));
		 * product.setDescription(rs.getString("description"));
		 * 
		 * return product; }
		 * 
		 * });
		 * }
		 */

	public void updateProduct(Product product) {
		
		Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(product);
        session.flush();

		/*
		 * spring jdbc 버전 
		 * int id = product.getId(); String name = product.getName();
		 * String category = product.getCategory(); int price = product.getPrice();
		 * String manufacturer = product.getManufacturer(); int unitInStock =
		 * product.getUnitInStock(); String description = product.getDescription();
		 * 
		 * String sqlStatement =
		 * "update product set name=?, category=?, price=?, manufacturer=?, unitInStock=?, description=?"
		 * + "where id=? ";
		 * 
		 * return (jdbcTemplate.update(sqlStatement, new Object[] { name, category,
		 * price, manufacturer, unitInStock, description, id }) == 1);
		 */
	}
	
	public void infoProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(product);
		session.flush();
	}
	
}
