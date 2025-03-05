package practica6ad;

import org.bson.Document;
import com.mongodb.client.MongoCollection;

public class Principal {

	public static void main(String[] args) {
		// obtener la colección 'harry-potter'
		MongoCollection<Document> personajes = BaseDatos.obtenerPersonajes();
		
		// mostrar todos los personajes cuyo atributo 'species' tenga como valor 'human'
		System.out.println("PERSONAJES HUMANOS:");
		BaseDatos.mostrarHumanos(personajes);
		System.out.println();
		
		// mostrar todos los personajes cuyo atributo 'yearOfBirth' sea anterior a 1979
		System.out.println("PERSONAJES NACIDOS ANTES DE 1979:");
		BaseDatos.mostrarNacidosAntesDe1979(personajes);
		System.out.println();
		
		// mostrar todos los personajes cuyo atributo 'wood' de la propiedad 'wand' sea 'holly'
		System.out.println("PERSONAJES CUYO WAND ES HOLLY:");
		BaseDatos.mostrarHollys(personajes);
		System.out.println();
		
		// mostrar todos los personajes que estén vivos y sean estudiantes
		System.out.println("ESTUDIANTES QUE ESTÁN VIVOS");
		BaseDatos.mostrarEstudiantesVivos(personajes);
		System.out.println();
	}

}
