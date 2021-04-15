package br.com.zup.transacoes.Transacao.DTO;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.transacoes.Transacao.Models.Cartao;
import br.com.zup.transacoes.Transacao.Models.Estabelecimento;
import br.com.zup.transacoes.Transacao.Models.Transacao;

import java.math.BigDecimal;

public class TransacaoConsumerDTO {

    @NotBlank
    private String id;
    @NotNull
    private BigDecimal valor;
    @NotNull
    private Estabelecimento estabelecimento;
    @NotNull
    private Cartao cartao;
    @NotNull
    private String efetivadaEm;


    @Deprecated
    public TransacaoConsumerDTO(){}


    public TransacaoConsumerDTO(@NotBlank String id, @NotNull BigDecimal valor,
                                @NotNull Estabelecimento estabelecimento,
                                @NotNull Cartao cartao, @NotNull String efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }


    public String getId() {
        return id;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }
    public Cartao getCartao() {
        return cartao;
    }
    public String getEfetivadaEm() {
        return efetivadaEm;
    }
    public Transacao toModel(){
        return new Transacao(id,valor,estabelecimento,cartao,efetivadaEm);
    }


}
