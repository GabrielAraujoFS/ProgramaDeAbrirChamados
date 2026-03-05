package DeskFlow.API.demo.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import DeskFlow.API.demo.model.Chamado;
import DeskFlow.API.demo.model.StatusChamado;
import DeskFlow.API.demo.repository.ChamadoRepository;
@Service
@RequiredArgsConstructor
public class ChamadoService {

    private final ChamadoRepository repository;

    public Chamado abrirChamado(Chamado chamado) {
        chamado.setStatus(StatusChamado.ABERTO);
        chamado.setDataAbertura(LocalDateTime.now());
        return repository.save(chamado);
    }

    public List<Chamado> listarTodos() {
        return repository.findAll();
    }

    public Chamado iniciarAtendimento(Long id) {
        Chamado chamado = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chamado não encontrado"));

        chamado.setStatus(StatusChamado.EM_ATENDIMENTO);
        chamado.setDataInicioAtendimento(LocalDateTime.now());

        return repository.save(chamado);
    }

    public Chamado finalizarChamado(Long id, StatusChamado status, String observacao) {
        Chamado chamado = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chamado não encontrado"));

        chamado.setStatus(status);
        chamado.setDataFinalizacao(LocalDateTime.now());
        chamado.setObservacao(observacao);

        return repository.save(chamado);
    }
}
