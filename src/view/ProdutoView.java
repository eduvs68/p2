package view;

import DAO.CategoriaDAO;
import DAO.FornecedorDAO;
import DAO.ProdutoDAO;
import domain.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class ProdutoView extends JFrame {

    private JTextField txtNome, txtGTIN, txtPrecoVenda, txtPrecoCompra, txtQtdEstoque, txtEstoqueMin;
    private JComboBox<Categoria> cbCategoria;
    private JComboBox<Fornecedor> cbFornecedor;

    public ProdutoView() {
        setTitle("Cadastro de Produto");
        setSize(400, 400);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNome = new JLabel("Nome:");
        JLabel lblGTIN = new JLabel("GTIN:");
        JLabel lblPrecoVenda = new JLabel("Preço Venda:");
        JLabel lblPrecoCompra = new JLabel("Preço Compra:");
        JLabel lblQtdEstoque = new JLabel("Quantidade:");
        JLabel lblEstoqueMin = new JLabel("Estoque Mínimo:");
        JLabel lblCategoria = new JLabel("Categoria:");
        JLabel lblFornecedor = new JLabel("Fornecedor:");

        txtNome = new JTextField();
        txtGTIN = new JTextField();
        txtPrecoVenda = new JTextField();
        txtPrecoCompra = new JTextField();
        txtQtdEstoque = new JTextField();
        txtEstoqueMin = new JTextField();
        cbCategoria = new JComboBox<>();
        cbFornecedor = new JComboBox<>();

        JButton btnSalvar = new JButton("Salvar");

        lblNome.setBounds(20, 20, 100, 25); txtNome.setBounds(150, 20, 200, 25);
        lblGTIN.setBounds(20, 50, 100, 25); txtGTIN.setBounds(150, 50, 200, 25);
        lblPrecoVenda.setBounds(20, 80, 100, 25); txtPrecoVenda.setBounds(150, 80, 200, 25);
        lblPrecoCompra.setBounds(20, 110, 100, 25); txtPrecoCompra.setBounds(150, 110, 200, 25);
        lblQtdEstoque.setBounds(20, 140, 100, 25); txtQtdEstoque.setBounds(150, 140, 200, 25);
        lblEstoqueMin.setBounds(20, 170, 120, 25); txtEstoqueMin.setBounds(150, 170, 200, 25);
        lblCategoria.setBounds(20, 200, 100, 25); cbCategoria.setBounds(150, 200, 200, 25);
        lblFornecedor.setBounds(20, 230, 100, 25); cbFornecedor.setBounds(150, 230, 200, 25);
        btnSalvar.setBounds(130, 280, 100, 30);

        add(lblNome); add(txtNome);
        add(lblGTIN); add(txtGTIN);
        add(lblPrecoVenda); add(txtPrecoVenda);
        add(lblPrecoCompra); add(txtPrecoCompra);
        add(lblQtdEstoque); add(txtQtdEstoque);
        add(lblEstoqueMin); add(txtEstoqueMin);
        add(lblCategoria); add(cbCategoria);
        add(lblFornecedor); add(cbFornecedor);
        add(btnSalvar);

        preencherCombos();

        btnSalvar.addActionListener(e -> salvarProduto());

        setVisible(true);
    }

    private void preencherCombos() {
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        FornecedorDAO fornecedorDAO = new FornecedorDAO();

        List<Categoria> categorias = categoriaDAO.listar();
        for (Categoria c : categorias) cbCategoria.addItem(c);

        List<Fornecedor> fornecedores = fornecedorDAO.listar();
        for (Fornecedor f : fornecedores) cbFornecedor.addItem(f);
    }

    private void salvarProduto() {
        ProdutoDAO dao = new ProdutoDAO();

        Produto p = new Produto(
                null,
                txtNome.getText(),
                txtGTIN.getText(),
                Double.parseDouble(txtPrecoVenda.getText()),
                Double.parseDouble(txtPrecoCompra.getText()),
                Integer.parseInt(txtQtdEstoque.getText()),
                Integer.parseInt(txtEstoqueMin.getText()),
                (Categoria) cbCategoria.getSelectedItem(),
                (Fornecedor) cbFornecedor.getSelectedItem()
        );

        dao.inserir(p);
        JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso!");
        dispose();
    }
}
