package Main;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Tbusqueda extends Thread{
	
	private MessageDigest md;
	private String hash;
	private String sal;
	private int espacioBusqueda;
	private String cadenaV;
	static boolean  signal;
	
	
	public Tbusqueda(String tipoHash, String hash, String sal, int espacioBusqueda, boolean signal) {
		this.espacioBusqueda=espacioBusqueda;
		this.hash=hash;
		this.sal=sal;
		cadenaV="";
		this.signal=signal;
		
		try {
			if(tipoHash.equals("SHA256")) {
				md = MessageDigest.getInstance("SHA-256");
			}
			else {
				md = MessageDigest.getInstance("SHA-512");
			}
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void run() {
		//Con cierto espacio de busuqeda debo encontrar una cadena V+C que genere un hash igual al hash dado.
		
		//Paso 1 construir el V + C iterativamente para explorar todo el espacio de busqueda. (Como parto el espacio de busqueda?)
		//Por ahora no lo partamos.
		//todas las letras del abecedario
		long inicio = System.currentTimeMillis();
        if(espacioBusqueda==1) {
        	espacio1();
        }
        else {
        	espacio2();
        }
        long fin = System.currentTimeMillis();
        long tiempo = fin - inicio;
        System.out.println("El tiempo de ejecución es: " + tiempo/1000 + " segundos");
        if(cadenaV.equals(""))
        	System.out.println("No se encontro ninguna cadena v en el thread con espacio de busqueda "+espacioBusqueda);
        else
        	System.out.println("Se encontro la cadena V: "+cadenaV+ " que cumple con el algoritmo");
        System.out.println(cadenaV);
    
    
}
		
		
		
		//Luego construye el algoritmo de hash para que cree el hash.
		
		//Luego compara.
	public void espacio1() {
		boolean terminar=false;
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int passwordLength = 7;
        
        for (int i = 0; i < alphabet.length()&&!terminar&&!signal; i++) {
            String password = "" + alphabet.charAt(i);
            terminar=verificate(password);
            System.out.println(password);
            
            if (passwordLength >= 2&&!terminar) {
                for (int j = 0; j < alphabet.length()&&!terminar&&!signal; j++) {
                    password = "" + alphabet.charAt(i) + alphabet.charAt(j);
                    terminar=verificate(password);
                    
                    if (passwordLength >= 3&&!terminar) {
                        for (int k = 0; k < alphabet.length()&&!terminar&&!signal; k++) {
                            password = "" + alphabet.charAt(i) + alphabet.charAt(j) + alphabet.charAt(k);
                            terminar=verificate(password);
                            
                            if (passwordLength >= 4&&!terminar) {
                                for (int l = 0; l < alphabet.length()&&!terminar&&!signal; l++) {
                                    password = "" + alphabet.charAt(i) + alphabet.charAt(j) + alphabet.charAt(k) + alphabet.charAt(l);
                                    terminar=verificate(password);
                                    
                                    if (passwordLength >= 5&&!terminar) {
                                        for (int m = 0; m < alphabet.length()&&!terminar&&!signal; m++) {
                                            password = "" + alphabet.charAt(i) + alphabet.charAt(j) + alphabet.charAt(k) + alphabet.charAt(l) + alphabet.charAt(m);
                                            terminar=verificate(password);
                                            
                                            if (passwordLength >= 6&&!terminar) {
                                                for (int n = 0; n < alphabet.length()&&!terminar&&!signal; n++) {
                                                    password = "" + alphabet.charAt(i) + alphabet.charAt(j) + alphabet.charAt(k) + alphabet.charAt(l) + alphabet.charAt(m) + alphabet.charAt(n);
                                                    terminar=verificate(password);
                                                    
                                                    if (passwordLength == 7&&!terminar) {
                                                        for (int o = 0; o < alphabet.length()&&!terminar&&!signal; o++) {
                                                            password = "" + alphabet.charAt(i) + alphabet.charAt(j) + alphabet.charAt(k) + alphabet.charAt(l) + alphabet.charAt(m) + alphabet.charAt(n) + alphabet.charAt(o);
                                                            terminar=verificate(password);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        signal=terminar;
	}
	
	public void espacio2() {
		boolean terminar=false;
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int passwordLength = 7;
        
        for (int i = alphabet.length()-1; i >=0&&!terminar&&!signal; i--) {
            String password = "" + alphabet.charAt(i);
            terminar=verificate(password);
            System.out.println(password);
            if (passwordLength >= 2&&!terminar) {
                for (int j = alphabet.length()-1; j >=0&&!terminar&&!signal; j--) {
                    password = "" + alphabet.charAt(i) + alphabet.charAt(j);
                    terminar=verificate(password);
                    
                    if (passwordLength >= 3&&!terminar) {
                        for (int k = alphabet.length()-1; k >=0&&!terminar&&!signal; k--) {
                            password = "" + alphabet.charAt(i) + alphabet.charAt(j) + alphabet.charAt(k);
                            terminar=verificate(password);
                            
                            if (passwordLength >= 4&&!terminar) {
                                for (int l = alphabet.length()-1; l >=0&&!terminar&&!signal; l--) {
                                    password = "" + alphabet.charAt(i) + alphabet.charAt(j) + alphabet.charAt(k) + alphabet.charAt(l);
                                    terminar=verificate(password);
                                    
                                    if (passwordLength >= 5&&!terminar) {
                                        for (int m = alphabet.length()-1; m >=0&&!terminar&&!signal; m--) {
                                            password = "" + alphabet.charAt(i) + alphabet.charAt(j) + alphabet.charAt(k) + alphabet.charAt(l) + alphabet.charAt(m);
                                            terminar=verificate(password);
                                            
                                            if (passwordLength >= 6&&!terminar) {
                                                for (int n = alphabet.length()-1; n >=0&&!terminar&&!signal; n--) {
                                                    password = "" + alphabet.charAt(i) + alphabet.charAt(j) + alphabet.charAt(k) + alphabet.charAt(l) + alphabet.charAt(m) + alphabet.charAt(n);
                                                    terminar=verificate(password);
                                                    
                                                    if (passwordLength == 7&&!terminar) {
                                                        for (int o = alphabet.length()-1; o >=0&&!terminar&&!signal; o--) {
                                                            password = "" + alphabet.charAt(i) + alphabet.charAt(j) + alphabet.charAt(k) + alphabet.charAt(l) + alphabet.charAt(m) + alphabet.charAt(n) + alphabet.charAt(o);
                                                            terminar=verificate(password);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        signal=terminar;
	}
	
	
	public boolean verificate(String texto) {
		
		
		boolean exitoso=false;
		//añadirle el sal
		String cadena = texto+sal;
		
		byte[] cadenaBytes = cadena.getBytes();
		//calcular el hash con md de texto
		md.update(cadenaBytes);
		byte[] hashcalculado = md.digest();
		String aHexa = aHex(hashcalculado);
		if(aHexa.equals(hash)) {
			exitoso=true;
			cadenaV=texto;
		}
			//verificar
		
		return exitoso;
	}
	public String aHex(byte[] bytes) {
        StringBuilder hexBuilder = new StringBuilder();
        for (byte b : bytes) {
            int parteAlta = (b >> 4) & 0xF;
            int parteBaja = b & 0xF;
            hexBuilder.append(Integer.toHexString(parteAlta));
            hexBuilder.append(Integer.toHexString(parteBaja));
        }
        return hexBuilder.toString();
    }
	
	
	
	
	
}
