import java.sql.*;

public class DBConnection {
private Driver myDriver;
private Connection myConnection;
public DBConnection(String address) {
	try {
		   Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException ex) {
		   System.out.println("Error: unable to load driver class!");
		   System.exit(1);
		}
	try {
		   myDriver = new oracle.jdbc.driver.OracleDriver();
		   DriverManager.registerDriver( myDriver );
		}
		catch(SQLException ex) {
		   System.out.println("Error: unable to load driver class!");
		   System.exit(1);
		}
	try {
		myConnection = DriverManager.getConnection("jdbc:oracle:thin:@"+address+":1521:orakyl", "bd2_project", "topkek");
		}
		catch(SQLException ex)
		{
			System.out.println("connection error or wrong username/passwd");
			ex.printStackTrace();
			System.exit(1);
}
}
public DBConnection(String address, String password){
	try {
		   Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException ex) {
		   System.out.println("Error: unable to load driver class!");
		   System.exit(1);
		}
	try {
		   myDriver = new oracle.jdbc.driver.OracleDriver();
		   DriverManager.registerDriver( myDriver );
		}
		catch(SQLException ex) {
		   System.out.println("Error: unable to load driver class!");
		   System.exit(1);
		}
	try {
		myConnection = DriverManager.getConnection("jdbc:oracle:thin//"+address+":1521:orakyl", "bd2_project", password);
		}
		catch(SQLException ex)
		{
			System.out.println("connection error or wrong username/passwd");
			ex.printStackTrace();
			System.exit(1);
		}
}
/**
 * @param date
 * @param employeeID
 * @param loggerID
 * @param eventType
 * @return czy był błąd
 */
public boolean addEvent(Date date, String employeeID, String loggerID, String eventType)
{
	String insert_sql = "insert into Event_Log (LOG_DATE, EVENT_TYPE, LOGGER_ID, EMPLOYEE_ID) values (TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS'), ?, ?, ?)";
	String getlast_sql = "select * from event_log where log_id in (select max(log_id) from event_log)";
	try { 
		PreparedStatement prst = myConnection.prepareStatement(insert_sql);
		prst.setDate(1, date);
		prst.setString(2, eventType);
		prst.setString(3, loggerID);
		prst.setString(4, employeeID);
		prst.execute();
		PreparedStatement stm = myConnection.prepareStatement(getlast_sql);
		ResultSet rs = stm.executeQuery();
		int column = rs.findColumn("possible_error");
		rs.next();
		return rs.getInt(column) == 1;
	}
	catch(SQLException ex)
	{
		ex.printStackTrace();
		return false;
	}
}



}
