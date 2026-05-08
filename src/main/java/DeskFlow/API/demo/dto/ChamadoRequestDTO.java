package DeskFlow.API.demo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ChamadoRequestDTO {

    @NotBlank(message = "Título é obrigatório")
    private String titulo;

    @NotBlank(message = "Descrição é obrigatória")
    private String descricao;

    private String setor;
}