package com.bcopstein;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.bcopstein.entidades.Bairro;
import com.bcopstein.entidades.geometria.Area;
import com.bcopstein.entidades.geometria.Ponto;
import com.bcopstein.entidades.geometria.Reta;
import com.bcopstein.entidades.geometria.SituacaoReta;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BairroTest {
    private Ponto ponto_aux;
    private Ponto ponto_aux2;
    private Area area_aux;
    private Bairro bairro_aux;
   
    @Test
    public void novoBairroQuadradoTeste(){
        ponto_aux = new Ponto(50, 200);
        ponto_aux2 = new Ponto(150, 100);
        area_aux = new Area(ponto_aux,ponto_aux2);
        Bairro bairro = Bairro.novoBairroQuadrado("Viamão", ponto_aux, 100, 35);
        assertEquals("Viamão", bairro.getNome());
        assertEquals(35, bairro.getCustoTransporte());
        assertEquals(area_aux, bairro.getArea());
    }

    @Test
    public void novoBairroRetangularTest(){
        ponto_aux = new Ponto(10,40);
        ponto_aux2 = new Ponto(30,30);
        area_aux = new Area(ponto_aux,ponto_aux2);
        Bairro bairro = Bairro.novoBairroRetangular("Santa cicilha", ponto_aux, 20, 10, 61);
        assertEquals("Santa cicilha", bairro.getNome());
        assertEquals(61, bairro.getCustoTransporte());
        assertEquals(area_aux, bairro.getArea());
    }

    @Test
    public void alteraCustoTransporteTest() {
        Bairro bairro = Bairro.novoBairroRetangular("Centro", new Ponto(10,40), 20, 10, 10);
        bairro.alteraCustoTransporte(35.0);
        assertEquals(35, bairro.getCustoTransporte());
    }
    
}
