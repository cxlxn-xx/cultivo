package ar.com.cultivo.entities;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity

public class Venta implements Serializable {
   private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
   private LocalDate fecha;
   private Double cantidadVendida;
   private Double precioUnitario;

   @ManyToOne
    @JoinColumn(name = "fk_plantacion")
    private Plantacion plantacion;

   @ManyToOne
    @JoinColumn(name = "fk_comprador")
    private Comprador comprador;

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

    public Double getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(Double cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
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

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }
}
