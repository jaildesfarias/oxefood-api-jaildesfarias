package br.com.ifpe.oxefood.modelo.venda;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendaService {

    @Autowired
    private VendaRepository repository;

    @Transactional
    public Venda save(Venda venda) {
        venda.setHabilitada(Boolean.TRUE);
        return repository.save(venda);

        }
    public List<Venda> listarTodas() {// Método para listar todas as vendas
        return repository.findAll();
        
    }
}
