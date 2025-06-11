package DAO;

import domain.FluxoCaixa;
import util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FluxoCaixaDAO {
    public boolean inserir(FluxoCaixa fc) {
        String sql = "INSERT INTO FluxoCaixa (idFormaPagamento, data, tipo, valor, descricao) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, fc.getFormaPagamento().getIdFormaPagamento());
            stmt.setString(2, fc.getData());
            stmt.setString(3, fc.getTipo());
            stmt.setDouble(4, fc.getValor());
            stmt.setString(5, fc.getDescricao());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir fluxo de caixa: " + e.getMessage());
            return false;
        }
    }

    public List<FluxoCaixa> listarTodos() {
        return new ArrayList<>();
    }
}
