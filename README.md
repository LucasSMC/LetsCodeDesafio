# LetsCodeDesafio
Realização de desafio do LetsCode(Ada-Tech)

Enunciado:


Enunciado
O projeto consiste em implementar um processador de pagamentos utilizando os recursos que foram ensinados durante o modulo.

Seguem instruções:

Ler os arquivos da pasta (csv)
Converter em objetos Java Pagamentos

  { 
  
      clienteNome : String
      
      dataVencimento : LocalDate
      
      valor : Double
      
      classificacao : Integer
      
      
  )
  
Realizar o processamento dos pagamentos conforme as seguintes regras:

Caso a data de pagamento esteja em atraso:

Multa inicial de 50 reais.

1% de juros para cada semana de atraso

Para cada mês de atraso a classificação do cliente cai um ponto (10 -> 0)

Caso o pagamento ainda esteja dentro do prazo:

% de desconto de acordo com classificação (Classificação 10, 10% de desconto. Classificação 1, 1% de desconto...)

Desconto não deve exceder os 500 reais.

Após aplicado a alteração de valor, o registro deve ser escrito no arquivo 'pagamentosAtualizados_'DATA'.

Observações:

Utilize o parâmetro do nome do arquivo no formato 'MM-yyyy', separando os registros por arquivo conforme mes e ano de vencimento.

O processamento dos objetos devem ser feitos em paralelo.

A escrita do arquivo deve ser feita em tempo real (processa, escreve, processa, escreve...)
