package no.hvl.dat104.handler;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import no.hvl.dat104.model.Participant;

@Stateless
public class ParticipantHandler {

	@PersistenceContext(name = "RegistryPersistenceUnit")
	private EntityManager em;
	
	public void saveParticipant(Participant p) {
		em.persist(p);
	}
	
	public List<Participant> getAllParticipants() {
		TypedQuery<Participant> query = em.createQuery("SELECT p FROM Participant p", Participant.class);
		return query.getResultList();
	}
	
	public Participant getParticipant(String phone) {
		return em.find(Participant.class, phone);
	}
	
	public void payFor(String phone) {
		getParticipant(phone).setPaid(true);
	}
	
}
	