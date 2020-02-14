import dao.ModalityDAO;
import dao.TourTypeDAO;
import domain.Modality;
import domain.TourType;

import java.util.List;

public class App {

    public static void main(String[] args) {
        ModalityDAO modalityDAO = new ModalityDAO();
        modalityDAO.save(new Modality("Caminhada"));

        TourTypeDAO tourTypeDAO = new TourTypeDAO();
        TourType tourType = new TourType("Privativo");
        tourTypeDAO.save(tourType);
//        List<Modality> modalities = modalityDAO.listarTodos();
//        for (Modality domain : modalities) {
//            System.out.println(domain.getId() + " / " + domain.getNome());
//        }

    }

}
