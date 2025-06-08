package domain;

public class FormaPagamento {
    private Integer idFormaPagamento;
    private String tipo;

    public FormaPagamento(Integer idFormaPagamento, String tipo) {
        this.idFormaPagamento = idFormaPagamento;
        this.tipo = tipo;
    }

    public Integer getIdFormaPagamento() {
        return idFormaPagamento;
    }

    public void setIdFormaPagamento(Integer idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void mostrar() {}

}
