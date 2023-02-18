package Models;

import java.time.LocalDate;

public class Pagamento {
    private String clienteNome;

    private LocalDate dataVencimento;

    private Double valor;

    private Integer classificacao;


    public Pagamento(String clienteNome, LocalDate dataVencimento, Double valor, Integer classificacao) {
        this.clienteNome = clienteNome;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.classificacao = classificacao;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public Double getValor() {
        return valor;
    }

    public Integer getClassificacao() {
        return classificacao;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setClassificacao(Integer classificacao) {
        this.classificacao = classificacao;
    }

    public String toCSV() {
        StringBuilder builder = new StringBuilder();
        builder.append(clienteNome).append(";");
        builder.append(dataVencimento).append(";");
        builder.append(valor).append(";");
        builder.append(classificacao);
        return builder.toString();
    }

    @Override
    public String toString() {
        return "Pagamento{" +
                "clienteNome='" + clienteNome + '\'' +
                ", dataVencimento=" + dataVencimento +
                ", valor=" + valor +
                ", classificacao=" + classificacao +
                '}';
    }
}
