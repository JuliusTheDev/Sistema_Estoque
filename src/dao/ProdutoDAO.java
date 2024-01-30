package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Produto;

public class ProdutoDAO {
    private Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    public boolean verificaCodigo(int codigo) throws SQLException {
        String sql = "select count(*) from nome_produto where id = ?";
        try (PreparedStatement test = connection.prepareStatement(sql)) {
            test.setInt(1, codigo);
            try (ResultSet resultado = test.executeQuery()) {
                if (resultado.next()) {
                    int result = resultado.getInt(1);
                    return result > 0;
                }
            }
        }
        return false;
    }
    
    public void alterar(Produto newProduto) throws SQLException {
        String sql = "update nome_produto set descricao = ?, categoria = ?, preco_custo = ?, "
                + "preco_venda = ?, quantidade = ?, data_entrada = ? where id = ?";

        PreparedStatement product = connection.prepareStatement(sql);
        product.setString(1, newProduto.getDescricao());
        product.setString(2, newProduto.getCategoria());
        product.setDouble(3, newProduto.getPrecoCusto());
        product.setDouble(4, newProduto.getPrecoVenda());
        product.setInt(5, newProduto.getQuantidade());
        product.setDate(6, new java.sql.Date(newProduto.getDataEntrada().getTime()));
        product.setInt(7, newProduto.getCodigo());
        product.executeUpdate();
        product.close();
    }

    public boolean deletar(int codigo) throws SQLException {
        String sql = "delete from nome_produto where id = ?";

        PreparedStatement product = connection.prepareStatement(sql);
        product.setInt(1, codigo);
        ;
        int linhasDeletadas = product.executeUpdate();
        product.close();
        return linhasDeletadas > 0;
    }
    
    public void salvar(Produto newProduto) throws SQLException {
        String sql = "insert into nome_produto (descricao, categoria, preco_custo, "
                + "preco_venda, quantidade, data_entrada) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement product = connection.prepareStatement(sql);
        product.setString(1, newProduto.getDescricao());
        product.setString(2, newProduto.getCategoria());
        product.setDouble(3, newProduto.getPrecoCusto());
        product.setDouble(4, newProduto.getPrecoVenda());
        product.setInt(5, newProduto.getQuantidade());
        product.setDate(6, new java.sql.Date(newProduto.getDataEntrada().getTime()));
        product.executeUpdate();
        product.close();
    }
}