package chapter4;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

// Soluție pentru activitatea practică
public class RegistrationValidatorTest {

    // 1. Variabilă privată
    private RegistrationValidator validator;

    // 2. Metoda @BeforeClass modificată
    @BeforeClass(alwaysRun = true) // <-- Adaugă alwaysRun = true aici
    public void setup() {
        System.out.println("Se inițializează RegistrationValidator...");
        validator = new RegistrationValidator();
    }

    // 3. Test simplu (caz pozitiv email)
    @Test(groups = {"email", "smoke"})
    public void testValidEmailFormat() {
        Assert.assertTrue(validator.isEmailValid("test@domeniu.com"), "Email-ul 'test@domeniu.com' ar trebui să fie valid.");
    }

    // 4. Test simplu (potrivire email)
    @Test(groups = {"email", "regression"})
    public void testEmailsMatch() {
        Assert.assertTrue(validator.doEmailsMatch("test@test.com", "test@test.com"), "Email-urile identice ar trebui să se potrivească.");
    }

    @Test(groups = {"email", "regression"})
    public void testEmailsDoNotMatch() {
        Assert.assertFalse(validator.doEmailsMatch("test@test.com", "altul@test.com"), "Email-urile diferite nu ar trebui să se potrivească.");
    }

    // 5. Test simplu (nepotrivire parole)
    @Test(groups = {"password", "smoke"})
    public void testPasswordsDoNotMatch() {
        Assert.assertFalse(validator.doPasswordsMatch("Parola123", "Parola999"), "Parolele diferite nu ar trebui să se potrivească.");
    }

    // 6. DataProvider pentru email-uri invalide
    @DataProvider(name = "invalidEmailProvider")
    public Object[][] invalidEmailProvider() {
        return new Object[][] {
                { "email.fara.at" },  // Lipsește @
                { "email@fara-punct" }, // Lipsește .
                { "" },               // Gol
                { null }              // Null
        };
    }

    // 7. Test parametrizat pentru email-uri invalide
    @Test(dataProvider = "invalidEmailProvider", groups = {"email", "regression"})
    public void testInvalidEmailFormats(String invalidEmail) {
        Assert.assertFalse(validator.isEmailValid(invalidEmail), "Email-ul '" + invalidEmail + "' ar trebui să fie invalid.");
    }

    // 8. DataProvider pentru tăria parolei
    @DataProvider(name = "passwordStrengthProvider")
    public Object[][] passwordStrengthProvider() {
        // Logica: valid între 5 și 30 caractere
        return new Object[][] {
                { "parolaValida", true },   // Cazul 1: Valid (12 caractere)
                { "scrt", false },          // Cazul 2: Prea scurt (4 caractere)
                { "12345", true },          // Cazul 3: Valid (exact 5)
                { "oParolaFoarteLungaDePesteTreizeciDeCaractere", false }, // Cazul 4: Prea lung (43 caractere)
                { "", false },              // Cazul 5: Gol
                { null, false }             // Cazul 6: Null
        };
    }

    // 9. Test parametrizat pentru tăria parolei
    @Test(dataProvider = "passwordStrengthProvider", groups = {"password", "regression"})
    public void testPasswordStrength(String password, boolean expectedResult) {
        boolean actualResult = validator.isPasswordValid(password);
        Assert.assertEquals(actualResult, expectedResult, "Validarea tăriei parolei a eșuat pentru: '" + password + "'");
    }
}

