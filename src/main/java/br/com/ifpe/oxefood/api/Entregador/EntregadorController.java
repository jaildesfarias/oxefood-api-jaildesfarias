package br.com.ifpe.oxefood.api.entregador;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/entregador")
@CrossOrigin
public class EntregadorController {
@Tag(
    name = "API Entregador",
    description = "API responsável pelos servidos de entregador no sistema"
)

    @Autowired
    private EntregadorService entregadorService;
...
import io.swagger.v3.oas.annotations.Operation;
...
@RestController
@RequestMapping("/api/cliente")
@CrossOrigin
@Tag(
    name = "API Cliente",
    description = "API responsável pelos servidos de cliente no sistema"
)
public class ClienteController {

   @Autowired
   private ClienteService clienteService;

   @Operation(
       summary = "Serviço responsável por salvar um entregador no sistema.",
       description = "Exemplo de descrição de um endpoint responsável por inserir um entregador no sistema."
   )
   @PostMapping
   public ResponseEntity<Cliente> save(@RequestBody @Valid ClienteRequest request) {

       Cliente cliente = clienteService.save(request.build());
       return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
   }
...

    @PostMapping
    public ResponseEntity<Entregador> save(@RequestBody EntregadorRequest request) {
        Entregador entregador = entregadorService.save(request.build());
        return ResponseEntity.status(HttpStatus.CREATED).body(entregador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entregador> update(@PathVariable Long id, @RequestBody EntregadorRequest request) {
        Entregador entregadorAlterado = request.build();

        Entregador entregador = entregadorService.findById(id)
                .orElseThrow(() -> new RuntimeException("Entregador não encontrado"));

        // Atualiza os dados do entregador
        entregador.setNome(entregadorAlterado.getNome());
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

        entregadorService.update(entregador); // Salva a atualização
        return ResponseEntity.ok(entregador);
    }
}
