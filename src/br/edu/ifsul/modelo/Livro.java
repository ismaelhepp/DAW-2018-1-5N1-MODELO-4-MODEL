package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "livro")
public class Livro extends LivroBasico implements Serializable {
    
    @NotNull(message = "O código de barras não pode ser nulo")
    @NotBlank(message = "O código de barras não pode ser em branco")
    @Length(max = 50, message = "O código de barras não pode ter mais que {max} caracteres")
    @Column(name = "codigoBarras", length = 50, nullable = false) 
    private String codigoBarras;
    
    @Min(value = 0, message = "O número de páginas não pode ser negativo")
    @NotNull(message = "O número de páginas deve ser informado")
    @Column(name = "numero_paginas", nullable = false)
    private Integer numeroPaginas;
    
    @NotNull(message = "Informe se o livro está ativo")
    @Column(name = "ativo", nullable = false)
    private Boolean ativo;
    
    @NotNull(message = "A data de cadastro deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "data_cadastro", nullable = false)
    private Calendar dataCadastro;
    
    @Min(value = 0, message = "O valor não pode ser negativo")
    @NotNull(message = "O valor deve ser informado")
    @Column(name = "valor", nullable = false, columnDefinition = "decimal(10,2)") 
    private Double valor;
    
    @NotNull(message = "O idioma deve ser informado")
    @ManyToOne
    @JoinColumn(name = "idioma", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_livro_idioma")       
    private Idioma idioma;
    
    @NotNull(message = "O formato deve ser informado")
    @ManyToOne
    @JoinColumn(name = "formato", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_livro_formato")
    private Formato formato;
    
    @NotNull(message = "O catalogo deve ser informado")
    @ManyToOne
    @JoinColumn(name = "catalogo", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_catalogo_livro")       
    private Catalogo catalogo;

    public Livro() {}

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

	public Idioma getIdioma() {
		return idioma;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}

	public Formato getFormato() {
		return formato;
	}

	public void setFormato(Formato formato) {
		this.formato = formato;
	}

	public Catalogo getCatalogo() {
		return catalogo;
	}

	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}
}
