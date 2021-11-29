package com.bcopstein;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;


import com.bcopstein.casosDeUso.Politicas.ICalculoCustoViagem;
import com.bcopstein.casosDeUso.Repositorios.IRepositorioBairros;
import com.bcopstein.casosDeUso.Repositorios.IRepositorioPassageiros;
import com.bcopstein.casosDeUso.Servicos.ServicosPassageiro;
import com.bcopstein.interfaces.Persistencia.RepositorioBairrosImplMem;
import com.bcopstein.interfaces.Persistencia.RepositorioPassageirosImplMem;
import com.bcopstein.entidades.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ServicosPassageiroTest {
    Passageiro passageiro;
    Roteiro roteiro;
    Viagem viagem;
    IRepositorioBairros repoBairros;
    IRepositorioPassageiros repoPassageiros;
    ServicosPassageiro servicoPassageiro;
    ICalculoCustoViagem calculoCustoViagem;    


    @BeforeEach
    public void setup(){
        repoBairros = new RepositorioBairrosImplMem();
        repoPassageiros = new RepositorioPassageirosImplMem();
        servicoPassageiro = new ServicosPassageiro(repoBairros,repoPassageiros, calculoCustoViagem);
        roteiro = mock(Roteiro.class);

    }

    @Test
    public void ServicosTest(){
        assertTrue(servicoPassageiro.getListaBairros() != null);
        assertTrue(servicoPassageiro.getPassageirosCadastrados() != null);
    }
}