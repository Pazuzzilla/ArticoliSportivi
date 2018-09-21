package Magazzino;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;



public class GestioneUsciteView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();
	private GestioneUsciteController guc;
	private GestioneUsciteModel gum;

	/**
	 * Launch the application.
	 */
/*	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestioneUsciteView frame = new GestioneUsciteView();
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
	public GestioneUsciteView(GestioneUsciteController guc, GestioneUsciteModel gum) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1115, 614);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 95, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 35, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, 392, SpringLayout.WEST, contentPane);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Numero Ordine", "Codice Negozio"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnVisualizza = new JButton("Visualizza");
		btnVisualizza.setAction(action);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnVisualizza, 416, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnVisualizza, -95, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, -84, SpringLayout.NORTH, btnVisualizza);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnVisualizza, 139, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnVisualizza, 279, SpringLayout.WEST, contentPane);
		contentPane.add(btnVisualizza);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane_1, 43, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane_1, 152, SpringLayout.EAST, scrollPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane_1, -109, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane_1, -21, SpringLayout.EAST, contentPane);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Codice Ordine", "Codice Negozio", "Articolo", "Numero Pezzi", "Data"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JButton btnEliminaOrdine = new JButton("Elimina Ordine");
		btnEliminaOrdine.setAction(action_1);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnEliminaOrdine, -60, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnEliminaOrdine, -521, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnEliminaOrdine, -27, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnEliminaOrdine, -390, SpringLayout.EAST, contentPane);
		contentPane.add(btnEliminaOrdine);
		
		JButton btnSpedisci = new JButton("Spedisci");
		btnSpedisci.setAction(action_2);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnSpedisci, -16, SpringLayout.NORTH, btnEliminaOrdine);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnSpedisci, -245, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnSpedisci, -11, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnSpedisci, -84, SpringLayout.EAST, contentPane);
		contentPane.add(btnSpedisci);
	}
	
	
	public void run() {
		try {
			setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Carica Ordine");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Elimina");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "Spedisci");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}

/*
	public void updateT() {
		int j;
		int i = 0;
		List <Integer> l = new ArrayList();
		l = gum.getOrdini();
		table.setModel(new DefaultTableModel(new Object[i][2], new String[]{"Ordine", "Codice Negozio"}));
		
		int[][]ordineUscita;

		for (j=0;j<i;j++){

			table.setValueAt(l[j][0],j,0);
			table.setValueAt(l[j][1],j,1);
			table.set
		}
	}
	
	*/
}
