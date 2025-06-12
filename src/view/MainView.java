package view;

import javax.swing.*;
import java.awt.event.*;

public class MainView extends JFrame {

    public MainView() {
        setTitle("Sistema de Controle de Estoque");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JButton btnProdutos = new JButton("Gerenciar Produtos");
        btnProdutos.setBounds(100, 30, 200, 30);
        add(btnProdutos);

        JButton btnAjuste = new JButton("Ajuste de Estoque");
        btnAjuste.setBounds(100, 80, 200, 30);
        add(btnAjuste);

        btnProdutos.addActionListener(e -> new ProdutoView());
        btnAjuste.addActionListener(e -> new AjusteEstoqueView());

        setVisible(true);
    }

    public static void main(String[] args) {
        new MainView();
    }
}
