package application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Compromissos")
public class Compromisso{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private String datainicio;
    private String datafim;
    private String horainicio;
    private String horafim;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getDatainicio() {
        return datainicio;
    }
    public void setDatainicio(String datainicio) {
        this.datainicio = datainicio;
    }
    public String getDatafim() {
        return datafim;
    }
    public void setDatafim(String datafim) {
        this.datafim = datafim;
    }
    public String getHorainicio() {
        return horainicio;
    }
    public void setHorainicio(String horainicio) {
        this.horainicio = horainicio;
    }
    public String getHorafim() {
        return horafim;
    }
    public void setHorafim(String horafim) {
        this.horafim = horafim;
    }
   
}