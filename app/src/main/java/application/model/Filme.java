package application.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="filmes")
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String sinopse;

    @ManyToOne
    @JoinColumn(name = "id_diretor")
    private Diretor diretor;

    @Column(name = "id_diretor", updatable = false, insertable = false)
    private Long idDiretor;

    public Long getId() {
        return id;
    }
   public void setId(Long id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getSinopse() {
        return sinopse;
    }
    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }
    public Diretor getDiretor() {
        return diretor;
    }
    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }
    public Long getIdDiretor() {
        return idDiretor;
    }
    public void setIdDiretor(Long idDiretor) {
        this.idDiretor = idDiretor;
    }
}
