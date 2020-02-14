package dao;

import domain.BaseEntity;
import domain.Modality;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public abstract class DAO<T extends BaseEntity> {

    protected abstract String getSqlString();
    protected abstract Class getClassName();

    private EntityManagerFactory emf = null;
    private EntityManager em = null;

    private void begin() {
        emf = Persistence
                .createEntityManagerFactory("reserva-pu");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    private void close() {
        if (Objects.nonNull(this.em)) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().commit();
            }
            this.em.close();
        }
        if (Objects.nonNull(this.emf)) {
            this.emf.close();
        }
    }

    public void save(T domain) {
        begin();
        em.persist(domain);
        close();
    }

    public void update(T domain) {
        begin();
        em.persist(domain);
        close();
    }

    public void remove(T domain) {
        begin();
        em.remove(domain);
        close();
    }

    public List<T> findAll() {
        begin();
        Query query = em.createQuery(getSqlString());
        List<T> list = query.getResultList();
        close();
        return list;
    }

    public T findById(T domain) {
        begin();
        T value = (T) em.find(getClassName(), domain.getId());
        close();
        return value;
    }

}
