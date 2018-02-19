package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;

import controller.APFController;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;


public class APFParceirosView {

	public JFrame frame;
	private JTable table;
	private JTextField txtFiltro;
	private final ButtonGroup buttonGroup = new ButtonGroup();


	/**
	 * Create the application.
	 */
	public APFParceirosView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 555, 548);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setBounds(20, 103, 516, 387);
		frame.getContentPane().add(table);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setBounds(419, 37, 117, 29);
		frame.getContentPane().add(btnFiltrar);
		
		txtFiltro = new JTextField();
		txtFiltro.setText("Filtro");
		txtFiltro.setBounds(334, 6, 202, 26);
		frame.getContentPane().add(txtFiltro);
		txtFiltro.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(28, 7, 141, 58);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnDistrito = new JRadioButton("Distrito");
		buttonGroup.add(rdbtnDistrito);
		rdbtnDistrito.setSelected(true);
		rdbtnDistrito.setBounds(0, 0, 141, 23);
		panel.add(rdbtnDistrito);
		
		JRadioButton rdbtnLocalidade = new JRadioButton("Localidade");
		buttonGroup.add(rdbtnLocalidade);
		rdbtnLocalidade.setBounds(0, 35, 141, 23);
		panel.add(rdbtnLocalidade);

	}
}
