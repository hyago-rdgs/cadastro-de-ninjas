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
    public String cadastrar() {
        return "Ninja Criado";
    }

    @GetMapping("/listar")
    public List<NinjaModel> listar() {
        return ninjaService.listar();
    }

    @GetMapping("/listar/{id}")
    public NinjaModel listarPorId(@PathVariable Long id) {
        return ninjaService.listarPorId(id);
    }

    @PutMapping("/atualizar")
    public String atualizar() {
        return "Ninja atualizado";
    }

    @DeleteMapping("/excluir/ID")
    public String excluirPorId() {
        return "Ninja excluido por ID";
    }
}
