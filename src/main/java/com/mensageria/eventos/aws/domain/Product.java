package com.mensageria.eventos.aws.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
public class Product {

    private String descricao;
    private BigDecimal valor;

}
