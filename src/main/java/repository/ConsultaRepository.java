package repository;

import model.Consulta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsultaRepository {

    private Connection conn;

    public ConsultaRepository(Connection conn) {
        this.conn = conn;
    }

    public void salvar(Consulta consulta) {
        String sql = "INSERT INTO consulta (descricao) VALUES (?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, consulta.getDescricao());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Consulta> listar() {
        List<Consulta> lista = new ArrayList<>();
        String sql = "SELECT * FROM consulta";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Consulta c = new Consulta();
                c.setDescricao(rs.getString("descricao"));
                lista.add(c);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }
}