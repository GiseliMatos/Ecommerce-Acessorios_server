package br.edu.utfpr.pb.pw44s.server.enums;

import lombok.Getter;

@Getter
public enum FormaPagamento {
    CARTAO_CREDITO("Cartão de Crédito"),
    CARTAO_DEBITO("Cartão de Débito"),
    PIX("PIX"),
    BOLETO("Boleto Bancário"),
    DINHEIRO("Dinheiro");

    private final String descricao;

    FormaPagamento(String descricao) {
        this.descricao = descricao;
    }
}
