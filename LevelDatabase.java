import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;
import java.sql.*;

/**
 * Write a description of class DB here.
 *
 * @author Nicolas Lisgaras
 * @version 03.07.19
 */
public class LevelDatabase
{
    public static String prefix = "jdbc:sqlite:";
    public static String DBsuffix = ".db";
    public static String DBname = "";

    LevelDatabase(String newDBname){
        DBname = newDBname;
    }

    /**
     * From: http://www.sqlitetutorial.net/sqlite-java/sqlite-jdbc-driver/ 
     * altered
     */
    public void connection() {
        Connection connection = null;
        try {

            String url = prefix+DBname+DBsuffix;

            connection = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private Connection connect() {
        // SQLite connection string
        String url = prefix+DBname+DBsuffix;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    /**
     * http://www.sqlitetutorial.net/sqlite-java/create-database/
     */
    public void createNewDatabase() {

        String url = prefix+DBname+DBsuffix;

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * http://www.sqlitetutorial.net/sqlite-java/create-table/
     */
    public void createNewTable(String tabname) {
        // SQLite connection string
        String url = prefix+DBname+DBsuffix;

        // SQL statement for creating a new table
        String tabelle = "CREATE TABLE IF NOT EXISTS "+tabname+"(" 
            + " frame integer NOT NULL,\n"
            + " type String NOT NULL,\n"
            + " death integer NOT NULL,\n"
            + " posX integer NOT NULL,\n"
            + " posY integer NOT NULL,\n"
            + " width integer NOT NULL,\n"
            + " height integer NOT NULL,\n"
            + " delay integer NOT NULL,\n"
            + " opacity integer NOT NULL,\n"
            + " ID integer NOT NULL,\n"
            + " PRIMARY KEY (ID)"
            +")";

        try (Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(tabelle);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * http://www.sqlitetutorial.net/sqlite-java/insert/
     */    
    public void insert(int ID,int frame, String type, int death, int posX, int posY, int width ,int height, int delay, int opacity, String tabname)
    {
        String sql = "INSERT INTO " + tabname + "(frame,type,death,posX,posY,width,height,delay,opacity,ID) VALUES(?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = this.connect();
        PreparedStatement prepState = conn.prepareStatement(sql)) {
            prepState.setInt(1, frame);
            prepState.setString(2, type);
            prepState.setInt(3, death);
            prepState.setInt(4, posX);
            prepState.setInt(5, posY);
            prepState.setInt(6, width);
            prepState.setInt(7, height);
            prepState.setInt(8, delay);
            prepState.setInt(9, opacity);
            prepState.setInt(10, ID);
            prepState.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * http://www.sqlitetutorial.net/sqlite-java/select/
     */
    public void selectAll(String tabname){
        String sql = "SELECT frame, type, death, posX, posY, width, height, delay, opacity, ID FROM " + tabname;

        try (Connection conn = this.connect();
        Statement stmt  = conn.createStatement();
        ResultSet resset    = stmt.executeQuery(sql)){
            System.out.println("frame,\t type,\t death,\t posX,\t posY,\t width,\t height, delay,\t opacity,ID");
            // loop through the result set
            while (resset.next()) {
                System.out.print(
                    "|"+resset.getInt("frame")+"\t"+
                    "|"+resset.getString("type")+"\t"+
                    "|"+resset.getInt("death")+"\t"+
                    "|"+resset.getInt("posX")+"\t"+
                    "|"+resset.getInt("posY")+"\t"+
                    "|"+resset.getInt("width")+"\t"+
                    "|"+resset.getInt("height")+"\t"+ 
                    "|"+resset.getInt("delay")+"\t"+
                    "|"+resset.getInt("opacity")+"\t"+
                    "|"+resset.getInt("ID")+"\n"
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * http://www.sqlitetutorial.net/sqlite-java/update/
     */
    public void update(int ID,int frame, String type, int death, int posX, int posY, int width ,int height, int delay, int opacity, String tabname) {
        String sql = "UPDATE "+tabname+" SET name = ? , "
            + "type = ? "
            + "death = ? "
            + "posX = ? "
            + "posY = ? "
            + "width = ? "
            + "height = ? "
            + "delay = ? "
            + "opacity = ? "
            + "WHERE ID = ?";

        try (Connection conn = this.connect();
        PreparedStatement prepState = conn.prepareStatement(sql)) {

            // set the corresponding param
            prepState.setInt(1, frame);
            prepState.setString(2, type);
            prepState.setInt(3, death);
            prepState.setInt(4, posX);
            prepState.setInt(5, posY);
            prepState.setInt(6, width);
            prepState.setInt(7, height);
            prepState.setInt(8, delay);
            prepState.setInt(9, opacity);
            prepState.setInt(10, ID);
            // update 
            prepState.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * http://www.sqlitetutorial.net/sqlite-java/delete/
     */
    public void delete(int ID,String tabname) {
        String sql = "DELETE FROM " + tabname + " WHERE ID = ?";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setInt(1, ID);
            // execute the delete statement
            pstmt.executeUpdate();
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
