package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Catalogo;
import br.edu.ifsul.modelo.Livraria;
import br.edu.ifsul.modelo.Livro;

import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestePersistirCatalogo {
    
    EntityManager em;
    
    public TestePersistirCatalogo() {}
    
    @Before
    public void setUp() {
        em = EntityManagerUtil.getEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
    }
    
    @Test
    public void teste(){
        boolean exception = false;
        try {
            Catalogo c = new Catalogo();
            c.setNome("Catalogo_Teste");
            c.setDescricao("Catalogo_Teste_Descricao");
            c.setLivraria(em.find(Livraria.class, 1));
//            c.adicionarLivro(em.find(Livro.class, "Teste_Livro_ISBN"));
			
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } catch (Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
