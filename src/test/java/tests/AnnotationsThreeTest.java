package tests;

import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AnnotationsThreeTest {
    static int operacion;
    static int numA;
    static int numB;
    
    @BeforeClass
    public static void initConfig() {
        System.out.println("Inicializando la aplicacion...");
        operacion = 0;
        numA = 0;
        numB = 0;
        System.out.println("-------------------------------------");
    }
    
    @Before
    public void instanceApplication() {
        System.out.println("Creando instancia de la aplicacion...");
        numA = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero A: "));
        numB = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero B: "));
        System.out.println("-------------------------------------");
    }
    
    @Test
    public void performSuma() {
        System.out.println("Relizando operacion suma...");
        operacion = numA + numB;
        System.out.println("La suma es: " + operacion);
        System.out.println("-------------------------------------");
    }
    
    @Test
    public void performResta() {
        System.out.println("Relizando operacion resta...");
        operacion = numA - numB;
        System.out.println("La resta es: " + operacion);
        System.out.println("-------------------------------------");
    }
    
    @After
    public void clearValues() {
        System.out.println("Valor actual numero A: " + numA);
        System.out.println("Valor actual numero B: " + numB);
        System.out.println("Valor actual operacion: " + operacion);
        System.out.println("Limpiando valores...");
        numA = 0;
        numB = 0;
        operacion = 0;
        System.out.println("-------------------------------------");
    }
    
    @AfterClass
    public static void tearDown() {
        System.out.println("Finalizando aplicacion...");
    }
}
