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

public class ManageDeps extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1352418072229474154L;
	private JPanel contentPane;
	private JTextField txtDeptName;
	private JTextField txtId;
	private JButton btnModify;
	private JTextField txtId_1;


	/**
	 * Create the frame.
	 */
	public ManageDeps() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBounds(10, 10, 600, 20);
		contentPane.add(horizontalBox);
		
		JLabel lblId = new JLabel("Id działu:");
		horizontalBox.add(lblId);
		
		txtId = new JTextField();
		horizontalBox.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nazwa działu:");
		horizontalBox.add(lblNewLabel);
		
		txtDeptName = new JTextField();
		horizontalBox.add(txtDeptName);
		txtDeptName.setColumns(10);
		
		JButton btnWyszukaj = new JButton("Wyszukaj");
		horizontalBox.add(btnWyszukaj);
		
		JButton btnDodajPracownika = new JButton("Dodaj");
		horizontalBox.add(btnDodajPracownika);
		
		btnModify = new JButton("Modyfikuj");
		horizontalBox.add(btnModify);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setBounds(10, 40, 300, 20);
		contentPane.add(horizontalBox_1);
		
		JLabel lblNewLabel_1 = new JLabel("Id:");
		horizontalBox_1.add(lblNewLabel_1);
		
		txtId_1 = new JTextField();
		horizontalBox_1.add(txtId_1);
		txtId_1.setColumns(10);
		
		JButton btnUsuPracownika = new JButton("Usuń dział");
		horizontalBox_1.add(btnUsuPracownika);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 75, 600, 200);
		contentPane.add(textArea);
	}
}
