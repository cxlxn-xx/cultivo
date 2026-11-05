package ar.com.cultivo.entities;


import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity

public class Cosechas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate fecha;
    private Double rendimientokg;
    @ManyToOne
    @JoinColumn(name="fk_plantacion")
    private Plantacion plantacion;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public Double getRendimientokg() {
        return rendimientokg;
    }

    public void setRendimientokg(Double rendimientokg) {
        this.rendimientokg = rendimientokg;
    }

    public Plantacion getPlantacion() {
        return plantacion;
    }

    public void setPlantacion(Plantacion plantacion) {
        this.plantacion = plantacion;
    }
}
