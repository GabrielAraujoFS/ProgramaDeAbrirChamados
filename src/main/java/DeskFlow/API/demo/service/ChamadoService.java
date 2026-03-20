package DeskFlow.API.demo.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import DeskFlow.API.demo.model.Chamado;
import DeskFlow.API.demo.model.StatusChamado;
import DeskFlow.API.demo.repository.ChamadoRepository;
@Service
@RequiredArgsConstructor
public class ChamadoService {

    public List<Chamado> listarPorStatus(StatusChamado status) {
        return repository.findByStatus(status);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Chamado buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chamado não encontrado"));
    }

    private final ChamadoRepository repository;


    public Chamado abrirChamado(Chamado chamado) {
        chamado.setStatus(StatusChamado.ABERTO);
        chamado.setDataAbertura(Instant.now());
        return repository.save(chamado);
    }

    public List<Chamado> listarTodos() {
        return repository.findAll();

    }

    public Chamado iniciarAtendimento(Long id) {
        Chamado chamado = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chamado não encontrado"));

        chamado.setStatus(StatusChamado.EM_ATENDIMENTO);
        chamado.setDataInicioAtendimento(Instant.now());

        return repository.save(chamado);
    }

    public Chamado finalizarChamado(Long id, String observacao) {
        Chamado chamado = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chamado não encontrado"));

        chamado.setStatus(StatusChamado.RESOLVIDO);
        chamado.setDataFinalizacao(Instant.now());
        chamado.setObservacao(observacao);

        return repository.save(chamado);
    }
}
