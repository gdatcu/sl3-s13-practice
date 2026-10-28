package chapter2;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGAnnotationOrderTest {

    // 1. Se execută O SINGURĂ DATĂ, la începutul întregii suite
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("--- @BeforeSuite: Pregătim întreaga suită (ex: curățăm directorul de screenshots) ---");
    }

    // 2. Se execută O SINGURĂ DATĂ, la începutul tag-ului <test> din XML
    @BeforeTest
    public void beforeTest() {
        System.out.println("---- @BeforeTest: Setup pentru acest set de teste (ex: conexiune la DB) ----");
    }

    // 3. Se execută O SINGURĂ DATĂ, înainte de prima metodă @Test din această clasă
    @BeforeClass
    public void beforeClass() {
        System.out.println("====== @BeforeClass: Setup pentru CLASA 'TestNGAnnotationOrder' (ex: deschidem browser-ul) ======");
    }

    // 4. Se execută ÎNAINTEA FIECĂREI metode @Test
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("  > @BeforeMethod: Setup înainte de fiecare test (ex: mergem la homepage, ne asigurăm că suntem logați)");
    }

    // 5. TESTUL 1
    @Test(priority = 1)
    public void testCase1() {
        System.out.println("    [TEST 1] Executăm logica testului 1...");
        Assert.assertTrue(true);
    }

    // 7. TESTUL 2
    @Test(priority = 2)
    public void testCase2() {
        System.out.println("    [TEST 2] Executăm logica testului 2...");
        Assert.assertEquals(5, 5);
    }

    // 6. Se execută DUPĂ FIECARE metodă @Test
    @AfterMethod
    public void afterMethod() {
        System.out.println("  < @AfterMethod: Cleanup după fiecare test (ex: facem screenshot la eșec, ștergem cookies)");
    }

    // 8. Se execută O SINGURĂ DATĂ, după toate metodele @Test din această clasă
    @AfterClass
    public void afterClass() {
        System.out.println("====== @AfterClass: Cleanup pentru CLASA 'TestNGAnnotationOrder' (ex: driver.quit()) ======");
    }

    // 9. Se execută O SINGURĂ DATĂ, la finalul tag-ului <test> din XML
    @AfterTest
    public void afterTest() {
        System.out.println("---- @AfterTest: Cleanup pentru acest set de teste (ex: închidem conexiunea la DB) ----");
    }

    // 10. Se execută O SINGURĂ DATĂ, la finalul întregii suite
    @AfterSuite
    public void afterSuite() {
        System.out.println("--- @AfterSuite: Închidem întreaga suită (ex: generăm și deschidem raportul final) ---");
    }
}