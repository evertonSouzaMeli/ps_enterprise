package model;

import lombok.*;

import javax.persistence.*;

@Builder
@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "T_GCD_LOGRADOURO")
@Entity
@SequenceGenerator(name = "SEQ_LOGRADOURO", sequenceName ="SEQ_T_GCD_LOGRADOURO", allocationSize = 1)
public class Logradouro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LOGRADOURO")
    @Column(name = "id_logradouro", precision = 10)
    private Long id;

    @Column(name = "cd_tp_logradouro", nullable = false, precision = 8)
    private Integer codigoTipoLogradouro;

    @Column(name = "ds_logradouro", nullable = false, length = 190)
    private String descricaoLogradouro;

    @Column(name = "nr_cep", nullable = false, precision = 8)
    private Integer cep;

    @ManyToOne
    @JoinColumn(name = "id_bairro")
    private Bairro bairro;

    @ManyToOne
    @JoinColumn(name = "id_tp_logradouro")
    private TipoLogradouro tipoLogradouro;
}
