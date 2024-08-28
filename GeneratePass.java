public class genratePass{
    public static void main(String []args){
        import java.util.Scanner;

public class GeneratePass {
    private void printMenu() {
        System.out.println();
        System.out.println("1 - Password Generator");
        System.out.println("2 - Password Strength Check");
        System.out.println("3 - Useful Information");
        System.out.println("4 - Quit");
        System.out.print("Choice:");
    }

    public class Alphabet {
        public static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        public static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
        public static final String NUMBERS = "1234567890";
        public static final String SYMBOLS = "!@#$%^&*()-_=+\\/~?";

        private final StringBuilder pool;

        public Alphabet(boolean uppercaseIncluded, boolean lowercaseIncluded, boolean numbersIncluded, boolean specialCharactersIncluded) {
            pool = new StringBuilder();
            if (uppercaseIncluded) pool.append(UPPERCASE_LETTERS);
            if (lowercaseIncluded) pool.append(LOWERCASE_LETTERS);
            if (numbersIncluded) pool.append(NUMBERS);
            if (specialCharactersIncluded) pool.append(SYMBOLS);
        }

        public String getAlphabet() {
            return pool.toString();
        }
    }

    public static class Generator {
        private static boolean includeUpper = false;
        private static boolean includeLower = false;
        private static boolean incNumber = false;
        private static boolean includeSpecial = false;
        private static final Scanner sc = new Scanner(System.in);

        public static void getInfo() {
            System.out.println("Give answers in yes or no only!");

            System.out.print("Do you want to include uppercase letters? ");
            String response = sc.next();
            if (response.equalsIgnoreCase("yes")) {
                includeUpper = true;
            } else if (!response.equalsIgnoreCase("no")) {
                PasswordError(response);
            }

            System.out.print("Do you want to include lowercase letters? ");
            response = sc.next();
            if (response.equalsIgnoreCase("yes")) {
                includeLower = true;
            } else if (!response.equalsIgnoreCase("no")) {
                PasswordError(response);
            }

            System.out.print("Do you want to include numbers? ");
            response = sc.next();
            if (response.equalsIgnoreCase("yes")) {
                incNumber = true;
            } else if (!response.equalsIgnoreCase("no")) {
                PasswordError(response);
            }

            System.out.print("Do you want to include special characters? ");
            response = sc.next();
            if (response.equalsIgnoreCase("yes")) {
                includeSpecial = true;
            } else if (!response.equalsIgnoreCase("no")) {
                PasswordError(response);
            }
        }
    }

    public static void main(String[] args) {
        Generator.getInfo();
    }

    public static void PasswordError(String i) {
        if (!i.equalsIgnoreCase("yes") && !i.equalsIgnoreCase("no")) {
            System.out.println("You have entered something incorrect, let's go over it again.\n");
        }
    }
}

    }
}
