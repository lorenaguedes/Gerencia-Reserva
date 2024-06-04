import java.util.ArrayList;

import javax.swing.JOptionPane;

public class GerenciaListaReserva extends ArrayList<Reserva> {
    public void reservarMesa(Reserva reserva){
        String mensagem;
        add(reserva);
        if (size() < 6 ) {
            mensagem ="Reservado com sucesso\n";
            JOptionPane.showMessageDialog(null, mensagem, "Reserva concluida", JOptionPane.INFORMATION_MESSAGE);
        }else{
            mensagem ="Reservado com sucesso, voce está na lista de espera";
            JOptionPane.showMessageDialog(null, mensagem, "Reserva concluida", JOptionPane.INFORMATION_MESSAGE);
        }

    }
    public void pesquisarReserva(String cpf){
        boolean encontrou = false;
        forEach();
    }
    public void imprimirReserva(){}
    public void imprimirLista(){}
    public void cancelarReserva(){}

}
