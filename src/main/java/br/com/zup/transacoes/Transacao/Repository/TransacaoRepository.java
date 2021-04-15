package br.com.zup.transacoes.Transacao.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.transacoes.Transacao.Models.Transacao;

import java.util.List;

public interface TransacaoRepository extends JpaRepository <Transacao,String> {
    List<Transacao> findFirst10ByCartaoIdOrderByEfetivadaDesc(String id);
}
