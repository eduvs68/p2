package DAO;

import domain.Fornecedor;
import util.Conexao;

import java.sql.*;

public class FornecedorDAO {
    public boolean inserir(Fornecedor fornecedor) {
        String sql = "INSERT INTO Fornecedor (cnpj, nome, endereco, telefone) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, fornecedor.getCnpj());
            stmt.setString(2, fornecedor.getNome());
            stmt.setString(3, fornecedor.getEndereco());
            stmt.setString(4, fornecedor.getTelefone());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir fornecedor: " + e.getMessage());
            return false;
        }
    }
}
