import java.util.Random;
import java.util.Scanner;

public class GameTebakAngka {
    public static void main() {
        Random random = new Random();
        int secretNumber = random.nextInt(20) + 1;
        int score = 0;
        int guesses = 0;

        System.out.println("Selamat datang di permainan Tebak Angka!");
        System.out.println("Saya telah memilih angka antara 1 hingga 20. Coba tebak angka tersebut!");

        Scanner scanner = new Scanner(System.in);

        while (guesses < 20) {
            System.out.print("Masukkan tebakan Anda: ");
            int guess;

            try {
                guess = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Masukan tidak valid. Masukkan angka.");
                scanner.nextLine();
                continue;
            }

            if (guess < secretNumber) {
                System.out.println("Tebakan Anda terlalu rendah!");
                guesses++;
            } else if (guess > secretNumber) {
                System.out.println("Tebakan Anda terlalu tinggi!");
                guesses++;
            } else {
                System.out.println("Selamat! Anda berhasil menebak angka dengan benar!");
                score = (20 - guesses) * 100 / 20;
                break;
            }
        }

        System.out.println("Permainan selesai.");
        System.out.println("Score Anda: " + score + "%");

        scanner.close();
    }
}
