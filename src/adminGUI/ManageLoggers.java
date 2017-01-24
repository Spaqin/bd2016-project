package adminGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class ManageLoggers extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1352418070989555154L;
	private JPanel contentPane;
	private JTextField txtId;
	private JButton btnModify;
	private JTextField txtIdLoggera;
	private JTextField txtDeptId;


	/**
	 * Create the frame.
	 */
	public ManageLoggers() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBounds(10, 10, 600, 20);
		contentPane.add(horizontalBox);
		
		JLabel lblNewLabel = new JLabel("Id:");
		horizontalBox.add(lblNewLabel);
		
		txtId = new JTextField();
		horizontalBox.add(txtId);
		txtId.setColumns(10);
		
		JButton btnWyszukaj = new JButton("Wyszukaj");
		horizontalBox.add(btnWyszukaj);
		
		JButton btnDodajPracownika = new JButton("Dodaj");
		horizontalBox.add(btnDodajPracownika);
		
		btnModify = new JButton("Modyfikuj");
		horizontalBox.add(btnModify);
		
		JButton btnUsuPracownika = new JButton("Usuń Logger");
		horizontalBox.add(btnUsuPracownika);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 70, 600, 200);
		contentPane.add(textArea);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		horizontalBox_2.setBounds(10, 40, 600, 20);
		contentPane.add(horizontalBox_2);
		
		JLabel lblNewLabel_1 = new JLabel("Id loggera:");
		horizontalBox_2.add(lblNewLabel_1);
		
		txtIdLoggera = new JTextField();
		horizontalBox_2.add(txtIdLoggera);
		txtIdLoggera.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Id działu:");
		horizontalBox_2.add(lblNewLabel_2);
		
		txtDeptId = new JTextField();
		horizontalBox_2.add(txtDeptId);
		txtDeptId.setColumns(10);
		
		JButton btnDodajPowizanie = new JButton("Dodaj powiązanie");
		horizontalBox_2.add(btnDodajPowizanie);
		
		JButton btnDelConn = new JButton("Usuń powiązanie");
		horizontalBox_2.add(btnDelConn);
	}
}
