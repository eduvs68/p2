package dao;

import domain.Categoria;
import domain.Fornecedor;
import domain.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private final Connection connection;

    public ProdutoDAO(Connection connection) {
        this.connection = connection;
    }

    public void inserir(Produto produto) throws SQLException {
        String sql = "INSERT INTO produto (id, nome, gtin, precovenda, precocompra, qtdestoque, estoquemin, categoria_id, fornecedor_cnpj) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, produto.getId());
            stmt.setString(2, produto.getNome());
            stmt.setInt(3, produto.getGtin());
            stmt.setString(4, produto.getPrecoVenda());
            stmt.setString(5, produto.getPrecoCompra());
            stmt.setString(6, produto.getQtdEstoque());
            stmt.setString(7, produto.getEstoqueMin());
            stmt.setInt(8, produto.getCategoria().getIdCategoria());
            stmt.setInt(9, produto.getFornecedor().getCnpj());
            stmt.executeUpdate();
        }
    }

    public Produto buscarPorId(int id) throws SQLException {
        String sql = "SELECT p.*, c.nome AS nome_categoria, f.nome AS nome_fornecedor, f.cnpj, f.endereco, f.telefone " +
                "FROM produto p " +
                "JOIN categoria c ON p.categoria_id = c.id_categoria " +
                "JOIN fornecedor f ON p.fornecedor_cnpj = f.cnpj " +
                "WHERE p.id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Categoria categoria = new Categoria(
                            rs.getInt("categoria_id"),
                            rs.getString("nome_categoria")
                    );
                    Fornecedor fornecedor = new Fornecedor(
                            rs.getInt("cnpj"),
                            rs.getString("nome_fornecedor"),
                            rs.getString("endereco"),
                            rs.getString("telefone")
                    );
                    return new Produto(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getInt("gtin"),
                            rs.getString("preco_venda"),
                            rs.getString("preco_compra"),
                            rs.getString("qtd_estoque"),
                            rs.getString("estoque_min"),
                            categoria,
                            fornecedor
                    );
                }
            }
        }
        return null;
    }

    public List<Produto> listarTodos() throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT p.*, c.nome AS nome_categoria, f.nome AS nome_fornecedor, f.cnpj, f.endereco, f.telefone " +
                "FROM produto p " +
                "JOIN categoria c ON p.categoria_id = c.id_categoria " +
                "JOIN fornecedor f ON p.fornecedor_cnpj = f.cnpj";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Categoria categoria = new Categoria(
                        rs.getInt("categoria_id"),
                        rs.getString("nome_categoria")
                );
                Fornecedor fornecedor = new Fornecedor(
                        rs.getInt("cnpj"),
                        rs.getString("nome_fornecedor"),
                        rs.getString("endereco"),
                        rs.getString("telefone")
                );
                Produto produto = new Produto(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("gtin"),
                        rs.getString("preco_venda"),
                        rs.getString("preco_compra"),
                        rs.getString("qtd_estoque"),
                        rs.getString("estoque_min"),
                        categoria,
                        fornecedor
                );
                produtos.add(produto);
            }
        }
        return produtos;
    }

    // métodos atualizar, deletar podem ser adicionados da mesma forma
}
