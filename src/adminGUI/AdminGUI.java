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
	private JTextField txtImie;
	private JTextField txtIdPracownika;
	private JTextField txtDateStart;
	private JTextField txtDateEnd;
	private JPanel panel;
	private JTable table;
	private JPanel panel_1;
	private JButton btnRefresh;
	private JTextField txtNazwisko;

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

		JCheckBox chckbxTylkoLogiMoliwie = new JCheckBox(
				"tylko logi mo\u017Cliwie b\u0142\u0119dne");
		chckbxTylkoLogiMoliwie.setFont(new Font("Tahoma", Font.PLAIN, 9));
		chckbxTylkoLogiMoliwie.setBounds(249, 40, 151, 23);
		panel_filtry.add(chckbxTylkoLogiMoliwie);
		
		txtNazwisko = new JTextField();
		txtNazwisko.setText("nazwisko");
		txtNazwisko.setBounds(132, 11, 100, 19);
		panel_filtry.add(txtNazwisko);
		txtNazwisko.setColumns(10);

		panel = new JPanel();
		panel.setBounds(6, 102, 531, 442);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		table = new JTable();
		table.setBounds(0, 22, 511, 420);
		panel.add(table);

		panel_1 = new JPanel();
		panel_1.setBounds(586, 31, 211, 271);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JButton btnZarzdzajPracownikami = new JButton(
				"Zarz\u0105dzaj pracownikami");
		btnZarzdzajPracownikami.setBounds(0, 12, 199, 23);
		panel_1.add(btnZarzdzajPracownikami);

		JButton btnZarzdzajDepartamentami = new JButton(
				"Zarz\u0105dzaj departamentami");
		btnZarzdzajDepartamentami.setBounds(0, 46, 199, 23);
		panel_1.add(btnZarzdzajDepartamentami);

		JButton btnZarzdzajLoggerami = new JButton("Zarz\u0105dzaj loggerami");
		btnZarzdzajLoggerami.setBounds(0, 80, 199, 23);
		panel_1.add(btnZarzdzajLoggerami);

		btnRefresh = new JButton("Odśwież");
		btnRefresh.setBounds(0, 147, 199, 23);
		panel_1.add(btnRefresh);
	}
}
