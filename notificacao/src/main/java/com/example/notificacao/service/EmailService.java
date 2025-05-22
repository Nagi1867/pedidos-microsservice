package com.example.notificacao.service;

import com.example.notificacao.entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public void enviarEmail(Pedido pedido) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom("gabriel.pantanogabriel@gmail.com");
        simpleMailMessage.setTo(pedido.getEmail());
        simpleMailMessage.setSubject("Pedido de compra");
        simpleMailMessage.setText(this.gerarMenssagem(pedido));
        mailSender.send(simpleMailMessage);
    }

    private String gerarMenssagem(Pedido pedido) {
        String pedidoId = pedido.getId().toString();
        String cliente = pedido.getCliente();
        String valor = String.valueOf(pedido.getValor());
        String status = pedido.getStatus().name();

        return String.format("Olá %s seu pedido de n* %s no valor de %s, foi realizado com sucesso.\nStatus %s", cliente, pedidoId, valor, status);
    }
}
