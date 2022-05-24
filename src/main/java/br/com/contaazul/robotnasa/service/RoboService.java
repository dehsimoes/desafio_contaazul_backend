package br.com.contaazul.robotnasa.service;


import br.com.contaazul.robotnasa.enums.Movimento;
import br.com.contaazul.robotnasa.model.Robo;
import br.com.contaazul.robotnasa.util.ValidaMovimento;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RoboService {


    public ResponseEntity<String> instrucao(String movimentos)
    {
        ValidaMovimento validaMovimento = new ValidaMovimento();
        Robo robo = validaMovimento.check(movimentos);
        if(robo == null){
            return ResponseEntity.badRequest().body("Movimento invalido");
        }
        return ResponseEntity.ok(robo.toString());
    }
}
