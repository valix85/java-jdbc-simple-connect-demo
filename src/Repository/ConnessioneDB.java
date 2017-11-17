package Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnessioneDB {

    private String driver;
    private String url;
    private String username;
    private String password;
    private Connection conn;

    private static ConnessioneDB instance;

    private ConnessioneDB(){}

    public static ConnessioneDB getInstance(){
        if (ConnessioneDB.instance == null){
            ConnessioneDB.instance = new ConnessioneDB();
        }
        return instance;
    }


    public Connection getConnection(){


        try{
            Class.forName(this.getDriver());
            conn = DriverManager.getConnection(this.getUrl(),this.getUsername(),this.getPassword());
            System.out.println("Connessione avvenuta");
        }catch (ClassNotFoundException e){
            System.out.println("Errore di connessione al DB: classe non valida");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Errore di connessione al DB: Host, nome utente o password non validi.");
            e.printStackTrace();
        }


        return  conn;
    }



    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
