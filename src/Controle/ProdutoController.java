package Controle;

import Modelo.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ProdutoController {

    EntityManagerFactory emf;//abertura sessao mysql
    EntityManager em;//realizar operaçoes no banco

    public ProdutoController() {
        emf = Persistence.createEntityManagerFactory("produto");//abri sessao no BD
        em = emf.createEntityManager();
    }

    public void salvarProduto(Produto _produto) {//add novo produto
        em.getTransaction().begin();//iniciar transaçao
        em.merge(_produto);//salva o objeto no bd
        em.getTransaction().commit();//salva no bd
        emf.close();//encerra transaçao
    }

    public void removerProduto(Produto _produto) {
        em.getTransaction().begin();//iniciar transaçao
        Query q = em.createNativeQuery("DELETE PRODUTO FROM PRODUTO WHERE titulo=" + _produto.getTitulo());//remove o objeto no bd
        q.executeUpdate();
        em.getTransaction().commit();//salva o bd
        emf.close();//encerra transaçao
    }

    public List<Produto> listarProduto() {//listar usuarios
        em.getTransaction().begin();//iniciar transaçao
        Query consultaProduto = em.createQuery("SELECT produto FROM Produto produto");//remove o objeto no bd
        List<Produto> listaProduto = consultaProduto.getResultList(); //cria lista de alunos
        em.getTransaction().commit();//salva o bd
        emf.close();//encerra transaçao
        return listaProduto;
    }
}
