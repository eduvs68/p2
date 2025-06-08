package domain;

public class FluxoCaixa {
    private Integer idFluxo;
    private FormaPagamento formaPagamento;
    private String data;
    private String tipo;
    private Double valor;
    private String descricao;

    public Integer getIdFluxo() {
        return idFluxo;
    }

    public void setIdFluxo(Integer idFluxo) {
        this.idFluxo = idFluxo;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public FluxoCaixa(Integer idFluxo, FormaPagamento formaPagamento, String data, String tipo, Double valor, String descricao) {
        this.idFluxo = idFluxo;
        this.formaPagamento = formaPagamento;
        this.data = data;
        this.tipo = tipo;
        this.valor = valor;
        this.descricao = descricao;


    }

    public void mostrar() {}

}
