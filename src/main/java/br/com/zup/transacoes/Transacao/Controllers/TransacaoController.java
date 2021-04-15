package br.com.zup.transacoes.Transacao.Controllers;

import br.com.zup.transacoes.Transacao.Models.Transacao;
import br.com.zup.transacoes.Transacao.Repository.TransacaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransacaoController {

    @Autowired
    private TransacaoRepository repository;

    @GetMapping("/transacoes/{id}")
    private ResponseEntity<?> getTransacoes(@PathVariable("id") String id ){
        List<Transacao> transacoes = repository.findFirst10ByCartaoIdOrderByEfetivadaDesc(id);
        if(transacoes.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(transacoes);
    }


}
