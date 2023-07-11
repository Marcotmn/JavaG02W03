package u4D12;


import java.util.UUID;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import entities.Evento;
import entities.EventoDAO;
import entities.tipoEvento;
import utility.JpaUtil;

public class App {
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
	

	public static void main(String[] args) {
		
		EntityManager em = emf.createEntityManager();
		System.out.println("CIAO");
		
		Evento domenicaBellissima = new Evento ("Domenica Bellissima", "2023-08-12", "Domenica Techno", tipoEvento.PRIVATO , 200);
		EventoDAO sd = new EventoDAO(em);
		
		sd.save(domenicaBellissima);
		
		Evento domenicaBellissimaDb = sd.findById(UUID.fromString("4de78671-9338-4cb4-b563-0b764bd87590"));
		System.out.println(domenicaBellissimaDb);
		
		em.close();
		emf.close();
	}

}
