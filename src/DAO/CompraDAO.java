package DAO;

import domain.Compra;
import util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompraDAO {
    public boolean inserir(Compra compra) {
        String sql = "INSERT INTO Compra (data, valorTotal) VALUES (?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, compra.getData());
            stmt.setDouble(2, compra.getValorTotal());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir compra: " + e.getMessage());
            return false;
        }
    }

    public List<Compra> listarTodos() {
        List<Compra> lista = new ArrayList<>();
        String sql = "SELECT * FROM Compra";

        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Compra c = new Compra(
                        rs.getInt("idCompra"),
                        rs.getString("data"),
                        rs.getDouble("valorTotal")
                );
                lista.add(c);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar compras: " + e.getMessage());
        }
        return lista;
    }
}
