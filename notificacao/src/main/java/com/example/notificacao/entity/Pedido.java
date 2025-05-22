package com.example.notificacao.entity;

import com.example.notificacao.entity.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Pedido {
    private UUID id = UUID.randomUUID();
    private String cliente;
    private List<ItemPedido> itemPedidos = new ArrayList<>();
    private Double valor;
    private String email;
    private Status status = Status.EM_PROCESSAMENTO;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataHora = LocalDateTime.now();

    public Pedido() {
    }

    public Pedido(UUID id, String cliente, List<ItemPedido> itemPedidos, Double valor, String email, Status status, LocalDateTime dataHora) {
        this.id = id;
        this.cliente = cliente;
        this.itemPedidos = itemPedidos;
        this.valor = valor;
        this.email = email;
        this.status = status;
        this.dataHora = dataHora;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItemPedidos() {
        return itemPedidos;
    }

    public void setItemPedidos(List<ItemPedido> itemPedidos) {
        this.itemPedidos = itemPedidos;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id) && Objects.equals(cliente, pedido.cliente) && Objects.equals(itemPedidos, pedido.itemPedidos) && Objects.equals(valor, pedido.valor) && Objects.equals(email, pedido.email) && status == pedido.status && Objects.equals(dataHora, pedido.dataHora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cliente, itemPedidos, valor, email, status, dataHora);
    }
}
