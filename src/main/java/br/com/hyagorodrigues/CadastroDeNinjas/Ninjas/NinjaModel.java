package br.com.hyagorodrigues.CadastroDeNinjas.Ninjas;

import br.com.hyagorodrigues.CadastroDeNinjas.Missoes.MissaoModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_ninjas")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String cpf;

    private String email;

    private Integer idade;

    // @ManyToOne um ninja tem uma única missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") // chave estrangeira
    private MissaoModel missao;
}
