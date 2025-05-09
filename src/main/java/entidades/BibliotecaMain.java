package entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class BibliotecaMain {
	
	public static void main(String[] args) {
		Biblioteca biblioteca = new Biblioteca();
		int opcionSalir = 2;
                
		do {
			Scanner sc = new Scanner(System.in); 
			
                        System.out.println("**********************************");
			System.out.println("Bienvenidos a la Biblioteca UCC");
			System.out.println("MENU");
			System.out.println("1. Registrar libro");
			System.out.println("2. Registrar estudiante");
			System.out.println("3. Registrar prestamo");
			System.out.println("4. Consultar prestamos");
                        System.out.println("**********************************");
			System.out.println("> Ingrese opción: ");
			
			int opcion = sc.nextInt();
			
			switch(opcion) {
				case 1: 
                                        System.out.println("**********************************");
					System.out.println("REGISTRO DE LIBRO");
					System.out.println(">Id:");
					int idLibro = sc.nextInt();
					
					System.out.println(">Titulo:");
					String titulo = sc.next();
					
					System.out.println(">Isbn:");
					String isbn = sc.next();
					
					System.out.println(">Categoria:");
					String categoria = sc.next();
					
					System.out.println(">Autor:");
					String autor = sc.next();
					
					Libro libro = new Libro(idLibro, titulo, isbn, categoria, autor);
					biblioteca.registrarLibro(libro);
					System.out.println("**********************************");
					System.out.println("Libro registrado con exito: "+libro.toString());
                                        System.out.println("**********************************");
                                        				
					break;
				case 2: 
                                        System.out.println("**********************************");
                                        System.out.println("REGISTRO DE ESTUDIANTE");
					System.out.println(">Id:");
					int idEstudiante = sc.nextInt();
					
					System.out.println(">Nombre:");
					String nombre = sc.next();
					
					System.out.println(">Email:");
					String email = sc.next();
					
					System.out.println(">Programa:");
					String programa = sc.next();
					
					
					Estudiante estudiante = new Estudiante(idEstudiante, nombre, email, programa);
					biblioteca.registrarEstudiante(estudiante);
					System.out.println("**********************************");
					System.out.println("Estudiante registrado con exito: "+estudiante.toString());
                                        System.out.println("**********************************");
					break;
				case 3: 
					System.out.println("**********************************");
					System.out.println("REGISTRO PRESTAMO");
					ArrayList<Libro> libros = biblioteca.consultarLibros();
                                        System.out.println("-----------------------------------");
                                        System.out.println("Libros disponibles");
					for (int i=0; i<libros.size(); i++) {
						System.out.println("->"+i + " Lrbro: "+libros.get(i).getTitulo());
					}
                                        System.out.println("");
					System.out.println("-----------------------------------");
                                        System.out.println("Estudiantes disponibles");
					ArrayList<Estudiante> estudiantes = biblioteca.consultarEstudiantes();
					for (int i=0; i<estudiantes.size(); i++) {
						System.out.println("->"+i + "Estudiante :"+estudiantes.get(i).getNombre());
					}
                                        System.out.println("-----------------------------------");
                                        
                                        System.out.println("> Selecione el libro:");
					int opcionLibro = sc.nextInt();
				
                                        System.out.println("> Selecione el estudiante:");
					int opcionEstudiante = sc.nextInt();
					
					
					Date fechaPrestamo = new Date();
					Date fechaEntrega = fechaPrestamo;
					Prestamo prestamo = new Prestamo(1, estudiantes.get(opcionEstudiante), libros.get(opcionLibro), fechaPrestamo, fechaEntrega, "activo");
					biblioteca.registrarPrestamo(prestamo);
                                        
                                        System.out.println("**********************************");
					System.out.println("Prestamo registrado con exito: "+prestamo.toString());
                                        System.out.println("**********************************");
				
					
					break;
				case 4: 
					break;
			}
			
			System.out.println("¿Desea salir? (1=SI, 2=NO)");
			opcionSalir = sc.nextInt();
		
	
			
		}while(opcionSalir  == 2);
		
	}
}
