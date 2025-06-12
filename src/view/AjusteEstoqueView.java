package view;

import DAO.AjusteEstoqueDAO;
import DAO.ProdutoDAO;
import domain.*;

import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.util.List;

public class AjusteEstoqueView extends JFrame {

    private JComboBox<Produto> cbProduto;
    private JComboBox<String> cbTipo;
    private JTextField txtQuantidade, txtDescricao;

    public AjusteEstoqueView() {
        setTitle("Ajuste de Estoque");
        setSize(400, 300);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblProduto = new JLabel("Produto:");
        JLabel lblTipo = new JLabel("Tipo:");
        JLabel lblQtd = new JLabel("Quantidade:");
        JLabel lblDescricao = new JLabel("Descrição:");

        cbProduto = new JComboBox<>();
        cbTipo = new JComboBox<>(new String[] { "entrada", "saída" });
        txtQuantidade = new JTextField();
        txtDescricao = new JTextField();
        JButton btnSalvar = new JButton("Salvar");

        lblProduto.setBounds(20, 20, 100, 25); cbProduto.setBounds(150, 20, 200, 25);
        lblTipo.setBounds(20, 50, 100, 25); cbTipo.setBounds(150, 50, 200, 25);
        lblQtd.setBounds(20, 80, 100, 25); txtQuantidade.setBounds(150, 80, 200, 25);
        lblDescricao.setBounds(20, 110, 100, 25); txtDescricao.setBounds(150, 110, 200, 25);
        btnSalvar.setBounds(130, 160, 100, 30);

        add(lblProduto); add(cbProduto);
        add(lblTipo); add(cbTipo);
        add(lblQtd); add(txtQuantidade);
        add(lblDescricao); add(txtDescricao);
        add(btnSalvar);

        preencherProdutos();

        btnSalvar.addActionListener(e -> realizarAjuste());

        setVisible(true);
    }

    private void preencherProdutos() {
        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> produtos = dao.listar();
        for (Produto p : produtos) cbProduto.addItem(p);
    }

    private void realizarAjuste() {
        Produto produto = (Produto) cbProduto.getSelectedItem();
        String tipoStr = (String) cbTipo.getSelectedItem();
        int qtd = Integer.parseInt(txtQuantidade.getText());
        String descricao = txtDescricao.getText();

        TipoAjusteEstoque tipo = TipoAjusteEstoque.fromDescricao(tipoStr);

        AjusteEstoque ajuste = new AjusteEstoque(
                null,
                produto,
                LocalDateTime.now().toString(),
                tipo,
                qtd,
                descricao
        );

        AjusteEstoqueDAO dao = new AjusteEstoqueDAO();
        dao.inserir(ajuste);

        // Atualizar estoque real
        if (tipo == TipoAjusteEstoque.ENTRADA)
            produto.setQtdEstoque(produto.getQtdEstoque() + qtd);
        else
            produto.setQtdEstoque(produto.getQtdEstoque() - qtd);

        new ProdutoDAO().inserir(produto); // pode trocar por update

        JOptionPane.showMessageDialog(this, "Ajuste realizado com sucesso!");
        dispose();
    }
}
