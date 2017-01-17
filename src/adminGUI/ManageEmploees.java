package adminGUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class ManageEmploees extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1352418070989474154L;
	private JPanel contentPane;
	private JTextField txtImie;
	private JTextField txtNazwisko;
	private JTextField txtId;
	private JTextField txtPesel;
	private JTextField txtDeptID;
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
	public ManageEmploees() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 300);
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
		
		txtImie = new JTextField();
		horizontalBox.add(txtImie);
		txtImie.setText("imie");
		txtImie.setColumns(10);
		
		txtNazwisko = new JTextField();
		horizontalBox.add(txtNazwisko);
		txtNazwisko.setText("nazwisko");
		txtNazwisko.setColumns(10);
		
		txtPesel = new JTextField();
		txtPesel.setText("PESEL");
		horizontalBox.add(txtPesel);
		txtPesel.setColumns(10);
		
		txtDeptID = new JTextField();
		txtDeptID.setText("id działu");
		horizontalBox.add(txtDeptID);
		txtDeptID.setColumns(10);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setBounds(10, 40, 300, 20);
		contentPane.add(horizontalBox_1);
		
		txtId_1 = new JTextField();
		txtId_1.setText("id");
		horizontalBox_1.add(txtId_1);
		txtId_1.setColumns(10);
		
		JButton btnUsuPracownika = new JButton("Usuń Pracownika");
		horizontalBox_1.add(btnUsuPracownika);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBounds(630, 10, 120, 80);
		contentPane.add(verticalBox);
		
		JButton btnWyszukaj = new JButton("Wyszukaj");
		verticalBox.add(btnWyszukaj);
		
		JButton btnDodajPracownika = new JButton("Dodaj");
		verticalBox.add(btnDodajPracownika);
		
		btnModify = new JButton("Modyfikuj");
		verticalBox.add(btnModify);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 75, 600, 200);
		contentPane.add(textArea);
	}
}
