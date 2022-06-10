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
@Table(name = "T_GCD_TIPO_LOGRADOURO")
@Entity
@SequenceGenerator(name = "SEQ_TIPO_LOGRADOURO", sequenceName ="SEQ_T_GCD_TIPO_LOGRADOURO", allocationSize = 1)
public class TipoLogradouro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_T_GCD_TIPO_LOGRADOURO")
    @Column(name = "id_tp_logradouro", precision = 10)
    private Integer id;

    @Column(name = "nm_tipo_logradouro", nullable = false, length = 50)
    private String nome;

    @OneToMany(mappedBy = "tipoLogradouro", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Logradouro> logradouros;
}
