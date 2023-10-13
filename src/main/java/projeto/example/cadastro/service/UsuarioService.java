package projeto.example.cadastro.service;



import java.util.List;

import projeto.example.cadastro.domain.model.Usuario;

public  interface UsuarioService {
    
 Usuario createUsuario (Usuario usuario);

 Usuario  getUsuarioById (Long id);

 List<Usuario> getAllUsuario ();

 Usuario  updateUsuario (Long id, Usuario usuario); 

 void deleteUsuario (Long id);


    
}
