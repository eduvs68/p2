package dao;

import domain.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    private final Connection connection;

    public CategoriaDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserir(Categoria categoria) throws SQLException {
        String sql = "INSERT INTO categoria (id_categoria, nome) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, categoria.getIdCategoria());
            stmt.setString(2, categoria.getNome());
            stmt.executeUpdate();
        }
    }

    public void atualizar(Categoria categoria) throws SQLException {
        String sql = "UPDATE categoria SET nome = ? WHERE id_categoria = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, categoria.getNome());
            stmt.setInt(2, categoria.getIdCategoria());
            stmt.executeUpdate();
        }
    }

    public void deletar(int idCategoria) throws SQLException {
        String sql = "DELETE FROM categoria WHERE id_categoria = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idCategoria);
            stmt.executeUpdate();
        }
    }

    public Categoria buscarPorId(int idCategoria) throws SQLException {
        String sql = "SELECT * FROM categoria WHERE id_categoria = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idCategoria);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Categoria(
                            rs.getInt("id_categoria"),
                            rs.getString("nome")
                    );
                }
            }
        }
        return null;
    }

    public List<Categoria> listarTodas() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT * FROM categoria";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                categorias.add(new Categoria(
                        rs.getInt("id_categoria"),
                        rs.getString("nome")
                ));
            }
        }
        return categorias;
    }
}
