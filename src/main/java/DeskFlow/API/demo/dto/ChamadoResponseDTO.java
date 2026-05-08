package DeskFlow.API.demo.dto;

import DeskFlow.API.demo.model.StatusChamado;
import lombok.Builder;
import lombok.Data;
import java.time.Instant;

@Data
@Builder
public class ChamadoResponseDTO {

    private Long id;
    private String titulo;
    private String descricao;
    private String setor;
    private StatusChamado status;
    private Instant dataAbertura;
    private Instant dataInicioAtendimento;
    private Instant dataFinalizacao;
    private String observacao;
}