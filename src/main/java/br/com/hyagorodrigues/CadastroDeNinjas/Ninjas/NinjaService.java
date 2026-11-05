package br.com.hyagorodrigues.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public NinjaModel cadastrar(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

    public List<NinjaModel> listar() {
        return ninjaRepository.findAll();
    }

    public NinjaModel listarPorId(Long id) {
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);
        return ninja.orElse(null);
    }

    public NinjaModel atualizarPorId(Long id, NinjaModel ninja) {
        if(ninjaRepository.existsById(id)) {
            ninja.setId(id);
            return ninjaRepository.save(ninja);
        }

        return null;
    }

    public void deletarPorId(Long id) {
        ninjaRepository.deleteById(id);
    }
}
