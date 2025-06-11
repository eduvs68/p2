package DAO;

import domain.Venda;
import util.Conexao;

import java.sql.*;

public class VendaDAO {
    public boolean inserir(Venda venda) {
        String sql = "INSERT INTO Venda (data, valorTotal) VALUES (?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, venda.getData());
            stmt.setDouble(2, venda.getValorTotal());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir venda: " + e.getMessage());
            return false;
        }
    }
}
