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

    
    
}
