package domain;

public class CompraProduto {
    private Integer idCompraProduto;
    private Compra compra;
    private Produto produto;
    private Integer quantidade;
    private Integer PrecoUnitario;

    public Integer getIdCompraProduto() {
        return idCompraProduto;
    }

    public void setIdCompraProduto(Integer idCompraProduto) {
        this.idCompraProduto = idCompraProduto;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getPrecoUnitario() {
        return PrecoUnitario;
    }

    public void setPrecoUnitario(Integer precoUnitario) {
        PrecoUnitario = precoUnitario;
    }

    public CompraProduto(Integer idCompraProduto, Compra compra, Produto produto, Integer quantidade, Integer precoUnitario) {
        this.idCompraProduto = idCompraProduto;
        this.compra = compra;
        this.produto = produto;
        this.quantidade = quantidade;
        PrecoUnitario = precoUnitario;


    }

    public void mostrar() {}

}
