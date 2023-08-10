package alura.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class VentanaLongitud extends JFrame {

	private JPanel contentPane;
	private JTextField txtMm;
	private JTextField txtYardas;
	private JTextField txtCm;
	private JTextField txtMillas;
	private JTextField txtMt;
	private JTextField txtPies;
	private JTextField txtKm;
	private JTextField txtPulg;
	private JTextField input;

	// Se llama al constructor para iniciar la ventana
	public VentanaLongitud() {
		
		setTitle("Conversor de Longitud");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHeader = new JLabel("");
		lblHeader.setBounds(-2, 0, 500, 100);
		lblHeader.setIcon(new ImageIcon(getClass().getResource("/alura/gui/img/header_longitud.jpg")));
		contentPane.add(lblHeader);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 102, 140, 130);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblInput = new JLabel("Tipo de unidad:");
		lblInput.setBounds(21, 27, 98, 16);
		panel_1.add(lblInput);
		
		JComboBox comboInput = new JComboBox();
		lblInput.setLabelFor(comboInput);
		comboInput.setBounds(21, 46, 98, 25);
		comboInput.setModel(new DefaultComboBoxModel(new String[] {"Milimetros", "Centimetros", "Metros", "Kilometros", "Yardas", "Millas", "Pies", "Pulgadas"}));
		panel_1.add(comboInput);
		
		input = new JTextField();
		input.setBounds(12, 80, 114, 20);
		panel_1.add(input);
		input.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(140, 102, 358, 130);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Milimetros");
		lblNewLabel.setBounds(23, 18, 60, 16);
		panel_2.add(lblNewLabel);
		
		txtMm = new JTextField();
		lblNewLabel.setLabelFor(txtMm);
		txtMm.setEditable(false);
		txtMm.setBounds(101, 18, 86, 20);
		panel_2.add(txtMm);
		txtMm.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Centimetros");
		lblNewLabel_1.setBounds(12, 43, 70, 16);
		panel_2.add(lblNewLabel_1);
		
		txtYardas = new JTextField();
		txtYardas.setBounds(262, 18, 86, 20);
		panel_2.add(txtYardas);
		txtYardas.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Kilometros");
		lblNewLabel_2.setBounds(21, 93, 62, 16);
		panel_2.add(lblNewLabel_2);
		
		txtCm = new JTextField();
		lblNewLabel_1.setLabelFor(txtCm);
		txtCm.setBounds(101, 43, 86, 20);
		panel_2.add(txtCm);
		txtCm.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Millas");
		lblNewLabel_3.setBounds(212, 43, 33, 16);
		panel_2.add(lblNewLabel_3);
		
		txtMillas = new JTextField();
		lblNewLabel_3.setLabelFor(txtMillas);
		txtMillas.setBounds(262, 43, 86, 20);
		panel_2.add(txtMillas);
		txtMillas.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Yardas");
		lblNewLabel_4.setLabelFor(txtYardas);
		lblNewLabel_4.setBounds(209, 18, 40, 16);
		panel_2.add(lblNewLabel_4);
		
		txtMt = new JTextField();
		txtMt.setBounds(101, 68, 86, 20);
		panel_2.add(txtMt);
		txtMt.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Pies");
		lblNewLabel_5.setBounds(219, 68, 25, 16);
		panel_2.add(lblNewLabel_5);
		
		txtPies = new JTextField();
		lblNewLabel_5.setLabelFor(txtPies);
		txtPies.setBounds(262, 68, 86, 20);
		panel_2.add(txtPies);
		txtPies.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Pulgadas");
		lblNewLabel_6.setBounds(199, 93, 53, 16);
		panel_2.add(lblNewLabel_6);
		
		txtKm = new JTextField();
		lblNewLabel_2.setLabelFor(txtKm);
		txtKm.setBounds(101, 93, 86, 20);
		panel_2.add(txtKm);
		txtKm.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Metros");
		lblNewLabel_7.setLabelFor(txtMt);
		lblNewLabel_7.setBounds(37, 68, 40, 16);
		panel_2.add(lblNewLabel_7);
		
		txtPulg = new JTextField();
		lblNewLabel_6.setLabelFor(txtPulg);
		txtPulg.setBounds(262, 93, 86, 20);
		panel_2.add(txtPulg);
		txtPulg.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 232, 498, 47);
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
				txtMm.setText("");
				txtCm.setText("");
				txtMt.setText("");
				txtKm.setText("");
				txtYardas.setText("");
				txtMillas.setText("");
				txtPies.setText("");
				txtPulg.setText("");
			}
		});
		panel_3.add(btnLimpiar);
		
		JButton btnConvertir = new JButton("Convertir");
		panel_3.add(btnConvertir);
		
		///////////////////////////////////////////////////////////////////
		
		comboInput.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
		            
		            String in = (String) comboInput.getSelectedItem();      
		            
		            if(in.equals("Milimetros")) {
		            	txtMm.setEditable(false);
		            	txtCm.setEditable(true);
		            	txtMt.setEditable(true);
		            	txtKm.setEditable(true);
		            	txtYardas.setEditable(true);
		            	txtMillas.setEditable(true);
		            	txtPies.setEditable(true);
		            	txtPulg.setEditable(true);
		            }else if(in.equals("Centimetros")) {
		            	txtMm.setEditable(true);
		            	txtCm.setEditable(false);
		            	txtMt.setEditable(true);
		            	txtKm.setEditable(true);
		            	txtYardas.setEditable(true);
		            	txtMillas.setEditable(true);
		            	txtPies.setEditable(true);
		            	txtPulg.setEditable(true);
		            }else if(in.equals("Metros")) {
		            	txtMm.setEditable(true);
		            	txtCm.setEditable(true);
		            	txtMt.setEditable(false);
		            	txtKm.setEditable(true);
		            	txtYardas.setEditable(true);
		            	txtMillas.setEditable(true);
		            	txtPies.setEditable(true);
		            	txtPulg.setEditable(true);
		            }else if(in.equals("Kilometros")) {
		            	txtMm.setEditable(true);
		            	txtCm.setEditable(true);
		            	txtMt.setEditable(true);
		            	txtKm.setEditable(false);
		            	txtYardas.setEditable(true);
		            	txtMillas.setEditable(true);
		            	txtPies.setEditable(true);
		            	txtPulg.setEditable(true);
		            }else if(in.equals("Yardas")) {
		            	txtMm.setEditable(true);
		            	txtCm.setEditable(true);
		            	txtMt.setEditable(true);
		            	txtKm.setEditable(true);
		            	txtYardas.setEditable(false);
		            	txtMillas.setEditable(true);
		            	txtPies.setEditable(true);
		            	txtPulg.setEditable(true);
		            }else if(in.equals("Millas")) {
		            	txtMm.setEditable(true);
		            	txtCm.setEditable(true);
		            	txtMt.setEditable(true);
		            	txtKm.setEditable(true);
		            	txtYardas.setEditable(true);
		            	txtMillas.setEditable(false);
		            	txtPies.setEditable(true);
		            	txtPulg.setEditable(true);
		            }else if(in.equals("Pies")) {
		            	txtMm.setEditable(true);
		            	txtCm.setEditable(true);
		            	txtMt.setEditable(true);
		            	txtKm.setEditable(true);
		            	txtYardas.setEditable(true);
		            	txtMillas.setEditable(true);
		            	txtPies.setEditable(false);
		            	txtPulg.setEditable(true);
		            }else if(in.equals("Pulgadas")) {
		            	txtMm.setEditable(true);
		            	txtCm.setEditable(true);
		            	txtMt.setEditable(true);
		            	txtKm.setEditable(true);
		            	txtYardas.setEditable(true);
		            	txtMillas.setEditable(true);
		            	txtPies.setEditable(true);
		            	txtPulg.setEditable(false);
		            }
		            
				}
			}
		});
		
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String in = (String) comboInput.getSelectedItem();
					BigDecimal valIn = new BigDecimal(input.getText().trim());
					BigDecimal[] values = convertToAll(in,valIn);
					
					txtMm.setText(String.valueOf(values[0]));
	            	txtCm.setText(String.valueOf(values[1]));
	            	txtMt.setText(String.valueOf(values[2]));
	            	txtKm.setText(String.valueOf(values[3]));
	            	txtYardas.setText(String.valueOf(values[4]));
	            	txtMillas.setText(String.valueOf(values[5]));
	            	txtPies.setText(String.valueOf(values[6]));
	            	txtPulg.setText(String.valueOf(values[7]));
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(VentanaLongitud.this, "Ingrese un valor válido", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
	}
	
	// Recibe el tipo de unidad, y el valor ingresado, y retorna un arreglo[8] con todos los valores de medida
	private BigDecimal[] convertToAll(String in, BigDecimal value) {
        BigDecimal[] values = new BigDecimal[8];

		if(in.equals("Milimetros")) {
			values[0] = value;
            values[1] = value.divide(new BigDecimal("10")).setScale(4, RoundingMode.HALF_UP);
            values[2] = value.divide(new BigDecimal("1000")).setScale(4, RoundingMode.HALF_UP);
            values[3] = value.divide(new BigDecimal("1000000")).setScale(4, RoundingMode.HALF_UP);
            values[4] = value.multiply(new BigDecimal("0.00109361")).setScale(4, RoundingMode.HALF_UP);
            values[5] = value.multiply(new BigDecimal("6.2137e-7")).setScale(4, RoundingMode.HALF_UP);
            values[6] = value.multiply(new BigDecimal("0.00328084")).setScale(4, RoundingMode.HALF_UP);
            values[7] = value.multiply(new BigDecimal("0.0393701")).setScale(4, RoundingMode.HALF_UP);
        }else if(in.equals("Centimetros")) {
        	values[0] = value.multiply(new BigDecimal("10")).setScale(4, RoundingMode.HALF_UP);
            values[1] = value;
            values[2] = value.divide(new BigDecimal("100")).setScale(4, RoundingMode.HALF_UP);
            values[3] = value.divide(new BigDecimal("100000")).setScale(4, RoundingMode.HALF_UP);
            values[4] = value.multiply(new BigDecimal("0.0109361")).setScale(4, RoundingMode.HALF_UP);
            values[5] = value.multiply(new BigDecimal("6.2137e-6")).setScale(4, RoundingMode.HALF_UP);
            values[6] = value.multiply(new BigDecimal("0.0328084")).setScale(4, RoundingMode.HALF_UP);
            values[7] = value.multiply(new BigDecimal("0.393701")).setScale(4, RoundingMode.HALF_UP);
        }else if(in.equals("Metros")) {
        	values[0] = value.multiply(new BigDecimal("1000")).setScale(4, RoundingMode.HALF_UP);
            values[1] = value.multiply(new BigDecimal("100")).setScale(4, RoundingMode.HALF_UP);
            values[2] = value;
            values[3] = value.divide(new BigDecimal("1000")).setScale(4, RoundingMode.HALF_UP);
            values[4] = value.multiply(new BigDecimal("1.09361")).setScale(4, RoundingMode.HALF_UP);
            values[5] = value.divide(new BigDecimal("1609.34")).setScale(4, RoundingMode.HALF_UP);
            values[6] = value.multiply(new BigDecimal("3.28084")).setScale(4, RoundingMode.HALF_UP);
            values[7] = value.multiply(new BigDecimal("39.3701")).setScale(4, RoundingMode.HALF_UP);
        }else if(in.equals("Kilometros")) {
        	values[0] = value.multiply(new BigDecimal("1000000")).setScale(4, RoundingMode.HALF_UP);
            values[1] = value.multiply(new BigDecimal("100000")).setScale(4, RoundingMode.HALF_UP);
            values[2] = value.multiply(new BigDecimal("1000")).setScale(4, RoundingMode.HALF_UP);
            values[3] = value;
            values[4] = value.multiply(new BigDecimal("1093.61")).setScale(4, RoundingMode.HALF_UP);
            values[5] = value.multiply(new BigDecimal("0.621371")).setScale(4, RoundingMode.HALF_UP);
            values[6] = value.multiply(new BigDecimal("3280.84")).setScale(4, RoundingMode.HALF_UP);
            values[7] = value.multiply(new BigDecimal("39370.1")).setScale(4, RoundingMode.HALF_UP);
        }else if(in.equals("Yardas")) {
        	values[0] = value.multiply(new BigDecimal("914.4")).setScale(4, RoundingMode.HALF_UP);
            values[1] = value.multiply(new BigDecimal("91.44")).setScale(4, RoundingMode.HALF_UP);
            values[2] = value.multiply(new BigDecimal("0.9144")).setScale(4, RoundingMode.HALF_UP);
            values[3] = value.multiply(new BigDecimal("0.0009144")).setScale(4, RoundingMode.HALF_UP);
            values[4] = value;
            values[5] = value.multiply(new BigDecimal("0.000568182")).setScale(4, RoundingMode.HALF_UP);
            values[6] = value.multiply(new BigDecimal("3")).setScale(4, RoundingMode.HALF_UP);
            values[7] = value.multiply(new BigDecimal("36")).setScale(4, RoundingMode.HALF_UP);
        }else if(in.equals("Millas")) {
        	values[0] = value.multiply(new BigDecimal("1609344")).setScale(4, RoundingMode.HALF_UP);
            values[1] = value.multiply(new BigDecimal("160934.4")).setScale(4, RoundingMode.HALF_UP);
            values[2] = value.multiply(new BigDecimal("1609.341")).setScale(4, RoundingMode.HALF_UP);
            values[3] = value.multiply(new BigDecimal("1.60934")).setScale(4, RoundingMode.HALF_UP);
            values[4] = value.multiply(new BigDecimal("1760")).setScale(4, RoundingMode.HALF_UP);
            values[5] = value;
            values[6] = value.multiply(new BigDecimal("5280")).setScale(4, RoundingMode.HALF_UP);
            values[7] = value.multiply(new BigDecimal("63360")).setScale(4, RoundingMode.HALF_UP);
        }else if(in.equals("Pies")) {
        	values[0] = value.multiply(new BigDecimal("304.8")).setScale(4, RoundingMode.HALF_UP);
            values[1] = value.multiply(new BigDecimal("30.48")).setScale(4, RoundingMode.HALF_UP);
            values[2] = value.multiply(new BigDecimal("0.3048")).setScale(4, RoundingMode.HALF_UP);
            values[3] = value.multiply(new BigDecimal("0.0003048")).setScale(4, RoundingMode.HALF_UP);
            values[4] = value.multiply(new BigDecimal("0.333333")).setScale(4, RoundingMode.HALF_UP);
            values[5] = value.multiply(new BigDecimal("0.000189394")).setScale(4, RoundingMode.HALF_UP);
            values[6] = value;
            values[7] = value.multiply(new BigDecimal("12")).setScale(4, RoundingMode.HALF_UP);
        }else if(in.equals("Pulgadas")) {
        	values[0] = value.multiply(new BigDecimal("25.4")).setScale(4, RoundingMode.HALF_UP);
            values[1] = value.multiply(new BigDecimal("2.54")).setScale(4, RoundingMode.HALF_UP);
            values[2] = value.multiply(new BigDecimal("0.0254")).setScale(4, RoundingMode.HALF_UP);
            values[3] = value.multiply(new BigDecimal("0.0000254")).setScale(4, RoundingMode.HALF_UP);
            values[4] = value.multiply(new BigDecimal("0.0277778")).setScale(4, RoundingMode.HALF_UP);
            values[5] = value.multiply(new BigDecimal("0.0000157828")).setScale(4, RoundingMode.HALF_UP);
            values[6] = value.multiply(new BigDecimal("0.0833333")).setScale(4, RoundingMode.HALF_UP);
            values[7] = value;
        }
        
        return values;
    }
}
