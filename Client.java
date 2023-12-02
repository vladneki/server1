package server1;
import java.io.*;
import java.net.Socket;

public class Client {

    private static Socket clientSocet;
    private static BufferedReader reader;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) {

        try {
            try {

                clientSocet = new Socket("localhost", 4004);

                reader = new BufferedReader(new InputStreamReader(System.in, "ibm866"));

                in = new BufferedReader(new InputStreamReader(clientSocet.getInputStream()));

                out = new BufferedWriter(new OutputStreamWriter(clientSocet.getOutputStream()));

                System.out.println("Вы что-то хотели сказать? Введите это здесь: ");

                String word = reader.readLine();

                out.write(word + "\n");

                out.flush();
                String serverWord = in.readLine();
                System.out.println(serverWord);

            } finally {

                System.out.println("Клиент был закрыт...");

                clientSocet.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

}
