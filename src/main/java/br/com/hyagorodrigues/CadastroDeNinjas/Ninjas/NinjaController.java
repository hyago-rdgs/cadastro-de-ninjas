package br.com.hyagorodrigues.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boas-vindas")
    public String boasVindas() {
        return "Esta é a minha primeira mensagem nessa rota";
    }

    // Adicionar Ninja (CREATE)
    @PostMapping("/ninja/cadastrar")
    public String cadastrar() {
        return "Ninja Criado";
    }

    // Listar todos os Ninjas (READ)
    @GetMapping("/ninja/listar")
    public String listar() {
        return "Ninja Listado";
    }

    // Listar Ninja por ID (READ)
    @GetMapping("/ninja/listar/ID")
    public String listarPorId() {
        return "Ninja Listado por ID";
    }

    // Editar Ninja (UPDATE)
    @PutMapping("/ninja/atualizar")
    public String atualizar() {
        return "Ninja atualizado";
    }

    // Deletar Ninja (DELETE)
    @DeleteMapping("ninja/excluir/ID")
    public String excluirPorId() {
        return "Ninja excluido por ID";
    }
}
