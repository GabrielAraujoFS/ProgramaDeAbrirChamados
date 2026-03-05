package DeskFlow.API.demo.model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;


    @Entity
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public class Chamado {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String titulo;

        @Column(length = 1000)
        private String descricao;

        @Enumerated(EnumType.STRING)
        private StatusChamado status;

        private String setor;

        private LocalDateTime dataAbertura;

        private LocalDateTime dataInicioAtendimento;

        private LocalDateTime dataFinalizacao;

        @Column(length = 1000)
        private String observacao;
    }

