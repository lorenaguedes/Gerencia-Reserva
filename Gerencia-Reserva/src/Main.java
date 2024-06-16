import javax.swing.*;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static GerenciaListaReserva listaReserva = new GerenciaListaReserva();
    public static void main(String[] args) {
        // criar uma lista de reservas 
        
        

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

            if (opcaoStr == null) {
                // Usuário clicou em cancelar ou fechou a janela
                JOptionPane.showMessageDialog(null, "Operação cancelada.");
                break;
            }

            try {
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
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida! Por favor, insira um número.");
            }
        }
    }

    private static void pesquisarReserva() {
     // objeto reserva
        Reserva reserva;
        
       // Criar painel para os componentes
       JPanel painel = new JPanel();
       painel.setLayout(new GridLayout(5, 2, 5, 5)); // Layout em grade

       // Adicionar rótulos e campos de texto
       painel.add(new JLabel("CPF/CNPJ:"));
       painel.add(new JTextField(15));

       int opcao = JOptionPane.showConfirmDialog(null, painel, "Pesquisar reserva", JOptionPane.OK_CANCEL_OPTION);

       // Processar a resposta do usuário
       if (opcao == JOptionPane.OK_OPTION) {
           // Obter valores dos campos de texto
           String cpf = ((JTextField) painel.getComponent(1)).getText();
           listaReserva.pesquisarReserva(cpf);
       }
    }

    private static void reservarMesa() {
        // objeto reserva
        Reserva reserva;
        
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
                    reserva = new Reserva(cliente, opcaoPgVistaSelecionada ? opcaoPgVistaSelecionada : opcaoPgParceladoSelecionada);
                } else {
                    PessoaJuridica cliente = new PessoaJuridica(nome, cpf);
                    reserva = new Reserva(cliente, opcaoPgVistaSelecionada ? opcaoPgVistaSelecionada : opcaoPgVistaSelecionada);
                }

           listaReserva.reservarMesa(reserva);
        
       }
       
    }

    private static void cancelarReserva() {
 
       // Criar painel para os componentes
       JPanel painel = new JPanel();
       painel.setLayout(new GridLayout(5, 2, 5, 5)); // Layout em grade

       // Adicionar rótulos e campos de texto
       painel.add(new JLabel("CPF/CNPJ:"));
       painel.add(new JTextField(15));

       int opcao = JOptionPane.showConfirmDialog(null, painel, "Deletar reserva", JOptionPane.OK_CANCEL_OPTION);

       // Processar a resposta do usuário
       if (opcao == JOptionPane.OK_OPTION) {
           // Obter valores dos campos de texto
           String cpf = ((JTextField) painel.getComponent(1)).getText();
           listaReserva.cancelarReserva(cpf);
       }
    }

    private static void imprimirLista() {
        listaReserva.imprimirListaReserva();
    }

    private static void imprimirReserva() {
        listaReserva.imprimirLista();
    }
}