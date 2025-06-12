package domain;

public class Compra {
    private Integer idCompra;
    private String data;
    private Double valorTotal;
    private Fornecedor fornecedor;

    public Compra(Integer idCompra, String data, Double valorTotal, Fornecedor fornecedor) {
        this.idCompra = idCompra;
        this.data = data;
        this.valorTotal = valorTotal;
        this.fornecedor = fornecedor;
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

    public Fornecedor getFornecedor() {return fornecedor;}
    public void setFornecedor(Fornecedor fornecedor){this.fornecedor = fornecedor;}

    public void mostrar() {}

}
