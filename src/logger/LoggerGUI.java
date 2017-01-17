/**
 * 
 */
package logger;

import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author x
 */
public class LoggerGUI
{

	private JFrame frame;
	private JTextField txtIdPrac;

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

		JLabel label = new JLabel("< z args. >");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(263, 11, 91, 20);
		panel.add(label);

		Choice choice = new Choice();
		choice.setBounds(10, 49, 203, 20);
		panel.add(choice);

		txtIdPrac = new JTextField();
		txtIdPrac.setText("id prac.");
		txtIdPrac.setBounds(263, 49, 86, 20);
		panel.add(txtIdPrac);
		txtIdPrac.setColumns(10);

		JButton btnJustDoIt = new JButton("Zatwierdź");
		btnJustDoIt.setBounds(106, 208, 107, 41);
		panel.add(btnJustDoIt);

		JLabel lblLampka = new JLabel("Lampka");
		lblLampka.setBounds(308, 235, 46, 14);
		panel.add(lblLampka);
	}
}
