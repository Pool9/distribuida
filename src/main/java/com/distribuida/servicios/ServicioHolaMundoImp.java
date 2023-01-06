package com.distribuida.servicios;

import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDateTime;
@ApplicationScoped
public class ServicioHolaMundoImp implements ServicioHolaMundo {
    public String hola() {
        return "Hola Paul" + LocalDateTime.now();
    }
}