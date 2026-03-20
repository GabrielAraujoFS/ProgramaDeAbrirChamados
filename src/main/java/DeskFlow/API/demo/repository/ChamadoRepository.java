package DeskFlow.API.demo.repository;
import DeskFlow.API.demo.model.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;
public interface ChamadoRepository extends JpaRepository<Chamado,Long> {
    List<Chamado> findByDataFinalizacaoBetween(LocalDateTime inicio, LocalDateTime fim);
    <StatusChamado> List<Chamado> findByStatus(StatusChamado status);

}
