@Entity
@Table(name = "Perfil")
@SQLRestriction("habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Perfil extends EntidadeNegocio implements GrantedAuthority {
  
   public static final String ROLE_CLIENTE = "CLIENTE";
   public static final String ROLE_FUNCIONARIO_ADMIN = "ROLE_FUNCIONARIO_ADMIN"; // READ, DELETE, WRITE, UPDATE.
   public static final String ROLE_FUNCIONARIO_USER = "ROLE_FUNCIONARIO_USER"; // READ, WRITE, UPDATE.
  
   private String nome;
  
   @Override
   public String getAuthority() {
       return this.nome;
   }
  
}//corrig

