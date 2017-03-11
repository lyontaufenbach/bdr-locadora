/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.lyontaufenbach.bdr.locadora.service;

import io.github.lyontaufenbach.bdr.locadora.model.Carro;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Lyon
 */
public class CarroService {
    
    static HashMap<Long,Carro> carroIdMap = getCarroIdMap();  
    
    public CarroService() {
        super();
        
        if (getCarroIdMap() == null) {
            carroIdMap = new HashMap<>();
            Carro c1 = new Carro(1, "Modelo teste 1", BigDecimal.ZERO);
            Carro c2 = new Carro(2, "Modelo teste 2", BigDecimal.ONE);
            Carro c3 = new Carro(3, "Modelo teste 3", BigDecimal.TEN);
            
            carroIdMap.put(Long.valueOf(1), c1);
            carroIdMap.put(Long.valueOf(2), c2);
            carroIdMap.put(Long.valueOf(3), c3);
        }
    }
    
    public List<Carro> getCarros() {
        List<Carro> carros = new ArrayList<>(carroIdMap.values());  
        return carros;  
    }

    public Carro getCarro(long id) {
        //TODO validar collection vazia
        Carro carro;  
        carro = carroIdMap.get(id);
        return carro;  
    }

    public void deleteCarro(long id) {
        carroIdMap.remove(id);  
    }

    public Carro addCarro(Carro carro) {
        carro.setId(getMaxId()+1);  
        carroIdMap.put(carro.getId(), carro);  
        return carro; 
    }

    public Carro updateCarro(Carro carro) {
        if (carro.getId()<=0)  
            return null;  
        carroIdMap.put(carro.getId(), carro);  
        return carro;  
    }
    
    public static HashMap<Long, Carro> getCarroIdMap() {  
        return carroIdMap;  
    }  
    
    public static long getMaxId() { 
        return Collections.max(carroIdMap.keySet());  
    }
}