 package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Autor;
import br.edu.ifsul.modelo.Catalogo;
import br.edu.ifsul.modelo.Formato;
import br.edu.ifsul.modelo.Idioma;
import br.edu.ifsul.modelo.Livraria;
import br.edu.ifsul.modelo.Livro;

import java.util.Calendar;

import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestePersistirLivro {
    
    EntityManager em;
    
    public TestePersistirLivro() {}
    
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
            
            Livraria l = new Livraria();
            l.setNome("Livraria_Teste_Nome");
            l.setSite("http://www.site.com");
            
            em.getTransaction().begin();
            em.persist(l);
            c.setLivraria(l);
//            c.adicionarLivro(em.find(Livro.class, "Teste_Livro_ISBN"));
			
            em.persist(c);
            em.getTransaction().commit();
            
            Livro livro = new Livro();
            livro.setIsbn("Teste_Livro_ISBN");
            livro.setTitulo("Teste_Livro_Titulo");
            livro.setResumo("Teste_Livro_Resumo");
            livro.setEditora("Teste_Livro_Editora");
            livro.setDataCadastro(Calendar.getInstance());
            livro.setDataPublicacao(Calendar.getInstance());
            livro.setCodigoBarras("Teste_Livro_Codigo_de_Barras");
            livro.setNumeroPaginas(100);
            livro.setAtivo(true);
            livro.setValor(100.00);
            livro.getAutores().add(em.find(Autor.class, 1));
            livro.setIdioma(em.find(Idioma.class, 1));
            livro.setFormato(em.find(Formato.class, 1));
            livro.setCatalogo(em.find(Catalogo.class, 1));
			
            em.getTransaction().begin();
            c.adicionarLivro(livro);
            em.persist(livro);
            em.getTransaction().commit();
        } catch (Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}