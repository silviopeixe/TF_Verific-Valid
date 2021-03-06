package com.bcopstein;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.bcopstein.entidades.geometria.Area;
import com.bcopstein.entidades.geometria.Ponto;
import com.bcopstein.entidades.geometria.Reta;
import com.bcopstein.entidades.geometria.SituacaoReta;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AreaTest {

    private Ponto pontoSupEsq;
    private Ponto pontoInfDir;
	private Area areaAux;

    @BeforeEach
    void setup() {
        pontoSupEsq = new Ponto(10, 50);
        pontoInfDir = new Ponto(60, 10);
        areaAux = new Area(pontoSupEsq, pontoInfDir);
    }

    @Test
    public void testar_construtor_ponto() {
        int X = 35; 
        int Y = 30;
        Ponto testa_ponto_Central = areaAux.pontoCentral();
        assertEquals(X, testa_ponto_Central.getX());
        assertEquals(Y, testa_ponto_Central.getY());
    }

    @Test
    public void testar_construtor_area() {
        assertEquals(10, pontoSupEsq.getX());
        assertEquals(50, pontoSupEsq.getY());
		
        assertEquals(60, pontoInfDir.getX());
        assertEquals(10, pontoInfDir.getY());
    }

    @Test
    public void testar_Ponto_AcimaDireita() {
        Ponto ponto = new Ponto(80, 80);
        assertEquals(5, areaAux.codificaPonto(ponto));
    }

    @Test
    public void testar_Ponto_AcimaEsquerda() {
        Ponto ponto = new Ponto(0, 60);
        assertEquals(9, areaAux.codificaPonto(ponto));
    }

    @Test
    public void testar_Ponto_AbaixoDireita() {
        Ponto ponto = new Ponto(80, 5);
        assertEquals(6, areaAux.codificaPonto(ponto));
    }

    @Test
    public void testar_Ponto_AbaixoEsquerda() {
        Ponto ponto = new Ponto(0, 5);
        assertEquals(10, areaAux.codificaPonto(ponto));
    }

    @ParameterizedTest
    @CsvSource({"15, 40, 35, 40, TODA_DENTRO", "15,  5, 35,  5, TODA_FORA"})
    public void retornarAlgumStatus(int x1, int y1, int x2, int y2, String status) {

        areaAux = new Area(new Ponto(10,50), new Ponto(60,10));
        Reta reta = new Reta(new Ponto(x1,y1), new Ponto(x2, y2));

        SituacaoReta statusReta = switch(status) {
            case "TODA_DENTRO" -> SituacaoReta.TODA_DENTRO;
            case "TODA_FORA" -> SituacaoReta.TODA_FORA;
            case "INTERSECTA" -> SituacaoReta.INTERSECTA;
            default -> SituacaoReta.TODA_DENTRO;
        };
        assertEquals(statusReta, areaAux.classifica(reta));
    }
    
}