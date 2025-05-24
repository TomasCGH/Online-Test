package co.edu.uco.onlinetest.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Prueba {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/prueba")
    public String probarConexion() {
        try {
            jdbcTemplate.execute("SELECT 1");
            return "✅ Conexión a PostgreSQL exitosa";
        } catch (Exception e) {
            return "❌ Error de conexión: " + e.getMessage();
        }
    }
}
