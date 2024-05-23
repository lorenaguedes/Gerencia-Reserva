import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.GridLayout;

public class Main {

    public static void main(String[] args) {
        // lista do tipo reserva

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
       // Criar painel para os componentes
       JPanel painel = new JPanel();
       painel.setLayout(new GridLayout(5, 2, 5, 5)); // Layout em grade

       // Adicionar rótulos e campos de texto
       painel.add(new JLabel("Nome:"));
       painel.add(new JTextField(15));
       painel.add(new JLabel("CPF/CNPJ:"));
       painel.add(new JTextField(15));

       // Adicionar caixas de seleção
       JCheckBox caixaSelecaoCpf = new JCheckBox("CPF");
       JCheckBox caixaSelecaoCnpj = new JCheckBox("CNPJ");

       JCheckBox caixaSelecaoVista = new JCheckBox("À vista");
       JCheckBox caixaSelecaoParcelado = new JCheckBox("Parcelado");

       ButtonGroup tpCliente = new ButtonGroup();
       tpCliente.add(caixaSelecaoCnpj);
       tpCliente.add(caixaSelecaoCpf);

       ButtonGroup pgModo = new ButtonGroup();
       pgModo.add(caixaSelecaoVista);
       pgModo.add(caixaSelecaoParcelado);

       painel.add(caixaSelecaoCpf);
       painel.add(caixaSelecaoCnpj);

       painel.add(caixaSelecaoVista);
       painel.add(caixaSelecaoParcelado);

       // Exibir painel em um JOptionPane
       int opcao = JOptionPane.showConfirmDialog(null, painel, "Reservar Mesa", JOptionPane.OK_CANCEL_OPTION);

       // Processar a resposta do usuário
       if (opcao == JOptionPane.OK_OPTION) {
           // Obter valores dos campos de texto
           String nome = ((JTextField) painel.getComponent(1)).getText();
           String cpf = ((JTextField) painel.getComponent(3)).getText();

           // Obter valores das caixas de seleção
           boolean opcaoCpfSelecionada = caixaSelecaoCpf.isSelected();
           boolean opcaoCnpjSelecionada = caixaSelecaoCnpj.isSelected();

           boolean opcaoPgVistaSelecionada = caixaSelecaoVista.isSelected();
           boolean opcaoPgParceladoSelecionada = caixaSelecaoParcelado.isSelected();

           // separa tipo de cliente
           if (opcaoCpfSelecionada) {
             PessoaFisica cliente = new PessoaFisica(nome, cpf);
                if (opcaoPgVistaSelecionada) {
                    Reserva reserva = new Reserva(cliente, opcaoPgVistaSelecionada);
                }else{
                    Reserva reserva = new Reserva(cliente, opcaoPgParceladoSelecionada);
                }
           }else{
             PessoaJuridica cliente = new PessoaJuridica(nome,cpf);
                if (opcaoPgVistaSelecionada) {
                Reserva reserva = new Reserva(cliente, opcaoPgVistaSelecionada);
            }else{
                Reserva reserva = new Reserva(cliente, opcaoPgParceladoSelecionada);
            }
           }

           // Exibir informações
           String mensagem = "Nome: " + nome + "\n" +
                             "Cpf: " + cpf + "\n" +
                             "Opção 1: " + (opcaoCpfSelecionada ? "Sim" : "Não") + "\n" +
                             "Opção 2: " + (opcaoCnpjSelecionada ? "Sim" : "Não")+ "\n" +
                             "Opção 1: " + (opcaoPgVistaSelecionada ? "Sim" : "Não") + "\n" +
                             "Opção 2: " + (opcaoPgParceladoSelecionada ? "Sim" : "Não");
           JOptionPane.showMessageDialog(null, mensagem, "Dados Selecionados", JOptionPane.INFORMATION_MESSAGE);
       }
       // criar uma lista de reservas 
    }

    private static void cancelarReserva() {
        
    }

    private static void imprimirLista() {
       
    }

    private static void imprimirReserva() {
    
    }
}