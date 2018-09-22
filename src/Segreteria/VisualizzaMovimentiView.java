package Segreteria;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.Action;

public class VisualizzaMovimentiView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private final Action action = new SwingAction();
	private VisualizzaMovimentiModel vMM;
	private VisualizzaMovimentiController vMC;


	/**
	 * Create the frame.
	 */
	public VisualizzaMovimentiView(VisualizzaMovimentiController vmc, VisualizzaMovimentiModel vmm) {
		setTitle("Visualizza Movimenti");
		setResizable(false);
		vMC = vmc;
		vMM = vmm;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 346, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		JLabel lblNegozioDaVisualizzare = new JLabel("Negozio da Visualizzare");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNegozioDaVisualizzare, 21, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNegozioDaVisualizzare, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNegozioDaVisualizzare, 446, SpringLayout.WEST, contentPane);
		contentPane.add(lblNegozioDaVisualizzare);

		textField = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, 6, SpringLayout.SOUTH, lblNegozioDaVisualizzare);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, 5, SpringLayout.WEST, contentPane);
		contentPane.add(textField);
		textField.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 11, SpringLayout.SOUTH, textField);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, -24, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, 306, SpringLayout.WEST, contentPane);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][]{
						{null, null}, {null, null},
						/*{null, null}, {null, null},
						{null, null}, {null, null},
						{null, null}, {null, null},
						{null, null}, {null, null},
						{null, null}, {null, null},
						{null, null}, {null, null},
						{null, null}, {null, null},
						{null, null}, {null, null},
						{null, null}, {null, null},
						{null, null}, {null, null},
						{null, null}, {null, null},
						{null, null}, {null, null},*/
				},
				new String[]{
						"Ordine", "Uscita"
				}
		));
		scrollPane.setViewportView(table);

		JButton btnVisualizza = new JButton("Visualizza");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnVisualizza, 40, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblNegozioDaVisualizzare, -3, SpringLayout.NORTH, btnVisualizza);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnVisualizza, -30, SpringLayout.EAST, contentPane);
		btnVisualizza.setAction(action);
		contentPane.add(btnVisualizza);
	}

	//fa partire la finestra
	public void run () {
		try {
			setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	//metodo che ritornera' dopo una query su database i valori da stampare
	public void visualizza(String negozio) throws SQLException {
		VisualizzaMovimentiModel vmm= vMM;
		VisualizzaMovimentiController vmc= vMC;

		vmm.setiG(negozio);
		int i=0;
		i=vmc.howMany(vmm);
		vMM.setHowMany(i);

		int[][]ordineUscita=vmc.visualizza(i,vmm);
		vMM.setOrdineUscita(ordineUscita);
	}

	// metodo che fa visualizzare la tabella con le info sugli ordini
	public void updateTable() {
		VisualizzaMovimentiModel vmm= vMM;
		VisualizzaMovimentiController vmc= vMC;
		int j;
		int i=vMM.getHowMany();
		int[][] ordineUscita=vMM.getOrdineUscita();

		//setto la nuova tabella che avra' solo le righe necessarie
		table.setModel(new DefaultTableModel(new Object[i][2], new String[]{"Ordine", "Uscita"}));


		for (j=0;j<i;j++){

			table.setValueAt(ordineUscita[j][0],j,0);
			table.setValueAt(ordineUscita[j][1],j,1);

			if (ordineUscita[j][1]==0){
				table.setValueAt("Non Evaso",j,1);
			}
		}
	}

	//classe privata per far partire il comando visualizza dopo che si e' premuto il bottone
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Visualizza");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {

			try {
				visualizza(textField.getText());
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			updateTable();
		}
	}
}