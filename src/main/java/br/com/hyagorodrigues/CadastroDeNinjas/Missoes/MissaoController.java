package br.com.hyagorodrigues.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/listar")
    public List<MissaoModel> listar() {
        return missaoService.listar();
    }

    @GetMapping("/listar/{id}")
    public MissaoModel listarPorId(@PathVariable Long id) {
        return missaoService.listarPorId(id);
    }

    @PutMapping("/atualizar/{id}")
    public MissaoModel atualizar(@PathVariable Long id, @RequestBody MissaoModel missao) {
        return missaoService.atualizarPorId(id, missao);
    }

    @DeleteMapping("/excluir/{id}")
    public void excluirPorId(@PathVariable Long id) {
        missaoService.excluirPorId(id);
    }
}
