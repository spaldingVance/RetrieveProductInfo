package com.Dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Product.Product;

public class ProductIdDao {

	public ProductIdDao() {
		seedDatabase();
	}

	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hcl", "admin", "pass");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public void closeConnection(Connection con) throws SQLException {
		if (con != null) {
			con.close();
		}
	}

	public Product getRecordById(int id) {
		Product p = null;
		try {
			
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select * from products where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				p = new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setCategory(rs.getString("category"));
				p.setPrice(rs.getFloat("price"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return p;
	}

	public void seedDatabase() {
		
		String clearSeedsSQL = "Drop Database hcl";
		String createSchmaSQL = "Create Database hcl";
		String useSchemaSQL = "use hcl";
		String createTableSQL = "Create Table products(id Integer auto_increment primary key, name varchar(30), category varchar(30), price decimal(10,2))";

		try {
			Connection con = getConnection();
			Statement statement = con.createStatement();
			try {
				statement.executeUpdate(clearSeedsSQL);

			} catch (SQLException e) {
				e.printStackTrace();
			}

			statement.executeUpdate(createSchmaSQL);
			statement.executeUpdate(useSchemaSQL);
			statement.executeUpdate(createTableSQL);

			String insert1 = "insert into products(name, category, price) values ('Windshield', 'Windows', 100)";
			String insert2 = "insert into products(name, category, price) values ('Red Paint', 'Paint', 15)";
			String insert3 = "insert into products(name, category, price) values ('Brake Pads', 'Mechanical', 800)";
			String insert4 = "insert into products(name, category, price) values ('Steering Wheel', 'Internal', 20)";
			String insert5 = "insert into products(name, category, price) values ('Michelin Tires', 'Tires', 250)";
			String insert6 = "insert into products(name, category, price) values ('Firestone Tires', 'Tires', 200)";
			String insert7 = "insert into products(name, category, price) values ('Gasoline', 'Fuel', 2.50)";

			statement.executeUpdate(insert1);
			statement.executeUpdate(insert2);
			statement.executeUpdate(insert3);
			statement.executeUpdate(insert4);
			statement.executeUpdate(insert5);
			statement.executeUpdate(insert6);
			statement.executeUpdate(insert7);

			statement.close();
			closeConnection(con);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}