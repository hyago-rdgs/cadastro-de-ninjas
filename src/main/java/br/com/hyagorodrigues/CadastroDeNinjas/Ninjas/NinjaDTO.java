package br.com.hyagorodrigues.CadastroDeNinjas.Ninjas;

import br.com.hyagorodrigues.CadastroDeNinjas.Missoes.MissaoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private Integer idade;
    private String rank;
    private MissaoModel missao;
}
