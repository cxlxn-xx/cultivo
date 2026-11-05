package ar.com.cultivo.entities;
import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class Cultivos implements Serializable {
    private static final long serialVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    private String descripcion;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}