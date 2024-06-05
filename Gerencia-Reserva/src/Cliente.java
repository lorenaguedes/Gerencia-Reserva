public abstract class  Cliente {
    String nome;
    String documento;
    
    public Cliente(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString(){
        return this.nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
