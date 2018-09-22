
package Magazzino;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;

public class MagazzinoView extends JFrame {

	private JPanel contentPane;
	private final Apripannello action = new Apripannello();
	private final Action action_1 = new SwingAction();
	private final Action action_2 = new SwingAction_1();
	private MagazzinoController mC;


	/**
	 * Create the frame.
	 */
	public MagazzinoView(MagazzinoController mc) {
		setResizable(false);

		mC = mc;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 194);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnInserireNuovoArticolo = new JButton("New button");
		btnInserireNuovoArticolo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInserireNuovoArticolo.setBounds(4, 6, 197, 109);
		btnInserireNuovoArticolo.setAction(action);
		contentPane.add(btnInserireNuovoArticolo);
		
		JButton btnVisualizzaMovimentiMagazzino = new JButton("New button");
		btnVisualizzaMovimentiMagazzino.setBounds(213, 6, 231, 109);
		btnVisualizzaMovimentiMagazzino.setAction(action_1);
		contentPane.add(btnVisualizzaMovimentiMagazzino);
		
		JLabel label = new JLabel("");
		label.setBounds(5, 70, 440, 32);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setAction(action_2);
		btnNewButton.setBounds(6, 127, 438, 39);
		contentPane.add(btnNewButton);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(5, 134, 440, 32);
		contentPane.add(label_1);
		/*btnInserireNuovoArticolo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});*/
	}
	
	public void run() {
		try {
			setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void openVMM() {
		MagazzinoController c1 =this.mC;
		
		//c1.openVMM();
	}

	public void openGI() {
		MagazzinoController c1 =this.mC;

		c1.openGI();
	}




	//Azione per far Partire l'inerfaccia di nuovoarticolo
	private class Apripannello extends AbstractAction {
		public Apripannello() {
			putValue(NAME, "Gestione Ingressi");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			openGI();
		}
	}
	
	//Azione per aprire l'interfaccia di visualizzazzione di un ordine in base al negozio
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Gestione Uscite");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			mC.openGU();
		}
	}


	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Gestione Posizioni");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {

			mC.openGA();
		}
	}
}
