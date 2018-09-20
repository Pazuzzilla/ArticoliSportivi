package lib;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Negozio extends JFrame {

	private JPanel contentPane;
	private boolean neworder; 

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Negozio frame = new Negozio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public Negozio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		

		
		//il bottone fa partire la finestra di nuovo ordine che si trova gia' pronta nel costruttore
		JButton btnNewButton = new JButton("Nuovo Ordine");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Nuovo_Ordine myfrnewo=new Nuovo_Ordine();
				myfrnewo.run();
				
				while(myfrnewo.isVisible()){
					System.out.println("x");
					
				}
			
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnEffettuaOrdine = new JButton("Ordini effettuati");
		contentPane.add(btnEffettuaOrdine);
	}
	
	
	public void setNO(boolean b) {
		neworder=b;
	}
	public boolean getNO() {
		boolean b=this.neworder;
		return b;
	}
	
	public void run() {
		try {
			setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
