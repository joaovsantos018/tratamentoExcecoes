package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    private Integer numeroDoQuarto;
    private Date checkin;
    private Date checkout;

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Date getCheckout() {
        return checkout;
    }

    public Date getCheckin() {
        return checkin;
    }

    public Integer getNumeroDoQuarto() {
        return numeroDoQuarto;
    }

    public void setNumeroDoQuartor(Integer numeroDoQuarto) {
        this.numeroDoQuarto = numeroDoQuarto;
    }

    public Reservation(Integer numeroDoQuarto, Date checkin, Date checkout) {
        this.numeroDoQuarto = numeroDoQuarto;
        this.checkin = checkin;
        this.checkout = checkout;
    }
     public long duracao() {
        long diff = checkout.getTime() - checkin.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
     }

     public void atualizarReserva(Date checkin, Date checkout){
        this.checkin = checkin;
        this.checkout = checkout;
     }

     @Override
     public String toString() {
        return "Quarto " + numeroDoQuarto
                + ", check-in: " + sdf.format(checkin)
                + ", check-out: " + sdf.format(checkout)
                + ", " + duracao() + " noites";
     }
}
