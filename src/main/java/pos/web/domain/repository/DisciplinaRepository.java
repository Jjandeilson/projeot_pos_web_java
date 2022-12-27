package pos.web.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pos.web.domain.entity.Disciplina;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{

}
