import dao.ModalityDAO;
import domain.Modality;

import java.util.List;

public class App {

    public static void main(String[] args) {
        ModalityDAO modalityDAO = new ModalityDAO();

        modalityDAO.salvar(new Modality("Nova Modalidade"));

//        List<Modality> modalities = modalityDAO.listarTodos();
//        for (Modality domain : modalities) {
//            System.out.println(domain.getId() + " / " + domain.getNome());
//        }

    }

}
