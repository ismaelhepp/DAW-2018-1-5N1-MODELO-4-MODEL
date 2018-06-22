package br.edu.ifsul.util;

import br.edu.ifsul.modelo.Catalogo;
import br.edu.ifsul.modelo.Formato;
import br.edu.ifsul.modelo.Idioma;
import br.edu.ifsul.modelo.Livraria;
import br.edu.ifsul.modelo.Livro;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Ismael Felipe Hepp
 */
public class FabricaObjetos {

    public static List<Livro> carregaLivro() {
        List<Livro> listaLivro = new ArrayList<>();

        Idioma i = new Idioma();
        i.setNome("Idioma_Teste");
        i.setSigla("TST");
        
        Formato f = new Formato();
        f.setNome("Formato_Teste");
        
        Livro l = new Livro();

        Catalogo c = new Catalogo();
        c.setDescricao("Desc_Teste");
        c.setNome("CATALOGOTESTE");
        
        Livraria li = new Livraria();
        li.setNome("LIVRARIA_TESTE");
        li.setSite("http://www.teste.com");
        c.setLivraria(li);

        l.setCatalogo(c);
        l.setCodigoBarras("TESTECODBARRAS");
        l.setIsbn("Teste_Livro_ISBN");
        l.setTitulo("Teste_Livro_Titulo");
        l.setResumo("Teste_Livro_Resumo");
        l.setEditora("Teste_Livro_Editora");
        l.setDataCadastro(Calendar.getInstance());
        l.setDataPublicacao(Calendar.getInstance());
        l.setNumeroPaginas(100);
        l.setAtivo(true);
        l.setValor(100.00);
        l.setFormato(f);
        l.setIdioma(i);
        
        Livro a = l;
        a.setIsbn("AAAAAAAAAAA");
        Livro b = l;
        b.setIsbn("BBBBBBBBBBB");
        
        listaLivro.add(l);
        listaLivro.add(a);
        listaLivro.add(b);

        return listaLivro;
    }
}
