package Controle;

import Modelo.Venda;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class VendaController {

    EntityManagerFactory emf;//abertura sessao mysql
    EntityManager em;//realizar operaçoes no banco

    public VendaController() {
        emf = Persistence.createEntityManagerFactory("venda");//abri sessao no BD
        em = emf.createEntityManager();
    }

    public void salvarVenda(Venda _venda) {//add novo produto
        em.getTransaction().begin();//iniciar transaçao
        em.merge(_venda);//salva o objeto no bd
        em.getTransaction().commit();//salva no bd
        emf.close();//encerra transaçao
    }

    public void removerVenda(Venda _venda) {
        em.getTransaction().begin();//iniciar transaçao
        Query q = em.createNativeQuery("DELETE VENDA FROM VENDA WHERE comprador=" + _venda.getComprador());//remove o objeto no bd
        q.executeUpdate();
        em.getTransaction().commit();//salva o bd
        emf.close();//encerra transaçao
    }

    public List<Venda> listarVenda() {//listar usuarios
        em.getTransaction().begin();//iniciar transaçao
        Query consultaVenda = em.createQuery("SELECT venda FROM Venda venda");//remove o objeto no bd
        List<Venda> listaVenda = consultaVenda.getResultList(); //cria lista de alunos
        em.getTransaction().commit();//salva o bd
        emf.close();//encerra transaçao
        return listaVenda;
    }
}
