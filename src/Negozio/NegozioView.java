package Negozio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Login.LoginController;
import Login.LoginObservedModel;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class NegozioView extends JFrame {

	private JPanel contentPane;
	private NegozioController NegozioController;
	private NegozioModel NegozioModel;
	private final VisOrd action = new VisOrd();
	private final Action visOrd = new SwingAction();


	/**
	 * Create the frame.
	 */
	public NegozioView(NegozioController sc, NegozioModel sm) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		NegozioController=sc;
		NegozioModel=sm;
		contentPane.setLayout(null);
		
		JButton btnStorico = new JButton("Storico");
		btnStorico.setBounds(5, 5, 197, 253);
		contentPane.add(btnStorico);
		btnStorico.setAction(action);
		
		JButton btnOrdine = new JButton("Ordine");
		btnOrdine.setBounds(229, 5, 197, 253);
		btnOrdine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.add(btnOrdine);
		btnOrdine.setAction(visOrd);
	}
	
	//funzione per far partire
	public void run() {
		try {
			setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void openNO() {
		NegozioController o1 =this.NegozioController;
		
		o1.newOrdine();
	}
	
	public void openVS() {
		NegozioController c1 =this.NegozioController;
		
		c1.openStorico();
	}
	
	
	
	//Azione per far Partire l'inerfaccia di nuovoarticolo
	private class VisOrd extends AbstractAction {
		public VisOrd() {
			putValue(NAME, "Ordine");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		 openNO();
		}
	}
	
	//Azione per aprire l'interfaccia di visualizzazzione di un ordine in base al negozio
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Storico");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
			openVS();
		}
	}
	
	
}
