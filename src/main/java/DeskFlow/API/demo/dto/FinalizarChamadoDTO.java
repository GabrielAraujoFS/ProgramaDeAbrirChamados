package DeskFlow.API.demo.dto;
import DeskFlow.API.demo.dto.FinalizarChamadoDTO;
import DeskFlow.API.demo.model.StatusChamado;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FinalizarChamadoDTO {
    @NotNull(message = "Observação é obrigatória")
    private String observacao;

    @NotNull(message = "Status é obrigatória")
    private StatusChamado status;
}