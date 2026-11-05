package br.com.hyagorodrigues.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missao")
public class MissaoController {

    private MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    @PostMapping("/cadastrar")
    public MissaoModel cadastrar(@RequestBody MissaoModel missao) {
        return missaoService.cadastrar(missao);
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
