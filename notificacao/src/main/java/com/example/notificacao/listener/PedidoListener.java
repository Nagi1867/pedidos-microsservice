package com.example.notificacao.listener;

import com.example.notificacao.entity.Pedido;
import com.example.notificacao.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoListener {
    private Logger logger = LoggerFactory.getLogger(PedidoListener.class);
    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = "pedidos.v1.pedido-criado.gerar-notificacao")
    public void enviarNotificacao(Pedido pedido) {
        logger.info("Tentando consumir a mensagem");
        if (pedido.getValor() > 3000) {
            throw new RuntimeException("Valor muito alto");
        }
        emailService.enviarEmail(pedido);
        logger.info("Notificação gerada: {}", pedido.toString());
    }
}
