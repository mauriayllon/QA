package basicJunit;

import org.junit.*;

public class BasicJunit1 {

    @BeforeClass
    public static void beforeClass(){
        System.out.println("-----> Before Class");
    }

    @Before
    public void before(){
        System.out.println("Before");
    }
    @After
    public void after(){
        System.out.println("After");
    }

    @Test
    public void verify_some_thing(){
        System.out.println("La logica de mi test1");
    }

    @Test
    public void verify_some_thing2(){
        System.out.println("La logica de mi test2");
    }
    @Test
    @Ignore
    public void verify_some_thing3(){
        System.out.println("La logica de mi test3");
    }

    @Test(timeout = 2000)
    public void verify_some_thing4() {
        System.out.println("La logica de mi test4 - Velocidad de metodo");
    }
}
