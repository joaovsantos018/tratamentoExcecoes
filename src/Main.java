import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Numero do quarto");
        int numeroDoQuarto = sc.nextInt();
        System.out.print("data de check-in ");
        Date checkin = sdf.parse(sc.next());
        System.out.print("data de Check-out");
        Date checkout = sdf.parse(sc.next());

        if(!checkout.after(checkin)){
            System.out.println("Data de checkout se inicia antes da data de inicio");
        }else {
            Reservation reservation = new Reservation(numeroDoQuarto, checkin, checkout);
            System.out.println("Dados da reserva: " + reservation);

            System.out.println();
            System.out.println("Entre com os dados para atualizar a reserva");
            System.out.print("Check-in date");
            checkin = sdf.parse(sc.next());
            System.out.print("Check-out date");
            checkout = sdf.parse(sc.next());

            Date now = new Date();
            if(checkin.before(now) || checkout.before(now)) {
                System.out.println("Erro na reserva: a Data de atualizada tem que ser futura");
            }else if(!checkout.after(checkin)){
                System.out.println("Data de checkout se inicia antes da data de inicio");
            }else {
            reservation.atualizarReserva(checkin, checkout);
            System.out.println("Dados da reserva: " + reservation);
            }

        }
    }
}
