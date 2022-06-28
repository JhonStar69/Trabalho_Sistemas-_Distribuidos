package Controle;

import Modelo.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class UsuarioController {
    EntityManagerFactory emf;//abertura sessao mysql
    EntityManager em;//realizar operaçoes no banco

    public UsuarioController() {
        emf = Persistence.createEntityManagerFactory("usuario");//abri sessao no BD
        em = emf.createEntityManager();
    }

    public void salvarUsuario(Usuario _usuario) {//add novo usuario
        em.getTransaction().begin();//iniciar transaçao
        em.merge(_usuario);//salva o objeto no bd
        em.getTransaction().commit();//salva no bd
        emf.close();//encerra transaçao
    }

    public void removerUsuario(Usuario _usuario) {
        em.getTransaction().begin();//iniciar transaçao
        Query q = em.createNativeQuery("DELETE USUARIO FROM USUARIO WHERE nome=" + _usuario.getNome());//remove o objeto no bd
        q.executeUpdate();
        em.getTransaction().commit();//salva o bd
        emf.close();//encerra transaçao
    }

    public List<Usuario> listarUsuario() {//listar usuarios
        em.getTransaction().begin();//iniciar transaçao
        Query consultaUsuario = em.createQuery("SELECT usuario FROM Usuario usuario");//remove o objeto no bd
        List<Usuario> listaUsuario = consultaUsuario.getResultList(); //cria lista de alunos
        em.getTransaction().commit();//salva o bd
        emf.close();//encerra transaçao
        return listaUsuario;
    }
}
