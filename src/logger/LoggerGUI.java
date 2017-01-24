/**
 * 
 */
package logger;

import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.Date;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import utils.DBConnection;

/**
 * @author x
 */
public class LoggerGUI
{

	private JFrame frame;
	private JTextField txtIdPrac;
	private static DBConnection dbc;
	private static String loggerID;
	private Choice typLogu;
	private JLabel lblLampka;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		String help = "usage: <db ip> <logger id>";
		if(args.length != 2)
		{
			System.out.println(help);
			System.exit(1);
		}
		loggerID = args[1];
		dbc = new DBConnection(args[0]);
		if(!dbc.loggerExists(Integer.valueOf(args[1])))
			System.exit(2);
		
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					LoggerGUI window = new LoggerGUI();
					window.frame.setVisible(true);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoggerGUI()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 502, 427);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 466, 367);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblLoggerId = new JLabel("Logger ID");
		lblLoggerId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLoggerId.setBounds(10, 11, 84, 20);
		panel.add(lblLoggerId);

		JLabel label = new JLabel("");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(263, 11, 91, 20);
		panel.add(label);
		label.setText(loggerID);

		typLogu = new Choice();
		typLogu.setBounds(10, 49, 203, 20);
		panel.add(typLogu);
		String[] loggsType = dbc.getEventTypes();
		for(int i = 0; i< loggsType.length;i++)
			typLogu.add(loggsType[i]);

		txtIdPrac = new JTextField();
		txtIdPrac.setBounds(380, 49, 86, 20);
		panel.add(txtIdPrac);
		txtIdPrac.setColumns(10);

		JButton btnJustDoIt = new JButton("Zatwierdź");
		btnJustDoIt.addActionListener(new AbstractAction() {


	        /**
			 * 
			 */
			private static final long serialVersionUID = -804237937006436793L;

			@Override
	        public void actionPerformed(ActionEvent arg0) {
	             //UPDATE the JTree 
				//dbc.addEvent(date, employeeID, loggerID, eventType)
				java.util.Date currentDate = new java.util.Date();
				Date currentDateSQL = new Date(currentDate.getTime());
				boolean possibleError = dbc.addEvent(currentDateSQL, txtIdPrac.getText(), Integer.parseInt(loggerID), typLogu.getSelectedItem());
				if(possibleError)
				{
					lblLampka.setText("Możliwy Błąd");
				}
				else
				{
					lblLampka.setText("OK");
				}
	        }
			


	    });
		btnJustDoIt.setBounds(106, 208, 107, 41);
		panel.add(btnJustDoIt);

		lblLampka = new JLabel("Lampka");
		lblLampka.setBounds(308, 235, 46, 14);
		panel.add(lblLampka);
		
		JLabel lblIdPracownika = new JLabel("Id Pracownika:");
		lblIdPracownika.setBounds(220, 54, 150, 15);
		panel.add(lblIdPracownika);
	}
}
