package Dao;

import Models.Pagamento;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.format.DateTimeFormatter;

public class FileWriter {

    public synchronized void escreveArquivo(Pagamento pagamento){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("MM-yyyy");
        String data = pagamento.getDataVencimento().format(formato);
        Path concluidos = Path.of("concluidos");
        Path path = Path.of("concluidos","pagamentosAtualizados_"+data+".csv");
//        System.out.println(path + " " + pagamento.getDataVencimento() + " "+ pagamento.getClienteNome());

        if(!Files.exists(concluidos)){
            try {
                Files.createDirectory(concluidos);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if(!Files.exists(path)){
            try {
                Files.createFile(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try(BufferedWriter writer =Files.newBufferedWriter(path, StandardOpenOption.APPEND)){
                writer.append(pagamento.toCSV());
                writer.newLine();



        }catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
