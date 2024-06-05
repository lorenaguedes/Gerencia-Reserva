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

    public Reserva pesquisarReserva(String documento) {
        boolean encontrou = false;
        String mensagem;
        for (Reserva reserva : this) {
            if (reserva.getCliente() instanceof PessoaFisica) {
                if (((PessoaFisica) reserva.getCliente()).getCpf().equals(documento)) {
                    mensagem = "Reserva encontrada para o CPF/CNPJ: " + documento;
                    JOptionPane.showMessageDialog(null, mensagem, "Resultado pesquisa", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println(reserva);
                    encontrou = true;
                    return reserva;
                }
                
            } else if (reserva.getCliente() instanceof PessoaJuridica) {
                if (((PessoaJuridica) reserva.getCliente()).getCnpj().equals(documento)) {
                    mensagem = "Reserva encontrada para o CPF/CNPJ:" + documento;
                    JOptionPane.showMessageDialog(null, mensagem, "Resultado pesquisa", JOptionPane.INFORMATION_MESSAGE);
                    encontrou = true;
                    return reserva;
                }
            }
        }

        if (!encontrou) {
            mensagem = "Reserva não encontrada para o documento: " + documento;
            JOptionPane.showMessageDialog(null, mensagem, "Resultado pesquisa", JOptionPane.INFORMATION_MESSAGE);
        }
        
        return null;
    }

    public void imprimirReserva(String documento) {
        Reserva reserva = pesquisarReserva(documento); 
        if (reserva != null) { 
            String mensagem = "Detalhes da Reserva:\n";
            JOptionPane.showMessageDialog(null, mensagem, "Detalhes da Reserva", JOptionPane.INFORMATION_MESSAGE);
            mensagem = reserva.toString();
            JOptionPane.showMessageDialog(null, mensagem, "Detalhes da Reserva", JOptionPane.INFORMATION_MESSAGE); 
        } else {
            JOptionPane.showMessageDialog(null, "Reserva não encontrada para o documento: " + documento, "Detalhes da Reserva", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void imprimirLista() {
        String mensagem;
        int cont = 0;
        if (isEmpty()) { 
            mensagem = "Lista de Reservas vazia.";
            JOptionPane.showMessageDialog(null,mensagem, "Lista de Reservas", JOptionPane.INFORMATION_MESSAGE);

        } else {
            mensagem = "Lista de Reservas:";
            for (Reserva reserva : this) {
                if (cont < 6) {
                    mensagem += reserva.toString() + "\n";
                    cont++;
                }
            }

            JOptionPane.showMessageDialog(null,mensagem, "Lista de Reservas", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void cancelarReserva(String cpf) {
        Reserva reserva = pesquisarReserva(cpf); 
        String mensagem;
        if (reserva != null) { 
            remove(reserva); 
            mensagem = "Reserva cancelada com sucesso para o CPF: " + cpf;
            JOptionPane.showMessageDialog(null,mensagem, "Cancelar reserva", JOptionPane.INFORMATION_MESSAGE);
        } else {
            mensagem = "Reserva não encontrada para o CPF: " + cpf;
            JOptionPane.showMessageDialog(null,mensagem, "Cancelar reserva", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void imprimirListaReserva() {
        String mensagem;
        int cont = 0;
        if (isEmpty()) { 
            mensagem = "Lista de Reservas vazia.";
            JOptionPane.showMessageDialog(null,mensagem, "Lista de Reservas", JOptionPane.INFORMATION_MESSAGE);

        } else {
            mensagem = "Lista de Reservas:";
            for (Reserva reserva : this) {
                if (cont > 6) {
                    mensagem += reserva.toString() + "\n";
                    cont++;
                }
            }

            JOptionPane.showMessageDialog(null,mensagem, "Lista de Espera", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
