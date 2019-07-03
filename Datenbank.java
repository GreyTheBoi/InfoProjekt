import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;
import java.sql.*;

/**
 * Write a description of class Datenbank here.
 *
 * @author Nicolas Lisgaras
 * @version 03.07.19
 */
public class Datenbank
{
    String driver = "org.sqlite.JDBC";
    String pre = "jdbc:sqlite:";
    String user = "";
    String pw = "";
    String DBname;
    Connection connection;
    Statement statem;

    String tabelle = "CREATE TABLE IF NOT EXISTS "+DBname+"(" 
        + " frame integer NOT NULL,\n"
        + " type String NOT NULL,\n"
        + " death integer NOT NULL,\n"
        + " posX integer NOT NULL,\n"
        + " posY integer NOT NULL,\n"
        + " width integer NOT NULL,\n"
        + " height integer NOT NULL,\n"
        + " delay integer NOT NULL,\n"
        + " opacity integer NOT NULL,\n"
        + " PRIMARY KEY (name)"
        +")";

    public Datenbank(String DBnameN)
    {
        DBname = DBnameN;
    }

    public  void makeDB() {
        try (Connection conn = DriverManager.getConnection(pre+DBname)){
            if(conn!= null)
            {
                DatabaseMetaData meta = conn.getMetaData();   
                System.out.println("Driver:" + meta.getDriverName());
                System.out.println("DB has been made");
            }

            statem = conn.createStatement();
            statem.execute(tabelle);

        } catch (Exception e) {
            System.out.println("Exception: "+e);
        } 
        closeDB();
        closeStatem();
        System.out.print("EOF, EOD\n");
    }

    public void datenhinzufügen(int frame, String type, int death, int posX, int posY, int width ,int height, int delay, int opacity)
    {
        String sql = "INSERT INTO "+DBname+"(frame,type,death,posX,posY,width,height,delay,opacity) VALUES(?,?,?,?,?,?,?,?,?)";

        try (Connection nConnection = this.Connect(); PreparedStatement prepState = nConnection.prepareStatement(sql))
        {
            prepState.setInt(1, frame);
            prepState.setString(2, type);
            prepState.setInt(3, death);
            prepState.setInt(4, posX);
            prepState.setInt(5, posY);
            prepState.setInt(6, width);
            prepState.setInt(7, height);
            prepState.setInt(8, delay);
            prepState.setInt(9, opacity);
            prepState.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println("Exception: "+e);
        }
        System.out.println("daten erfolgreich hinzugefügt ");
        closeDB();
        closeStatem();
        System.out.println();
    }

    public void GesamteDatenbankAusgeben()
    {

        String SQLrequest = "SELECT frame, type, death, posX, posY, width, height, delay, opacity FROM "+DBname;

        try(Connection connection = this.Connect();
        Statement statem  = connection.createStatement();
        ResultSet resset = statem.executeQuery(SQLrequest) )
        {            
            System.out.println("frame,\t type,\t death,\t posX,\t posY,\t width,\t height,\t delay,\t opacity");
            while (resset.next()) {
                System.out.println(
                    resset.getInt("frame")+"\t"+
                    resset.getString("type")+"\t"+
                    resset.getInt("death")+"\t"+
                    resset.getInt("posX")+"\t"+
                    resset.getInt("posY")+"\t"+
                    resset.getInt("width")+"\t"+
                    resset.getInt("height")+"\t"+ 
                    resset.getInt("delay")+"\t"+
                    resset.getInt("opacity")+"\n" );
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception: "+e);
        }
        closeDB();
        closeStatem();
        System.out.println();
    }

    public void Datenbankzurücksetzen()
    {
        String sql = "DELETE FROM "+DBname;

        try (Connection nConnection = this.Connect();
        PreparedStatement prepState = nConnection.prepareStatement(sql);)
        {

            prepState.setInt(1, -1);
            prepState.setString(2, "err");
            prepState.setInt(3, -1);
            prepState.setInt(4, -1);
            prepState.setInt(5, -1);
            prepState.setInt(6, -1);
            prepState.setInt(7, -1);
            prepState.setInt(8, -1);
            prepState.setInt(9, -1);
            prepState.executeUpdate();
            System.out.println("Set DB to error parameters");

        }
        catch (SQLException e) {
            System.out.println("Exception: "+e);
        }
        System.out.println();
    }

    public Connection Connect()
    {
        try
        {
            connection = DriverManager.getConnection(pre+DBname);
        }
        catch(Exception e)
        {
            System.out.println("Exception: "+e);
        }
        return connection;
    }

    public void closeStatem()
    {
        try{
            statem.close();   
            System.out.println("Statment geschlossen");
        }
        catch(Exception e)
        {
            System.out.println("Exception: "+e);
        }
    }

    public void closeDB()
    {
        if (connection != null)
        {
            try{
                connection.close();
                System.out.println("closed DB");
            }
            catch(Exception e)
            {
                System.out.println("Exception: "+e);
            }
        }
        else
        {
            System.out.println("connection failed: no DB open");   
        }
    }

}
