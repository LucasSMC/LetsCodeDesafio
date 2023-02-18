import Dao.FileReader;
import Models.Pagamento;
import Services.Processamento;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Main {
    public static Processamento service = new Processamento();

    public static void main(String[] args) throws Exception {
        List<Path> arquivos = Collections.emptyList();
        FileReader dao = new FileReader();
        try {
            arquivos = dao.listaArquivos();
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception(" Aconteceu algo");
        }
        List<List<Pagamento>> pagamentos = new ArrayList<>();
        arquivos.stream().forEach(path -> pagamentos.add(dao.LerArquivos(path)));

        pagamentos.stream().forEach(lista -> {

             lista.removeIf(Objects::isNull);
            service.processaPagamento(lista);
        });
    }
}