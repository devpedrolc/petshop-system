package repository;

import model.Animal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalRepositoryImpl {

    private Connection conn;

    public AnimalRepositoryImpl(Connection conn) {
        this.conn = conn;
    }

    // ✅ SALVAR
    public void salvar(Animal animal) {
        String sql = "INSERT INTO animal (nome, idade, tipo) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, animal.getNome());
            stmt.setInt(2, animal.getIdade());
            stmt.setString(3, animal.getTipo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // ✅ LISTAR
    public List<Animal> listar() {
        List<Animal> lista = new ArrayList<>();
        String sql = "SELECT * FROM animal";

        try (PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Animal a = new Animal();
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setId(rs.getInt("idade"));
                a.setTipo(rs.getString("tipo"));
                lista.add(a);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return lista;
    }

    // ✅ BUSCAR POR NOME (resolve erro 1)
    public Animal buscarPorNome(String nome) {
        String sql = "SELECT * FROM animal WHERE nome = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Animal a = new Animal();
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setIdade(rs.getInt("idade"));
                a.setTipo(rs.getString("tipo"));
                return a;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    // ✅ DELETAR (resolve erro 2)
    public boolean deletar(String nome) {
        String sql = "DELETE FROM animal WHERE nome = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            return stmt.executeUpdate() > 0; // 👈 retorna boolean
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}