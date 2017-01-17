package adminGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JTextArea;

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
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public ManageDeps() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBounds(10, 10, 600, 20);
		contentPane.add(horizontalBox);
		
		txtId = new JTextField();
		horizontalBox.add(txtId);
		txtId.setText("id");
		txtId.setColumns(10);
		
		txtDeptName = new JTextField();
		horizontalBox.add(txtDeptName);
		txtDeptName.setText("Nazwa");
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
		
		txtId_1 = new JTextField();
		txtId_1.setText("id");
		horizontalBox_1.add(txtId_1);
		txtId_1.setColumns(10);
		
		JButton btnUsuPracownika = new JButton("Usuń departament");
		horizontalBox_1.add(btnUsuPracownika);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 75, 600, 200);
		contentPane.add(textArea);
	}

}
