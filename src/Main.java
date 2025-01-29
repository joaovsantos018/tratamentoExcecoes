import model.entities.Reservation;
import model.exception.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

      try{
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Numero do quarto");
        int numeroDoQuarto = sc.nextInt();
        System.out.print("data de check-in ");
        Date checkin = sdf.parse(sc.next());
        System.out.print("data de Check-out");
        Date checkout = sdf.parse(sc.next());


        Reservation reservation = new Reservation(numeroDoQuarto, checkin, checkout);
        System.out.println("Dados da reserva: " + reservation);

        System.out.println();
        System.out.println("Entre com os dados para atualizar a reserva");
        System.out.print("Check-in date");
        checkin = sdf.parse(sc.next());
        System.out.print("Check-out date");
        checkout = sdf.parse(sc.next());


       reservation.atualizarReserva(checkin, checkout);

        System.out.println("Dados da reserva: " + reservation);


    }catch (ParseException e) {
          System.out.println("Data inválida");
      }catch (DomainException e) {
          System.out.println("Data inválida" + e.getMessage());
      }catch (RuntimeException e) {
          System.out.println("Erro inesperado");
      }
    }
}
