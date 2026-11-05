package ar.com.cultivo.config;

import ar.com.cultivo.dao.IUsuarioDao; //
import ar.com.cultivo.entities.Rol;
import ar.com.cultivo.entities.Usuarios; //
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private IUsuarioDao usuariosDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (usuariosDao.findByUsername("admin").isEmpty()) {

            Rol rolAdmin = new Rol();
            rolAdmin.setNombre("ROLE_ADMIN");

            Usuarios admin = new Usuarios(); //
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRoles(List.of(rolAdmin));

            usuariosDao.save(admin);

            System.out.println(" USUARIO ADMIN CREADO EXITOSAMENTE");
        }
    }
}