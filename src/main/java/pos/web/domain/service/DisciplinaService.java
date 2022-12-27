package pos.web.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pos.web.domain.entity.Disciplina;
import pos.web.domain.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	@Transactional
	public Disciplina salvar(Disciplina disciplina) {
		return disciplinaRepository.save(disciplina);
	}
	
	@Transactional
	public Disciplina atualizar(Long id, Disciplina disciplina) {
		Disciplina disciplinaSalva = buscarOuFalhar(id);
		atualizarDisciplina(disciplinaSalva, disciplina);
		
		return this.salvar(disciplinaSalva);
	}
	
	@Transactional
	public void remover(Long id) {
		Disciplina disciplina = buscarOuFalhar(id);
		
		disciplinaRepository.delete(disciplina);
	}

	public Disciplina buscarOuFalhar(Long id) {
		return disciplinaRepository.findById(id).orElseThrow(() -> new RuntimeException("Disciplina não existente"));
	}
	
	private void atualizarDisciplina(Disciplina disciplinaSalva, Disciplina disciplina) {
		disciplinaSalva.setNome(disciplina.getNome());
		disciplinaSalva.setProfessor(disciplina.getProfessor());
		disciplinaSalva.setCargaHoraria(disciplina.getCargaHoraria());
		disciplinaSalva.setStatus(disciplina.getStatus());
		disciplinaSalva.setObservacao(disciplina.getObservacao());
	}
	
}
