package utils;
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
		myConnection = DriverManager.getConnection("jdbc:oracle:thin:@"+address+":1521:orakyl", "bd2_project", password);
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
public boolean addEvent(Date date, String employeeID, int loggerID, String eventType)
{
	String insert_sql = "insert into Event_Log (LOG_DATE, EVENT_TYPE, LOGGER_ID, EMPLOYEE_ID) values (TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS'), ?, ?, ?)";
	String getlast_sql = "select * from event_log where log_id in (select max(log_id) from event_log)";
	try { 
		PreparedStatement prst = myConnection.prepareStatement(insert_sql);
		prst.setDate(1, date);
		prst.setString(2, eventType);
		prst.setInt(3, loggerID);
		prst.setString(4, employeeID);
		prst.execute();
		PreparedStatement stm = myConnection.prepareStatement(getlast_sql);
		ResultSet rs = stm.executeQuery();
		rs.next();
		return rs.getInt("possible_error") == 1;
	}
	catch(SQLException ex)
	{
		ex.printStackTrace();
		return false;
	}
}

public boolean loggerExists(int loggerID)
{
	String sql = "select * from logger where logger_id = ?";
	try {
		PreparedStatement prst = myConnection.prepareStatement(sql);
		prst.setInt(1, loggerID);
		ResultSet rs = prst.executeQuery();
		return rs.next();
	}
	catch(SQLException ex)
	{
		ex.printStackTrace();
	}
	return false;
}

public String[] getEventTypes()
{
	String sql = "select event_type from event_type";
	String[] eventTypes = new String[4];
	try {
		PreparedStatement prst = myConnection.prepareStatement(sql);
		ResultSet rs = prst.executeQuery();
		for(int i = 0; i < 4 && rs.next(); ++i)
		{
			eventTypes[i] = rs.getString("event_type");
		}
	}
	catch(SQLException ex)
	{
		ex.printStackTrace();
	}
	return eventTypes;
}

public String getLogs(String name, String surname, String employeeID, String loggerID, Date afterDate, Date beforeDate, boolean possibleError)
{
	String columnNames = "ID PRACOWNIKA|        IMIĘ|    NAZWISKO|      PESEL|ID DEPT-u|OSTATNIE ZDARZENIE| ID LOGU|       DATA I GODZINA|BŁĄD|       ZDARZENIE|ID LOGGERA|";
	String resultFormatString = "%13s|%12s|%12s|%11s|%9s|%18s|%8s|%21s|%4s|%16s|%10s|";
	String results = columnNames;
	String sql = "select * from employee natural join event_log where ";
	String sql_name = "first_name = ? ";
	int name_id = 0;
	String sql_surname = "surname = ? ";
	int surname_id = 0;
	String sql_employeeID = "employee_ID = ? ";
	int employeeid_id = 0;
	String sql_loggerID = "logger_id = ? ";
	int loggerid_id = 0;
	String sql_possible_error = "possible_error = 1 ";
	String sql_after_date = "log_date > TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS') ";
	int afterdate_id = 0;
	String sql_before_date = "log_date < TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS') ";
	int beforedate_id = 0;
	
	int globalid = 1;
	
	if(name != null && name != "")
	{
		sql += sql_name;
		name_id = globalid++;
	}
	if(surname != null && surname != "")
	{
		if(globalid > 1)
			sql += "AND ";
		sql += sql_surname;
		surname_id = globalid++;
	}
	if(employeeID != null && employeeID != "")
	{
		if(globalid > 1)
			sql += "AND ";
		sql += sql_employeeID;
		employeeid_id = globalid++;
	}
	if(loggerID != null && loggerID != "")
	{
		if(globalid > 1)
			sql += "AND ";
		sql += sql_loggerID;
		loggerid_id = globalid++;
	}
	if(possibleError != false)
	{
		if(globalid > 1)
			sql += "AND ";
		sql += sql_possible_error;
	}
	if(beforeDate != null)
	{
		if(globalid > 1)
			sql += "AND ";
		sql += sql_before_date;
		beforedate_id = globalid++;
	}
	if(afterDate != null)
	{
		if(globalid > 1)
			sql += "AND ";
		sql += sql_after_date;
		afterdate_id = globalid++;
	}
	
	try {
		PreparedStatement prst = myConnection.prepareStatement(sql);
		if(name != null && name != "")
		{
			prst.setString(name_id, name);
		}
		if(surname != null && surname != "")
		{
			prst.setString(surname_id, surname);
		}
		if(employeeID != null && employeeID != "")
		{
			prst.setString(employeeid_id, employeeID);
		}
		if(loggerID != null && loggerID != "")
		{
			prst.setString(loggerid_id, loggerID);
		}
		if(beforeDate != null)
		{
			prst.setDate(beforedate_id, beforeDate);
		}
		if(afterDate != null)
		{
			prst.setDate(afterdate_id, afterDate);
		}
		//smacznego
		ResultSet rs = prst.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
//		String[] columns = new String[rsmd.getColumnCount()];
//		for(int i = 0; i < rsmd.getColumnCount(); ++i)
//		{
//			columns[i] = rsmd.getColumnName(i+1);
//			results += columns[i] + "|";
//			int type = rsmd.getColumnType(i+1);
//			resultFormatString += "%" + columns[i].length() + "s|";
//			
//		}
		while(rs.next())
		{
			results += "\n";
			String[] rowdata = new String[rsmd.getColumnCount()];
			for(int i = 0; i < rsmd.getColumnCount(); ++i)
			{
				rowdata[i] = rs.getString(i+1);
			}
			results += String.format(resultFormatString, (Object[])rowdata);
		}
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	
	return results;
}

}
