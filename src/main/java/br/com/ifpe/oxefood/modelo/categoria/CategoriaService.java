package br.com.ifpe.oxefood.modelo.categoria;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    /**
     * Salva uma nova categoria no banco de dados.
     *
     * @param categoria Objeto Categoria a ser salvo.
     * @return Categoria salva.
     */
    @Transactional
    public Categoria save(Categoria categoria) {
        categoria.setHabilitado(Boolean.TRUE); // Define a categoria como habilitada por padrão
        return repository.save(categoria);
    }

    /**
     * Lista todas as categorias do banco de dados.
     *
     * @return Lista de categorias.
     */
    public List<Categoria> listarTodos() {
        return repository.findAll();
    }

    /**
     * Obtém uma categoria pelo ID.
     *
     * @param id Identificador da categoria.
     * @return Categoria encontrada.
     * @throws RuntimeException Se a categoria não for encontrada.
     */
    public Categoria obterPorID(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria com ID " + id + " não encontrada."));
    }

    /**
     * Atualiza os dados de uma categoria existente.
     *
     * @param id                Identificador da categoria a ser atualizada.
     * @param categoriaAlterada Dados atualizados da categoria.
     * @throws RuntimeException Se a categoria não for encontrada.
     */
    @Transactional
    public void update(Long id, Categoria categoriaAlterada) {
        Categoria categoria = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria com ID " + id + " não encontrada."));

        // Atualiza os dados da categoria
        categoria.setNome(categoriaAlterada.getNome());
        categoria.setDescricao(categoriaAlterada.getDescricao());

        repository.save(categoria);
    }

    /**
     * Desativa uma categoria (soft delete).
     *
     * @param id Identificador da categoria a ser desativada.
     * @throws RuntimeException Se a categoria não for encontrada.
     */
    @Transactional
    public void delete(Long id) {
        Categoria categoria = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria com ID " + id + " não encontrada."));
        categoria.setHabilitado(Boolean.FALSE);
        repository.save(categoria);
    }
}
// corrig