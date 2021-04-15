package br.com.zup.transacoes.Transacao.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Transacao {
    @Id
    private String id;
    private BigDecimal valor;
    @OneToOne(cascade = CascadeType.MERGE)
    private Estabelecimento estabelecimento;
    @OneToOne(cascade = CascadeType.MERGE)
    private Cartao cartao;
    @JsonProperty(value = "efetivadaEm")
    private String efetivada;

    @Deprecated
    public Transacao(){}

    public Transacao(String id, BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao, String efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivada = efetivadaEm;
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

    public String getEfetivada() {
        return efetivada;
    }

}
