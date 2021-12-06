package dao;

import domain.Product;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static utils.DataSourceUtils.getDataSource;

public class ProductDao {
	public Product FindBookByName(String ProductName) throws SQLException {
		DataSource dataSource=getDataSource();
		Connection connection=dataSource.getConnection();
		String sql = "select * from Products where ProductName=?";
		PreparedStatement statement=connection.prepareStatement(sql);
		statement.setString(1,ProductName);
		ResultSet resultset=statement.executeQuery();

		Product product=new Product();
		while(resultset.next())
		{
			product.setProductName(resultset.getString(1));
			product.setProductPrice(resultset.getDouble(2));
			product.setProductDescription(resultset.getString(3));
			product.setProductType(resultset.getString(4));
			product.setProductPictureName(resultset.getString(5));
			product.setProductSale(resultset.getInt(6));
		}
		resultset.close();
		statement.close();
		connection.close();
		return product;
	}

	public void AddProduct(Product product)throws SQLException {
		DataSource dataSource=getDataSource();
		Connection connection=dataSource.getConnection();
		String sql = "insert into products values(?,?,?,?,?,?)";
		PreparedStatement statement=connection.prepareStatement(sql);
		statement.setString(1,product.getProductName());
		statement.setDouble(2,product.getProductPrice());
		statement.setString(3,product.getProductDescription());
		statement.setString(4,product.getProductType());
		statement.setString(5,product.getProductPictureName());
		statement.setInt(6,0);
		statement.executeUpdate();
		statement.close();
		connection.close();
	}

	public void DeleteProduct(String productname)throws SQLException {
		DataSource dataSource=getDataSource();
		Connection connection=dataSource.getConnection();
		String sql = "delete from products where ProductName=?";
		PreparedStatement statement=connection.prepareStatement(sql);
		statement.setString(1,productname);
		statement.executeUpdate();
		statement.close();
		connection.close();
	}

	public void UpdateProduct(Product product)throws SQLException {
		DataSource dataSource=getDataSource();
		Connection connection=dataSource.getConnection();
		String sql = "UPDATE products SET ProductPrice=?,ProductDescription=?,ProductType=?,ProductPictureName=? where ProductName=?";
		PreparedStatement statement=connection.prepareStatement(sql);
		statement.setDouble(1,product.getProductPrice());
		statement.setString(2,product.getProductDescription());
		statement.setString(3,product.getProductType());
		statement.setString(4,product.getProductPictureName());
		statement.setString(5,product.getProductName());
		statement.executeUpdate();
		statement.close();
		connection.close();
	}

	public List<Product> ShowSale() throws SQLException{
		DataSource dataSource=getDataSource();
		Connection connection=dataSource.getConnection();
		String sql = "select * from Products";
		PreparedStatement statement=connection.prepareStatement(sql);
		ResultSet resultset=statement.executeQuery();
		List<Product> Lproduct= new ArrayList<>();
		while(resultset.next())
		{
			String productname=resultset.getString(1);
			double productprice=resultset.getDouble(2);
			String productdescription=resultset.getString(3);
			String producttype=resultset.getString(4);
			String productpicturename=resultset.getString(5);
			int productsale=resultset.getInt(6);
			Lproduct.add(new Product(productname,productprice,productdescription,producttype,productpicturename,productsale));
		}
		resultset.close();
		statement.close();
		connection.close();
		return Lproduct;
	}
}
