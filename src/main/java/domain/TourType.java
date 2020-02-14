package domain;

import javax.persistence.*;

@Entity
@Table(name = "tipo_passeio")
public class TourType implements BaseEntity {

    @Id
    @GeneratedValue(generator = "tipo_passeio_seq",
            strategy = GenerationType.AUTO)
    @Column(name = "id_tipo_passeio")
    private Long id;

    private String description;

    public TourType() {
    }

    public TourType(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
