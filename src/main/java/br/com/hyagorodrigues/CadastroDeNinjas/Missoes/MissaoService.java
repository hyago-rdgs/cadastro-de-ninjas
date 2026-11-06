package br.com.hyagorodrigues.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissaoService {

    private final MissaoRepository missaoRepository;
    private final MissaoMapper missaoMapper;

    public MissaoService(MissaoRepository missaoRepository, MissaoMapper missaoMapper) {
        this.missaoRepository = missaoRepository;
        this.missaoMapper = missaoMapper;
    }

    public MissaoDTO cadastrar(MissaoDTO missaoDTO) {
        MissaoModel missao = missaoMapper.map(missaoDTO);
        missao = missaoRepository.save(missao);
        return missaoMapper.map(missao);
    }

    public List<MissaoDTO> listar() {
        List<MissaoModel> missoes = missaoRepository.findAll();
        return missoes.stream()
                .map(missaoMapper::map)
                .collect(Collectors.toList());
    }

    public MissaoDTO listarPorId(Long id) {
        Optional<MissaoModel> missao = missaoRepository.findById(id);
        return missao
                .map(missaoMapper::map)
                .orElse(null);
    }

    public MissaoDTO atualizarPorId(Long id, MissaoDTO missao) {
        Optional<MissaoModel> missaoExistente = missaoRepository.findById(id);

        if(missaoExistente.isPresent()) {
           MissaoModel missaoAtualizado = missaoMapper.map(missao);
           missaoAtualizado.setId(id);

           missaoAtualizado = missaoRepository.save(missaoAtualizado);
           return missaoMapper.map(missaoAtualizado);
        }

        return null;
    }

    public void excluirPorId(Long id) {
        missaoRepository.deleteById(id);
    }
}
