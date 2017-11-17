import Entity.Abbonamento;
import Repository.ConnessioneDB;
import Service.AbbonamentoService;
import Service.Impl.AbbonamentoServiceImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Pr044 {

    public static void main(String[] args) {

        ConnessioneDB connBuilder = ConnessioneDB.getInstance();
        connBuilder.setDriver("com.mysql.jdbc.Driver");
        connBuilder.setUrl("jdbc:mysql://localhost:3306/bike_sharing");
        connBuilder.setUsername("root");
        connBuilder.setPassword("root");

        Connection conn = connBuilder.getConnection();


        // unico statement che riutilizzereò nel tempo

        try {
            Statement st = conn.createStatement();

            // CRUD OPERATION
            // READ = SELECT

            // Nel service c'è dichiarato cosa si può fare su una entity
            // Nel serviceImpl c'è una particolare implementazione su
            //      come si fanno le cose di un service
            // Nel repository ci sono le interrogazion alla entity

            AbbonamentoService abbSrv = new AbbonamentoServiceImpl();
            ResultSet rs = st.executeQuery(abbSrv.getAll());
            System.out.println("Select completata... ("+abbSrv.getAll()+")");
            List<Abbonamento> abbonamenti = new ArrayList<>();
            while(rs.next()){
                Abbonamento record = new Abbonamento();
                /*
                * posso ottnere sia per posizione colonna (int)
                * sia per nome colonna (String)
                * */
                record.setIdAbbonamento(rs.getInt(1));
                //record.setIdAbbonamento(rs.getInt("id"));
                record.setDescrizione(rs.getString(2));
                //record.setDescrizione(rs.getString("label"));
                record.setCostoAlSecondo(rs.getDouble(3));
                //record.setCostoAlSecondo(rs.getDouble("costo_secondo"));
                record.setAttivo(rs.getBoolean(4));
                //record.setAttivo(rs.getBoolean("attivato"));
                record.setCancellato(rs.getBoolean(5));
                //record.setCancellato(rs.getBoolean("cancellato"));
                abbonamenti.add(record);
            }
            rs.close();
            abbonamenti.stream().forEach(System.out::println);



            // CREATE = INSERT
            Abbonamento abbDemo = new Abbonamento(
                    "Prova 7 Gratis",
                    0.0,
                    true,
                    false
            );
            String queryInsert = abbSrv.addAbbonamento(abbDemo);
            System.out.println(queryInsert);
            System.out.println("insert: " + st.executeUpdate(queryInsert));






            // UPDATE = UPDATE





            // TROVO L'ULTIMO
            rs = st.executeQuery(abbSrv.getLast());
            System.out.println("Select completata... ("+abbSrv.getLast()+")");
            Abbonamento ultimoAbbonamento = new Abbonamento();
            while(rs.next()){
                Abbonamento record = new Abbonamento();
                /*
                * posso ottnere sia per posizione colonna (int)
                * sia per nome colonna (String)
                * */
                record.setIdAbbonamento(rs.getInt(1));
                //record.setIdAbbonamento(rs.getInt("id"));
                record.setDescrizione(rs.getString(2));
                //record.setDescrizione(rs.getString("label"));
                record.setCostoAlSecondo(rs.getDouble(3));
                //record.setCostoAlSecondo(rs.getDouble("costo_secondo"));
                record.setAttivo(rs.getBoolean(4));
                //record.setAttivo(rs.getBoolean("attivato"));
                record.setCancellato(rs.getBoolean(5));
                //record.setCancellato(rs.getBoolean("cancellato"));
                ultimoAbbonamento = record;
            }
            rs.close();
            System.out.println(ultimoAbbonamento);



            // DELETE = DELETE
            String queryDelete = abbSrv.deleteStmByID();
            PreparedStatement prst = conn.prepareStatement(queryDelete);
            prst.setLong(1, ultimoAbbonamento.getIdAbbonamento());
            System.out.println(prst);
            prst.executeUpdate();
            System.out.println("Ultimo record disponibile cancellato correttamente");




            st.close();

        } catch (SQLException e) {
            System.out.println("Errore nella creazione dello statement");
            e.printStackTrace();
        }finally {
            // non chiudo qui la connessione perchè
            // potrei fare altro su di essa...
        }










        // prima di terminare l'esecuzione del
        // programma chiudo la connessione
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }//end main

}//end class
