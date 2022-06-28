package Modelo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Venda")

public class Venda {
    //Venda: Id, data, valorTotal, listaProdutos , comprador;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    Date data;
    @Column
    private float valorTotal;
    @Column
    private String listaProdutos;
    @Column
    private String comprador;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(String listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    public String getComprador() {
        return comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }
}
