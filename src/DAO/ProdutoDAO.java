package DAO;

import domain.*;
import util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private CategoriaDAO categoriaDAO = new CategoriaDAO();
    private FornecedorDAO fornecedorDAO = new FornecedorDAO();

    public void inserir(Produto p) {
        String sql = "INSERT INTO Produto (gtin, nome, precoVenda, precoCompra, qtdEstoque, estoqueMin, idCategoria, cnpj) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getGtin());
            stmt.setString(2, p.getNome());
            stmt.setDouble(3, p.getPrecoVenda());
            stmt.setDouble(4, p.getPrecoCompra());
            stmt.setInt(5, p.getQtdEstoque());
            stmt.setInt(6, p.getEstoqueMin());
            stmt.setInt(7, p.getCategoria().getIdCategoria());
            stmt.setString(8, p.getFornecedor().getCnpj());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao inserir produto: " + e.getMessage());
        }
    }

    public void atualizarEstoque(Produto p) {
        String sql = "UPDATE Produto SET qtdEstoque = ? WHERE idProduto = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, p.getQtdEstoque());
            stmt.setInt(2, p.getIdProduto());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar estoque: " + e.getMessage());
        }
    }


    public List<Produto> listar() {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM Produto";
        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Categoria categoria = categoriaDAO.buscarPorId(rs.getInt("idCategoria"));
                Fornecedor fornecedor = fornecedorDAO.buscarPorCnpj(rs.getString("cnpj"));

                Produto p = new Produto(
                        rs.getInt("idProduto"),
                        rs.getString("nome"),
                        rs.getString("gtin"),
                        rs.getDouble("precoVenda"),
                        rs.getDouble("precoCompra"),
                        rs.getInt("qtdEstoque"),
                        rs.getInt("estoqueMin"),
                        categoria,
                        fornecedor
                );
                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar produtos: " + e.getMessage());
        }
        return lista;
    }

    public boolean excluirComVerificacao(int idProduto) {
        String sql = "DELETE FROM Produto WHERE idProduto = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idProduto);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            int errorCode = e.getErrorCode();
            if (errorCode == 1451) { // Código específico do MySQL para violação de FK (restrição ON DELETE)
                System.out.println("Não é possível excluir o produto: ele está vinculado a outra tabela.");
                return false;
            } else {
                System.out.println("Erro ao excluir produto: " + e.getMessage());
                return false;
            }
        }
    }


    public Produto buscarPorId(int idProduto) {
        String sql = "SELECT * FROM Produto WHERE idProduto = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idProduto);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Categoria categoria = categoriaDAO.buscarPorId(rs.getInt("idCategoria"));
                Fornecedor fornecedor = fornecedorDAO.buscarPorCnpj(rs.getString("cnpj"));
                return new Produto(
                        rs.getInt("idProduto"),
                        rs.getString("nome"),
                        rs.getString("gtin"),
                        rs.getDouble("precoVenda"),
                        rs.getDouble("precoCompra"),
                        rs.getInt("qtdEstoque"),
                        rs.getInt("estoqueMin"),
                        categoria,
                        fornecedor
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar produto: " + e.getMessage());
        }
        return null;
    }
}
