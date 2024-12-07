package com.klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Create a product
    public void insertProduct(Product product) {
        String sql = "INSERT INTO products (product_id, product_name, price, description) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, product.getProductId(), product.getProductName(), product.getPrice(), product.getDescription());
    }

    // Read a single product by ID
    public Product getProductById(int productId) {
        String sql = "SELECT * FROM products WHERE product_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{productId}, new ProductRowMapper());
    }

    // Read all products
    public List<Product> listAllProducts() {
        String sql = "SELECT * FROM products";
        return jdbcTemplate.query(sql, new ProductRowMapper());
    }

    // Update a product
    public void updateProduct(Product product) {
        String sql = "UPDATE products SET product_name = ?, price = ?, description = ? WHERE product_id = ?";
        jdbcTemplate.update(sql, product.getProductName(), product.getPrice(), product.getDescription(), product.getProductId());
    }

    // Delete a product
    public void deleteProduct(int productId) {
        String sql = "DELETE FROM products WHERE product_id = ?";
        jdbcTemplate.update(sql, productId);
    }

    // RowMapper implementation for Product
    private static class ProductRowMapper implements RowMapper<Product> {
        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Product(
                rs.getInt("product_id"),
                rs.getString("product_name"),
                rs.getDouble("price"),
                rs.getString("description")
            );
        }
    }
}
