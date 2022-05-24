package br.com.contaazul.robotnasa.model;


import br.com.contaazul.robotnasa.enums.Direcao;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

public class Robo {

    @Setter@Getter
    private int x = 0;
    @Setter@Getter
    private int y = 0;
    @Setter@Getter
    private Direcao direcao = Direcao.N;

    public Robo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Robo(int x, int y, Direcao direcao) {
        this.x = x;
        this.y = y;
        this.direcao = direcao;
    }

    @Override
    public String toString() {
        return "(" +
                 x +
                ", " + y +
                ", " + direcao +
                ')';
    }
}
