package domain;

public class Produto {
    private Integer idProduto;
    private String nome;
    private String gtin;
    private Double precoVenda;
    private Double precoCompra;
    private Integer qtdEstoque;
    private Integer estoqueMin;
    private Categoria categoria;
    private Fornecedor fornecedor;

    public Produto(Integer idProduto, String nome, String gtin, Double precoVenda, Double precoCompra, Integer qtdEstoque, Integer estoqueMin, Categoria categoria, Fornecedor fornecedor) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.gtin = gtin;
        this.precoVenda = precoVenda;
        this.precoCompra = precoCompra;
        this.qtdEstoque = qtdEstoque;
        this.estoqueMin = estoqueMin;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
    }

    public Integer getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGtin() {
        return gtin;
    }
    public void setGtin(String gtin) {
        this.gtin = gtin;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }
    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Double getPrecoCompra() {
        return precoCompra;
    }
    public void setPrecoCompra(Double precoCompra) {this.precoCompra = precoCompra;}

    public Integer getQtdEstoque() {
        return qtdEstoque;
    }
    public void setQtdEstoque(Integer qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public Integer getEstoqueMin() {
        return estoqueMin;
    }
    public void setEstoqueMin(Integer estoqueMin) {
        this.estoqueMin = estoqueMin;
    }

    public Categoria getCategoria() {return categoria;}
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }
    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public String toString() {
        return "Produto: " + nome + " (código de barras:" + gtin + ")";
    }

}
