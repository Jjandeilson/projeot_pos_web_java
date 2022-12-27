package pos.web.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pos.web.domain.entity.Aluno;
import pos.web.domain.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@Transactional
	public Aluno salvar(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	@Transactional
	public Aluno atualizar(Long id, Aluno aluno) {
		Aluno alunoSalvo = buscarouFalhar(id);
		atualizarAluno(alunoSalvo, aluno);
		return this.salvar(alunoSalvo);
	}
	
	@Transactional
	public void remover(Long id) {
		Aluno aluno = buscarouFalhar(id);
		
		alunoRepository.delete(aluno);
	}
	
	private void atualizarAluno(Aluno alunoSalvo, Aluno aluno) {
		alunoSalvo.setNome(aluno.getNome());
		alunoSalvo.setCurso(aluno.getCurso());
		alunoSalvo.setMatricula(aluno.getMatricula());
	}

	public Aluno buscarouFalhar(Long id){
		return alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não existente"));
	}
	
}
