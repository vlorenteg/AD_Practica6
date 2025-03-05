package practica6ad;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class BaseDatos {
	// método para obtener todos los personajes
	public static MongoCollection<Document> obtenerPersonajes() {
		// conexión a la base de datos
		MongoClient conexion = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase database = conexion.getDatabase("harry");
		MongoCollection<Document> personajes = database.getCollection("harry-potter");
		return personajes;
	}
	
	// método para mostrar personajes cuyo atributo 'species' tenga como valor 'human'
	public static void mostrarHumanos(MongoCollection<Document> personajes) {
		FindIterable<Document> humans = personajes.find(Filters.eq("species", "human"));
		for (Document human : humans) {
			System.out.println(human.toJson());
		}
	}
	
	// método para mostrar personajes cuyo atributo 'yearOfBirth' sea anterior a 1979
	public static void mostrarNacidosAntesDe1979(MongoCollection<Document> personajes) {
		FindIterable<Document> nacidosAntesDe1979 = personajes.find(Filters.lt("yearOfBirth", 1979));
		for (Document nacidoAntesDe1979 : nacidosAntesDe1979) {
			System.out.println(nacidoAntesDe1979.toJson());
		}
	}
	
	// método para mostrar personajes cuyo atributo 'wood' de la propiedad 'wand' sea 'holly'
	public static void mostrarHollys(MongoCollection<Document> personajes) {
		FindIterable<Document> hollys = personajes.find(Filters.eq("wand.wood", "holly"));
		for (Document holly : hollys) {
			System.out.println(holly.toJson());
		}
	}

	// método para mostrar personajes que estén vivos (propiedad "alive" igual a true) 
	// y además sean estudiantes (propiedad "hogwartsStudent" igual a true)
	public static void mostrarEstudiantesVivos(MongoCollection<Document> personajes) {
		FindIterable<Document> estudiantesVivos = personajes.find(Filters.and(Filters.eq("alive", true),
				Filters.eq("hogwartsStudent", true)));
		for (Document estudianteVivo : estudiantesVivos) {
			System.out.println(estudianteVivo.toJson());
		}
	}
}
