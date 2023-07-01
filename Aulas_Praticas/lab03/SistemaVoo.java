import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class SistemaVoo {

    // Variavel de FlightManager
    public static HashMap<String, Voo> recordedFlights = new HashMap<>();

    // Runner (main class)
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                if (!menu(scanner)) break;
            } catch (Exception e) {
                System.out.println("Formato errado.");
            }
        }
        scanner.close();
    }

    // Menu com opções disponíveis
    private static boolean menu(Scanner scanner) {

        System.out.println("\nEscolha uma opção: (H para ajuda)");

        System.out.print("> ");
        String input = scanner.nextLine();
        String[] cmd = input.split("[ \t]+",2);
        String opt = cmd[0];
        String flightCode;
        Voo v;

        // SWITCH CASE
	
    switch (opt) {
        case "H":
            printHelp();
            break;
        case "I":
            File wordFile = new File(cmd[1]);
            boolean result;
            result = wordFile.exists();
            if (result)
                System.out.println(wordFile.getAbsolutePath());
            if (!result) {
                System.out.println("File '" +wordFile + "' not found.");
            }
            else {
                v = new Voo(wordFile);
                if (!recordedFlights.containsKey(v.getFlightCode()))
                    recordedFlights.put(v.getFlightCode(), v);
                else
                    System.out.println("<!> Identificação de um voo já registado.");
            }
            break;
        case "M": 
            flightCode = cmd[1];
            if (recordedFlights.containsKey(flightCode))
                recordedFlights.get(flightCode).PrintFlightMap();
            else
                System.out.println("<!> Identificação de um voo não registado.");
            break;
        case "F":
            if (recordedFlights.containsKey(cmd[1].split("[ \t]", 2)[0]))
                System.out.println("<!> Identificação de um voo já registado.");
            else {
                v = new Voo(cmd[1]);
                recordedFlights.put(v.getFlightCode(), v);
            }
            break;
        case "R":
            break;
        case "C":
            break;
        case "Q":
            System.out.println("Exiting...");
            return false;
        default:
            System.out.println("\nOpção Inválida!\n");
            printHelp();
    }
    return true;
    }

    // TEXT BLOCK

    private static void printHelp() {

    System.out.println
        (
        "\nUsage:"
        + "\n> H"
        + "\n - apresenta as opções do menu.\n"
        + "\n> I <filename>"
        + "\n - lê um ficheiro de texto contento informação sobre um voo.\n"
        + "\n> M <flight_code>"
        + "\n - exibe o mapa das reservas de um voo.\n"
        + "\n> F <flight_code> <num_seats_executive> <num_seats_tourist>"
        + "\n - acrescenta um novo voo.\n"
        + "\n> R <flight_code> <class> <number_seat>"
        + "\n - acrescenta uma nova reserva a um voo.\n"
        + "\n> C <reservation_code>"
        + "\n - cancela uma reserva.\n"
        + "\n> Q"
        + "\n - termina o programa.\n"
        );
    }

}