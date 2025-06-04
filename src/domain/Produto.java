package domain;

public class Produto {
    private Integer id;
    private String nome;
    private Integer gtin;
    private String precoVenda;
    private String precoCompra;
    private String qtdEstoque;
    private String estoqueMin;

    public Produto(Integer id, String nome, Integer gtin, String precoVenda, String precoCompra, String qtdEstoque, String estoqueMin) {
        this.id = id;
        this.nome = nome;
        this.gtin = gtin;
        this.precoVenda = precoVenda;
        this.precoCompra = precoCompra;
        this.qtdEstoque = qtdEstoque;
        this.estoqueMin = estoqueMin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getGtin() {
        return gtin;
    }

    public void setGtin(Integer gtin) {
        this.gtin = gtin;
    }

    public String getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(String precoVenda) {
        this.precoVenda = precoVenda;
    }

    public String getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(String precoCompra) {
        this.precoCompra = precoCompra;
    }

    public String getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(String qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public String getEstoqueMin() {
        return estoqueMin;
    }

    public void setEstoqueMin(String estoqueMin) {
        this.estoqueMin = estoqueMin;
    }

    public void mostrar() {}
}
