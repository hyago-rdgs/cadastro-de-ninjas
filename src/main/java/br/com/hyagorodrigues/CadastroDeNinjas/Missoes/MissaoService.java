package br.com.hyagorodrigues.CadastroDeNinjas.Missoes;

import java.util.List;
import java.util.Optional;

public class MissaoService {

    private MissaoRepository missaoRepository;

    public MissaoService(MissaoRepository missaoRepository) {
        this.missaoRepository = missaoRepository;
    }

    public MissaoModel cadastrar(MissaoModel missao) {
        return missaoRepository.save(missao);
    }

    public List<MissaoModel> listar() {
        return missaoRepository.findAll();
    }

    public MissaoModel listarPorId(Long id) {
        Optional<MissaoModel> missao = missaoRepository.findById(id);
        return missao.orElse(null);
    }
}
