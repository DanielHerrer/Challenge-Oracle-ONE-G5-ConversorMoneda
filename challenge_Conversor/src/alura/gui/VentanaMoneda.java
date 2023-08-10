package alura.gui;

import alura.persistence.PersistenciaMoneda;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ImageIcon;

public class VentanaMoneda extends JFrame {

	private JPanel contentPane;
	private JTextField inputMoneda;
	private JComboBox comboMonedasOut;
	private JTextField outputMoneda;
	private JLabel lblInput;
	private JLabel lblOutput;
	private JComboBox comboMonedasIn;
	private JButton btnConvertir;
	private JButton btnRegresar;
	private JButton btnSalir;
	private JPanel panel_1;
	private JPanel panel_4;
	private JButton btnLimpiar;
	private JPanel panel_3;
	private JLabel lblDesc;
	private JLabel simboloDineroIn;
	private JLabel simboloDineroOut;

	// Se llama al constructor para iniciar la ventana
	public VentanaMoneda() {
		
		setTitle("Conversor de Moneda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,517, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHeader = new JLabel("");
		lblHeader.setIcon(new ImageIcon(getClass().getResource("/alura/gui/img/header_moneda.jpg")));
		lblHeader.setBounds(0, 0, 501, 94);
		contentPane.add(lblHeader);
		
		panel_1 = new JPanel();
		panel_1.setBounds(0, 97, 213, 85);
		contentPane.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 19));
		
		lblInput = new JLabel("Ingrese cantidad a convertir");
		panel_1.add(lblInput);
		
