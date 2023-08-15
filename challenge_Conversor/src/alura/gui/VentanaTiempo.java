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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class VentanaTiempo extends JFrame {

	private JPanel contentPane;
	private JTextField input;
	private JTextField txtMs;
	private JTextField txtDia;
	private JTextField txtSg;
	private JTextField txtSemana;
	private JTextField txtMt;
	private JTextField txtHr;
	private JTextField txtAnio;
	private JTextField txtMes;

	// Se llama al constructor para iniciar la ventana
	public VentanaTiempo() {
		
		setTitle("Conversor de Tiempo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 498, 88);
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/alura/gui/img/header_tiempos.jpg")));
		contentPane.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 204, 498, 47);
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
				txtMs.setText("");
				txtSg.setText("");
				txtMt.setText("");
				txtHr.setText("");
				txtDia.setText("");
				txtSemana.setText("");
				txtMes.setText("");
				txtAnio.setText("");
			}
		});
		panel_3.add(btnLimpiar);
		
		JButton btnConvertir = new JButton("Convertir");
		panel_3.add(btnConvertir);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 100, 152, 106);
		contentPane.add(panel_1);
		
		JLabel lblInput = new JLabel("Ingrese su unidad:");
		panel_1.add(lblInput);
		
		JComboBox<String> comboInput = new JComboBox<>();
		comboInput.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
		            String in = (String) comboInput.getSelectedItem();      
		            
		            if(in.equals("Milisegundos")) {
		            	txtMs.setEditable(false);
		            	txtSg.setEditable(true);
		            	txtMt.setEditable(true);
		            	txtHr.setEditable(true);
		            	txtDia.setEditable(true);
		            	txtMes.setEditable(true);
		            	txtSemana.setEditable(true);
		            	txtAnio.setEditable(true);
		            }else if(in.equals("Segundos")) {
		            	txtMs.setEditable(true);
		            	txtSg.setEditable(false);
		            	txtMt.setEditable(true);
		            	txtHr.setEditable(true);
		            	txtDia.setEditable(true);
		            	txtMes.setEditable(true);
		            	txtSemana.setEditable(true);
		            	txtAnio.setEditable(true);
		            }else if(in.equals("Minutos")) {
		            	txtMs.setEditable(true);
		            	txtSg.setEditable(true);
		            	txtMt.setEditable(false);
		            	txtHr.setEditable(true);
		            	txtDia.setEditable(true);
		            	txtMes.setEditable(true);
		            	txtSemana.setEditable(true);
		            	txtAnio.setEditable(true);
		            }else if(in.equals("Horas")) {
		            	txtMs.setEditable(true);
		            	txtSg.setEditable(true);
		            	txtMt.setEditable(true);
		            	txtHr.setEditable(false);
		            	txtDia.setEditable(true);
		            	txtMes.setEditable(true);
		            	txtSemana.setEditable(true);
		            	txtAnio.setEditable(true);
		            }else if(in.equals("Dias")) {
		            	txtMs.setEditable(true);
		            	txtSg.setEditable(true);
		            	txtMt.setEditable(true);
		            	txtHr.setEditable(true);
		            	txtDia.setEditable(false);
		            	txtMes.setEditable(true);
		            	txtSemana.setEditable(true);
		            	txtAnio.setEditable(true);
		            }else if(in.equals("Semanas")) {
		            	txtMs.setEditable(true);
		            	txtSg.setEditable(true);
		            	txtMt.setEditable(true);
		            	txtHr.setEditable(true);
		            	txtDia.setEditable(true);
		            	txtMes.setEditable(true);
		            	txtSemana.setEditable(false);
		            	txtAnio.setEditable(true);
		            }else if(in.equals("Meses")) {
		            	txtMs.setEditable(true);
		            	txtSg.setEditable(true);
		            	txtMt.setEditable(true);
		            	txtHr.setEditable(true);
		            	txtDia.setEditable(true);
		            	txtMes.setEditable(false);
		            	txtSemana.setEditable(true);
		            	txtAnio.setEditable(true);
		            }else if(in.equals("Anios")) {
		            	txtMs.setEditable(true);
		            	txtSg.setEditable(true);
		            	txtMt.setEditable(true);
		            	txtHr.setEditable(true);
		            	txtDia.setEditable(true);
		            	txtMes.setEditable(true);
		            	txtSemana.setEditable(true);
		            	txtAnio.setEditable(false);
		            }
				}
			}
		});
		lblInput.setLabelFor(comboInput);
		comboInput.setModel(new DefaultComboBoxModel<String>(new String[] {"Milisegundos", "Segundos", "Minutos", "Horas", "Dias", "Semanas", "Meses", "Anios"}));
		panel_1.add(comboInput);
		
		input = new JTextField();
		panel_1.add(input);
		input.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(164, 100, 334, 106);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblMs = new JLabel("Milisegundos");
		lblMs.setBounds(5, 7, 75, 16);
		panel_2.add(lblMs);
		
		txtMs = new JTextField();
		txtMs.setBounds(85, 5, 81, 20);
		txtMs.setEditable(false);
		panel_2.add(txtMs);
		txtMs.setColumns(7);
		
		JLabel lblDia = new JLabel("Días");
		lblDia.setBounds(194, 7, 25, 16);
		panel_2.add(lblDia);
		
		txtDia = new JTextField();
		txtDia.setBounds(234, 5, 81, 20);
		panel_2.add(txtDia);
		txtDia.setColumns(7);
		
		JLabel lblSg = new JLabel("Segundos");
		lblSg.setBounds(23, 32, 57, 16);
		panel_2.add(lblSg);
		
		txtSg = new JTextField();
		txtSg.setBounds(85, 30, 81, 20);
		panel_2.add(txtSg);
		txtSg.setColumns(7);
		
		JLabel lblSemana = new JLabel("Semanas");
		lblSemana.setBounds(172, 32, 54, 16);
		panel_2.add(lblSemana);
		
		txtSemana = new JTextField();
		txtSemana.setBounds(234, 30, 81, 20);
		panel_2.add(txtSemana);
		txtSemana.setColumns(7);
		
		JLabel lblMt = new JLabel("Minutos");
		lblMt.setBounds(33, 57, 45, 16);
		panel_2.add(lblMt);
		
		txtMt = new JTextField();
		txtMt.setBounds(85, 55, 81, 20);
		panel_2.add(txtMt);
		txtMt.setColumns(7);
		
		JLabel lblMes = new JLabel("Meses");
		lblMes.setBounds(187, 57, 38, 16);
		panel_2.add(lblMes);
		
		JLabel lblHr = new JLabel("Horas");
		lblHr.setBounds(43, 82, 34, 16);
		panel_2.add(lblHr);
		
		txtHr = new JTextField();
		txtHr.setBounds(85, 80, 81, 20);
		panel_2.add(txtHr);
		txtHr.setColumns(7);
		
		JLabel lblAnio = new JLabel("Anios");
		lblAnio.setBounds(190, 82, 32, 16);
		panel_2.add(lblAnio);
		
		txtAnio = new JTextField();
		txtAnio.setBounds(234, 80, 81, 20);
		panel_2.add(txtAnio);
		txtAnio.setColumns(7);
		
		txtMes = new JTextField();
		txtMes.setColumns(7);
		txtMes.setBounds(234, 55, 81, 20);
		panel_2.add(txtMes);
	
		////////////////////////////////////////////////////////////////////////////
		
		btnConvertir.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
			        String in = (String) comboInput.getSelectedItem();
			        long valIn = Long.parseLong(input.getText().trim());
			        long[] values = convertToAll(in, valIn);
			        
			        txtMs.setText(String.valueOf(values[0]));
			        txtSg.setText(String.valueOf(values[1]));
			        txtMt.setText(String.valueOf(values[2]));
			        txtHr.setText(String.valueOf(values[3]));
			        txtDia.setText(String.valueOf(values[4]));
			        txtSemana.setText(String.valueOf(values[5]));
			        txtMes.setText(String.valueOf(values[6]));
			        txtAnio.setText(String.valueOf(values[7]));
			    } catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(VentanaTiempo.this, "Ingrese un valor válido", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
		    }
		});

	}

	private long[] convertToAll(String in, long value) {
	    long[] values = new long[8];
	    
	    if (in.equals("Milisegundos")) {
	        values[0] = value; // Milisegundos
	        values[1] = value / 1000; // Segundos
	        values[2] = value / 60000; // Minutos
	        values[3] = value / 3600000; // Horas
	        values[4] = value / 86400000; // Dias
	        values[5] = value / 604800000; // Semanas
	        values[6] = value / 2592000000L; // Meses
	        values[7] = value / 31536000000L; // Anios
	    } else if (in.equals("Segundos")) {
	        values[0] = value * 1000; // Milisegundos
	        values[1] = value; // Segundos
	        values[2] = value / 60; // Minutos
	        values[3] = value / 3600; // Horas
	        values[4] = value / 86400; // Dias
	        values[5] = value / 604800; // Semanas
	        values[6] = value / 2592000; // Meses
	        values[7] = value / 31536000; // Anios
	    } else if (in.equals("Minutos")) {
	        values[0] = value * 60000; // Milisegundos
	        values[1] = value * 60; // Segundos
	        values[2] = value; // Minutos
	        values[3] = value / 60; // Horas
	        values[4] = value / 1440; // Dias
	        values[5] = value / 10080; // Semanas
	        values[6] = value / 43200; // Meses
	        values[7] = value / 525600; // Anios
	    } else if (in.equals("Horas")) {
	        values[0] = value * 3600000; // Milisegundos
	        values[1] = value * 3600; // Segundos
	        values[2] = value * 60; // Minutos
	        values[3] = value; // Horas
	        values[4] = value / 24; // Dias
	        values[5] = value / 168; // Semanas
	        values[6] = value / 720; // Meses
	        values[7] = value / 8760; // Anios
	    } else if (in.equals("Dias")) {
	        values[0] = value * 86400000; // Milisegundos
	        values[1] = value * 86400; // Segundos
	        values[2] = value * 1440; // Minutos
	        values[3] = value * 24; // Horas
	        values[4] = value; // Dias
	        values[5] = value / 7; // Semanas
	        values[6] = value / 30; // Meses
	        values[7] = value / 365; // Anios
	    } else if (in.equals("Semanas")) {
	        values[0] = value * 604800000; // Milisegundos
	        values[1] = value * 604800; // Segundos
	        values[2] = value * 10080; // Minutos
	        values[3] = value * 168; // Horas
	        values[4] = value * 7; // Dias
	        values[5] = value; // Semanas
	        values[6] = (long) (value * 4.345); // Meses
	        values[7] = (long) (value / 52.18); // Anios
	    } else if (in.equals("Meses")) {
	        values[0] = value * 2592000000L; // Milisegundos
	        values[1] = value * 2592000; // Segundos
	        values[2] = value * 43200; // Minutos
	        values[3] = value * 720; // Horas
	        values[4] = (long) (value * 30.44); // Dias
	        values[5] = (long) (value * 4.345); // Semanas
	        values[6] = value; // Meses
	        values[7] = value / 12; // Anios
	    } else if (in.equals("Anios")) {
	        values[0] = value * 31536000000L; // Milisegundos
	        values[1] = value * 31536000; // Segundos
	        values[2] = value * 525600; // Minutos
	        values[3] = value * 8760; // Horas
	        values[4] = (long) (value * 365.25); // Dias
	        values[5] = (long) (value * 52.18); // Semanas
	        values[6] = value * 12; // Meses
	        values[7] = value; // Anios
	    }
	    
	    return values;
	}
}