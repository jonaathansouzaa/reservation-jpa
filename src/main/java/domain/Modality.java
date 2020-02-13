package domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "modalidade")
public class Modality {

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_modalidade")
    private Long id;
    @Column(name = "nome")
    private String name;

    public Modality() {
    }

    public Modality(String nome) {
        this.name = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long idModalidade) {
        this.id = idModalidade;
    }

    public String getNome() {
        return name;
    }

    public void setNome(String nome) {
        this.name = nome;
    }
}
