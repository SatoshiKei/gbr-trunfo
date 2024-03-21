package repository;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import model.Carta;

import java.util.List;
@Stateless
public class CartaRepository {

    @PersistenceContext
    private EntityManager em;

    public Integer inserir(Carta carta) {
        this.em.persist(carta);
        return carta.getId();
    }

    public Carta consultar(int id) {
        return this.em.find(Carta.class, id);
    }

    public void atualizar(Carta carta) {
        this.em.merge(carta);
    }

    public void remover(int id) {
        Carta carta = this.consultar(id);
        if (carta != null)
            this.em.remove(carta);
    }

    public List<Carta> pesquisar() {
        return this.em.createQuery("select c from Carta c", Carta.class).getResultList();
    }


}
