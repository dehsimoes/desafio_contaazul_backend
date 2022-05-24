package br.com.contaazul.robotnasa.enums;

import lombok.Getter;

public enum Direcao {

    N(0),
    E(1),
    S(2),
    W(3);
    @Getter
    private final int sentido;
    Direcao(int sentido) {
        this.sentido = sentido;
    }
}
