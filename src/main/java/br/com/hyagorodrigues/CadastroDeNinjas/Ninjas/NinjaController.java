package br.com.hyagorodrigues.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrar(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoRegistro = ninjaService.cadastrar(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja #" + novoRegistro.getId() + " criado com sucesso!");
    }

    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listar() {
        List<NinjaDTO> ninjas = ninjaService.listar();
        return ResponseEntity.ok()
                .body(ninjas);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarPorId(@PathVariable Long id) {
        NinjaDTO ninja = ninjaService.listarPorId(id);
        if(ninja != null) {
            return ResponseEntity.ok()
                    .body(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja #" + id + " nao foi encontrado");
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarPorId(@PathVariable Long id, @RequestBody NinjaDTO ninja) {
        if(ninjaService.listarPorId(id) != null) {
            ninjaService.atualizarPorId(id, ninja);
            return ResponseEntity.ok()
                    .body("Ninja #" + id + " atualizado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja #" + id + " nao foi encontrado!");
        }
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluirPorId(@PathVariable Long id) {
        if(ninjaService.listarPorId(id) != null) {
            ninjaService.excluirPorId(id);
            return ResponseEntity.ok()
                    .body("Ninja #" + id + " deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja #" + id + " nao foi encontrado!");
        }
    }
}
