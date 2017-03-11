 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.lyontaufenbach.bdr.locadora.model;

import java.math.BigDecimal;

/**
 *
 * @author Lyon
 */
public class Carro {
    
    private long id;
    private String modelo;
    private BigDecimal valor; 
    
    public Carro() {
        super();
    }
    
    public Carro(long id, String modelo, BigDecimal valor) {
        this.id = id;
        this.modelo = modelo;
        this.valor = valor;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carro other = (Carro) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}