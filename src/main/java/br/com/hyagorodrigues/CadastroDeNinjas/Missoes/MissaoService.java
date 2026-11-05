package br.com.hyagorodrigues.CadastroDeNinjas.Missoes;

public class MissaoService {

    private MissaoRepository missaoRepository;

    public MissaoService(MissaoRepository missaoRepository) {
        this.missaoRepository = missaoRepository;
    }

    public MissaoModel cadastrar(MissaoModel missao) {
        return missaoRepository.save(missao);
    }
}
