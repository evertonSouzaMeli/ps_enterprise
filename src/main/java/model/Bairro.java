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
@Table(name = "T_GCD_BAIRRO")
@Entity
@SequenceGenerator(name = "SEQ_BAIRRO", sequenceName ="SEQ_T_GCD_BAIRRO", allocationSize = 1)
public class Bairro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BAIRRO")
    @Column(name = "id_bairro", precision = 8)
    private Long id;

    @Column(name = "nm_bairro", nullable = false, length = 100)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_cidade")
    private Cidade cidade;

    @OneToMany(mappedBy = "bairro", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Logradouro> logradouros;
}
