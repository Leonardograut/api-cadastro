package projeto.example.cadastro.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import projeto.example.cadastro.domain.model.Usuario;
import projeto.example.cadastro.service.UsuarioService;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/")
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioCadastrado = usuarioService.createUsuario(usuario);
        return new ResponseEntity<>(usuarioCadastrado, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id){
        Usuario usuario = usuarioService.getUsuarioById(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsers(){
        List<Usuario> usuarios = usuarioService.getAllUsuario();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }


     @PutMapping("{id}")
     public ResponseEntity<Usuario> updateUser(@PathVariable Long id,
                                             @RequestBody Usuario user){
        user.setId(id);
        Usuario updatedUsuario = usuarioService.updateUsuario(id, user);
        return new ResponseEntity<>(updatedUsuario, HttpStatus.OK);
    }



    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
       usuarioService.deleteUsuario(id);
        return new ResponseEntity<>("Usuario deletado com sucesso !", HttpStatus.OK);
    }


}
