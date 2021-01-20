import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    private static Hall[] halls;

    public static void main(String[] args) {
//        if (args.length % 3 != 0 || args.length < 3) {
//            System.err.println("Wrong arguments!\n" +
//                    "\tFirst argument is count rows,\n" +
//                    "\tSecond argument is count chairs in row,\n" +
//                    "\tThird argument is price.");
//            return;
//        }
        halls = new Hall[args.length / 3];
        int j = 0;
        for (int i = 0; i < args.length; i += 3) {
            if (parseInt(args[i]) <= 0 || parseInt(args[i + 1]) <= 0 || parseInt(args[i + 2]) <= 0) {
                System.err.println("Row and count are should be bigger than 0");
                return;
            }
            halls[j++] = new Hall(parseInt(args[i]), parseInt(args[i + 1]), Integer.parseInt(args[i + 2]));
        }

        System.out.println("\u001B[32mThe halls is complete success!\u001B[0m");
        console();
    }

    private static void console() {
        Scanner sc = new Scanner(System.in);
        System.out.println("List of available commands:\n" +
                "\t\u001B[33mshow <hall's char>\u001B[0m - Show hall\n" +
                "\t\u001B[33mres <hall's char> <row> <place>\u001B[0m - Place reservation\n" +
                "\t\u001B[33munres <hall's char> <row> <place>\u001B[0m - Place unreservation\n" +
                "\t\u001B[33mprice <hall's char> <row> <price>\u001B[0m - Price for this row\n" +
                "\t\u001B[33mend\u001B[0m - End of program.");

        while (true) {
            System.out.println("Enter command:");
            String str = sc.nextLine();
            if (str.startsWith("show")) {
                String[] sep = str.split(" ");
                if (sep.length < 2) {
                    System.err.println("There is no complete numbers");
                    continue;
                }
                int k = (sep[1].charAt(0) - 65);
                if (k < 0 || k > halls.length - 1) {
                    System.err.println("This hall is not exist");
                    continue;
                }
                showHall(k);
            } else if (str.startsWith("res")) {
                String[] sep = str.split(" ");
                if (sep.length < 4) {
                    System.err.println("There is no complete numbers");
                    continue;
                }
                int k = (sep[1].charAt(0) - 65);
                if (k < 0 || k > halls.length - 1) {
                    System.err.println("This hall is not exist");
                    continue;
                }
                int result = halls[k].resChair(parseInt(sep[2]), parseInt(sep[3]));
                if (result == -1) {
                    System.err.println("This place is not exist!");
                } else if (result == 0) {
                    System.err.println("This place is already reserved!");
                } else {
                    System.out.println("The price for this place is " + halls[k].getChairs()[parseInt(sep[2])-1][parseInt(sep[3])-1].getPrice());
                    System.out.println("This place is successfully reserved");
                }
            } else if (str.startsWith("price")) {
                String[] sep = str.split(" ");
                if (sep.length < 4) {
                    System.err.println("There is no complete numbers");
                    continue;
                }
                int k = (sep[1].charAt(0) - 65);
                if (k < 0 || k > halls.length - 1) {
                    System.err.println("This hall is not exist");
                    continue;
                }
                int n = (Integer.parseInt(sep[2]) - 1);
                if (n < 0 || n > halls[k].getRow()) {
                    System.err.println("This place is not exist");
                    continue;
                }
                int p = Integer.parseInt(sep[3]);
                if (p <= 0) {
                    System.err.println("The price can't be lower than zero");
                    continue;
                }
                for (int i = 0; i < halls[k].getCount(); i++) {
                    halls[k].editPrice(n, i, p);
                }
                System.out.println("The price for this row is changed");

            } else if (str.startsWith("unres")) {
                String[] sep = str.split(" ");
                if (sep.length < 4) {
                    System.err.println("There is no complete numbers");
                    continue;
                }
                int k = (sep[1].charAt(0) - 65);
                if (k < 0 || k > halls.length - 1) {
                    System.err.println("This hall is not exist");
                    continue;
                }
                int result = halls[k].unresChair(parseInt(sep[2]), parseInt(sep[3]));
                if (result == -1) {
                    System.err.println("This place is not exist!");
                } else if (result == 0) {
                    System.err.println("This place is not reserved!");
                } else {
                    System.out.println("This place is successfully unreserved");
                }
            } else if (str.equals("end")) {
                System.out.println("The program is over");
                return;
            } else {
                System.err.println("This command is never exist!");
            }
        }
    }

    private static void showHall(int c) {
        Chair[][] chairs = halls[c].getChairs();
        System.out.print("\t");
        for (int i = 0; i < ((halls[c].getCount() * 4) - 3); i++) System.out.print("=");
        System.out.println();

        for (int i = 0; i < halls[c].getRow(); i++) {

            for (int j = 0; j < halls[c].getCount(); j++) {
                if (j == 0) System.out.print((i + 1) + "\t");
                if (chairs[i][j].isReserved()) {
                    System.out.print("\u001B[32m@\u001B[0m\t");
                } else {
                    System.out.print(".\t");
                }
            }
            System.out.println(chairs[i][0].getPrice() + " Kc");
        }
        for (int i = 0; i < halls[c].getCount(); i++) System.out.print("\t" + (i + 1));
        System.out.println();
    }
}
