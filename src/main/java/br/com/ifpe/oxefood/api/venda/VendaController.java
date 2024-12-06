package br.com.ifpe.oxefood.api.venda;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.venda.Venda;
import br.com.ifpe.oxefood.modelo.venda.VendaService;

@RestController
@RequestMapping("/api/venda")
@CrossOrigin
public class VendaController{
    

   @Autowired
   private VendaService venda Service;

   @PostMapping
   public ResponseEntity<Venda> save(@RequestBody VendaRequest request) {

       Venda venda = VendaService.save(request.build());
       return new ResponseEntity<Venda>(venda, HttpStatus.CREATED);
   }
}


