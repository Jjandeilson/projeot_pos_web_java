package pos.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pos.web.domain.entity.Aluno;
import pos.web.domain.repository.AlunoRepository;
import pos.web.domain.service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private AlunoService alunoService;
	
	@GetMapping
	public List<Aluno> listar() {
		return alunoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Aluno> buscar(@PathVariable Long id){
		try {
			Aluno aluno = this.alunoService.buscarouFalhar(id);
			
			return ResponseEntity.ok(aluno);
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Aluno salvar(@RequestBody Aluno aluno) {
		aluno = this.alunoService.salvar(aluno);
		
		return aluno;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Aluno> atualizar(@PathVariable Long id, @RequestBody Aluno aluno){
		try {
			aluno = this.alunoService.atualizar(id, aluno);
			
			return ResponseEntity.ok(aluno);
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		try {
			 this.alunoService.remover(id);
			 
			 return ResponseEntity.noContent().build();
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
}
