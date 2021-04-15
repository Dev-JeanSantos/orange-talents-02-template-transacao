package br.com.zup.transacoes.Configuration;

import br.com.zup.transacoes.TransacoesApplication;
import br.com.zup.transacoes.Transacao.DTO.TransacaoConsumerDTO;
import br.com.zup.transacoes.Transacao.Repository.TransacaoRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Component
public class ListennerDeTransacao {

    @Autowired
    private TransacaoRepository repository;

    private final Logger logger = LoggerFactory.getLogger(TransacoesApplication.class);
    
    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(@Valid TransacaoConsumerDTO transacaoConsumerDTO) {

       try{
           repository.save(transacaoConsumerDTO.toModel());
       }catch (Exception e){
           logger.error("Falha ao persistir transação");
       }

       logger.info("Nova transação efetivada: "+ transacaoConsumerDTO.getEfetivadaEm().toString());

    }

}
