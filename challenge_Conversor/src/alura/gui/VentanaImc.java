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
import java.awt.Color;
import java.awt.Font;

public class VentanaImc extends JFrame {

	private JPanel contentPane;
	private JTextField inputCm;
	private JTextField inputKg;

	// Se llama al constructor para iniciar la ventana
	public VentanaImc() {
		
		setTitle("Conversor de IMC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 515, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 533, 100);
		lblNewLabel.setIcon(new ImageIcon(getClass().getResource("/alura/gui/img/header_imc.jpg")));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 142, 499, 29);
		contentPane.add(panel);
		
		JLabel lblCm = new JLabel("Ingrese su estatura:");
		panel.add(lblCm);
		
		inputCm = new JTextField();
		lblCm.setLabelFor(inputCm);
		panel.add(inputCm);
		inputCm.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("(cm.)");
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setVgap(10);
		panel_1.setBounds(0, 204, 499, 41);
		contentPane.add(panel_1);
		
		JLabel lblImc = new JLabel("Realice la conversion..");
		lblImc.setForeground(new Color(128, 128, 128));
		panel_1.add(lblImc);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setVgap(3);
		panel_2.setBounds(0, 175, 499, 29);
		contentPane.add(panel_2);
		
		JLabel lblKg = new JLabel("Ingrese su peso:");
		panel_2.add(lblKg);
		
		inputKg = new JTextField();
		lblKg.setLabelFor(inputKg);
		panel_2.add(inputKg);
		inputKg.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("(kg.)");
		panel_2.add(lblNewLabel_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 244, 499, 50);
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
				inputCm.setText("");
				inputKg.setText("");
				lblImc.setText("Realice una conversion..");
				lblImc.setForeground(new Color(128, 128, 128));
			}
		});
		panel_3.add(btnLimpiar);
		
		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double valCm = Double.parseDouble(inputCm.getText().trim());
					double valKg = Double.parseDouble(inputKg.getText().trim());
					double imc = calcularIMC(valCm,valKg);
					
					if(imc < 18.5) {
						lblImc.setText("[ Bajo Peso ]");
						lblImc.setForeground(new Color(2,165,170));
					}else if(imc >= 18.5 && imc <= 24.9) {
						lblImc.setText("[ Peso Normal ]");
						lblImc.setForeground(new Color(29,154,2));
					}else if(imc >= 25 && imc <= 29.9) {
						lblImc.setText("[ Sobrepeso ]");
						lblImc.setForeground(new Color(237,175,2));
					}else if(imc >= 30 && imc <= 34.9) {
						lblImc.setText("[ Obesidad Grado I ]");
						lblImc.setForeground(new Color(255,103,2));
					}else if(imc >= 35 && imc <= 39.9) {
						lblImc.setText("[ Obesidad Grado II ]");
						lblImc.setForeground(new Color(231,39,34));
					}else if(imc >= 40) {
						lblImc.setText("[ Obesidad Grado III ]");
						lblImc.setForeground(new Color(113,30,27));
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(VentanaImc.this, "Ingrese un valor válido", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
								
			}
		});
		panel_3.add(btnConvertir);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 100, 499, 41);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("*El IMC es una herramienta simplificada y no tiene en cuenta factores individuales ");
		lblNewLabel_1.setBounds(23, 0, 452, 15);
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 11));
		lblNewLabel_1.setForeground(new Color(128, 128, 128));
		panel_4.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("como la composición corporal, la distribución de grasa, la masa muscular, etc.\r\n");
		lblNewLabel_1_1.setBounds(34, 13, 430, 15);
		lblNewLabel_1_1.setForeground(Color.GRAY);
		lblNewLabel_1_1.setFont(new Font("Dialog", Font.BOLD, 11));
		panel_4.add(lblNewLabel_1_1);
	}
	
	private double calcularIMC(double alturaCm, double pesoKg) {
		// Convertir altura de cm a metros
        double alturaMt = alturaCm / 100.0;
        // Calcular el IMC
        double imc = pesoKg / (alturaMt * alturaMt);
        
        return imc;
    }
}