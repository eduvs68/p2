package domain;

public class Compra {
    private Integer idCompra;
    private String data;
    private Double valorTotal;

    public Compra(Integer idCompra, String data, Double valorTotal) {
        this.idCompra = idCompra;
        this.data = data;
        this.valorTotal = valorTotal;
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void mostrar() {}

}
