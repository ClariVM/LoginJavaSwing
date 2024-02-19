package com.mycompany.login.logica;

import com.mycompany.login.persistencia.ControladoraPersistencia;
import java.util.List;


public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public Usuario validarUsuario(String usuario, String contrasenia) {
       
       //String mensaje = ""; 
       Usuario user = null;
       List<Usuario> listaUsuarios = controlPersis.traerUsuarios();
       
       for(Usuario usu : listaUsuarios){
           if(usu.getNombreUsuario().equals(usuario)){
               if(usu.getContrasenia().equals(contrasenia)){
                   //mensaje = "Usuario y contraseña correctos. Bienvenido/a!";
                   user = usu;
                   return user;
               }else{
                    //mensaje = "Contraseña Incorrecta";
                    user = null;
                    return user;
               }
           }else{
               //mensaje = "Usuario Incorrecto";
               user = null;
     
           }
       }
        return user;
    }

    public List<Usuario> traerUsuarios() {
        
        return controlPersis.traerUsuarios();
        
    }

    public List<Rol> traerRoles() {
        return controlPersis.traerRoles();
    }

    public void crearUsuario(String usuario, String contrasenia, String rolRecibido) {
        
        Usuario usu = new Usuario();
        usu.setNombreUsuario(usuario);
        usu.setContrasenia(contrasenia);
        
        Rol rolEncontrado = new Rol();
        rolEncontrado = this.traerRol(rolRecibido);
        if(rolEncontrado!=null){
            usu.setUnRol(rolEncontrado);
        }
        
        int id = this.buscarUltimaIdUsuarios();
        usu.setId(id+1);
        
        controlPersis.crearUsuario(usu);
        
    }

    private Rol traerRol(String rolRecibido) {
        
       List <Rol> listaRoles= controlPersis.traerRoles();
       
       for(Rol rol : listaRoles){
           if(rol.getNombreRol().equals(rolRecibido)){
               return rol;
           }
       }
        return null;
    }

    private int buscarUltimaIdUsuarios() {
        
        List <Usuario> listaUsuarios = this.traerUsuarios();
        
        Usuario usu = listaUsuarios.get(listaUsuarios.size()-1);
        
        return usu.getId();
    }

    public void borrarUsuario(int id_usuario) {
        
        controlPersis.borrarUsuario(id_usuario);
    }

   

    
}
