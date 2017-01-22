/**
 * 
 */
package adminGUI;

import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.Date;

import utils.DBConnection;


import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;

/**
 * @author x
 */
public class AdminGUI
{

	private JFrame frame;
	private JTextField txtImie;
	private JTextField txtIdPracownika;
	private JTextField txtDateStart;
	private JTextField txtDateEnd;
	private JPanel panel_1;
	private JButton btnRefresh;
	private JTextField txtNazwisko;
	private static DBConnection dbc;
	private JCheckBox chckbxTylkoLogiMoliwie;
	private JTextArea outTextArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		if(args.length != 2)
		{
			System.out.print("usage: admingui.java <database server IP> <db password>");
			System.exit(1);
		}
		dbc = new DBConnection(args[0], args[1]);

		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					AdminGUI window = new AdminGUI();
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
	public AdminGUI()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel_filtry = new JPanel();
		panel_filtry.setBorder(new TitledBorder(null, "JPanel title",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_filtry.setBounds(6, 11, 531, 67);
		frame.getContentPane().add(panel_filtry);
		panel_filtry.setLayout(null);

		txtImie = new JTextField();
		txtImie.setText("imie");
		txtImie.setBounds(20, 11, 100, 20);
		panel_filtry.add(txtImie);
		txtImie.setColumns(10);

		txtIdPracownika = new JTextField();
		txtIdPracownika.setText("id pracownika");
		txtIdPracownika.setBounds(257, 11, 86, 20);
		panel_filtry.add(txtIdPracownika);
		txtIdPracownika.setColumns(10);

		Choice choice_TypZdarzenia = new Choice();
		choice_TypZdarzenia.setBounds(380, 11, 141, 20);
		panel_filtry.add(choice_TypZdarzenia);

		txtDateStart = new JTextField();
		txtDateStart.setText("date start");
		txtDateStart.setBounds(20, 43, 80, 20);
		panel_filtry.add(txtDateStart);
		txtDateStart.setColumns(10);

		txtDateEnd = new JTextField();
		txtDateEnd.setText("date end");
		txtDateEnd.setBounds(132, 43, 80, 20);
		panel_filtry.add(txtDateEnd);
		txtDateEnd.setColumns(10);

		chckbxTylkoLogiMoliwie = new JCheckBox(
				"tylko logi mo\u017Cliwie b\u0142\u0119dne");
		chckbxTylkoLogiMoliwie.setFont(new Font("Tahoma", Font.PLAIN, 9));
		chckbxTylkoLogiMoliwie.setBounds(249, 40, 151, 23);
		panel_filtry.add(chckbxTylkoLogiMoliwie);
		
		txtNazwisko = new JTextField();
		txtNazwisko.setText("nazwisko");
		txtNazwisko.setBounds(132, 11, 100, 19);
		panel_filtry.add(txtNazwisko);
		txtNazwisko.setColumns(10);

		panel_1 = new JPanel();
		panel_1.setBounds(586, 10, 210, 100);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JButton btnZarzdzajPracownikami = new JButton(
				"Zarz\u0105dzaj pracownikami");
		btnZarzdzajPracownikami.setBounds(0, 0, 200, 20);
		panel_1.add(btnZarzdzajPracownikami);
		btnZarzdzajPracownikami.addActionListener(new AbstractAction() {


	        /**
			 * 
			 */
			private static final long serialVersionUID = -804233322006333793L;

			@Override
	        public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ManageEmploees frame = new ManageEmploees();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
	        }


	    });
		
		JButton btnZarzdzajDepartamentami = new JButton(
				"Zarz\u0105dzaj departamentami");
		btnZarzdzajDepartamentami.setBounds(0, 25, 200, 20);
		panel_1.add(btnZarzdzajDepartamentami);
		btnZarzdzajDepartamentami.addActionListener(new AbstractAction() {


	        /**
			 * 
			 */
			private static final long serialVersionUID = -804233388811333793L;

			@Override
	        public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ManageDeps frame = new ManageDeps();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
	        }


	    });

		JButton btnZarzdzajLoggerami = new JButton("Zarz\u0105dzaj loggerami");
		btnZarzdzajLoggerami.setBounds(0, 50, 200, 20);
		panel_1.add(btnZarzdzajLoggerami);
		btnZarzdzajLoggerami.addActionListener(new AbstractAction() {


	        /**
			 * 
			 */
			private static final long serialVersionUID = -804233388811333793L;

			@Override
	        public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ManageLoggers frame = new ManageLoggers();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
	        }


	    });

		btnRefresh = new JButton("Odśwież");
		btnRefresh.setBounds(0, 75, 200, 20);
		panel_1.add(btnRefresh);
		
		JPanel outJPanel = new JPanel();
		outJPanel.setBounds(6, 110, 900, 600);
		frame.getContentPane().add(outJPanel);

				outTextArea = new JTextArea(16, 58);
				outTextArea.setFont(new Font("DejaVu Sans Mono", Font.PLAIN, 10));
				outTextArea.setBounds(0, 0, 900, 600);
				outJPanel.add(outTextArea);
		btnRefresh.addActionListener(new AbstractAction() {


	        /**
			 * 
			 */
			private static final long serialVersionUID = -804237937006333793L;

			@Override
	        public void actionPerformed(ActionEvent arg0) {
				Date afterDate = null;
				Date beforeDate = null;
				if(txtDateStart.getText() != "")
				{
				String[] rzeczy = txtDateStart.getText().split("-");
						int year = Integer.valueOf(rzeczy[0]);
						int month = Integer.valueOf(rzeczy[1]);
						int day = Integer.valueOf(rzeczy[2]);
						afterDate = new Date(year, month, day);
				}
				if(txtDateEnd.getText() != "")
				{
				String[] rzeczy = txtDateEnd.getText().split("-");
						int year = Integer.valueOf(rzeczy[0]);
						int month = Integer.valueOf(rzeczy[1]);
						int day = Integer.valueOf(rzeczy[2]);
						beforeDate = new Date(year, month, day);
				}
	            outTextArea.setText(dbc.getLogs(txtImie.getText(), txtNazwisko.getText(), txtIdPracownika.getText(), null, afterDate, beforeDate, chckbxTylkoLogiMoliwie.isSelected())); 
				//UPDATE the JTree 
				
	        }


	    });
	}
}
