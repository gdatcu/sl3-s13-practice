package chapter4;

// Acesta este SUT - clasa pe care o vom testa
public class RegistrationValidator {

    /**
     * Validează un email.
     * Logica aplicației hapifyme:
     * 1. Nu trebuie să fie gol.
     * 2. Trebuie să conțină '@'.
     * 3. Trebuie să conțină '.'.
     */
    public boolean isEmailValid(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        // O verificare simplistă, similară cu logica de bază
        return email.contains("@") && email.contains(".");
    }

    /**
     * Validează potrivirea email-urilor.
     */
    public boolean doEmailsMatch(String email1, String email2) {
        if (email1 == null || email2 == null) {
            return false; // Sau aruncă o excepție, dar pentru simplitate returnăm false
        }
        return email1.equals(email2);
    }

    /**
     * Validează parola.
     * Logica aplicației hapifyme:
     * 1. Parola nu trebuie să fie goală.
     * 2. Trebuie să aibă între 5 și 30 de caractere.
     * (În realitate, ar trebui să fie mai puternică, ex: min 8, dar urmărim exemplul aplicației)
     */
    public boolean isPasswordValid(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }
        return password.length() >= 5 && password.length() <= 30;
    }

    /**
     * Validează potrivirea parolelor.
     */
    public boolean doPasswordsMatch(String pass1, String pass2) {
        if (pass1 == null || pass2 == null) {
            return false;
        }
        return pass1.equals(pass2);
    }
}