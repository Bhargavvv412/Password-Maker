import java.util.Scanner;

public class GeneratePass {
    private final Generator generator;

    public GeneratePass() {
        this.generator = new Generator();
    }

    private void printMenu() {
        System.out.println();
        System.out.println("1 - Password Generator");
        System.out.println("2 - Password Strength Check");
        System.out.println("3 - Useful Information");
        System.out.println("4 - Quit");
        System.out.print("Choice: ");
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

    public class Generator {
        private boolean includeUpper = false;
        private boolean includeLower = false;
        private boolean incNumber = false;
        private boolean includeSpecial = false;
        private final Scanner sc = new Scanner(System.in);

        public void getInfo() {
            System.out.println("Give answers in yes or no only!");

            System.out.print("Do you want to include uppercase letters? ");
            String response = sc.next();
            if (response.equalsIgnoreCase("yes")) {
                includeUpper = true;
            } else if (!response.equalsIgnoreCase("no")) {
                passwordError(response);
            }

            System.out.print("Do you want to include lowercase letters? ");
            response = sc.next();
            if (response.equalsIgnoreCase("yes")) {
                includeLower = true;
            } else if (!response.equalsIgnoreCase("no")) {
                passwordError(response);
            }

            System.out.print("Do you want to include numbers? ");
            response = sc.next();
            if (response.equalsIgnoreCase("yes")) {
                incNumber = true;
            } else if (!response.equalsIgnoreCase("no")) {
                passwordError(response);
            }

            System.out.print("Do you want to include special characters? ");
            response = sc.next();
            if (response.equalsIgnoreCase("yes")) {
                includeSpecial = true;
            } else if (!response.equalsIgnoreCase("no")) {
                passwordError(response);
            }
        }

        private void passwordError(String response) {
            if (!response.equalsIgnoreCase("yes") && !response.equalsIgnoreCase("no")) {
                System.out.println("You have entered something incorrect, let's go over it again.\n");
            }
        }

        public void generateredPass() {
            Alphabet alphabet = new Alphabet(includeUpper, includeLower, incNumber, includeSpecial);
            String availableCharacters = alphabet.getAlphabet();
        
            if (availableCharacters.isEmpty()) {
                System.out.println("You need to include at least one character type!");
                return;
            }
        
            int passwordLength = 12;
            StringBuilder password = new StringBuilder();
        
            for (int i = 0; i < passwordLength; i++) {
                int randomIndex = (int) (Math.random() * availableCharacters.length());
                password.append(availableCharacters.charAt(randomIndex));
            }
        
            System.out.println("Generated Password: " + password.toString());
        }
        

    }

    public void mainLoop() {
        System.out.println("Welcome Password Services :)");
        printMenu();

        Scanner sc = new Scanner(System.in);
        String userOption = "-1";

        while (!userOption.equals("4")) {
            userOption = sc.next();

            switch (userOption) {
                case "1" -> {
                    generator.getInfo();
                    printMenu();
                }
                case "2" -> {
                    // checkPassword();
                    printMenu();
                }
                case "3" -> {
                    // printUsefulInfo();
                    printMenu();
                }
                default -> {
                    System.out.println();
                    System.out.println("Kindly select one of the available commands");
                    printMenu();
                }
            }
        }
    }
}
