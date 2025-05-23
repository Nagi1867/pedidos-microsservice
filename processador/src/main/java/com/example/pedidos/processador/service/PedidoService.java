package com.example.pedidos.processador.service;

import com.example.pedidos.processador.entity.ItemPedido;
import com.example.pedidos.processador.entity.Pedido;
import com.example.pedidos.processador.repository.PedidoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    @Autowired
    private Logger logger = LoggerFactory.getLogger(PedidoService.class);
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private ItemPedidoService itemPedidoService;

    public void save(Pedido pedido) {
        produtoService.save(pedido.getItemPedidos());
        List<ItemPedido> itemPedidos = itemPedidoService.save(pedido.getItemPedidos());
        pedidoRepository.save(pedido);

        itemPedidoService.updatedItemPedido(itemPedidos, pedido);

        logger.info("pedido salvo: {}", pedido.toString());
    }
}
