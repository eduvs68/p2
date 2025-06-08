package domain;

public class VendaProduto {
    private Integer idVendaProduto;
    private Integer quantidade;
    private Double PrecoUnitario;
    private Produto produto;
    private Venda venda;

    public VendaProduto(Integer idVendaProduto, Integer quantidade, Double precoUnitario, Produto produto, Venda venda) {
        this.idVendaProduto = idVendaProduto;
        this.quantidade = quantidade;
        PrecoUnitario = precoUnitario;
        this.produto = produto;
        this.venda = venda;
    }

    public Integer getIdVendaProduto() {
        return idVendaProduto;
    }

    public void setIdVendaProduto(Integer idVendaProduto) {
        this.idVendaProduto = idVendaProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPrecoUnitario() {
        return PrecoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        PrecoUnitario = precoUnitario;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public void mostrar() {}

}
