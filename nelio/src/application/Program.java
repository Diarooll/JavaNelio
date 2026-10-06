package application;

import models.entities.Pedido;
import models.exception.DomainException;
import models.entities.Produto;
import models.services.CorreiosService;
import models.services.FreteService;
import models.services.PedidoService;
import models.services.TransportadoraService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Produto> produtos = new ArrayList<>();
        int qtdPedido = 0;
        boolean pedidoConcluido = false;



        try {
            while(!pedidoConcluido) {
                System.out.print("1-Ver carrinho\n2-adicionar produto\n3-finalizar pedido\n4-cancelar pedido");
                int opcao = sc.nextInt();
                sc.nextLine();
                switch (opcao) {
                    case 1:
                        System.out.println("\nProdutos na cesta: ");
                        if (produtos.size() == 0) {
                            System.out.println("0 produtos");
                        } else {
                            for (Produto produto : produtos) {
                                System.out.println(produto);
                            }
                            System.out.println();
                        }
                        break;
                    case 2:
                        System.out.print("\nNome do produto: ");
                        String nomeProduto = sc.nextLine();
                        System.out.print("Qual é o preço: R$");
                        double preco = sc.nextDouble();
                        System.out.print("Qual é o peso do produto em kg? ");
                        double peso = sc.nextDouble();
                        sc.nextLine();
                        System.out.println();
                        produtos.add(new Produto(nomeProduto, preco, peso));

                        break;
                    case 3:
                        if (produtos.size() > 0) {
                            System.out.println("\nPedido concluido.");
                            pedidoConcluido = true;
                            qtdPedido++;
                        } else {
                            System.out.println("\nSem itens no carrinho.");
                        }
                        break;

                    case 4:
                        System.out.println("\nPedido cancelado");
                        System.exit(0);
                }
            }

            LocalDate data = LocalDate.now();
            Pedido pedido = new Pedido(qtdPedido, data, produtos);

            System.out.println("\nEscolha o tipo de frete:\n1-Correios\n2-Transportadora");
            int escolhafrete = sc.nextInt();
            FreteService freteService;
            if(escolhafrete == 1){
                freteService = new CorreiosService();
            } else if (escolhafrete == 2){
                freteService = new TransportadoraService();
            } else {
                throw new DomainException("Numero invalido, operação cancelada");
            }
            PedidoService ps = new PedidoService(freteService);
            ps.fecharPedido(pedido);
            System.out.println(pedido);

        } catch(InputMismatchException e){
            System.out.println("Deveria ser um numero.");
        } catch (DomainException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
