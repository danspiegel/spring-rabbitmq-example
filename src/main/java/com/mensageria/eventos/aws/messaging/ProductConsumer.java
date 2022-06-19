package com.mensageria.eventos.aws.messaging;

import com.google.gson.Gson;
import com.mensageria.eventos.aws.domain.Product;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.NumberFormat;

@Component
public class ProductConsumer {

    @Autowired
    private ProductProducer producer;

    @RabbitListener(queues = "events.business.produtos")
    public void consumer(String message) throws InterruptedException {
        try {
            //Thread.sleep(10000);
            Product product = new Gson().fromJson(message, Product.class);
            producer.send("Produto lido com sucesso. Produto: " + product.getDescricao() + ", Valor: " + NumberFormat.getCurrencyInstance().format(product.getValor()));
        } catch(Exception e) {
            System.out.println("Erro consumidor: " + e.getMessage());
        }
    }

}
