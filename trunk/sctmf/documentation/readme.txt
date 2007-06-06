readme.txt

Sistema de Cria��o e Testes de Modelos Formais

Id�ia do Prof. YANDRE MALDONADO E GOMES DA COSTA 

"A id�ia � fazer uma ferramenta, multiplataforma, atrav�s da qual o usu�rio 
possa criar modelos formais e, em seguida, test�-los fornecendo cadeias para que
 os mesmos fa�am uma an�lise sint�tica destas. � algo parecido com o que voc� 
fez para Aut�mato com Pilha, entretanto, adicionariamos uma s�rie de outras 
possibilidades de modelos formais que poderiam ser criados pelo usu�rio, desde 
os mais simples, at� os mais complexos.
Para tentar organizar as coisas, podemos pensar em classificar os modelos de 
acordo com o poder de representa��o de linguagens. Assim, se pens�ssemos 
inicialmente nos mais simples (considerando a hierarqui de Chomsky), poder�amos 
come�ar por aqueles que s�o suficientes para representar linguagens regulares. 
Seria bom, inicialmente, come�armos a definir tamb�m quais ser�o os modelos 
indispens�veis, que dever�o constar na ferramenta de qualquer forma. Depois, 
conforme o avan�o do trabalho, poder�amos acrescentar outros.
Minha sugest�o inicial seria que part�ssemos dos seguintes modelos:

Para Linguagens Regulares:
- AFD
- AFND
- Express�es Regulares

Para Linguagens Livres de Contexto
- Aut�mato com Pilha
- Gram�tica Livre de Contexto

Para Linguagens Sens�veis ao Contexto
- Gram�tica Sens�vel ao Contexto
- Um modelo reconhecedor, a ser escolhido, para esta categoria 
(provavelmente Aut�mato com duas Pilhas)

Para Linguagens Enumer�veis Recursivamente
- M�quina de Turing
- Gram�tica com Estrutura de Frase

Al�m destes modelos, poder�amos implementar tamb�m transforma��es entre modelos 
equivalentes. Por exemplo: de Aut�mato com Pilha para Gram�tica Livre de 
Contexto. "

==============================================================================
E-mail dia 13/02/07
"Oi Rafael,

  Estou escrevendo para te informar alguns detalhes sobre os pr�ximos modelos 
formais que podem ser desenvolvidos. Acho que o pr�ximo modelo que deve ser 
desenvolvido seria o do AFND (Aut�mato Finito N�o Determin�stico). 
Este modelo � muito parecido com o AFD, eles se equivalem em poder de 
representa��o de linguagens � a rigor s�o pouco poderosos, podem apenas 
descrever linguagens regulares (categoria mais restrita). 
A diferen�a do AFND para o AFD consiste no fato de que o AFND 
permite que exista mais de um estado inicial, al�m disso, 
em um AFND pode existir mais de uma fun��o definida para um mesmo par 
Sx�, ou seja, para um mesmo estado pode haver mais de uma transi��o 
rotulada com o mesmo s�mbolo do alfabeto. Estas duas caracter�sticas 
conferem ao AFND o car�ter n�o-determin�stico, isto �, o processamento 
de uma mesma cadeia pode acontecer de maneiras diferentes em um AFND. 
Acho que o pr�ximo passo � come�ar a trabalhar com este cara. 
Uma id�ia interessante que tive � a de fazer convers�es entre modelos 
equivalentes. Por exemplo: criar um bot�o "Gerar AFD" na tela de 
cria��o do AFND para fazer a convers�o de um modelo para o outro e etc. 
Isto � uma id�ia para come�ar daqui um tempo.

Outra coisa que eu preciso � o seguinte: preciso de uma c�pia daquele 
e-mail que te mandei fazendo um esbo�o (ou um esqueleto) do trabalho, 
eu perdi a minha c�pia. Preciso tamb�m que voc� me encaminhe uma esp�cie 
de "tutorial" para me explicar como eu rodo estas aplica��es que voc� me 
manda, eu n�o me lembro como fizemos para rodar aquelas do ano passado...

 

Um abra�o."

