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
		scrollPane.setEnabled(false);
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 18, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, -24, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, 883, SpringLayout.WEST, contentPane);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Codice Negozio", "Codice Ordine", "Articolo", "Numero Pezzi", "Data","Prezzo totale"
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



	// metodo che fa visualizzare la tabella con le info sugli ordini
	public void updateTable(Object[][] o) {
		int j;
		int i = o.length;
		

		//setto la nuova tabella che avra' solo le righe necessarie
		table.setModel(new DefaultTableModel(new Object[i][6], new String[]{"Codice Ordine","Codice Negozio", "Articolo", "Numero Pezzi", "Data","Prezzo totale"}));

		for (j=0;j<i;j++){

			table.setValueAt(o[j][0],j,0);
			table.setValueAt(o[j][1],j,1);
			table.setValueAt(o[j][2],j,2);
			table.setValueAt(o[j][3],j,3);
			table.setValueAt(o[j][4],j,4);
			table.setValueAt(o[j][5],j,5);

		}
	}

}