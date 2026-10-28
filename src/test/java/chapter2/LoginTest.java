package chapter2;

import org.testng.annotations.Test;
import org.testng.Assert;

public class LoginTest {

    @Test // Aceasta este o metodă de test
    public void testLoginCuUserValid() {
        // Pașii testului (Vom adăuga Selenium aici mai târziu)
        System.out.println("Se execută testul de login cu user valid...");
        boolean loginSuccess = true; // Simulare

        // Asertarea: Verificarea rezultatului
        Assert.assertTrue(loginSuccess, "Login-ul ar trebui să reușească!");
    }

    @Test // Aceasta este ALTĂ metodă de test
    public void testLoginCuUserInvalid() {
        System.out.println("Se execută testul de login cu user invalid...");
        boolean loginSuccess = false; // Simulare

        // Asertarea: Verificarea rezultatului
        Assert.assertFalse(loginSuccess, "Login-ul ar trebui să eșueze!");
    }

    // Aceasta NU este o metodă de test, TestNG o va ignora
    public void metodaAjutatoare() {
        System.out.println("Sunt doar o metodă ajutătoare.");
    }
}

