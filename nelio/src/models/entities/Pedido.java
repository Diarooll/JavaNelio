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
    private double frete;
    private int prazo;
    private String transportadora;


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

    public void registrarFrete(double frete, int prazo, String transportadora) {
        this.frete = frete;
        this.prazo = prazo;
        this.transportadora = transportadora;
    }

    public double getTotalComFrete() {
        return valorTotal + frete;
    }

    public int getPrazo() { return prazo; }

    @Override
    public String toString() {
        return String.format("Pedido %d\nTransportadora: %s\nFrete: R$%.2f\nPrazo: %d dias\nTotal: R$%.2f",
                numero, transportadora, frete, prazo, getTotalComFrete());
    }

}
