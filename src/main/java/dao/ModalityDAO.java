package dao;

import domain.Modality;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

public class ModalityDAO implements DAO<Modality> {

    private EntityManagerFactory emf = null;
    private EntityManager em = null;

    private void begin() {
        emf = Persistence
                .createEntityManagerFactory("reserva-pu");
        em = emf.createEntityManager();
    }

    @Override
    public void salvar(Modality domain) {
//        try {
//            conexao = JDBCConnection.getConnection();
//            String sql = "INSERRT INTO modalidade(nome) values (?)";
//            ps = conexao.prepareStatement(sql);
//            ps.setString(1, domain.getNome());
//            ps.execute();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } finally {
//            close();
//        }
        begin();
        em.getTransaction().begin();
        em.persist(domain);
        em.getTransaction().commit();
        close();
    }

    @Override
    public void atualizar(Modality domain) {
//        try {
//            conexao = JDBCConnection.getConnection();
//            String sql = "UPDATE modalidade SET nome = ? WHERE id_modalidade = ?";
//            ps = conexao.prepareStatement(sql);
//            ps.setString(1, domain.getNome());
//            ps.setInt(2, domain.getIdModalidade());
//            ps.execute();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } finally {
//            close();
//        }
        begin();
        em.persist(domain);
        close();
    }

    @Override
    public void deletar(Modality domain) {
//        try {
//            conexao = JDBCConnection.getConnection();
//            String sql = "DELETE FROM modalidade WHERE id_modalidade = ?";
//            ps = conexao.prepareStatement(sql);
//            ps.setInt(1, domain.getIdModalidade());
//            ps.execute();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } finally {
//            close();
//        }
        begin();
        em.remove(domain);
        close();
    }

    @Override
    public List<Modality> listarTodos() {
//        List<Modalidade> modalidades = null;
//        try {
//            conexao = JDBCConnection.getConnection();
//            String sql = "SELECT * FROM modalidade";
//            ps = conexao.prepareStatement(sql);
//            ResultSet resultSet = ps.executeQuery();
//            modalidades = new ArrayList<>();
//            while (resultSet.next()) {
//                Modalidade modalidade = new Modalidade();
//                modalidade.setIdModalidade(resultSet.getInt("id_modalidade"));
//                modalidade.setNome(resultSet.getString("nome"));
//                modalidades.add(modalidade);
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } finally {
//            close();
//        }
//        return modalidades;
        begin();
        Query modalidade = em.createQuery("select m from Modality m",
                Modality.class);
        List<Modality> modalities = modalidade.getResultList();
        close();
        return modalities;
    }

    public Modality findById(Modality domain) {
        begin();
        Modality modality = em.find(Modality.class, domain.getId());
        close();
        return modality;
    }

    private void close() {
        if (Objects.nonNull(this.em)) {
            this.em.close();
        }
        if (Objects.nonNull(this.emf)) {
            this.emf.close();
        }
    }
}
