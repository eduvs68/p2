package DAO;

import domain.FormaPagamento;
import util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FormaPagamentoDAO {
    public boolean inserir(FormaPagamento fp) {
        String sql = "INSERT INTO FormaPagamento (tipo) VALUES (?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, fp.getTipo());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir forma de pagamento: " + e.getMessage());
            return false;
        }
    }

    public List<FormaPagamento> listarTodos() {
        List<FormaPagamento> lista = new ArrayList<>();
        String sql = "SELECT * FROM FormaPagamento";

        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                FormaPagamento fp = new FormaPagamento(
                        rs.getInt("idFormaPagamento"),
                        rs.getString("tipo")
                );
                lista.add(fp);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar formas de pagamento: " + e.getMessage());
        }

        return lista;
    }
}
