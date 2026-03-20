package DeskFlow.API.demo.controller;
import DeskFlow.API.demo.model.Chamado;
import DeskFlow.API.demo.model.StatusChamado;
import DeskFlow.API.demo.service.ChamadoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import DeskFlow.API.demo.dto.FinalizarChamadoDTO;

@RestController
@RequestMapping("/chamados")
@RequiredArgsConstructor
public class ChamadoController {

    private final ChamadoService service;

    @GetMapping("/filtro")
    public List<Chamado> filtrar(@RequestParam StatusChamado status) {
        return service.listarPorStatus(status);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    @PostMapping
    public Chamado abrir(@RequestBody @Valid Chamado chamado) {
        return service.abrirChamado(chamado);
    }
    @GetMapping("/{id}")
    public Chamado buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }
    @GetMapping
    public List<Chamado> listar() {
        return service.listarTodos();
    }

    @PutMapping("/{id}/iniciar")
    public Chamado iniciar(@PathVariable Long id) {
        return service.iniciarAtendimento(id);
    }

    @PutMapping("/{id}/finalizar")
    public Chamado finalizar(@PathVariable Long id,
                             @RequestBody FinalizarChamadoDTO dto) {
        return service.finalizarChamado(id, dto.getObservacao());
    }

}



