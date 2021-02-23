package ejercicio4Test;


import ejercicio4.BDUtil2;
import ejercicio4.Cajero;
import ejercicio4.Cajero2;
import ejercicio4.ClientDB2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;

import java.util.ArrayList;
import java.util.List;

//Paso 1 para metodos estaticos
@RunWith(PowerMockRunner.class)
//Paso 2 para metodos estaticos
@PowerMockRunnerDelegate(Parameterized.class)

@PrepareForTest({ClientDB2.class, BDUtil2.class})

public class CajeroTest2 {

    @Parameterized.Parameter(0)
    public int ci;
    @Parameterized.Parameter(1)
    public int amount;
    @Parameterized.Parameter(2)
    public String expectedResult;
    @Parameterized.Parameter(3)
    public boolean expectedMockClient;
    @Parameterized.Parameter(4)
    public boolean expectedMockDB;


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

    @Test
    public void verify_calculate_amount(){
        // PASO 3
        PowerMockito.mockStatic(ClientDB2.class);
        PowerMockito.mockStatic(BDUtil2.class);
        // PASO 4
        Mockito.when(ClientDB2.isConnectionSuccessfully("mysql")).thenReturn(this.expectedMockClient);
        Mockito.when(BDUtil2.updateSaldo(this.ci,10-this.amount)).thenReturn(this.expectedMockDB);
        Cajero2 cajero2 = new Cajero2(10);
        String actualResult= cajero2.getCash(this.ci,this.amount);
        Assert.assertEquals("ERROR! ",this.expectedResult,actualResult);
    }

}