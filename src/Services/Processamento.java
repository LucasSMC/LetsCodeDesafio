package Services;

import Dao.FileReader;
import Dao.FileWriter;
import Models.Pagamento;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Processamento {

    //FileReader dao = new FileReader();
    FileWriter writer = new FileWriter();

    public void processaPagamento(List<Pagamento> lista) {
        lista.stream().forEach((pagamento -> {
            new Thread(()->avaliaData(pagamento)).start();
        }));

    }

    private void avaliaData(Pagamento pagamento) {
        LocalDate dataVencimento = pagamento.getDataVencimento();
        LocalDate agora = LocalDate.now();
        if (agora.isAfter(dataVencimento)) {
            long semanas = ChronoUnit.WEEKS.between(dataVencimento, agora);
            pagamento.setValor(pagamento.getValor() * ((0.01 * semanas) + 1));
            long meses = ChronoUnit.MONTHS.between(dataVencimento,agora );
            int classificacao = (int) (Math.max(0L, (pagamento.getClassificacao() - meses)));
            pagamento.setClassificacao(classificacao);
            pagamento.setValor(pagamento.getValor() + 50);
        } else {
            double desconto = pagamento.getValor() * (0.01 * pagamento.getClassificacao());
            pagamento.setValor(pagamento.getValor() - Math.min(500, desconto));
        }
        writer.escreveArquivo(pagamento);

    }
}
