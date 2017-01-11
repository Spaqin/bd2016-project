/**
 * 
 */
package adminGUI;

import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * @author x
 */
public class AdminGUI
{

	private JFrame frame;
	private JTextField txtImieNazwisko;
	private JTextField txtIdPracownika;
	private JTextField txtDateStart;
	private JTextField txtDateEnd;
	private JPanel panel;
	private JTable table;
	private JPanel panel_1;
	private JButton btnRefresh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
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
		frame.setBounds(100, 100, 823, 580);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel_filtry = new JPanel();
		panel_filtry.setBorder(new TitledBorder(null, "JPanel title",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_filtry.setBounds(6, 11, 299, 67);
		frame.getContentPane().add(panel_filtry);
		panel_filtry.setLayout(null);

		txtImieNazwisko = new JTextField();
		txtImieNazwisko.setText("imie nazwisko");
		txtImieNazwisko.setBounds(10, 11, 86, 20);
		panel_filtry.add(txtImieNazwisko);
		txtImieNazwisko.setColumns(10);

		txtIdPracownika = new JTextField();
		txtIdPracownika.setText("id pracownika");
		txtIdPracownika.setBounds(106, 11, 86, 20);
		panel_filtry.add(txtIdPracownika);
		txtIdPracownika.setColumns(10);

		Choice choice_TypZdarzenia = new Choice();
		choice_TypZdarzenia.setBounds(198, 11, 91, 20);
		panel_filtry.add(choice_TypZdarzenia);

		txtDateStart = new JTextField();
		txtDateStart.setText("date start");
		txtDateStart.setBounds(10, 42, 66, 20);
		panel_filtry.add(txtDateStart);
		txtDateStart.setColumns(10);

		txtDateEnd = new JTextField();
		txtDateEnd.setText("date end");
		txtDateEnd.setBounds(86, 42, 66, 20);
		panel_filtry.add(txtDateEnd);
		txtDateEnd.setColumns(10);

		JCheckBox chckbxTylkoLogiMoliwie = new JCheckBox(
				"tylko logi mo\u017Cliwie b\u0142\u0119dne");
		chckbxTylkoLogiMoliwie.setFont(new Font("Tahoma", Font.PLAIN, 9));
		chckbxTylkoLogiMoliwie.setBounds(166, 41, 133, 23);
		panel_filtry.add(chckbxTylkoLogiMoliwie);

		panel = new JPanel();
		panel.setBounds(6, 89, 531, 442);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		table = new JTable();
		table.setBounds(10, 11, 511, 420);
		panel.add(table);

		panel_1 = new JPanel();
		panel_1.setBounds(536, 31, 261, 271);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JButton btnZarzdzajPracownikami = new JButton(
				"Zarz\u0105dzaj pracownikami");
		btnZarzdzajPracownikami.setBounds(83, 24, 168, 23);
		panel_1.add(btnZarzdzajPracownikami);

		JButton btnZarzdzajDepartamentami = new JButton(
				"Zarz\u0105dzaj departamentami");
		btnZarzdzajDepartamentami.setBounds(83, 58, 168, 23);
		panel_1.add(btnZarzdzajDepartamentami);

		JButton btnZarzdzajLoggerami = new JButton("Zarz\u0105dzaj loggerami");
		btnZarzdzajLoggerami.setBounds(83, 92, 168, 23);
		panel_1.add(btnZarzdzajLoggerami);

		btnRefresh = new JButton("refresh");
		btnRefresh.setBounds(0, 40, 73, 23);
		panel_1.add(btnRefresh);
	}
}
