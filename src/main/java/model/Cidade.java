package model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "T_GCD_CIDADE")
@Entity
@SequenceGenerator(name = "SEQ_CIDADE", sequenceName = "SEQ_T_GCD_CIDADE", allocationSize = 1)
public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "SEQ_CIDADE")
    @Column(name = "id_cidade", precision = 10)
    private Long id;

    @Column(name = "nm_cidade", nullable = false, length = 120)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estado;

    @OneToMany(mappedBy = "cidade", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Bairro> bairros;
}
