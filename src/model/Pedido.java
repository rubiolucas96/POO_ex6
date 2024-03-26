package model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int numeroNota;
    private List<ItemPedido> itens;
    
    public Pedido() {
        this.itens = new ArrayList<>();
    }
    
    public int getNumeroNota() {
        return numeroNota;
    }
    
    public void setNumeroNota(int numeroNota) {
        this.numeroNota = numeroNota;
    }
    
    public void adicionaItem(ItemPedido item) {
        itens.add(item);
    }
    
    public double getValorTotal() {
        double total = 0.0;
        for (ItemPedido item : itens) {
            total += item.getProduto().getValor() * item.getQuantidade();
        }
        return total;
    }
    
    public String getDetalhesPedido() {
        StringBuilder detalhes = new StringBuilder();
        detalhes.append("Detalhes do pedido:\n");
        for (ItemPedido item : itens) {
            detalhes.append(item.getQuantidade())
                   .append("x ")
                   .append(item.getProduto().getDescricao())
                   .append(": R$")
                   .append(item.getProduto().getValor() * item.getQuantidade())
                   .append("\n");
        }
        detalhes.append("Valor total do pedido: R$").append(getValorTotal());
        return detalhes.toString();
    }
}



