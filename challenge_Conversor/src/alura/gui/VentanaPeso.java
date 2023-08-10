package alura.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPeso extends JFrame {

	private JPanel contentPane;
	private JTextField input;
	private JTextField txtGr;
	private JTextField txtKg;
	private JTextField txtLb;
	private JTextField txtOz;

	// Se llama al constructor para iniciar la ventana
	public VentanaPeso() {
		
		setTitle("Conversor de Peso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHeader = new JLabel("");
		lblHeader.setBounds(-14, 0, 500, 100);
		lblHeader.setIcon(new ImageIcon(getClass().getResource("/alura/gui/img/header_peso.jpg")));
		contentPane.add(lblHeader);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 223, 471, 47);
		contentPane.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 12));
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panel_3.add(btnSalir);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal principal = new VentanaPrincipal();
				principal.setVisible(true);
				principal.setLocationRelativeTo(null);
				dispose();
			}
		});
		panel_3.add(btnRegresar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input.setText("");
				txtGr.setText("");
				txtKg.setText("");
				txtOz.setText("");
				txtLb.setText("");
			}
		});
		panel_3.add(btnLimpiar);
		
		JButton btnConvertir = new JButton("Convertir");
		panel_3.add(btnConvertir);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 101, 173, 122);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTipoDeUnidad = new JLabel("Tipo de unidad:");
		lblTipoDeUnidad.setBounds(43, 24, 85, 16);
		panel_1.add(lblTipoDeUnidad);
		
		JComboBox comboInput = new JComboBox();
		comboInput.setBounds(43, 43, 98, 25);
		comboInput.setModel(new DefaultComboBoxModel(new String[] {"Gramos", "Kilogramos", "Libras", "Onzas"}));
		comboInput.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
		            
		            String in = (String) comboInput.getSelectedItem();      
		            
		            if(in.equals("Gramos")) {
		            	txtGr.setEditable(false);
		            	txtKg.setEditable(true);
		            	txtLb.setEditable(true);
		            	txtOz.setEditable(true);
		            }else if(in.equals("Kilogramos")) {
		            	txtGr.setEditable(true);
		            	txtKg.setEditable(false);
		            	txtLb.setEditable(true);
		            	txtOz.setEditable(true);
		            }else if(in.equals("Libras")) {
		            	txtGr.setEditable(true);
		            	txtKg.setEditable(true);
		            	txtLb.setEditable(false);
		            	txtOz.setEditable(true);
		            }else if(in.equals("Onzas")) {
		            	txtGr.setEditable(true);
		            	txtKg.setEditable(true);
		            	txtLb.setEditable(true);
		            	txtOz.setEditable(false);
		            }
	          	}
			}
		});
		panel_1.add(comboInput);
		
		input = new JTextField();
		input.setBounds(34, 77, 114, 20);
		input.setColumns(10);
		panel_1.add(input);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(173, 101, 298, 122);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblGr = new JLabel("Gramos (gr.)");
		lblGr.setBounds(51, 14, 71, 16);
		panel_2.add(lblGr);
		
		txtGr = new JTextField();
		txtGr.setEditable(false);
		txtGr.setBounds(138, 12, 114, 20);
		panel_2.add(txtGr);
		txtGr.setColumns(10);
		
		JLabel lblKg = new JLabel("Kilogramos (kg.)");
		lblKg.setBounds(40, 39, 93, 16);
		panel_2.add(lblKg);
		
		txtKg = new JTextField();
		txtKg.setBounds(138, 37, 114, 20);
		panel_2.add(txtKg);
		txtKg.setColumns(10);
		
		JLabel lblLb = new JLabel("Libras (lb.)");
		lblLb.setBounds(57, 64, 60, 16);
		panel_2.add(lblLb);
		
		txtLb = new JTextField();
		txtLb.setBounds(138, 62, 114, 20);
		panel_2.add(txtLb);
		txtLb.setColumns(10);
		
		JLabel lblOz = new JLabel("Onzas (oz.)");
		lblOz.setBounds(55, 89, 63, 16);
		panel_2.add(lblOz);
		
		txtOz = new JTextField();
		txtOz.setBounds(138, 87, 114, 20);
		panel_2.add(txtOz);
		txtOz.setColumns(10);
		
		////////////////////////////////////////////////////////////////////////
		
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String in = (String) comboInput.getSelectedItem();
					BigDecimal valIn = new BigDecimal(input.getText().trim());
					BigDecimal[] values = convertToAll(in,valIn);
					
					txtGr.setText(String.valueOf(values[0]));
	            	txtKg.setText(String.valueOf(values[1]));
	            	txtLb.setText(String.valueOf(values[2]));
	            	txtOz.setText(String.valueOf(values[3]));
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(VentanaPeso.this, "Ingrese un valor válido", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
	}
	
	// Recibe el tipo de unidad, y el valor ingresado, y retorna un arreglo[4] con todos los valores de peso
	private BigDecimal[] convertToAll(String in, BigDecimal value) {
        BigDecimal[] values = new BigDecimal[4];
		if(in.equals("Gramos")) {
			values[0] = value; // Gramos
	        values[1] = value.divide(new BigDecimal("1000"), 2, RoundingMode.HALF_UP); // Kilogramos
	        values[2] = value.divide(new BigDecimal("1000"), 2, RoundingMode.HALF_UP); // Libras
	        values[3] = value.divide(new BigDecimal("28.3495"), 2, RoundingMode.HALF_UP); // Onzas
		}else if(in.equals("Kilogramos")) {
			values[0] = value.multiply(new BigDecimal("1000")).setScale(2, RoundingMode.HALF_UP); // Gramos
	        values[1] = value; // Kilogramos
	        values[2] = value.multiply(new BigDecimal("2.20462")).setScale(2, RoundingMode.HALF_UP); // Libras
	        values[3] = value.multiply(new BigDecimal("35.274")).setScale(2, RoundingMode.HALF_UP); // Onzas
		}else if(in.equals("Libras")) {
			values[0] = value.multiply(new BigDecimal("453.592")).multiply(new BigDecimal("1000")).setScale(2, RoundingMode.HALF_UP); // Gramos
	        values[1] = value.multiply(new BigDecimal("453.592")).setScale(2, RoundingMode.HALF_UP); // Kilogramos
	        values[2] = value; // Libras
	        values[3] = value.multiply(new BigDecimal("16")).setScale(2, RoundingMode.HALF_UP); // Onzas
		}else if(in.equals("Onzas")) {
			values[0] = value.multiply(new BigDecimal("28.3495")).setScale(2, RoundingMode.HALF_UP); // Gramos
	        values[1] = value.divide(new BigDecimal("35.274"), 2, RoundingMode.HALF_UP); // Kilogramos
	        values[2] = value.divide(new BigDecimal("16"), 2, RoundingMode.HALF_UP); // Libras
	        values[3] = value; // Onzas
		}
		
        return values;
	}
}

