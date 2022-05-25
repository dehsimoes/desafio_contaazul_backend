package br.com.contaazul.robotnasa.controller;

import br.com.contaazul.robotnasa.service.RoboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/mars")
public class RoboController {

    @Autowired
    RoboService roboService;

    @PostMapping("/{movimentos}")
    public ResponseEntity<String> executarMovimentos(@PathVariable("movimentos") String movimentos) {
        return roboService.instrucao(movimentos);
    }

}
