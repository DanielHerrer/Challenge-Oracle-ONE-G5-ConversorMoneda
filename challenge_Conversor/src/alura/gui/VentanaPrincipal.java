package alura.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import javax.swing.JSeparator;

public class VentanaPrincipal extends JFrame {

	private JPanel contentPane;
	
	// Se llama al constructor para iniciar la ventana
	public VentanaPrincipal() {
		
		setTitle("Conversores de Alura Latam");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 481, 212);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHeaderAlura = new JLabel("");
		lblHeaderAlura.setIcon(new ImageIcon(getClass().getResource("/alura/gui/img/header_alura.jpg")));
		lblHeaderAlura.setBounds(-18, 0, 483, 100);
		contentPane.add(lblHeaderAlura);

		JLabel lblElegir = new JLabel("Elija el tipo de conversion:");
		lblElegir.setBounds(12, 116, 146, 14);
		contentPane.add(lblElegir);

		JComboBox<String> comboConversiones = new JComboBox<>();
		lblElegir.setLabelFor(comboConversiones);
		comboConversiones.setBounds(163, 113, 190, 20);
		comboConversiones.setModel(new DefaultComboBoxModel<String>(new String[] { 
				"Conversor de Moneda", "Conversor de Temperatura", "Conversor de Longitud",
				 "Conversor de Peso", "Conversor de Tiempos", "Conversor de IMC" }));
		contentPane.add(comboConversiones);

		JButton btnElegir = new JButton("Elegir");
		btnElegir.setBounds(375, 112, 78, 23);
		btnElegir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String inConv = (String) comboConversiones.getSelectedItem();
				
				if(inConv.contains("Moneda")) {
					VentanaMoneda moneda = new VentanaMoneda();
					moneda.setVisible(true);
					moneda.setLocationRelativeTo(null);		
				}else if(inConv.contains("Temperatura")){
					VentanaTemperatura temperatura = new VentanaTemperatura();
					temperatura.setVisible(true);
					temperatura.setLocationRelativeTo(null);
				}else if(inConv.contains("Longitud")){
					VentanaLongitud longitud = new VentanaLongitud();
					longitud.setVisible(true);
					longitud.setLocationRelativeTo(null);
				}else if(inConv.contains("Peso")){
					VentanaPeso peso = new VentanaPeso();
					peso.setVisible(true);
					peso.setLocationRelativeTo(null);
				}else if(inConv.contains("Tiempos")){
					VentanaTiempo tiempo = new VentanaTiempo();
					tiempo.setVisible(true);
					tiempo.setLocationRelativeTo(null);
				}else if(inConv.contains("IMC")){
					VentanaImc imc = new VentanaImc();
					imc.setVisible(true);
					imc.setLocationRelativeTo(null);
				}
				
				dispose();
			}
		});
		contentPane.add(btnElegir);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(128, 128, 128));
		separator.setBounds(12, 142, 441, 2);
		contentPane.add(separator);
		
		/**
		 * Label Nombre
		 */
		JLabel lblNombre = new JLabel("<html><a href=\"#\" style=\"text-decoration:none; color:purple;\">Por Franco Daniel Herrera</a></html>");
		lblNombre.setForeground(new Color(128, 128, 128));
		lblNombre.setBackground(new Color(192, 192, 192));
		lblNombre.setBounds(162, 142, 147, 32);
		lblNombre.addMouseListener(new LinkMouseListener());
        lblNombre.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                lblNombre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblNombre.setCursor(Cursor.getDefaultCursor());
            }
        });
		contentPane.add(lblNombre);

	}

	/**
	 * Éste clase ayuda al código a poder manejar el acceso de URL por Label Nombre.
	 */
	private class LinkMouseListener extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                try {
                    // Abrir el perfil de LinkedIn en el navegador web predeterminado
                    URI uri = new URI("https://www.linkedin.com/in/danielfrancoherrera/");
                    Desktop.getDesktop().browse(uri);
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}