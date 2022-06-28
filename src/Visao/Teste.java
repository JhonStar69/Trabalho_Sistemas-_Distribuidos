package Visao;

import Controle.UsuarioController;
import Modelo.Usuario;

import java.util.List;

public class Teste {
    public static void main(String[] args) {
        Usuario u1 = new Usuario();
        u1.setNome("Cristiano");
        u1.setSenha("123456ff");

        UsuarioController con = new UsuarioController();
        con.salvarUsuario(u1);//salva novos usuarios
        /*List<Usuario> usuarios = con.listarUsuario();//criar lista

        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println("Nome: " + usuarios.get(i).getNome() + "Saldo: " + usuarios.get(i).getSaldo());
        }//imprimir dados de lista de todos os usuarios
        */


    }
}
