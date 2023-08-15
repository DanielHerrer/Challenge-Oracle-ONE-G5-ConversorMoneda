package alura.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class VentanaTemperatura extends JFrame {

	private JPanel contentPane;
	private JTextField input;
	private JTextField output;

	// Se llama al constructor para iniciar la ventana
	public VentanaTemperatura() {
		
		setTitle("Conversor de Temperatura");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 298);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHeader = new JLabel("");
		lblHeader.setBounds(0, 0, 499, 100);
		lblHeader.setIcon(new ImageIcon(getClass().getResource("/alura/gui/img/header_temperatura.jpg")));
		contentPane.add(lblHeader);
		
		JPanel panel_1 = new JPanel();
		FlowLayout fl_panel_1 = (FlowLayout) panel_1.getLayout();
		fl_panel_1.setVgap(10);
		panel_1.setBounds(0, 105, 499, 47);
		contentPane.add(panel_1);
		
		JComboBox<String>comboInput = new JComboBox<>();
		comboInput.setModel(new DefaultComboBoxModel<String>(new String[] {"Fahrenheit", "Celsius"}));
		panel_1.add(comboInput);
		
		JPanel panel_2 = new JPanel();
		FlowLayout fl_panel_2 = (FlowLayout) panel_2.getLayout();
		fl_panel_2.setVgap(8);
		panel_2.setBounds(0, 150, 248, 61);
		contentPane.add(panel_2);
		
		JLabel lblInput = new JLabel("Grados Fahrenheit (°F)");
		panel_2.add(lblInput);
		
		input = new JTextField();
		lblInput.setLabelFor(input);
		panel_2.add(input);
		input.setColumns(18);
		
		JPanel panel_3 = new JPanel();
		FlowLayout fl_panel_3 = (FlowLayout) panel_3.getLayout();
		fl_panel_3.setVgap(8);
		panel_3.setBounds(251, 150, 248, 61);
		contentPane.add(panel_3);
		
		JLabel lblOutput = new JLabel("Grados Celsius (°C)");
		panel_3.add(lblOutput);
		
		output = new JTextField();
		output.setEditable(false);
		lblOutput.setLabelFor(output);
		panel_3.add(output);
		output.setColumns(18);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 212, 499, 47);
		contentPane.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 12));
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panel_4.add(btnSalir);
		
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
		panel_4.add(btnRegresar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				output.setText("");
				input.setText("");
			}
		});
		panel_4.add(btnLimpiar);
		
		JButton btnConvertir = new JButton("Convertir");
		panel_4.add(btnConvertir);
	
///////////////////////////////////////////////////////////////////////////////////////////////
		
		comboInput.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
		            
		            String in = (String) comboInput.getSelectedItem();       
		            if(in.equals("Fahrenheit")) {
		            	lblInput.setText("Grados Fahrenheit (°F)");
		            	lblOutput.setText("Grados Celsius (°C)");
		            }else if(in.equals("Celsius")) {
		            	lblInput.setText("Grados Celsius (°C)");
		            	lblOutput.setText("Grados Fahrenheit (°F)");
		            }
		            
				}
			}
		});
		
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				try {
					String in = (String) comboInput.getSelectedItem();
					float valIn = Float.parseFloat(input.getText().trim());
					
		            if(in.equals("Fahrenheit")) {
		            	output.setText(String.valueOf(fahrenheitToCelsius(valIn)));
		            }else if(in.equals("Celsius")) {
		            	output.setText(String.valueOf(celsiusToFahrenheit(valIn)));
		            }
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(VentanaTemperatura.this, "Ingrese un valor válido", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

	}
	
	// De Celsius a Fahrenheit
	private float celsiusToFahrenheit(float celsius) {
        return (celsius * 9/5) + 32;
    }

    // De Fahrenheit a Celsius
    private float fahrenheitToCelsius(float fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }
}
