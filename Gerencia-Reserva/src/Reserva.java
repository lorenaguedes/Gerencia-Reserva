public class Reserva implements Pagamento{
    private Cliente cliente;
    private Boolean pagamentoAvista;

    public Reserva(Cliente cliente, Boolean pagamentoAvista) {
        this.cliente = cliente;
        this.pagamentoAvista = pagamentoAvista;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Boolean getPagamentoAvista() {
        return pagamentoAvista;
    }

    public void setPagamentoAvista(Boolean pagamentoAvista) {
        this.pagamentoAvista = pagamentoAvista;
    }

    // falta  retornar tipo do cliente 
    @Override 
    public String toString() {
        String pagamento = getPagamentoAvista() ? "À vista" : "Parcelado";
        return String.format("%-20s (%-3s) - %s", cliente.getNome(), cliente.getClass().getSimpleName(), pagamento);
    }

    @Override
    public double calcularPagamento(Boolean pagVista) {
       if (pagVista) {
        return 2880;
       }
        // parcelado precisa da qt de vezes?
        return 3200;
    }
    
}
