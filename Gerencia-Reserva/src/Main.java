import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        boolean finalizar = false;
        while (!finalizar) {
            String opcaoStr = JOptionPane.showInputDialog(null,
                    "1. Reservar Mesa\n" +
                            "2. Pesquisar Reserva\n" +
                            "3. Imprimir Reserva\n" +
                            "4. Imprimir lista de espera\n" +
                            "5. Cancelar Reserva\n" +
                            "6. Finalizar\n" +
                            "Escolha uma opção:");
            int opcao = Integer.parseInt(opcaoStr);

            switch (opcao) {
                case 1:
                    reservarMesa();
                    break;
                case 2:
                    pesquisarReserva();
                    break;
                case 3:
                    imprimirReserva();
                    break;
                case 4:
                    imprimirLista();
                    break;
                case 5:
                    cancelarReserva();
                    break;
                case 6:
                    finalizar = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }

    }

    private static void pesquisarReserva() {
    
    }

    private static void reservarMesa() {
    
    }

    private static void cancelarReserva() {
        
    }

    private static void imprimirLista() {
       
    }

    private static void imprimirReserva() {
    
    }
}