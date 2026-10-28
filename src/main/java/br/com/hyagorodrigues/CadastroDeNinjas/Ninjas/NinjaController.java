package br.com.hyagorodrigues.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boas-vindas")
    public String boasVindas() {
        return "Esta é a minha primeira mensagem nessa rota";
    }
}
