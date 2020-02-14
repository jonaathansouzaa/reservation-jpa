package domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "guia")
public class TourGuide {

    @Id()
    @GeneratedValue(generator = "guia_seq",
            strategy = GenerationType.AUTO)
    @Column(name = "id_guia")
    private Long id;
    @Column(name = "nome")
    private String name;

    @OneToMany(mappedBy = "tourGuide")
    private List<GuideModality> guideModalityList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GuideModality> getGuideModalityList() {
        return guideModalityList;
    }

    public void setGuideModalityList(List<GuideModality> guideModalityList) {
        this.guideModalityList = guideModalityList;
    }
}
