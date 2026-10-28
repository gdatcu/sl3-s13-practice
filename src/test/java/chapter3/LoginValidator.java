package chapter3;

// Aceasta este clasa pe care o testăm (SUT)
// Simulează logica de validare a aplicației HapifyMe
public class LoginValidator {

    // Definim constante pentru rezultatele posibile (o practică excelentă!)
    public static final String SUCCESS = "LOGIN_SUCCESSFUL";
    public static final String ERR_SERVER_INVALID_CREDENTIALS = "Email or password was incorrect";
    public static final String ERR_CLIENT_INVALID_EMAIL_FORMAT = "CLIENT_VALIDATION_EMAIL_FORMAT";
    public static final String ERR_CLIENT_EMPTY_FIELD = "CLIENT_VALIDATION_EMPTY_FIELD";

    /**
     * Validează datele de login.
     * @param email Email-ul
     * @param password Parola
     * @return Un string care reprezintă rezultatul validării.
     */
    public String validate(String email, String password) {

        // 1. Simulare validare Client-Side (câmpuri goale)
        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            return ERR_CLIENT_EMPTY_FIELD;
        }

        // 2. Simulare validare Client-Side (format email - cea din screenshot)
        if (!email.contains("@") || !email.contains(".")) {
            // Browser-ul ar opri trimiterea aici.
            return ERR_CLIENT_INVALID_EMAIL_FORMAT;
        }

        // 3. Simulare validare Server-Side (doar dacă formatul e corect)
        // Presupunem că doar admin@hapifyme.com cu parola "pass123" este valid.
        if (email.equals("admin@hapifyme.com") && password.equals("pass123")) {
            return SUCCESS;
        }

        // 4. Simulare validare Server-Side (eroarea de parolă/email greșit)
        return ERR_SERVER_INVALID_CREDENTIALS;
    }
}