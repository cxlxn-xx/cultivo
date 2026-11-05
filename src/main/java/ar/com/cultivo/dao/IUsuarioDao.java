package ar.com.cultivo.dao;


import ar.com.cultivo.entities.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface IUsuarioDao extends JpaRepository<Usuarios, Integer> {
    Optional<Usuarios> findByUsername(String username);
}