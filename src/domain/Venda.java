package domain;

public class Venda {
    private Integer idVenda;
    private String data;
    private Double valorTotal;

    public Venda(Integer idVenda, String data, Double valorTotal) {
        this.idVenda = idVenda;
        this.data = data;
        this.valorTotal = valorTotal;
    }

    public Integer getIdVenda() {return idVenda;}
    public void setIdVenda(Integer idVenda) {this.idVenda = idVenda;}

    public String getData() {return data;}
    public void setData(String data) {this.data = data;}

    public Double getValorTotal() {return valorTotal;}
    public void setValorTotal(Double valorTotal) {this.valorTotal = valorTotal;}

    public void mostrar() {}

}
