 package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Autor;
import br.edu.ifsul.modelo.Catalogo;
import br.edu.ifsul.modelo.Formato;
import br.edu.ifsul.modelo.Idioma;
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
			
            Livro l = new Livro();
            l.setIsbn("Teste_Livro_ISBN");
            l.setTitulo("Teste_Livro_Titulo");
            l.setResumo("Teste_Livro_Resumo");
            l.setEditora("Teste_Livro_Editora");
            l.setDataCadastro(Calendar.getInstance());
            l.setDataPublicacao(Calendar.getInstance());
            l.setCodigoBarras("Teste_Livro_Codigo_de_Barras");
            l.setNumeroPaginas(100);
            l.setAtivo(true);
            l.setValor(100.00);
            l.getAutores().add(em.find(Autor.class, 1));
            l.setIdioma(em.find(Idioma.class, 1));
            l.setFormato(em.find(Formato.class, 1));
            l.setCatalogo(em.find(Catalogo.class, 1));
			
            em.getTransaction().begin();
            em.persist(l);
            em.getTransaction().commit();
        } catch (Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}