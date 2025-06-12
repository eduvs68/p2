package DAO;

import domain.*;
import util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AjusteEstoqueDAO {

    private ProdutoDAO produtoDAO = new ProdutoDAO();

    public void inserir(AjusteEstoque a) {
        String sql = "INSERT INTO AjusteEstoque (idProduto, data, tipo, quantidade, descricao) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, a.getProduto().getIdProduto());
            stmt.setString(2, a.getData());
            stmt.setString(3, a.getTipo().getDescricao());
            stmt.setInt(4, a.getQuantidade());
            stmt.setString(5, a.getDescricao());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir ajuste de estoque: " + e.getMessage());
        }
    }

    public List<AjusteEstoque> listar() {
        List<AjusteEstoque> lista = new ArrayList<>();
        String sql = "SELECT * FROM AjusteEstoque";
        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Produto produto = produtoDAO.buscarPorId(rs.getInt("idProduto"));
                TipoAjusteEstoque tipo = TipoAjusteEstoque.fromDescricao(rs.getString("tipo"));

                AjusteEstoque a = new AjusteEstoque(
                        rs.getInt("idAjsuteEstoque"),
                        produto,
                        rs.getString("data"),
                        tipo,
                        rs.getInt("quantidade"),
                        rs.getString("descricao")
                );
                lista.add(a);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar ajustes de estoque: " + e.getMessage());
        }
        return lista;
    }
}
