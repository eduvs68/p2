package domain;

public class AjusteEstoque {
    private Integer idAjuste;
    private Produto produto;
    private String data;
    private TipoAjusteEstoque tipo;
    private Integer quantidade;
    private String descricao;

    public AjusteEstoque(Integer idAjuste, Produto produto, String data, TipoAjusteEstoque tipo, Integer quantidade, String descricao) {
        this.idAjuste = idAjuste;
        this.produto = produto;
        this.data = data;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.descricao = descricao;
    }

    public Integer getIdAjuste() {  return idAjuste;}
    public void setIdAjuste(Integer idAjuste) {
        this.idAjuste = idAjuste;
    }

    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    public TipoAjusteEstoque getTipo() {
        return tipo;
    }
    public void setTipo(TipoAjusteEstoque tipo) {
        this.tipo = tipo;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void mostrar() {}
}
