import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;
import java.sql.*;

/**
 * Level Datenbank
 *
 * @author Nicolas Lisgaras
 * @version 03.07.19
 */
public class LevelDatabase
{
    public static String prefix = "jdbc:sqlite:";
    public static String DBsuffix = ".db";
    public static String DBname = "Leveldata";
    public static String Tname = "Level1";

    LevelDatabase(){
        //leer
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
    
    /**
     * Erstellt eine Verbindung
     * 
     * @return Connection verbindungs referenz
     */
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
    public void createNewTable( ) {
        // SQLite connection string
        String url = prefix+DBname+DBsuffix;

        // SQL statement for creating a new table
        String tabelle = "CREATE TABLE IF NOT EXISTS "+Tname+"(" 
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
    public void insert(int ID, int frame, String type, int death, int posX, int posY, int width, int height, int delay, int opacity)
    {
        String sql = "INSERT INTO " + Tname + "(frame,type,death,posX,posY,width,height,delay,opacity,ID) VALUES(?,?,?,?,?,?,?,?,?,?)";

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
    public void selectAll( ){
        String sql = "SELECT frame, type, death, posX, posY, width, height, delay, opacity, ID FROM " + Tname;

        try (Connection conn = this.connect();
        Statement stmt  = conn.createStatement();
        ResultSet rs    = stmt.executeQuery(sql)){
            System.out.println("frame,\t type,\t death,\t posX,\t posY,\t width,\t height, delay,\t opacity,ID");
            // loop through the result set
            while (rs.next()) {
                System.out.print(
                    "|"+rs.getInt("frame")+"\t"+
                    "|"+rs.getString("type")+"\t"+
                    "|"+rs.getInt("death")+"\t"+
                    "|"+rs.getInt("posX")+"\t"+
                    "|"+rs.getInt("posY")+"\t"+
                    "|"+rs.getInt("width")+"\t"+
                    "|"+rs.getInt("height")+"\t"+ 
                    "|"+rs.getInt("delay")+"\t"+
                    "|"+rs.getInt("opacity")+"\t"+
                    "|"+rs.getInt("ID")+"\n"
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * gibt größe der datenbank aus (ausgenommen ID -1 und negativen ID generell.) BEGINNT BEI 0
     * 
     * @return int gesuchter wert
     */
    public int getSize(){
        String sql = "SELECT frame, type, death, posX, posY, width, height, delay, opacity, ID FROM " + Tname;
        int i = 0;

        try (Connection conn = this.connect();
        Statement stmt  = conn.createStatement();
        ResultSet rs    = stmt.executeQuery(sql)){
            // loop through the result set
            while (rs.next()) {
                i++;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return i;
    }
    
    /**
     * @param select spalte die ausgewählt wird
     * @param ID position/ID, datenbank schlüssel siehe L. 101
     * 
     * @return String gesuchter wert
     */
    public String selectString(String select,int ID){
        String sql = "SELECT "+select+", ID FROM " + Tname;
        String IDs = Integer.toString(ID);

        try (Connection conn = this.connect();
        Statement stmt  = conn.createStatement();
        ResultSet rs    = stmt.executeQuery(sql)){
            // loop through the result set
            while (rs.next()) {
                if(rs.getInt("ID")==ID){ 
                    return rs.getString(select);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return "error";
        }
        return"eof";
    }
    
    /**
     * @param select spalte die ausgewählt wird
     * @param ID position/ID, datenbank schlüssel siehe L. 101
     * 
     * @return int gesuchter wert
     */
    public int selectInt(String select,int ID){
        String sql = "SELECT "+select+", ID FROM " + Tname;
        String IDs = Integer.toString(ID);

        try (Connection conn = this.connect();
        Statement stmt  = conn.createStatement();
        ResultSet rs    = stmt.executeQuery(sql)){
            // loop through the result set
            while (rs.next()) {
                if(rs.getInt("ID")==ID){ 
                    return rs.getInt(select);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        }
        return -1; 
    }

    /**
     * http://www.sqlitetutorial.net/sqlite-java/update/
     */
    public void update(int ID,int frame, String type, int death, int posX, int posY, int width ,int height, int delay, int opacity) {
        String sql = "UPDATE "+Tname+" SET name = ? , "
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
    public void delete(int ID) {
        String sql = "DELETE FROM " + Tname + " WHERE ID = ?";

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
