package JavaConsola;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;


import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.plaf.synth.SynthScrollBarUI;


public class Formulario extends JFrame implements ActionListener{
	
	JButton button;
	JLabel etiNombre, etiEdad, etiSexo, etiPeso, etiAltura, eti;
	JTextField nombre, edad, peso, altura;
	JPanel panel;
	JRadioButton sexoM, sexoH;
	ButtonGroup grupo;
	Persona persona;
	
	public Formulario() {
		
		/*button = new JButton("Enviar");
		button.addActionListener(this);*/
		
		eti = new JLabel("Captura de datos");
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
		etiSexo.setBounds(80, 180, 80, 20);
		
		grupo = new ButtonGroup();
		
		sexoH = new JRadioButton();
		sexoH.setText("H");
		sexoH.setBounds(130, 180, 80, 20);
		
		sexoM = new JRadioButton();
		sexoM.setText("M");
		sexoM.setBounds(160, 180, 80, 20);
		
		grupo.add(sexoH);
		grupo.add(sexoM);
		
		nombre = new JTextField();
		nombre.setBounds(100, 60, 180, 20);
		
		edad = new JTextField();
		edad.setBounds(100, 90, 80, 20);
		
		peso = new JTextField();
		peso.setBounds(100, 120, 180, 20);
		
		altura = new JTextField();
		altura.setBounds(100, 150, 180, 20);
		
		button = new JButton("Enviar");
		button.setBounds(260, 200, 80, 20);
		button.addActionListener(this);
		
		panel = new JPanel(); 
		
		
		panel.add(eti);
		panel.add(etiNombre);
		panel.add(etiEdad);
		panel.add(etiPeso);
		panel.add(etiAltura);
		panel.add(etiSexo);
		panel.add(altura);
		panel.add(peso);
		panel.add(nombre);
		panel.add(edad);
		panel.add(button);
		panel.add(sexoM);
		panel.add(sexoH);
		
		panel.setLayout(null);
		
		setTitle("Formulario");
		add(panel);
		setSize(400, 300);
		setVisible(true);	
		
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button) {
			//System.out.println("Welcome: " +  textField.getText());
			char sexo = 'H';
			if(sexoM.isSelected()) {
				sexo = 'M';
			}
			String name = nombre.getText();
			Integer age = Integer.parseInt(edad.getText());
			Double kg = Double.parseDouble(peso.getText());
			Double alt = Double.parseDouble(altura.getText());
			
			Persona persona = new Persona(name, age, kg, alt, sexo);
			Persona tmp = persona.validar();
			Informacion info = new Informacion(tmp);
			
		}
	}
	
}
