package br.com.hyagorodrigues.CadastroDeNinjas.Missoes;

import br.com.hyagorodrigues.CadastroDeNinjas.Ninjas.NinjaModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore // Utilizado para resolver serializacao em loop
    private List<NinjaModel> ninjas;

}
