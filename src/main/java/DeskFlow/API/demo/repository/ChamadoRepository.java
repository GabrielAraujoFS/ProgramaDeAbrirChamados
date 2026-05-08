package DeskFlow.API.demo.repository;
import DeskFlow.API.demo.model.Chamado;
import DeskFlow.API.demo.model.StatusChamado;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.Instant;

import java.util.List;
public interface ChamadoRepository extends JpaRepository<Chamado,Long> {
    List<Chamado> findByDataFinalizacaoBetween(Instant inicio, Instant fim);
    List<Chamado> findByStatus(StatusChamado status);

}
