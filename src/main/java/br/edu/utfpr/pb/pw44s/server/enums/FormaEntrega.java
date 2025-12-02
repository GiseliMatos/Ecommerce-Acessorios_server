package br.edu.utfpr.pb.pw44s.server.enums;

import lombok.Getter;

@Getter
public enum FormaEntrega {
    ENTREGA_NORMAL("Entrega Normal"),
    ENTREGA_EXPRESSA("Entrega Expressa"),
    RETIRADA_LOJA("Retirada na Loja");

    private final String descricao;

    FormaEntrega(String descricao) {
        this.descricao = descricao;
    }
}
