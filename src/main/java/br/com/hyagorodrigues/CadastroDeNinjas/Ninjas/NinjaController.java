package br.com.hyagorodrigues.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ninja")
public class NinjaController {

    @GetMapping("/boas-vindas")
    public String boasVindas() {
        return "Esta é a minha primeira mensagem nessa rota";
    }

    // Adicionar Ninja (CREATE)
    @PostMapping("/cadastrar")
    public String cadastrar() {
        return "Ninja Criado";
    }

    // Listar todos os Ninjas (READ)
    @GetMapping("/listar")
    public String listar() {
        return "Ninja Listado";
    }

    // Listar Ninja por ID (READ)
    @GetMapping("/listar/ID")
    public String listarPorId() {
        return "Ninja Listado por ID";
    }

    // Editar Ninja (UPDATE)
    @PutMapping("/atualizar")
    public String atualizar() {
        return "Ninja atualizado";
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("/excluir/ID")
    public String excluirPorId() {
        return "Ninja excluido por ID";
    }
}
