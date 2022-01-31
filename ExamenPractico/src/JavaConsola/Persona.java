package JavaConsola;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JOptionPane;

public class Persona {
	
	 	private char sexo = 'H';
		private String nombre = "";
	    private Integer edad = 0;
	    private String nss;
	    private Double peso = 0.0;
	    private Double altura= 0.0;
	    
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public Integer getEdad() {
			return edad;
		}
		public void setEdad(Integer edad) {
			this.edad = edad;
		}
		public void setNss(String nss) {
			this.nss = nss;
		}
		public String getNss() {
			return nss;
		}
		
		public Double getPeso() {
			return peso;
		}
		public void setPeso(Double peso) {
			this.peso = peso;
		}
		public Double getAltura() {
			return altura;
		}
		public void setAltura(Double altura) {
			this.altura = altura;
		}
		public char getSexo() {
			return sexo;
		}
		public void setSexo(char sexo) {
			this.sexo = sexo;
		}
		
		
		
		public Persona() {
			
		}
		
		public Persona(String nombre, Integer edad, Double peso, Double altura, char sexo) {
			super();
			this.nombre = nombre;
			this.edad = edad;
			this.peso = peso;
			this.altura = altura;
			this.sexo = sexo;
			
		}
		
		
		Integer calcularIMC() {
			double imc = (this.peso/Math.sqrt(this.altura));
			int band = 0;
			if(imc < 18.5) {
				band = -1;
			}else if(imc>=25 && imc<=29.9) {
				band = 1;
			}
			
			return band;
		}
		
		Boolean esMayorDeEdad() {//no sera visible al exterior
			return (this.getEdad() >= 18)? true: false;
		}
		
		Boolean comprobarSexo() {//no sera visible al exterior
			return (this.getSexo() == 'H' || this.getSexo() == 'M')? true: false;
		}
		
		@Override
		public String toString() {
			return "Persona sexo=" + sexo + ", nombre=" + nombre + ", edad=" + edad + ", nss=" + nss
					+ ", peso=" + peso + ", altura=" + altura + "]";
		}
		
		public static int numeroAleatorio(int min, int max) {
			return ThreadLocalRandom.current().nextInt(min, max + 1);
		}
		
		public static String NSS() { //no sera visible 
			String banco = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
			String cadena = "";
			
			for(int i=0; i<8; i++) {
				int numAleatorio = numeroAleatorio(0, banco.length() - 1);
				char carAleatorio = banco.charAt(numAleatorio);
				cadena += carAleatorio;
			}
			return cadena;
		}
		
		Persona validar () {
			Integer respPeso = calcularIMC();
			Boolean respEdad = esMayorDeEdad();
			Boolean respSexo = comprobarSexo();
			String respuesta = toString();
			String nss = NSS();
			
			Persona tmpPersona = new Persona();
			tmpPersona.setAltura(altura);
			tmpPersona.setPeso(peso);
			tmpPersona.setNombre(nombre);
			tmpPersona.setSexo(sexo);
			tmpPersona.setNss(nss);
			
			if(respPeso == -1) {//debajo de peso ideal
				JOptionPane.showMessageDialog(null, "Estas por debajo del peso ideal");
			}else if(respPeso == 1){//sobre peso
				JOptionPane.showMessageDialog(null, "Presntas sintomas de sobrepeso");
			}
			
			if(respEdad && respSexo) {
				tmpPersona.setEdad(edad);
			}else {
				JOptionPane.showMessageDialog(null, "Eres menor de edad.");
				System.exit(0);
			}
			
			return tmpPersona;
		}
	    
}
