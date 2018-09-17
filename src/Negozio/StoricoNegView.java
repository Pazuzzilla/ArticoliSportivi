package Negozio;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
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

public class StoricoNegView extends JFrame {

	private JPanel contentPane;
	private JTable table;


	/**
	 * Create the frame.
	 */
	public StoricoNegView(Object[][] o) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 908, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);

		JScrollPane scrollPane = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 18, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, -24, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, 853, SpringLayout.WEST, contentPane);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Codice Negozio", "Codice Ordine", "Articolo", "Data", "Quantit\u00E0"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(86);
		updateTable(o);
		scrollPane.setViewportView(table);
	}

	//fa partire la finestra
	public void run () {
		try {
			setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	//metodo che ritornerà dopo una query su database i valori da stampare
	/*
	public void visualizza(String negozio) throws SQLException {
		StoricoNegModel vmm= vMM;
		StoricoNegController vmc= vMC;

		vmm.setiG(negozio);
		int i=0;
		i=vmc.howMany(vmm);
		vMM.setHowMany(i);

		int[][]ordineUscita=vmc.visualizza(i,vmm);
		vMM.setOrdineUscita(ordineUscita);
	}
*/
	// metodo che fa visualizzare la tabella con le info sugli ordini
	public void updateTable(Object[][] o) {
		int j;
		int i = o.length;
		
		//int i=vMM.getHowMany();

		//setto la nuova tabella che avrà solo le righe necessarie
		table.setModel(new DefaultTableModel(new Object[i][6], new String[]{"Codice Negozio", "Codice Ordine", "Articolo", "Data", "Quantit\u00E0"}));

		for (j=0;j<=i;j++){

			table.setValueAt(o[0][j],j,0);
			table.setValueAt(o[1][j],j,1);
			table.setValueAt(o[2][j],j,1);
			table.setValueAt(o[3][j],j,1);
			table.setValueAt(o[4][j],j,1);
			table.setValueAt(o[5][j],j,1);
			//table.setValueAt(arg0, arg1, arg2);
/*	
			if (ordineUscita[1][j]==0){
				table.setValueAt("non evaso",j,1);
			}
*/
		}
	}

}