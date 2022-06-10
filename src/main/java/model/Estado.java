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
@Table(name = "T_GCD_ESTADO")
@Entity
@SequenceGenerator(name = "SEQ_ESTADO", sequenceName ="SEQ_T_GCD_ESTADO", allocationSize = 1)
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ESTADO")
    @Column(name = "id_estado", precision = 10)
    private Long id;

    @Column(name = "nm_estado", nullable = false, length = 80)
    private String nome;

    @Column(name = "sg_estado", nullable = false, length = 2)
    private String sigla;

    @OneToMany(mappedBy = "estado", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Cidade> cidades;
}
