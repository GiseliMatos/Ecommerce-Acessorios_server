package br.edu.utfpr.pb.pw44s.server.enums;

import lombok.Getter;

@Getter
public enum FormaEntrega {
    ENTREGA_NORMAL("Entrega Normal - 5 a 7 dias"),
    ENTREGA_EXPRESSA("Entrega Expressa - 2 a 3 dias"),
    RETIRADA_LOJA("Retirada na Loja");

    private final String descricao;

    FormaEntrega(String descricao) {
        this.descricao = descricao;
    }
}
