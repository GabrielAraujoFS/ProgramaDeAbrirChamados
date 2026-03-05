package DeskFlow.API.demo.controller;
import DeskFlow.API.demo.model.Chamado;
import DeskFlow.API.demo.model.StatusChamado;
import DeskFlow.API.demo.service.ChamadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/chamados")
@RequiredArgsConstructor
public class ChamadoController {

    private final ChamadoService service;

    @PostMapping
    public Chamado abrir(@RequestBody Chamado chamado) {
        return service.abrirChamado(chamado);
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
                             @RequestParam StatusChamado status,
                             @RequestParam(required = false) String observacao) {
        return service.finalizarChamado(id, status, observacao);
    }
}


