/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.lyontaufenbach.bdr.locadora;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author Lyon
 */
@ApplicationPath("rest")
public class BdrApplication extends ResourceConfig {
    public BdrApplication() {
        packages("io.github.lyontaufenbach.bdr.locadora.controllers");
        packages("io.github.lyontaufenbach.bdr.locadora.service");
    }
}
