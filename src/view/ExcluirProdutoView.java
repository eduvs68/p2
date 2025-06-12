package view;

import DAO.ProdutoDAO;
import domain.Produto;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class ExcluirProdutoView extends JFrame {

    private JComboBox<Produto> cbProduto;
    private JButton btnExcluir;

    public ExcluirProdutoView() {
        setTitle("Excluir Produto");
        setSize(400, 200);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblProduto = new JLabel("Selecione o produto:");
        lblProduto.setBounds(30, 30, 150, 25);
        add(lblProduto);

        cbProduto = new JComboBox<>();
        cbProduto.setBounds(30, 60, 320, 25);
        add(cbProduto);

        btnExcluir = new JButton("Excluir Produto");
        btnExcluir.setBounds(120, 110, 150, 30);
        add(btnExcluir);

        preencherProdutos();

        btnExcluir.addActionListener(e -> excluirProduto());

        setVisible(true);
    }

    private void preencherProdutos() {
        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> produtos = dao.listar();
        cbProduto.removeAllItems();
        for (Produto p : produtos) {
            cbProduto.addItem(p);
        }
    }

    private void excluirProduto() {
        Produto produtoSelecionado = (Produto) cbProduto.getSelectedItem();
        if (produtoSelecionado == null) {
            JOptionPane.showMessageDialog(this, "Nenhum produto selecionado.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Tem certeza que deseja excluir o produto: " + produtoSelecionado.getNome() + "?",
                "Confirmar Exclusão",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            ProdutoDAO dao = new ProdutoDAO();
            boolean sucesso = dao.excluirComVerificacao(produtoSelecionado.getIdProduto());

            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Produto excluído com sucesso!");
                preencherProdutos(); // atualiza lista
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "Este produto está vinculado a outras tabelas (venda, compra ou ajuste) e não pode ser excluído.",
                        "Erro de Exclusão",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }
}
