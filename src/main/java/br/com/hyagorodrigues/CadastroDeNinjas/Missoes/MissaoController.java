package br.com.hyagorodrigues.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missao")
public class MissaoController {

    // Adicionar Missao (CREATE)
    @PostMapping("/cadastrar")
    public String cadastrar() {
        return "Missao Criado";
    }

    // Listar todos os Missoes (READ)
    @GetMapping("/listar")
    public String listar() {
        return "Missoes Listado";
    }

    // Listar Missao por ID (READ)
    @GetMapping("/listar/ID")
    public String listarPorId() {
        return "Missao Listado por ID";
    }

    // Editar Missao (UPDATE)
    @PutMapping("/atualizar")
    public String atualizar() {
        return "Missao atualizado";
    }

    // Deletar Missao (DELETE)
    @DeleteMapping("/excluir/ID")
    public String excluirPorId() {
        return "Missao excluido por ID";
    }
}
