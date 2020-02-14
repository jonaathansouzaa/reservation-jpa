package domain;

import javax.persistence.*;

@Entity
@Table(name = "guia_modalidade")
public class GuideModality {

    @Id()
    @GeneratedValue(generator = "guia_modalide_seq",
            strategy = GenerationType.AUTO)
    @Column(name = "id_guia_modalidade")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_guia")
    private TourGuide tourGuide;

    @ManyToOne
    @JoinColumn(name = "id_modalidade")
    private Modality modality;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TourGuide getTourGuide() {
        return tourGuide;
    }

    public void setTourGuide(TourGuide tourGuide) {
        this.tourGuide = tourGuide;
    }

    public Modality getModality() {
        return modality;
    }

    public void setModality(Modality modality) {
        this.modality = modality;
    }
}
