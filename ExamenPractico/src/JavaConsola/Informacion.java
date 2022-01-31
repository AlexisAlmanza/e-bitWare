package JavaConsola;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Informacion extends JFrame implements ActionListener{
	
	JPanel panel;
	JTextField sexo, nombre, edad, nss, peso, altura;
	JLabel etiNombre, etiEdad, etiSexo, etiPeso, etiAltura, etiNssm, eti;
	JButton button;
	
	public Informacion(Persona tmp) {

		button = new JButton("Cerrar");
		button.setBounds(200, 200, 80, 20);
		button.addActionListener(this);
		
		eti = new JLabel("Informacion");
		eti.setBounds(20,30,200,20);
		
		etiNombre = new JLabel("Nombre");
		etiNombre.setBounds(40, 60, 180, 20);
		
		etiEdad = new JLabel("Edad");
		etiEdad.setBounds(40, 90, 80, 20);
		
		etiPeso = new JLabel("Peso");
		etiPeso.setBounds(40, 120, 80, 20);
		
		etiAltura = new JLabel("Altura");
		etiAltura.setBounds(40, 150, 80, 20);
		
		etiSexo = new JLabel("Sexo");
		etiSexo.setBounds(40, 180, 80, 20);
		
		nombre = new JTextField(tmp.getNombre());
		nombre.setBounds(100, 60, 80, 20);
		nombre.setEditable(false);
		
		edad = new JTextField(String.valueOf(tmp.getEdad()));
		edad.setBounds(100, 90, 80, 20);
		edad.setEditable(false);
		
		peso = new JTextField(String.valueOf(tmp.getPeso()));
		peso.setBounds(100, 120, 80, 20);
		peso.setEditable(false);
		
		altura = new JTextField(String.valueOf(tmp.getAltura()));
		altura.setBounds(100, 150, 80, 20);
		altura.setEditable(false);

		sexo = new JTextField(String.valueOf(tmp.getSexo()));
		sexo.setBounds(100, 180, 80, 20);
		sexo.setEditable(false);
		
		panel = new JPanel();
		
		panel.add(eti);
		panel.add(etiNombre);
		panel.add(etiEdad);
		panel.add(etiPeso);
		panel.add(etiAltura);
		panel.add(etiSexo);
		panel.add(nombre);
		panel.add(edad);
		panel.add(peso);
		panel.add(altura);
		panel.add(sexo);
		panel.add(button);
		
		
		panel.setLayout(null);
		
		
		add(panel);
		setSize(400, 300);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button) {
			System.exit(ABORT);
		}
		
	}

}
