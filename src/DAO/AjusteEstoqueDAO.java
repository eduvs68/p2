package DAO;

import domain.AjusteEstoque;
import domain.Produto;
import util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AjusteEstoqueDAO {

    public boolean inserir(AjusteEstoque ajuste) {
        String sql = "INSERT INTO AjusteEstoque (idProduto, data, tipo, quantidade, descricao) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setInt(1, ajuste.getProduto().getIdProduto());
            stmt.setString(2, ajuste.getData());
            stmt.setString(3, ajuste.getTipo());
            stmt.setInt(4, ajuste.getQuantidade());
            stmt.setString(5, ajuste.getDescricao());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                ajuste.setIdAjuste(rs.getInt(1));
            }

            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir ajuste de estoque: " + e.getMessage());
            return false;
        }
    }

    public List<AjusteEstoque> listarTodos() {
        List<AjusteEstoque> lista = new ArrayList<>();
        String sql = "SELECT ae.*, p.* FROM AjusteEstoque ae JOIN Produto p ON ae.idProduto = p.idProduto";

        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setGtin(rs.getString("gtin"));
                produto.setProduto(rs.getString("produto"));
                produto.setPrecoVenda(rs.getDouble("precoVenda"));
                produto.setPrecoCompra(rs.getDouble("precoCompra"));
                produto.setQtdEstoque(rs.getInt("qtdEstoque"));
                produto.setEstoqueMin(rs.getInt("estoqueMin"));
                produto.setIdCategoria(rs.getInt("idCategoria"));
                produto.setCnpj(rs.getString("cnpj"));

                AjusteEstoque ajuste = new AjusteEstoque(
                        rs.getInt("idAjuste"),
                        produto,
                        rs.getString("data"),
                        rs.getString("tipo"),
                        rs.getInt("quantidade"),
                        rs.getString("descricao")
                );

                lista.add(ajuste);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar ajustes de estoque: " + e.getMessage());
        }

        return lista;
    }

    public AjusteEstoque buscarPorId(int id) {
        String sql = "SELECT ae.*, p.* FROM AjusteEstoque ae JOIN Produto p ON ae.idProduto = p.idProduto WHERE ae.idAjuste = ?";
        AjusteEstoque ajuste = null;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setGtin(rs.getString("gtin"));
                produto.setProduto(rs.getString("produto"));
                produto.setPrecoVenda(rs.getDouble("precoVenda"));
                produto.setPrecoCompra(rs.getDouble("precoCompra"));
                produto.setQtdEstoque(rs.getInt("qtdEstoque"));
                produto.setEstoqueMin(rs.getInt("estoqueMin"));
                produto.setIdCategoria(rs.getInt("idCategoria"));
                produto.setCnpj(rs.getString("cnpj"));

                ajuste = new AjusteEstoque(
                        rs.getInt("idAjuste"),
                        produto,
                        rs.getString("data"),
                        rs.getString("tipo"),
                        rs.getInt("quantidade"),
                        rs.getString("descricao")
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar ajuste de estoque: " + e.getMessage());
        }

        return ajuste;
    }

    public boolean deletar(int id) {
        String sql = "DELETE FROM AjusteEstoque WHERE idAjuste = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Erro ao deletar ajuste de estoque: " + e.getMessage());
            return false;
        }
    }
}
