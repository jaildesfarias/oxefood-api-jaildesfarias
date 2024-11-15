package br.com.ifpe.oxefood.api.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import br.com.ifpe.oxefood.modelo.cliente.Cliente;
import br.com.ifpe.oxefood.modelo.cliente.ClienteService;
import br.com.ifpe.oxefood.api.cliente.ClienteRequest;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin
public class ClienteController {

   @Autowired
   private ClienteService clienteService;

   @PostMapping
   public ResponseEntity<Cliente> save(@RequestBody ClienteRequest request) {

     
       Cliente cliente = clienteService.save(request.build());
       
    
       return new ResponseEntity<>(cliente, HttpStatus.CREATED);
   }

   @GetMapping
   public List<Cliente> listarTodos() {
       return clienteService.listarTodos();
   }

   @GetMapping("/{id}")
   public Cliente obterPorID(@PathVariable Long id) {
       return clienteService.obterPorID(id);
   }
}


