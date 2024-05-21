import javax.swing.JOptionPane;

public class Main {
    private static Reserva playlist = new Reserva();

    public static void main(String[] args) {
        boolean sair = false;
        while (!sair) {
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

    private static void cancelarReserva() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'cancelarReserva'");
    }

    private static void imprimirLista() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'imprimirLista'");
    }

    private static void imprimirReserva() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'imprimirReserva'");
    }

    private static void pesquisarReserva() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pesquisarReserva'");
    }

    private static void reservarMesa() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'reservarMesa'");
    }

    