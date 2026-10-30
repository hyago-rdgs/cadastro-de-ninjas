package br.com.hyagorodrigues.CadastroDeNinjas.Missoes;

import br.com.hyagorodrigues.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String dificuldade;

    // @OneToMany Uma missão pode ter vários ninjas
    @OneToMany(mappedBy = "missao")
    private List<NinjaModel> ninjas;

}