		lblOutput = new JLabel("Moneda a convertir");
		panel_1.add(lblOutput);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(213, 97, 288, 85);
		contentPane.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 13));

		comboMonedasIn = new JComboBox();
		lblInput.setLabelFor(comboMonedasIn);
		comboMonedasIn.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if (e.getStateChange() == ItemEvent.SELECTED) {
		            
		            String inCoin = (String) comboMonedasIn.getSelectedItem();
					
		            if(inCoin.equals("ARS")) {
		            	simboloDineroIn.setText("₱");
		            }else if(inCoin.equals("BRL")) {
						simboloDineroIn.setText("🇧🇷");
					}else if(inCoin.equals("MXN")) {
						simboloDineroIn.setText("₱");
					}else if(inCoin.equals("COP")) {
						simboloDineroIn.setText("₱");
					}else if(inCoin.equals("CLP")) {
						simboloDineroIn.setText("₱");
					}else if(inCoin.equals("UYU")) {
						simboloDineroIn.setText("₱");
					}else if(inCoin.equals("GBP")) {
						simboloDineroIn.setText("£");
					}else if(inCoin.equals("USD")) {
						simboloDineroIn.setText("$");
					}else if(inCoin.equals("EUR")) {
						simboloDineroIn.setText("€");
					}else if(inCoin.equals("JPY")) {
						simboloDineroIn.setText("¥");
					}
		        }
		    }
		});
		
		panel_2.add(comboMonedasIn);
		comboMonedasIn.setModel(new DefaultComboBoxModel(new String[] { "ARS", "BRL", "MXN", "COP", "CLP", "UYU", "GBP", "USD", "EUR", "JPY" }));
		
		simboloDineroIn = new JLabel("₱");
		panel_2.add(simboloDineroIn);

		inputMoneda = new JTextField();
		panel_2.add(inputMoneda);
		inputMoneda.setColumns(15);

		comboMonedasOut = new JComboBox();
		lblOutput.setLabelFor(comboMonedasOut);
		panel_2.add(comboMonedasOut);
		
		comboMonedasOut.addItemListener(new ItemListener() {
		    @Override
		    public void itemStateChanged(ItemEvent e) {
		        if (e.getStateChange() == ItemEvent.SELECTED) {
		            
		            String outCoin = (String) comboMonedasOut.getSelectedItem();
					
		            if(outCoin.equals("ARS")) {
		            	simboloDineroOut.setText("₱");
		            }else if(outCoin.equals("BRL")) {
						simboloDineroOut.setText("🇧🇷");
					}else if(outCoin.equals("MXN")) {
						simboloDineroOut.setText("₱");
					}else if(outCoin.equals("COP")) {
						simboloDineroOut.setText("₱");
					}else if(outCoin.equals("CLP")) {
						simboloDineroOut.setText("₱");
					}else if(outCoin.equals("UYU")) {
						simboloDineroOut.setText("₱");
					}else if(outCoin.equals("GBP")) {
						simboloDineroOut.setText("£");
					}else if(outCoin.equals("USD")) {
						simboloDineroOut.setText("$");
					}else if(outCoin.equals("EUR")) {
						simboloDineroOut.setText("€");
					}else if(outCoin.equals("JPY")) {
						simboloDineroOut.setText("¥");
					}
		        }
		    }
		});
		
		comboMonedasOut.setModel(new DefaultComboBoxModel(new String[] { "ARS", "BRL", "MXN", "COP", "CLP", "UYU", "GBP", "USD", "EUR", "JPY" }));
		
		simboloDineroOut = new JLabel("₱");
		panel_2.add(simboloDineroOut);

		outputMoneda = new JTextField();
		outputMoneda.setEditable(false);
		panel_2.add(outputMoneda);
		outputMoneda.setColumns(15);
		
		panel_3 = new JPanel();
		panel_3.setBounds(0, 186, 501, 29);
		contentPane.add(panel_3);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblDesc = new JLabel("Realice una conversión");
		panel_3.add(lblDesc);

		panel_4 = new JPanel();
		panel_4.setBounds(0, 215, 501, 49);
		contentPane.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 12));
		
		btnSalir = new JButton("Salir");
		panel_4.add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btnRegresar = new JButton("Regresar");
		panel_4.add(btnRegresar);
		btnRegresar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal principal = new VentanaPrincipal();
				principal.setVisible(true);
				principal.setLocationRelativeTo(null);
				dispose();
			}
		});
		
		btnLimpiar = new JButton("Limpiar");
		panel_4.add(btnLimpiar);
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				inputMoneda.setText("");
				outputMoneda.setText("");
				lblDesc.setText("Realice una conversión");

			}
		});

		//////////////////////////////////////////////////////////////////////////////////////////
		
		btnConvertir = new JButton("Convertir");
		panel_4.add(btnConvertir);
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					String in = inputMoneda.getText();
					String inCoin = (String) comboMonedasIn.getSelectedItem();
					String outCoin = (String) comboMonedasOut.getSelectedItem();

					// Se usa la clase para poder conectar a la API sobre el cambio de moneda
					PersistenciaMoneda pm = new PersistenciaMoneda();

					BigDecimal montoIn = new BigDecimal(in);
					BigDecimal valorIn = pm.obtenerValorMoneda(inCoin);
					BigDecimal valorOut = pm.obtenerValorMonedaOut(inCoin,outCoin);
					
					// montoOut = montoIn * ( valorOut / valorIn ) [setScale() se encarga de encoger el numero 0.00]
					BigDecimal montoOut = montoIn.multiply(valorOut.divide(valorIn)).setScale(2, RoundingMode.HALF_UP); 

					String out = montoOut.toString();

					outputMoneda.setText(out);
					
					String[] monedas = new String[2];
					monedas[0] = inCoin;
					monedas[1] = outCoin;
					String descripcion = "";
					
					for(int i=0; i<monedas.length; i++) {
						switch(monedas[i]) {
							case "ARS":
								descripcion += "[Peso Argentino]";
								break;
							case "BRL":
								descripcion += "[Real Brasileño]";
								break;
							case "MXN":
								descripcion += "[Peso Mexicano]";
								break;
							case "COP":
								descripcion += "[Peso Colombiano]";
								break;
							case "CLP":
								descripcion += "[Peso Chileno]";
								break;
							case "UYU":
								descripcion += "[Peso Uruguayo]";
								break;
							case "GBP":
								descripcion += "[Libra Esterlina]";
								break;
							case "USD":
								descripcion += "[Dólar Estadounidense]";
								break;
							case "EUR":
								descripcion += "[Euro]";
								break;
							case "JPY":
								descripcion += "[Yen japonés]";
								break;
						}
						if(i==0) {
							descripcion += " => ";
						}
					}
					
					lblDesc.setText(descripcion);

				} catch (IOException ioex) {
					JOptionPane.showMessageDialog(VentanaMoneda.this, "Error de API = " + ioex.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(VentanaMoneda.this, "Ingrese un monto válido", "Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});
	}
}