package com.mensageria.eventos.aws.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductProducer {

    private static final String ROUTING_KEY_EXCHANGE = "events.business.loja";
    private static final String ROUTING_KEY_RESULTADO = "resultado.v1";

    @Autowired
    private RabbitTemplate template;

    public void send(String message) throws Exception {
        try {
            template.convertAndSend(ROUTING_KEY_EXCHANGE, ROUTING_KEY_RESULTADO, message);
        } catch(Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw new Exception(e);
        }
    }

}
