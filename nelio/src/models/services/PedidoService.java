package models.services;

import models.entities.Pedido;
import models.exception.DomainException;

public class PedidoService {
    private FreteService freteService;

    public PedidoService(FreteService freteService) {
        this.freteService = freteService;
    }

    public void fecharPedido(Pedido pedido){
        if (pedido.getProdutos().isEmpty()) {
            throw new DomainException("Pedido sem produtos");
        }
        double frete = freteService.calcularFrete(pedido.getPesoTotal());
        int prazo = freteService.prazo();
        System.out.printf("Pedido concluido\nFrete: R$%.2f | Prazo: %d dias%n", frete, prazo);
    }
}
