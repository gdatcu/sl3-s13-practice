package chapter5;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

// 1. Clasa noastră trebuie să implementeze interfața ITestListener
public class TestListener implements ITestListener {

    // Vom suprascrie (override) doar metodele care ne interesează

    @Override
    public void onTestStart(ITestResult result) {
        // Se apelează înaintea fiecărui @Test
        System.out.println("===> START TEST: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Se apelează când un @Test trece
        System.out.println("===> SUCCES: Testul '" + result.getName() + "' a trecut!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Se apelează când un @Test eșuează
        System.err.println("===> EȘEC: Testul '" + result.getName() + "' a eșuat!");

        // Putem loga și eroarea (excepția) care a cauzat eșecul
        if (result.getThrowable() != null) {
            System.err.println("    EROAREA: " + result.getThrowable().getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Se apelează când un @Test este sărit
        System.out.println("===> SĂRIT: Testul '" + result.getName() + "' a fost sărit.");
    }

    @Override
    public void onStart(ITestContext context) {
        // Se apelează o dată la începutul tag-ului <test>
        System.out.println("\n*** ÎNCEPUT SET DE TESTE: " + context.getName() + " ***\n");
    }

    @Override
    public void onFinish(ITestContext context) {
        // Se apelează o dată la finalul tag-ului <test>
        System.out.println("\n*** FINAL SET DE TESTE: " + context.getName() + " ***\n");
    }

    // Nu este nevoie să implementăm celelalte metode dacă nu le folosim
    // (ex: onTestFailedButWithinSuccessPercentage)
}