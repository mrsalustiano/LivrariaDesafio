package com.qintess.Livraria.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost/livros?serverTimezone=UTC", "sa", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
}


