package adminGUI;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.DBConnection;

import javax.swing.JTextField;
import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;

public class ManageLoggers extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1352418070989555154L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtIdLoggera;
	private JTextField txtDeptId;
	//private DBConnection dbc;
	private JTextArea textArea;


	/**
	 * Create the frame.
	 */
	public ManageLoggers(final DBConnection dbc) {
		//this.dbc = dbc;
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
		btnWyszukaj.addActionListener(new AbstractAction() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 65423611655L;

			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.setText(dbc.getLoggers(txtId.getText()));
			}
		});
		
		JButton btnDodajPracownika = new JButton("Dodaj");
		horizontalBox.add(btnDodajPracownika);
		btnDodajPracownika.addActionListener(new AbstractAction() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 65427773655L;

			@Override
			public void actionPerformed(ActionEvent e) {
				dbc.addLogger(txtId.getText());
			}
		});
		
		JButton btnUsuPracownika = new JButton("Usuń Logger");
		horizontalBox.add(btnUsuPracownika);
		btnUsuPracownika.addActionListener(new AbstractAction() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 65423699955L;

			@Override
			public void actionPerformed(ActionEvent e) {
				dbc.removeLoggerAndConnections(txtId.getText());
			}
		});
		
		textArea = new JTextArea();
		textArea.setFont(new Font("DejaVu Sans Mono", Font.PLAIN, 10));
		textArea.setBounds(10, 70, 600, 500);
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
		btnDodajPowizanie.addActionListener(new AbstractAction() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 65423643655L;

			@Override
			public void actionPerformed(ActionEvent e) {
				dbc.connectLogger(txtIdLoggera.getText(), txtDeptId.getText());
			}
		});
		
		JButton btnDelConn = new JButton("Usuń powiązanie");
		horizontalBox_2.add(btnDelConn);
	}
}
