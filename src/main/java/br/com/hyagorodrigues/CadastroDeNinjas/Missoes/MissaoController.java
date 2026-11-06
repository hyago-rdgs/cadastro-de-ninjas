package br.com.hyagorodrigues.CadastroDeNinjas.Missoes;

import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> cadastrar(@RequestBody MissaoDTO missao) {
        MissaoDTO novoRegistro = missaoService.cadastrar(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missao #" + novoRegistro.getId() + " criada com sucesso!");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MissaoDTO>> listar() {
        List<MissaoDTO> missoes = missaoService.listar();
        return ResponseEntity.ok()
                .body(missoes);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id) {
        MissaoDTO missao = missaoService.listarPorId(id);
        if(missao != null) {
            return ResponseEntity.ok(missao);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao #" + id + " nao foi encontrada");
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Long id, @RequestBody MissaoDTO missao) {
        if(missaoService.listarPorId(id) != null) {
            missaoService.atualizarPorId(id, missao);
            return ResponseEntity.ok()
                    .body("Ninja #" + id + " atualizada com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao #" + id + " nao foi encontrada");
        }
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluirPorId(@PathVariable Long id) {
        if(missaoService.listarPorId(id) != null) {
            missaoService.excluirPorId(id);
            return ResponseEntity.ok()
                    .body("Missao #" + id + " deletada com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao #" + id + " nao foi encontrada");
        }
    }
}
