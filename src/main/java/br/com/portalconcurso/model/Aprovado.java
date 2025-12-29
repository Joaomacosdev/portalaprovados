package br.com.portalconcurso.model;

import br.com.portalconcurso.dto.request.AprovadoRequestDTO;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "aprovados")
public class Aprovado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String telefone;

    private String concursos;

    private String imagemPath;

    public Aprovado() {
    }



    public Aprovado(AprovadoRequestDTO dto) {
        this.nome = dto.nome();
        this.email = dto.email();
        this.telefone = dto.telefone();
        this.concursos = dto.concursos();
        this.imagemPath = dto.imagemPath();
    }

    public Long getId() {
        return id;
    }

    public Aprovado setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Aprovado setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Aprovado setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public Aprovado setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public String getConcursos() {
        return concursos;
    }

    public Aprovado setConcursos(String concursos) {
        this.concursos = concursos;
        return this;
    }

    public String getImagemPath() {
        return imagemPath;
    }

    public Aprovado setImagemPath(String imagemPath) {
        this.imagemPath = imagemPath;
        return this;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Aprovado aprovado = (Aprovado) object;
        return Objects.equals(getId(), aprovado.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
