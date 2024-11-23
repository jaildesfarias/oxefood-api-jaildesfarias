package br.com.ifpe.oxefood.api.Entregador;

ort org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.entregador.Cliente;
import br.com.ifpe.oxefood.modelo.entregador.ClienteService;
import jakarta.transaction.Transactional;
import br.com.ifpe.oxefood.api.entregador.ClienteRequest;

@RestController
@RequestMapping("/api/entregador")
@CrossOrigin
public class EntregadorController {

   @Autowired
   private EntregadorService entregadorService;

   @PostMapping
   public ResponseEntity<Entregador> save(@RequestBody EntregadorRequest request) {

    
       Entregador entregador = EntregadorService.save(request.build());
       
       return new ResponseEntity<>(entregador, HttpStatus.CREATED);
   }
        @Transactional

   public void update(Long id, Entregador entregadorAlterado) {

      entregador.entregador = repository.findById(id).get();
      entregador.setNome(entregadorAlterado.getNome());
      entregador.setCpf(entregadorAlterado.getCpf());
      entregador.setRg(entregadorAlterado.getRg());
      entregador.setDataNascimento(entregadorAlterado.getDataNascimento());
      entregador.setFoneCelular(entregadorAlterado.getFoneCelular());
      
      entregador.setFoneFixo(entregadorAlterado.getFoneFixo());
      entregador.setQtdEntregasRealizadas(entregadorAlterado.getqdEntregasRealizadas());
      entregador.setvalorFrete(valorFreteAlterado.getvalorFrete())
      entregador.setEnderecoRu(enderecoRuaAlterado.getEnderecoRua());
      
      entregador.setEnderecoCompleto(entregadorAlterado.getEnderecoCompleto()); 
      entregador.setEnderecoNumero(entregadorAlterado.getEnderecoNumero()); 
      entregador.settEnderecoBairro(entregadorAlterado.getEnderecoBairro()); 
      entregador.setEnderecoCidade(entregadorAlterado.getEnderecoCidade();
      entregador.setEnderecoCep(entregadorAlterado.getEnderecoCep();
      entregador.settEnderecoUf(entregadorAlterado.getEnderecoUf();
      entregador.setAtivo(entregadorAlterado.getAtivo();
  
   }
}

