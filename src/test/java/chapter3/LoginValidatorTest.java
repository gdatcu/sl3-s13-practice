package chapter3;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginValidatorTest {

    private LoginValidator validator;

    @BeforeClass
    public void setup() {
        // Inițializăm clasa pe care o testăm
        validator = new LoginValidator();
    }

    // 1. FURNIZORUL DE DATE
    // Această metodă furnizează datele de test
    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        System.out.println("DataProvider: Se pregătesc datele de test...");

        // Returnăm o matrice. Fiecare rând = o rulare a testului.
        // Coloane: [String email], [String password], [String expectedResult]
        return new Object[][] {
                // Cazul 1: Login corect (Server-side)
                { "admin@hapifyme.com", "pass123", LoginValidator.SUCCESS },

                // Cazul 2: Parolă greșită (Server-side)
                { "admin@hapifyme.com", "wrongpass", LoginValidator.ERR_SERVER_INVALID_CREDENTIALS },

                // Cazul 3: Email greșit (Server-side)
                { "user@test.com", "pass123", LoginValidator.ERR_SERVER_INVALID_CREDENTIALS },

                // Cazul 4: Email format invalid (Client-side HTML5 - simulat)
                { "email.fara.at", "pass123", LoginValidator.ERR_CLIENT_INVALID_EMAIL_FORMAT },

                // Cazul 5: Email gol (Client-side HTML5 - simulat)
                { "", "pass123", LoginValidator.ERR_CLIENT_EMPTY_FIELD },

                // Cazul 6: Parolă goală (Client-side HTML5 - simulat)
                { "admin@hapifyme.com", "", LoginValidator.ERR_CLIENT_EMPTY_FIELD }
        };
    }

    // 2. CONSUMATORUL
    // Acest test va rula de 6 ori, o dată pentru fiecare rând din DataProvider
    @Test(dataProvider = "loginData")
    public void testLoginValidation(String email, String password, String expectedResult) {

        System.out.println("Testăm cu: Email='" + email + "', Pass='" + password + "', Așteptat=" + expectedResult);

        // Act (Executăm metoda de testat)
        String actualResult = validator.validate(email, password);

        // Assert (Validăm rezultatul)
        Assert.assertEquals(actualResult, expectedResult, "Validarea a eșuat pentru email: " + email);
    }
}