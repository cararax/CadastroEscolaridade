package br.com.ufsm.CadastroEscolaridade.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.ufsm.CadastroEscolaridade.entity.EscolaridadeEntity;
import br.com.ufsm.CadastroEscolaridade.repository.EscolaridadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/escolaridade")
public class EscolaridadeController {

    @Autowired
    EscolaridadeRepository escolaridadeRepository;
    EscolaridadeEntity escolaridadeEntity;

    @GetMapping
    public List<EscolaridadeEntity> listar(){
        List<EscolaridadeEntity> escolaridadeEntityList = escolaridadeRepository.findAll();
        return escolaridadeEntityList;
    }

    @GetMapping("/{id}")
    public EscolaridadeEntity listarPorId(@PathVariable(value = "id") Integer id){
        EscolaridadeEntity escolaridadeEntity = escolaridadeRepository.findById(id).get();
        return escolaridadeEntity;
    }

    @PostMapping()
    public EscolaridadeEntity criarEscolaridaed(@RequestBody @Valid EscolaridadeEntity escolaridade) {
        EscolaridadeEntity escolaridadeSalvo = escolaridadeRepository.save(escolaridade);
        return escolaridadeSalvo;
    }

    @PutMapping("/{id}")
    public ResponseEntity<EscolaridadeEntity> atualizarEscolaridade(@PathVariable(value = "id") Integer id, @RequestBody @Valid EscolaridadeEntity escolaridadeEntity) {
        EscolaridadeEntity escolaridade = escolaridadeRepository.findById(id).get();

        escolaridade.setNome(escolaridadeEntity.getNome());
        escolaridade.setDataInicial(escolaridadeEntity.getDataInicial());
        escolaridade.setDataFinal(escolaridadeEntity.getDataFinal());
        escolaridade.setInstituicao(escolaridadeEntity.getInstituicao());

        final EscolaridadeEntity escolaridadeAtualizada = escolaridadeRepository.save(escolaridade);
        return ResponseEntity.ok(escolaridadeAtualizada);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> removerEscolaridade(@PathVariable(value = "id") Integer id){
        EscolaridadeEntity escolaridade = escolaridadeRepository.findById(id).get();
        escolaridadeRepository.delete(escolaridade);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deletado", Boolean.TRUE);
        return response;
    }
}
