package DeskFlow.API.demo.service;

import DeskFlow.API.demo.dto.FinalizarChamadoDTO;
import DeskFlow.API.demo.exception.ChamadoBussinesException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;
import DeskFlow.API.demo.dto.ChamadoRequestDTO;
import DeskFlow.API.demo.dto.ChamadoResponseDTO;
import DeskFlow.API.demo.model.Chamado;
import DeskFlow.API.demo.model.StatusChamado;
import DeskFlow.API.demo.repository.ChamadoRepository;

@Service
@RequiredArgsConstructor
public class ChamadoService {

    private final ChamadoRepository repository;

    // ==================== MÉTODOS PÚBLICOS ====================

    public ChamadoResponseDTO abrirChamado(ChamadoRequestDTO dto) {
        // Converte o DTO em entidade e já define status e data
        Chamado chamado = Chamado.builder()
                .titulo(dto.getTitulo())
                .descricao(dto.getDescricao())
                .setor(dto.getSetor())
                .status(StatusChamado.ABERTO)
                .dataAbertura(Instant.now())
                .build();

        return toResponse(repository.save(chamado));
    }

    public ChamadoResponseDTO buscarPorId(Long id) {
        return toResponse(buscarOuLancarErro(id));
    }

    public List<ChamadoResponseDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public List<ChamadoResponseDTO> listarPorStatus(StatusChamado status) {
        return repository.findByStatus(status)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public void deletar(Long id) {
        buscarOuLancarErro(id);
        repository.deleteById(id);
    }

    public ChamadoResponseDTO iniciarAtendimento(Long id) {
        Chamado chamado = buscarOuLancarErro(id);
        chamado.setStatus(StatusChamado.EM_ATENDIMENTO);
        chamado.setDataInicioAtendimento(Instant.now());
        return toResponse(repository.save(chamado));
    }

    public ChamadoResponseDTO finalizarChamado(Long id, FinalizarChamadoDTO dto) {
        Chamado chamado = buscarOuLancarErro(id);

        // Só aceita RESOLVIDO ou NAO_RESOLVIDO
        if (dto.getStatus() != StatusChamado.RESOLVIDO &&
                dto.getStatus() != StatusChamado.NAO_RESOLVIDO) {
            throw new ChamadoBussinesException("Status inválido para finalização");
        }

        chamado.setStatus(dto.getStatus());
        chamado.setDataFinalizacao(Instant.now());
        chamado.setObservacao(dto.getObservacao());

        return toResponse(repository.save(chamado));
    }
    // ==================== MÉTODOS PRIVADOS ====================

    // Busca o chamado no banco, se não achar lança exceção
    private Chamado buscarOuLancarErro(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ChamadoBussinesException("Chamado não encontrado"));
    }

    // Converte a entidade Chamado para o DTO de resposta
    private ChamadoResponseDTO toResponse(Chamado chamado) {
        return ChamadoResponseDTO.builder()
                .id(chamado.getId())
                .titulo(chamado.getTitulo())
                .descricao(chamado.getDescricao())
                .setor(chamado.getSetor())
                .status(chamado.getStatus())
                .dataAbertura(chamado.getDataAbertura())
                .dataInicioAtendimento(chamado.getDataInicioAtendimento())
                .dataFinalizacao(chamado.getDataFinalizacao())
                .observacao(chamado.getObservacao())
                .build();
    }
}