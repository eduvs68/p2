package DAO;

import domain.CompraProduto;
import domain.Produto;
import domain.Compra;
import util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompraProdutoDAO {
    public boolean inserir(CompraProduto cp) {
        String sql = "INSERT INTO CompraProduto (idCompra, idProduto, quantidade, precoUnitario) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, cp.getCompra().getIdCompra());
            stmt.setInt(2, cp.getProduto().getIdProduto());
            stmt.setInt(3, cp.getQuantidade());
            stmt.setInt(4, cp.getPrecoUnitario());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir compraProduto: " + e.getMessage());
            return false;
        }
    }

    public List<CompraProduto> listarTodos() {
        // Este método pode ser implementado conforme necessário.
        return new ArrayList<>();
    }
}
