package ejercicio4Test;

import ejercicio4.BDUtil;
import ejercicio4.Cajero;
import ejercicio4.ClientDB;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

@RunWith(value= Parameterized.class)
public class CajeroTest {

    private int ci;
    private int amount;
    private boolean expectedMockClient;
    private boolean isExpectedMockDB;
    private String expectedResult;

    public CajeroTest(int ci, int amount, String expectedResult, boolean expectedMockClient, boolean expectedMockDB){
        this.ci=ci;
        this.amount = amount;
        this.expectedResult = expectedResult;
        this.expectedMockClient = expectedMockClient;
        this.isExpectedMockDB =expectedMockDB;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> getData(){
        List<Object[]> objects= new ArrayList<>();
        objects.add(new Object[]{989898,-1, "Amount No Valido" ,true, true});
        objects.add(new Object[]{989898,0,"Amount No Valido",true, true});
        objects.add(new Object[]{989898,9,"Usted esta sacando la cantidad de 9 y tiene en saldo 1",true, true});
        objects.add(new Object[]{989898, 10   , "Usted esta sacando la cantidad de 10 y tiene en saldo 0",true,true});
        objects.add(new Object[]{989898, 10   , "Actualizacion Incorrecta, Intente Nuevamente",true,false});
        objects.add(new Object[]{989898, 10   , "Conexion a BD no fue satisfactoria",false,true});
        objects.add(new Object[]{989898, 11   ,"Usted no tiene suficiente saldo" ,true,true});
        objects.add(new Object[]{989898, 11   ,"Usted no tiene suficiente saldo" ,true,false});
        objects.add(new Object[]{989898, 11   ,"Conexion a BD no fue satisfactoria" ,false,true});
        objects.add(new Object[]{989898, 11   ,"Conexion a BD no fue satisfactoria",false,false});
        objects.add(new Object[]{100001,4,  "Usted esta sacando la cantidad de 4 y tiene en saldo 6",true,true});
        objects.add(new Object[]{100001,5,"Usted esta sacando la cantidad de 5 y tiene en saldo 5",true,true});
        objects.add(new Object[]{100001,6,"Usted esta sacando la cantidad de 6 y tiene en saldo 4",true,true});
        objects.add(new Object[]{100001,4,  "Actualizacion Incorrecta, Intente Nuevamente",true,false});
        objects.add(new Object[]{100001,5, "Conexion a BD no fue satisfactoria",false,false});;
        objects.add(new Object[]{100001,6, "Conexion a BD no fue satisfactoria",false,false});
        return objects;
    }

    //PASO 2
    BDUtil bdUtilMocked= Mockito.mock(BDUtil.class);
    ClientDB clientDBMocked = Mockito.mock(ClientDB.class);
    @Test
    public void verify_calculate_credit(){
        // Paso 3
        Mockito.when(clientDBMocked.isConnectionSuccessfully("mysql")).thenReturn(this.expectedMockClient);
        Mockito.when(bdUtilMocked.updateSaldo(this.ci,10-this.amount)).thenReturn(this.isExpectedMockDB);
        // Paso 4
        Cajero cajero = new Cajero(10,bdUtilMocked,clientDBMocked);
        String actualResult= cajero.getCash(this.ci,this.amount);
        Assert.assertEquals("ERROR! ",this.expectedResult,actualResult);
    }

}