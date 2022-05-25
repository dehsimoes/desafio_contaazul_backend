package br.com.contaazul.robotnasa.util;

import br.com.contaazul.robotnasa.RoboNasaApplication;
import br.com.contaazul.robotnasa.controller.RoboController;
import br.com.contaazul.robotnasa.enums.Direcao;
import br.com.contaazul.robotnasa.model.Robo;
import br.com.contaazul.robotnasa.service.RoboService;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.*;

class ValidaMovimentoTest {

    RoboController roboController = new RoboController();

    ValidaMovimento validaMovimento = new ValidaMovimento();

    @Test
    void comandoValidoGirarDireita() {
        Robo robo = validaMovimento.check("R");
        String result = robo.getDirecao().toString();
        assertEquals("E", result);
    }


    @Test
    void comandoValidoGirarEsquerda() {
        Robo robo = validaMovimento.check("L");
        String result = robo.getDirecao().toString();
        assertEquals("W", result);
    }

    @Test
    void comandoValidoAndar() {
       Robo robo = validaMovimento.check("M");
       String result = robo.toString();
       assertEquals("(0, 1, N)", result);
    }

    @Test
    void comandoInvalido() {
        var comandoNaoValido = validaMovimento.comandoValido("J");
        assertFalse(comandoNaoValido);
    }

    @Test
    void movimentoDentroDoLimite() {
        validaMovimento.movimentoValido(3,2);
    }

    @Test
    void movimentoForaDoLimite() {
        assertThrows(IllegalArgumentException.class, ()->{validaMovimento.movimentoValido(8,2);});
    }

}