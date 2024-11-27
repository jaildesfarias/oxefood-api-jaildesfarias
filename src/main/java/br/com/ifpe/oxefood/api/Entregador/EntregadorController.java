package br.com.ifpe.oxefood.api.entregador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import br.com.ifpe.oxefood.modelo.entregador.EntregadorService;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/entregador")
@CrossOrigin
public class EntregadorController {

   @Autowired
   private EntregadorService entregadorService;

   @PostMapping
   public ResponseEntity<Entregador> save(@RequestBody EntregadorRequest request) {
       // Usar o método save do entregadorService
       Entregador entregador = entregadorService.save(request.build());
       return new ResponseEntity<>(entregador, HttpStatus.CREATED);
   }

   @Transactional
   public void update(Long id, Entregador entregadorAlterado) {
       
       Entregador entregador = entregadorService.findById(id)// Buscar o entregador pelo ID
               .orElseThrow(() -> new RuntimeException("Entregador não encontrado"));

       entregador.setNome(entregadorAlterado.getNome()); // Atualizar os campos do entregador
       entregador.setCpf(entregadorAlterado.getCpf());
       entregador.setRg(entregadorAlterado.getRg());
       entregador.setDataNascimento(entregadorAlterado.getDataNascimento());
       entregador.setFoneCelular(entregadorAlterado.getFoneCelular());
       entregador.setFoneFixo(entregadorAlterado.getFoneFixo());
       entregador.setQtdEntregasRealizadas(entregadorAlterado.getQtdEntregasRealizadas());
       entregador.setValorFrete(entregadorAlterado.getValorFrete());
       entregador.setEnderecoRua(entregadorAlterado.getEnderecoRua());
       entregador.setEnderecoCompleto(entregadorAlterado.getEnderecoCompleto());
       entregador.setEnderecoNumero(entregadorAlterado.getEnderecoNumero());
       entregador.setEnderecoBairro(entregadorAlterado.getEnderecoBairro());
       entregador.setEnderecoCidade(entregadorAlterado.getEnderecoCidade());
       entregador.setEnderecoCep(entregadorAlterado.getEnderecoCep());
       entregador.setEnderecoUf(entregadorAlterado.getEnderecoUf());
       entregador.setAtivo(entregadorAlterado.getAtivo());

       
       entregadorService.update(entregador);//Salvar mudanças
   }
}
