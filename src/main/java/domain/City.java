package domain;

import javax.persistence.*;

@Entity
@Table(name = "cidade")
public class City implements BaseEntity {

    @Id
    @GeneratedValue(generator = "cidade_seq",
            strategy = GenerationType.AUTO)
    @Column(name = "id_cidade")
    private Long id;
    @Column(name = "nome")
    private String name;

    @ManyToOne
    @JoinColumn(name="id_estado")
    private State state;

    @Override
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
}
