package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "livro_basico")
@Inheritance(strategy = InheritanceType.JOINED)
public class LivroBasico implements Serializable {
    
    @Id
    private String isbn;
    
    @Column(name = "titulo", length = 100, nullable = false)
    @NotNull(message = "O titulo não pode ser nulo")
    @NotBlank(message = "O nome não pode ser em branco")
    @Length(max = 100, message = "O nome não pode ter mais que {max} caracteres") 
    private String titulo;
    
    @Column(name = "resumo", columnDefinition = "text")
    private String resumo;
    
    @Column(name = "editora", length = 50, nullable = false)
    @NotNull(message = "A editora não pode ser nula")
    @NotBlank(message = "A editora não pode ser em branco")
    @Length(max = 50, message = "A editora não pode ter mais que {max} caracteres") 
    private String editora;
    
    @Column(name = "data_publicacao", nullable = false)
    @NotNull(message = "A data de publicação não pode ser nula")
    @Temporal(TemporalType.DATE)
    private Calendar dataPublicacao;
    
    @ManyToMany
    @JoinTable(name = "obras", 
            joinColumns = @JoinColumn(name = "livro_basico", 
                    referencedColumnName = "isbn",
                    nullable = false),
            inverseJoinColumns = @JoinColumn(name = "autor", 
                    referencedColumnName = "id", 
                    nullable = false)
    )
    private List<Autor> autores = new ArrayList<>();

    public LivroBasico() {}

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public Calendar getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Calendar dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	@Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.isbn);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LivroBasico other = (LivroBasico) obj;
        if (!Objects.equals(this.isbn, other.isbn)) {
            return false;
        }
        return true;
    }
}
