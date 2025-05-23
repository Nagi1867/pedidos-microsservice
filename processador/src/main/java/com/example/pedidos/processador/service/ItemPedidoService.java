package com.example.pedidos.processador.service;

import com.example.pedidos.processador.entity.ItemPedido;
import com.example.pedidos.processador.entity.Pedido;
import com.example.pedidos.processador.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPedidoService {
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;


    public List<ItemPedido> save(List<ItemPedido> itemPedidos) {
        return itemPedidoRepository.saveAll(itemPedidos);
    }

    public void save(ItemPedido item) {
        itemPedidoRepository.save(item);
    }

    public void updatedItemPedido(List<ItemPedido> itemPedidos, Pedido pedido) {
        itemPedidos.forEach(itemPedido -> {
            itemPedido.setPedido(pedido);
            this.save(itemPedidos);
        });
    }
}
