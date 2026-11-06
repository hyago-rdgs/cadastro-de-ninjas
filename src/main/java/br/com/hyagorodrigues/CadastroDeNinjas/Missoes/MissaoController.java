package br.com.hyagorodrigues.CadastroDeNinjas.Missoes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missao")
public class MissaoController {

    private final MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    @Operation(
            summary = "Cadastra uma nova missao",
            description = "Cria uma nova missao a partir dos dados informados no corpo da requisição."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Missao criada com sucesso"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos para cadastro"
            )
    })
    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrar(@RequestBody MissaoDTO missao) {
        MissaoDTO novoRegistro = missaoService.cadastrar(missao);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Missao #" + novoRegistro.getId() + " criada com sucesso!");
    }

    @Operation(
            summary = "Lista todas as missoes",
            description = "Retorna uma lista contendo todos as missoes cadastradas."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Lista de missoes retornada com sucesso"
    )
    @GetMapping("/listar")
    public ResponseEntity<List<MissaoDTO>> listar() {
        List<MissaoDTO> missoes = missaoService.listar();
        return ResponseEntity.ok()
                .body(missoes);
    }

    @Operation(
            summary = "Busca uma missao por ID",
            description = "Retorna os dados de uma missao específica a partir do seu ID."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Missao encontrada"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Missao não encontrada"
            )
    })
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

    @Operation(
            summary = "Atualiza uma missao",
            description = "Atualiza os dados de uma missao existente a partir do ID informado."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Missao atualizada com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Missao não encontrada"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos para atualização"
            )
    })
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Long id, @RequestBody MissaoDTO missao) {
        if(missaoService.listarPorId(id) != null) {
            missaoService.atualizarPorId(id, missao);
            return ResponseEntity.ok()
                    .body("Missao #" + id + " atualizada com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao #" + id + " nao foi encontrada");
        }
    }

    @Operation(
            summary = "Exclui uma missao",
            description = "Remove uma missao existente a partir do seu ID."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Missao excluída com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Missao não encontrada"
            )
    })
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
