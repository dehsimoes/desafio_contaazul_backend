package br.com.contaazul.robotnasa.util;

import br.com.contaazul.robotnasa.enums.Direcao;
import br.com.contaazul.robotnasa.model.Robo;
import org.springframework.beans.factory.annotation.Value;

public class ValidaMovimento {

    @Value("${movimento.limite.largura")
    private static int largura = 5;

    @Value("${movimento.limite.altura")
    private static int altura = 5;

    Robo robo = new Robo(0, 0, Direcao.N);


    public Robo check(String comando) {

        String[] m = comando.split("");
        if (!checkMovimento(comando)) {
            return null;
        }
        return robo;
    }

    public boolean checkMovimento(String comando) {
        String[] m = comando.split("");
        for (int i = 0; i != m.length; i++) {
            if (!comandoValido(m[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean comandoValido(String comando) {
        try {
            switch (comando) {
                case "M":
                    this.andar();
                    break;
                case "R":
                    this.girarDireita();
                    break;
                case "L":
                    this.girarEsquerda();
                    break;
                default:
                    throw new IllegalArgumentException("Comando inválido!");
            }
        }
        catch(Exception e){
            return false;
            }
        return true;
    }

        public void andar() {

            switch (robo.getDirecao()) {
                case N:
                    this.movimentoValido(robo.getX(), robo.getY()+1);
                    robo.setY( robo.getY()+1 );
                    break;
                case E:
                    this.movimentoValido(robo.getX() + 1, robo.getY());
                    robo.setX( robo.getX()+1 );
                    break;
                case S:
                    this.movimentoValido(robo.getX(), robo.getY()-1);
                    robo.setY( robo.getY() - 1 );
                    break;
                case W:
                    this.movimentoValido(robo.getX()-1, robo.getY());
                    robo.setX( robo.getX()-1 );
                    break;
                default:
                    throw new IllegalArgumentException("Comando inválido!");
            }
        }

        public void girarDireita() {
            switch (robo.getDirecao()) {
                case N:
                    robo.setDirecao(Direcao.E);
                    break;
                case E:
                    robo.setDirecao(Direcao.S);
                    break;
                case S:
                    robo.setDirecao(Direcao.W);
                    break;
                case W:
                    robo.setDirecao(Direcao.N);
                    break;
                default:
                    throw new IllegalArgumentException("Comando inválido!");
            }
        }

        public void girarEsquerda() {

            switch (robo.getDirecao()) {
                case N:
                    robo.setDirecao(Direcao.W);
                    break;
                case W:
                    robo.setDirecao(Direcao.S);
                    break;
                case S:
                    robo.setDirecao(Direcao.E);
                    break;
                case E:
                    robo.setDirecao(Direcao.N);
                    break;
                default:
                    throw new IllegalArgumentException("Comando inválido!");
            }

        }

        public void movimentoValido( int x, int y) {
            if (!((x >= 0) && (x <= largura) && (y >= 0) && (y <= altura)))
            throw new IllegalArgumentException("Movimento fora do limite");
        }
}
