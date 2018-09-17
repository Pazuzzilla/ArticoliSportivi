package Login;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPasswordField;

public class LoginView extends JFrame{

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField textField_1;
	private final Action action = new SwingAction();
	private LoginController LoginController;
	private LoginObservedModel LoginModel;

	/**
	 * Create the frame.
	 */
	public LoginView (LoginController m,LoginObservedModel om) {
		setTitle("Articoli Sportivi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		LoginController=m;
		LoginModel=om;
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setAction(action);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnSubmit, 275, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnSubmit, -10, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnSubmit, -24, SpringLayout.EAST, contentPane);
		contentPane.add(btnSubmit);
		
		JLabel lblUsername = new JLabel("Username:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblUsername, 10, SpringLayout.NORTH, contentPane);
		contentPane.add(lblUsername);
		
		JLabel lblNewLabel = new JLabel("Password:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 24, SpringLayout.SOUTH, lblUsername);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblUsername, 0, SpringLayout.WEST, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 26, SpringLayout.WEST, contentPane);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 16, SpringLayout.EAST, lblUsername);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textField_1, -45, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textField, -11, SpringLayout.NORTH, textField_1);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField_1, 0, SpringLayout.WEST, textField);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
	


	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0));
			putValue(NAME, "Submit");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			//getText() di JButton restituisce il testo definito come etichetta del bottone
			//JOptionPane.showMessageDialog(null,"Hai premuto il pulsante: " + b.getText());
			try {
				accredita();
			} catch (ClassNotFoundException | NullPointerException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
	

	public void run() {
		try {
			setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void accredita() throws ClassNotFoundException, NullPointerException, SQLException {
		LoginController c1 =this.LoginController;
		LoginObservedModel m1=this.LoginModel;
		
		try {
			m1.setID(textField.getText());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m1.setpassw(textField_1.getText());
		boolean b=c1.accredita(m1);

		if (b==true) {
			dispose();
		}

		
	}


}
