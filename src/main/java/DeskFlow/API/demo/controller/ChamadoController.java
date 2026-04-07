package DeskFlow.API.demo.controller;

import DeskFlow.API.demo.dto.ChamadoRequestDTO;
import DeskFlow.API.demo.dto.ChamadoResponseDTO;
import DeskFlow.API.demo.dto.FinalizarChamadoDTO;
import DeskFlow.API.demo.model.StatusChamado;
import DeskFlow.API.demo.service.ChamadoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/chamados")
@RequiredArgsConstructor
public class ChamadoController {

    private final ChamadoService service;

    @PostMapping
    public ChamadoResponseDTO abrir(@RequestBody @Valid ChamadoRequestDTO dto) {
        return service.abrirChamado(dto);
    }

    @GetMapping
    public List<ChamadoResponseDTO> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ChamadoResponseDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping("/filtro")
    public List<ChamadoResponseDTO> filtrar(@RequestParam StatusChamado status) {
        return service.listarPorStatus(status);
    }

    @PutMapping("/{id}/iniciar")
    public ChamadoResponseDTO iniciar(@PathVariable Long id) {
        return service.iniciarAtendimento(id);
    }

    @PutMapping("/{id}/finalizar")
    public ChamadoResponseDTO finalizar(@PathVariable Long id,
                                        @RequestBody @Valid FinalizarChamadoDTO dto) {
        return service.finalizarChamado(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}