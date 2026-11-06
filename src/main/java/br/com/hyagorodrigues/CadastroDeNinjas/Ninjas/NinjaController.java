package br.com.hyagorodrigues.CadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(
            summary = "Cadastra um novo ninja",
            description = "Cria um novo ninja a partir dos dados informados no corpo da requisição."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Ninja criado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos para cadastro"
            )
    })
    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrar(@RequestBody NinjaDTO ninja) {
        NinjaDTO novoRegistro = ninjaService.cadastrar(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja #" + novoRegistro.getId() + " criado com sucesso!");
    }

    @Operation(
            summary = "Lista todos os ninjas",
            description = "Retorna uma lista contendo todos os ninjas cadastrados."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Lista de ninjas retornada com sucesso"
    )
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listar() {
        List<NinjaDTO> ninjas = ninjaService.listar();
        return ResponseEntity.ok()
                .body(ninjas);
    }

    @Operation(
            summary = "Busca um ninja por ID",
            description = "Retorna os dados de um ninja específico a partir do seu ID."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Ninja encontrado"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Ninja não encontrado"
            )
    })
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarPorId(@Parameter(description = "ID do ninja", example = "1") @PathVariable Long id) {
        NinjaDTO ninja = ninjaService.listarPorId(id);
        if (ninja != null) {
            return ResponseEntity.ok()
                    .body(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja #" + id + " nao foi encontrado");
        }
    }

    @Operation(
            summary = "Atualiza um ninja",
            description = "Atualiza os dados de um ninja existente a partir do ID informado."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Ninja atualizado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Ninja não encontrado"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos para atualização"
            )
    })
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarPorId(@Parameter(description = "ID do ninja", example = "1") @PathVariable Long id, @RequestBody NinjaDTO ninja) {
        if (ninjaService.listarPorId(id) != null) {
            ninjaService.atualizarPorId(id, ninja);
            return ResponseEntity.ok()
                    .body("Ninja #" + id + " atualizado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja #" + id + " nao foi encontrado!");
        }
    }

    @Operation(
            summary = "Exclui um ninja",
            description = "Remove um ninja existente a partir do seu ID."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Ninja excluído com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Ninja não encontrado"
            )
    })
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluirPorId(@Parameter(description = "ID do ninja", example = "1") @PathVariable Long id) {
        if (ninjaService.listarPorId(id) != null) {
            ninjaService.excluirPorId(id);
            return ResponseEntity.ok()
                    .body("Ninja #" + id + " deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja #" + id + " nao foi encontrado!");
        }
    }
}
