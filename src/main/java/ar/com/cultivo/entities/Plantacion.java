package ar.com.cultivo.entities;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
@Entity

public class Plantacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String periodo;

    private LocalDate fechaPlantacion;

    private Double porcentajeLote;

    private LocalDate fechaCierre;

    @ManyToOne
    @JoinColumn(name = "fk_cultivo")
    private Cultivos cultivo;

    @ManyToOne
    @JoinColumn(name = "fk_lote")
    private Lote lote;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public LocalDate getFechaPlantacion() {
        return fechaPlantacion;
    }

    public void setFechaPlantacion(LocalDate fechaPlantacion) {
        this.fechaPlantacion = fechaPlantacion;
    }

    public Double getPorcentajeLote() {
        return porcentajeLote;
    }

    public void setPorcentajeLote(Double porcentajeLote) {
        this.porcentajeLote = porcentajeLote;
    }

    public LocalDate getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(LocalDate fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public Cultivos getCultivo() {
        return cultivo;
    }

    public void setCultivo(Cultivos cultivo) {
        this.cultivo = cultivo;
    }

    public Lote getLote() {
        return lote;
    }

    public void setLote(Lote lote) {
        this.lote = lote;
    }
}
