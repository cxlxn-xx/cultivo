package ar.com.cultivo.entities;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Gasto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate fecha;

    private String concepto;

    private Double cantidadUnidades;

    private Double precioUnitario;

    @ManyToOne
    @JoinColumn(name = "fk_plantacion")
    private Plantacion plantacion;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Double getCantidadUnidades() {
        return cantidadUnidades;
    }

    public void setCantidadUnidades(Double cantidadUnidades) {
        this.cantidadUnidades = cantidadUnidades;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Plantacion getPlantacion() {
        return plantacion;
    }

    public void setPlantacion(Plantacion plantacion) {
        this.plantacion = plantacion;
    }
}
