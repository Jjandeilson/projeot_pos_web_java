package pos.web.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pos.web.domain.entity.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{

}
