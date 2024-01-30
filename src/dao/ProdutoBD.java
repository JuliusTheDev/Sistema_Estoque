package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class ProdutoBD {

    public static Connection conexaoOn() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/trabalholp2", "postgres", "postgres");

        } catch (ClassNotFoundException p) {
            System.out.println("Não encontrado JDBC.");
            p.printStackTrace();
        } catch (SQLException p) {
            System.out.println("Erro ao conectar ao sistema de SGBD.");
            p.printStackTrace();
        }
        return null;
    }
}