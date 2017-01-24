package adminGUI;

import utils.DBConnection;
import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.sql.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;

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
	private JLabel lblId;
	private JLabel lblImi;
	private JLabel lblNazwisko;
	private JLabel lblNewLabel;
	private JTextArea textArea;
	private DBConnection dbc;
	/**
	 * Create the frame.
	 */
	public ManageEmploees(DBConnection dbc) {
		this.dbc = dbc;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBounds(10, 10, 600, 20);
		contentPane.add(horizontalBox);
		
		lblId = new JLabel("ID:");
		horizontalBox.add(lblId);
		
		txtId = new JTextField();
		horizontalBox.add(txtId);
		txtId.setColumns(10);
		
		lblImi = new JLabel("Imię:");
		horizontalBox.add(lblImi);
		
		txtImie = new JTextField();
		horizontalBox.add(txtImie);
		txtImie.setColumns(10);
		
		lblNazwisko = new JLabel("Nazwisko");
		horizontalBox.add(lblNazwisko);
		
		txtNazwisko = new JTextField();
		horizontalBox.add(txtNazwisko);
		txtNazwisko.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("PESEL:");
		horizontalBox.add(lblNewLabel_1);
		
		txtPesel = new JTextField();
		horizontalBox.add(txtPesel);
		txtPesel.setColumns(10);
		
		lblNewLabel = new JLabel("Id działu:");
		horizontalBox.add(lblNewLabel);
		
		txtDeptID = new JTextField();
		horizontalBox.add(txtDeptID);
		txtDeptID.setColumns(10);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		horizontalBox_1.setBounds(10, 40, 300, 20);
		contentPane.add(horizontalBox_1);
		
		JLabel lblId_1 = new JLabel("ID:");
		horizontalBox_1.add(lblId_1);
		
		txtId_1 = new JTextField();
		horizontalBox_1.add(txtId_1);
		txtId_1.setColumns(10);
		
		JButton btnUsuPracownika = new JButton("Usuń Pracownika");
		horizontalBox_1.add(btnUsuPracownika);
		
		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBounds(630, 10, 120, 80);
		contentPane.add(verticalBox);
		
		JButton btnWyszukaj = new JButton("Wyszukaj");
		verticalBox.add(btnWyszukaj);
		btnWyszukaj.addActionListener(new AbstractAction() {


	        /**
			 * 
			 */
			private static final long serialVersionUID = -804237937006333793L;

			@Override
	        public void actionPerformed(ActionEvent arg0) {
				Date afterDate = null;
				Date beforeDate = null;
	            textArea.setText(dbc.getEmployees(txtImie.getText(), txtNazwisko.getText(), txtId.getText()));
				//UPDATE the JTree 
				
	        }


	    });
		
		JButton btnDodajPracownika = new JButton("Dodaj");
		verticalBox.add(btnDodajPracownika);
		btnDodajPracownika.addActionListener(new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dbc.insertEmployee(txtId.getText(), txtImie.getText(), txtNazwisko.getText(), txtPesel.getText(), txtDeptID.getText());
			}
		});
		
		btnModify = new JButton("Modyfikuj");
		verticalBox.add(btnModify);
		
		btnModify.addActionListener(new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dbc.updateEmployee(txtId.getText(), txtImie.getText(), txtNazwisko.getText(), txtPesel.getText(), txtDeptID.getText());
			}
		});
		
		textArea = new JTextArea();
		textArea.setBounds(10, 75, 600, 200);
		contentPane.add(textArea);
	}
}
