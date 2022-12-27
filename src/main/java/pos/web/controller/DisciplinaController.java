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

import pos.web.domain.entity.Disciplina;
import pos.web.domain.repository.DisciplinaRepository;
import pos.web.domain.service.DisciplinaService;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	@GetMapping
	public List<Disciplina> listar(){
		return disciplinaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Disciplina> buscar(@PathVariable Long id){
		try {
			Disciplina disciplina = this.disciplinaService.buscarOuFalhar(id);
			
			return ResponseEntity.ok(disciplina);
		}catch(RuntimeException ex){
			return ResponseEntity.notFound().build();
		}
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Disciplina salvar(@RequestBody Disciplina disciplina) {
		return this.disciplinaService.salvar(disciplina);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Disciplina> atualizar(@PathVariable Long id, @RequestBody Disciplina disciplina){
		try {
			disciplina = this.disciplinaService.atualizar(id, disciplina);
			
			return ResponseEntity.ok(disciplina);
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id){
		try {
			this.disciplinaService.remover(id);
			
			return ResponseEntity.noContent().build();
		}catch(RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
}
