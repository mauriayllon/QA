package calcularNotasTest;

import ejercicio1.CalcularNota;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

@RunWith(value= Parameterized.class)
public class CalcularNotasParameters {

    private int firstNota;
    private int secondNota;
    private int thirdNota;
    private String expectedResult;

    public CalcularNotasParameters(int firstNota, int secondNota, int thirdNota, String expectedResult){
        this.firstNota =firstNota;
        this.secondNota=secondNota;
        this.thirdNota=thirdNota;
        this.expectedResult=expectedResult;
    }

    /**
     Pruebas:
     1 Enero 2020  23 59 59
     1 Febrero 2020  23 59 59
     1 Marzo 2020  23 59 59
     1 Abril 2020  23 59 59
     1 Mayo 2020  23 59 59
     1 Junio 2020  23 59 59
     1 Julio 2020  23 59 59
     1 Agosto 2020  23 59 59
     1 Septiembre 2020  23 59 59
     1 Octubre 2020  23 59 59
     1 Noviembre 2020  23 59 59
     1 Diciembre 2020  23 59 59
     31 Enero 2020  23 59 59
     28 Febrero 2021  23 59 59
     29 Febrero 2020  23 59 59 ---- bisiesto
     31 Marzo 2020  23 59 59
     30 Abril 2020  23 59 59
     31 Mayo 2020  23 59 59
     30 Junio 2020  23 59 59
     31 Julio 2020  23 59 59
     31 Agosto 2020  23 59 59
     30 Septiembre 2020  23 59 59
     31 Octubre 2020  23 59 59
     30 Noviembre 2020  23 59 59
     31 Diciembre 2020  23 59 59

     20 Febrero -1 23 59 59 - Invalid Year
     31 Febrero 2020  23 59 59 - Invalid Day
     31 Diciembres 2020  23 59 59 - Invalid Month

     31 Diciembre 2020  -1 59 59  ---- Invalid Hour
     31 Diciembre 2020  00 59 59
     31 Diciembre 2020  01 59 59
     31 Diciembre 2020  11 59 59
     31 Diciembre 2020  12 59 59
     31 Diciembre 2020  13 59 59
     31 Diciembre 2020  22 59 59
     31 Diciembre 2020  23 59 59
     31 Diciembre 2020  24 59 59 ---- Invalid Hour

     31 Diciembre 2020  01 -1 59 ---- Invalid Minute
     31 Diciembre 2020  01 00 59
     31 Diciembre 2020  01 1 59
     31 Diciembre 2020  01 29 59
     31 Diciembre 2020  01 30 59
     31 Diciembre 2020  01 31 59
     31 Diciembre 2020  01 58 59
     31 Diciembre 2020  01 59 59
     31 Diciembre 2020  01 60 59 ---- Invalid Minute

     31 Diciembre 2020  01 01 -1 ---- Invalid Second
     31 Diciembre 2020  01 01 00
     31 Diciembre 2020  01 01 01
     31 Diciembre 2020  01 01 29
     31 Diciembre 2020  01 01 30
     31 Diciembre 2020  01 01 31
     31 Diciembre 2020  01 01 58
     31 Diciembre 2020  01 01 59
     31 Diciembre 2020  01 01 60 ---- Invalid Second

     */

    @Parameterized.Parameters
    public static Iterable<Object[]> getData(){
        List<Object[]>objects= new ArrayList<>();
        objects.add(new Object[]{0,0,0,"Esfuerzate mas, su nota es : 0"});
        objects.add(new Object[]{100,100,100,"Excelente su nota es : 100"});
        objects.add(new Object[]{101,80,80,"*** INGRESE DATOS CORRECTOS ***"});
        objects.add(new Object[]{99,80,80,"Muy Bien su nota es : 86"});
        objects.add(new Object[]{1,80,80,"Esfuerzate mas, su nota es : 53"});
        objects.add(new Object[]{-1,80,80,"*** INGRESE DATOS CORRECTOS ***"});
        objects.add(new Object[]{49,80,80,"Esfuerzate mas, su nota es : 69"});
        objects.add(new Object[]{50,80,80,"Esfuerzate mas, su nota es : 70"});
        objects.add(new Object[]{51,80,80,"Esfuerzate mas, su nota es : 70"});

        objects.add(new Object[]{80,0  ,80,"Esfuerzate mas, su nota es : 53"});
        objects.add(new Object[]{80,100,80,"Muy Bien su nota es : 86"});
        objects.add(new Object[]{80,101,80,"*** INGRESE DATOS CORRECTOS ***"});
        objects.add(new Object[]{80,99 ,80,"Muy Bien su nota es : 86"});
        objects.add(new Object[]{80,1  ,80,"Esfuerzate mas, su nota es : 53"});
        objects.add(new Object[]{80,-1 ,80,"*** INGRESE DATOS CORRECTOS ***"});
        objects.add(new Object[]{80,49 ,80,"Esfuerzate mas, su nota es : 69"});
        objects.add(new Object[]{80,50 ,80,"Esfuerzate mas, su nota es : 70"});
        objects.add(new Object[]{80,51 ,80,"Esfuerzate mas, su nota es : 70"});

        objects.add(new Object[]{80,80,0  ,"Esfuerzate mas, su nota es : 53"});
        objects.add(new Object[]{80,80,100,"Muy Bien su nota es : 86"});
        objects.add(new Object[]{80,80,101,"*** INGRESE DATOS CORRECTOS ***"});
        objects.add(new Object[]{80,80,99 ,"Muy Bien su nota es : 86"});
        objects.add(new Object[]{80,80,1  ,"Esfuerzate mas, su nota es : 53"});
        objects.add(new Object[]{80,80,-1 ,"*** INGRESE DATOS CORRECTOS ***"});
        objects.add(new Object[]{80,80,49 ,"Esfuerzate mas, su nota es : 69"});
        objects.add(new Object[]{80,80,50 ,"Esfuerzate mas, su nota es : 70"});
        objects.add(new Object[]{80,80,51 ,"Esfuerzate mas, su nota es : 70"});

        return objects;
    }


    @Test
    public void verify_suma_all_values(){

        CalcularNota calculaNota = new CalcularNota();
        String actualResult= calculaNota.notaFinal(this.firstNota,this.secondNota,this.thirdNota);
        Assert.assertEquals("ERROR! ",this.expectedResult,actualResult);

    }



}

