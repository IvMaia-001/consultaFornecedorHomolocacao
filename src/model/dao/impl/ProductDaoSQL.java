package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbConection.DB;
import dbConection.DbException;
import model.dao.ProductDao;
import model.entities.Product;

public class ProductDaoSQL implements ProductDao{

	private Connection conn;

	public ProductDaoSQL(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public Product findByProduct (Long codProduct) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT DESC_PRODUTO, FABRICANTE FROM PRODUTOS WHERE 1=1 and PRODUTO = ?");
			st.setLong(1, codProduct);
			rs = st.executeQuery();
			if (rs.next()) {
				Product obj = new Product();
	            obj.setDescProduct(rs.getString("DESC_PRODUTO"));
	            obj.setDescManufacturer(rs.getString("FABRICANTE"));
				return obj;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStantament(st);
			DB.closeResultSet(rs);
		}
	}
}
