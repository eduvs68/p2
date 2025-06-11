package DAO;

import domain.VendaProduto;
import util.Conexao;

import java.sql.*;

public class VendaProdutoDAO {
    public boolean inserir(VendaProduto vp) {
        String sql = "INSERT INTO VendaProduto (quantidade, precoUnitario, idProduto, idVenda) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, vp.getQuantidade());
            stmt.setDouble(2, vp.getPrecoUnitario());
            stmt.setInt(3, vp.getProduto().getIdProduto());
            stmt.setInt(4, vp.getVenda().getIdVenda());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir vendaProduto: " + e.getMessage());
            return false;
        }
    }
}
