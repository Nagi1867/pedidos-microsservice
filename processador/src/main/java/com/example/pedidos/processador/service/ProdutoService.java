package com.example.pedidos.processador.service;

import com.example.pedidos.processador.entity.ItemPedido;
import com.example.pedidos.processador.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public void save(List<ItemPedido> itemPedidos) {
        itemPedidos.forEach(itemPedido -> {
            produtoRepository.save(itemPedido.getProduto());
        });
    }
}
