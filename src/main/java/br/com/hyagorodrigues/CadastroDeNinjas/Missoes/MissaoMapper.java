package br.com.hyagorodrigues.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Component;

@Component
public class MissaoMapper {

    public MissaoModel map(MissaoDTO missaoDTO) {
        MissaoModel missaoModel = new MissaoModel();

        missaoModel.setId(missaoDTO.getId());
        missaoModel.setNome(missaoDTO.getNome());
        missaoModel.setDificuldade(missaoDTO.getDificuldade());
        missaoModel.setNinjas(missaoDTO.getNinjas());

        return missaoModel;
    }

    public MissaoDTO map(MissaoModel missaoModel) {
        MissaoDTO missaoDTO = new MissaoDTO();

        missaoDTO.setId(missaoModel.getId());
        missaoDTO.setNome(missaoDTO.getNome());
        missaoDTO.setDificuldade(missaoDTO.getDificuldade());
        missaoDTO.setNinjas(missaoDTO.getNinjas());

        return missaoDTO;
    }
}
