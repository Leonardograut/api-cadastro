package projeto.example.cadastro.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import projeto.example.cadastro.domain.model.Usuario;
import projeto.example.cadastro.domain.repository.UsuarioRepository;
import projeto.example.cadastro.service.UsuarioService;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public Usuario createUsuario(Usuario usario) {

        return usuarioRepository.save(usario);
    }

    @Override
    public Usuario getUsuarioById(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id); 
        return usuario.get();
        
    }

    @Override
    public List<Usuario> getAllUsuario() {
         
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario updateUsuario(Long id, Usuario usuario) {
    
       Usuario usuarioAtualizado = usuarioRepository.findById(usuario.getId()).get();    
       usuarioAtualizado.setNome(usuario.getNome());        
       usuarioAtualizado.setEmail(usuario.getEmail());  
       usuarioAtualizado.setDataNascimento(usuario.getDataNascimento());
       return usuarioRepository.save(usuarioAtualizado);

        
    }

    @Override
    public void deleteUsuario(Long id) {
        for (Iterator<Usuario> iterator = usuarioRepository.findAll().iterator(); iterator.hasNext();) {
            Usuario usuario = iterator.next();
            if (usuario.getId() == id) {
                iterator.remove();
                break;
            }
        }

    }

    
}
