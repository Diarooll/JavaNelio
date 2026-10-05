package models.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int numero;
    private LocalDate data;
    private List<Produto> produtos = new ArrayList<>();
    private double pesoTotal;
    private double valorTotal;


    public Pedido(){}
    public Pedido(int numero, LocalDate data, List<Produto> produtos) {
        this.numero = numero;
        this.data = data;
        this.produtos = produtos;
        for(Produto produto : produtos){
            this.pesoTotal += produto.getPeso();
            this.valorTotal += produto.getPreco();
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public double getPesoTotal() {
        return pesoTotal;
    }

    public double getValorTotal() {
        return valorTotal;
    }

}
