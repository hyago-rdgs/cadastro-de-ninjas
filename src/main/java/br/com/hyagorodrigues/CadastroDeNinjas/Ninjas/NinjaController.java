package br.com.hyagorodrigues.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @PostMapping("/cadastrar")
    public NinjaDTO cadastrar(@RequestBody NinjaDTO ninja) {
        return ninjaService.cadastrar(ninja);
    }

    @GetMapping("/listar")
    public List<NinjaDTO> listar() {
        return ninjaService.listar();
    }

    @GetMapping("/listar/{id}")
    public NinjaDTO listarPorId(@PathVariable Long id) {
        return ninjaService.listarPorId(id);
    }

    @PutMapping("/atualizar/{id}")
    public NinjaDTO atualizarPorId(@PathVariable Long id, @RequestBody NinjaDTO ninja) {
        return ninjaService.atualizarPorId(id, ninja);
    }

    @DeleteMapping("/excluir/{id}")
    public void excluirPorId(@PathVariable Long id) {
        ninjaService.excluirPorId(id);
    }
}
