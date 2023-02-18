package Dao;

import Models.Pagamento;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileReader {

    public List<Pagamento> LerArquivos(Path arquivo){
        List<Pagamento> lista = new ArrayList<>();
        try (BufferedReader bufferedReader = Files.newBufferedReader(arquivo)){
            bufferedReader.lines().forEach(line-> {
                lista.add(trataLinha(line));
            });
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Falha o ler o arquivo");
        }

        return lista;
    }
    public List<Path> listaArquivos() throws IOException {
        Path csvDirectory = Path.of("./csv");
        if(Files.isDirectory(csvDirectory)){
           return Files.list(csvDirectory).toList();
        }

        return Collections.emptyList();
    }

    private Pagamento trataLinha(String linha){
        String[] campos = linha.split(";");
        try {
            Integer classificacao = Integer.valueOf(campos[3]);
            Double valor = Double.valueOf(campos[2]);
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(campos[1], formato);

        return new Pagamento(campos[0],data,valor,classificacao);
        }catch (DateTimeParseException e){
            //e.printStackTrace();
            return null;
        }catch (NumberFormatException e){
            //e.printStackTrace();
            return null;
        }
    }


}
