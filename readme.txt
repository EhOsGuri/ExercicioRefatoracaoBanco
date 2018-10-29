#ESPECIFICACAO DE SOFTWARE
## Modulo de acesso a conta corrente do Banco Nossa Grana

O m�dulo de acesso a conta corrente � um m�dulo simples que deve permitir ao funcion�rio do banco executar opera��es b�sicas sobre as contas correntes:
* Consultar saldo
* Consultar �ltimos movimentos
* Consultar a categoria da conta
* Efetuar dep�sitos
* Efetuar retiradas
* Consultar estat�sticas sobre a conta corrente

O sistema � composto por tres telas:
* Tela de identifica��o da conta corrente: nesta tela o usu�rio informa o n�mero da conta corrente que deseja acessar.

* Tela de opera��es: nesta tela o usu�rio visualiza o saldo, a categoria da conta, o limite di�rio para saque e os �ltimos movimentos da conta informada e pode executar opera��es de dep�sito e retirada.

* Tela de estat�sticas: nesta tela o usu�rio visualiza informa��es gerais sobre a conta tais como: saldo m�dio no m�s/ano indicados; total e quantidade de cr�ditos no m�s ano indicados; total e quantidade de d�bitos no m�s ano indicados. O usu�rio tem acesso a tela de estatisticas a partir da tela de operacoes  << ESTA TELA AINDA N�O ESTA IMPLEMENTADA !!

Nesta primeira vers�o os dados das contas s�o mantidos em um arquivo texto. � necess�rio garantir que sempre que o sistema � encerrado as movimenta��es atualizadas das contas s�o salvas neste arquivo.

As contas desse banco tem um comportamento espec�fico. Quanto mais dinheiro o cliente tem depositado mais o banco valoriza seus dep�sitos. Todos as contas iniciam na categoria �Silver� e zeradas. Contas �Silver� n�o t�m seus dep�sitos valorizados, ou seja, o valor creditado � exatamente o valor depositado pelo cliente. Quando o saldo da conta atinge ou ultrapassa R$ 50.000,00, a conta passa para a categoria �Gold�. Contas �Gold� t�m seus dep�sitos valorizados em 1%. Neste caso se o cliente depositar R$ 1.000,00 o valor creditado ser� de R$ 1.010,00. Finalmente se o saldo da conta atinge ou supera os R$ 200.000,00, a conta passa para a categoria �Platinum�. Contas �Platinum� t�m seus dep�sitos valorizados em 2,5%. A verifica��o de �upgrade� da conta se d� via opera��o de dep�sito, e n�o � poss�vel que um cliente fa�a �upgrade� diretamente de �Silver� para �Platinum� em uma �nica opera��o.

Quando o saldo da conta diminui, em fun��o de uma opera��o de retirada/saque, a categoria tamb�m pode retroceder. Os limites, por�m, n�o s�o os mesmos ao verificados quando uma conta sofre �upgrade�. Uma conta s� perde sua categoria �Platinum�, e passa para �Gold�, se o saldo cair abaixo de R$ 100.000,00. A conta s� perde a categoria �Gold�, e passa para �Silver�, se o saldo cair para menos de R$ 25.000,00. Note que uma conta nunca perde duas categorias em uma �nica opera��o de retirada mesmo que o saldo caia abaixo de R$ 25.000,00. Se ele era �Platinum�, cai para �Gold�. S� poder� cair para �Silver� na pr�xima opera��o de retirada. Observa��o: as contas nunca podem ficar negativas (o banco n�o trabalha com cheque especial).

ATENCAO: contas Silver possuem um limite di�rio de R$ 10000,00 para saques; contas Gold possuem um limite di�rio de R$ 100000,00 para saques; contas Platinum possuem um limite di�rio de 500000,00 para saques. <<< ESTAS RESTRI��ES AINDA N�O EST�O IMPLEMENTADAS !!

Para efeitos de armazenamento no arquivo a categoria �Silver� � identificada com o n�mero �0�, a categoria �Gold� com o n�mero �1� e a categoria �Platinum� com o n�mero �2�.

O n�mero de conta pode ser qualquer inteiro positivo.

PERSISTENCIA DOS DADOS:
Para simplificar a troca de dados os seguintes arquivos s�o fornecidos:

* Persistencia.java:
  * modulo Java com m�todos para leitura e grava��o de dados relativos a contas corrente e movimenta��es de contas corrente (opera��es de dep�sito e retirada).
* BDContasBNG.txt:
  * arquivo exemplo com dados de contas corrente.
* BDOperBNG.txt:
  * arquivo exemplo com dados de opera��es sobre contas corrente.

ROTEIRO DE TRABALHO:

PARTE I: completar a implementa��o atual
1) Analisar a implementa��o do sistema
2) Implementar as funcionalidades que est�o faltando
3) Identificar os eventuais problemas encontrados

PARTE II: refatora��o

1) Ado��o do padr�o Singleton
Inicialmente aplica-se o padr�o singleton na classe "Persistencia".
Depois criam-se as classes "Contas" e "Operacoes" que ir�o
encapsular o dicion�rio de contas e a lista de opera��es.

Isso ir� permitir tanto aplicar o padr�o singleton como
opera��es de mais alto n�vel como manter a "conta em uso" como a
lista de opera��es da "conta em uso".

2) Ado��o da arquitetura em 3 camadas e do padr�o fachada
Ser� criada a classe LogicaOperacoes com as opera��es
demandadas pela camada de interface com o usu�rio:
- Definir conta em uso
- Opera�ao de cr�dito
- Operacao de d�bito
- Solicita extrato
- Solicita saldo
- Solicita saldo medio
- Total cr�ditos
- Total d�bitos
- VALIDACOES: criar uma classe (singleton) para validacoes dos limites di�rios de saques.

Isso ir� permitir que a dependencia da camada de 
apresentacao para a de l�gica se restrinja a apenas
uma classe.

3) Ado��o do padr�o StatePattern
Cria a interface StateConta
Altera a classe conta para explorar o padr�o StatePattern. 
Explora classes aninhadas.

4) Ado��o do padr�o Factory e padrao Factory Method
** para a cria��o dos StatePattern (Factory)
** para a criacao das operacoes (Factory Methods especificos para deposito e retirada)

5) Ado��o do padr�o Observer - funcionalidade adicional
Criar um dialogo modeless que mant�m vis�vel o nome do correntista e o saldo m�dio com o maior saldo m�dio da ag�ncia. Adotar observer para ser notificado pela persistencia toda vez que esta informa��o variar.

