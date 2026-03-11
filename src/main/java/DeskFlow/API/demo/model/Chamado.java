package DeskFlow.API.demo.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.Instant;
    @NotNull
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

        private Instant dataAbertura;

        private Instant dataInicioAtendimento;

        private Instant dataFinalizacao;

        @Column(length = 1000)
        private String observacao;
    }

