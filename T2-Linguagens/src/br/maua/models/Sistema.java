package br.maua.models;

import br.maua.interfaces.Data;

import static java.lang.Math.*;

public class Sistema implements Data {
    @Override
    public int gerarAno(){
        return (int) floor(2021 +(231* PI)/exp(0));
    }
}
