package pos.web.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pos.web.domain.entity.Curso;
import pos.web.domain.repository.CursoRepository;

@Service
public class CursoService {

	@Autowired
	private CursoRepository cursoRepository;
	
	@Transactional
	public Curso salvar(Curso curso) {
		return cursoRepository.save(curso);
	}
	
	@Transactional
	public Curso atualizar(Long id, Curso curso) {
		Curso cursoSalvo = this.buscarouFalhar(id);
		atualizarCurso(cursoSalvo, curso);
		return this.salvar(cursoSalvo);
	}
	
	@Transactional
	public void remover(long id) {
		Curso curso = buscarouFalhar(id);
		
		cursoRepository.delete(curso);
	}

	public Curso buscarouFalhar(Long id) {
		return cursoRepository.findById(id).orElseThrow(() -> new RuntimeException("Curso não existente"));
	}
	
	private void atualizarCurso(Curso cursoSalvo, Curso curso) {
		cursoSalvo.setNome(curso.getNome());
		cursoSalvo.setDuracao(curso.getDuracao());
		cursoSalvo.setQuantidadePeriodo(curso.getQuantidadePeriodo());		
	}
	
}
