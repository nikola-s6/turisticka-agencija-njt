package rs.ac.bg.fon.repository.db.impl;

import rs.ac.bg.fon.domain.Grad;
import rs.ac.bg.fon.repository.db.DbConnectionFactory;
import rs.ac.bg.fon.repository.db.DbConnectionRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RepositoryDBGrad implements DbConnectionRepository<Grad> {

    @Override
    public List<Grad> getAll(Grad param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Grad> getAll() throws Exception {
        List<Grad> gradovi = new ArrayList<>();
        try {
            String query = "SELECT gradid, naziv, drzava FROM grad ORDER BY naziv ASC;";
            Connection connection = DbConnectionFactory.getInstance().getConnection();

            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                Grad grad = new Grad();
                grad.setGradID(rs.getInt("gradid"));
                grad.setNaziv(rs.getString("naziv"));
                grad.setDrzava(rs.getString("drzava"));

                gradovi.add(grad);
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Sistem ne moze da ucita gradove");
        }
        return gradovi;
    }

    @Override
    public void add(Grad param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void edit(Grad param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Grad param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Grad getOne(Grad param) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
