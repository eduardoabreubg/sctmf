readme.txt

Sistema de Criação e Testes de Modelos Formais

Idéia do Prof. YANDRE MALDONADO E GOMES DA COSTA 

"A idéia é fazer uma ferramenta, multiplataforma, através da qual o usuário 
possa criar modelos formais e, em seguida, testá-los fornecendo cadeias para que
 os mesmos façam uma análise sintática destas. É algo parecido com o que você 
fez para Autômato com Pilha, entretanto, adicionariamos uma série de outras 
possibilidades de modelos formais que poderiam ser criados pelo usuário, desde 
os mais simples, até os mais complexos.
Para tentar organizar as coisas, podemos pensar em classificar os modelos de 
acordo com o poder de representação de linguagens. Assim, se pensássemos 
inicialmente nos mais simples (considerando a hierarqui de Chomsky), poderíamos 
começar por aqueles que são suficientes para representar linguagens regulares. 
Seria bom, inicialmente, começarmos a definir também quais serão os modelos 
indispensáveis, que deverão constar na ferramenta de qualquer forma. Depois, 
conforme o avanço do trabalho, poderíamos acrescentar outros.
Minha sugestão inicial seria que partíssemos dos seguintes modelos:

Para Linguagens Regulares:
- AFD
- AFND
- Expressões Regulares

Para Linguagens Livres de Contexto
- Autômato com Pilha
- Gramática Livre de Contexto

Para Linguagens Sensíveis ao Contexto
- Gramática Sensível ao Contexto
- Um modelo reconhecedor, a ser escolhido, para esta categoria 
(provavelmente Autômato com duas Pilhas)

Para Linguagens Enumeráveis Recursivamente
- Máquina de Turing
- Gramática com Estrutura de Frase

Além destes modelos, poderíamos implementar também transformações entre modelos 
equivalentes. Por exemplo: de Autômato com Pilha para Gramática Livre de 
Contexto. "

==============================================================================
E-mail dia 13/02/07
"Oi Rafael,

  Estou escrevendo para te informar alguns detalhes sobre os próximos modelos 
formais que podem ser desenvolvidos. Acho que o próximo modelo que deve ser 
desenvolvido seria o do AFND (Autômato Finito Não Determinístico). 
Este modelo é muito parecido com o AFD, eles se equivalem em poder de 
representação de linguagens – a rigor são pouco poderosos, podem apenas 
descrever linguagens regulares (categoria mais restrita). 
A diferença do AFND para o AFD consiste no fato de que o AFND 
permite que exista mais de um estado inicial, além disso, 
em um AFND pode existir mais de uma função definida para um mesmo par 
Sxå, ou seja, para um mesmo estado pode haver mais de uma transição 
rotulada com o mesmo símbolo do alfabeto. Estas duas características 
conferem ao AFND o caráter não-determinístico, isto é, o processamento 
de uma mesma cadeia pode acontecer de maneiras diferentes em um AFND. 
Acho que o próximo passo é começar a trabalhar com este cara. 
Uma idéia interessante que tive é a de fazer conversões entre modelos 
equivalentes. Por exemplo: criar um botão "Gerar AFD" na tela de 
criação do AFND para fazer a conversão de um modelo para o outro e etc. 
Isto é uma idéia para começar daqui um tempo.

Outra coisa que eu preciso é o seguinte: preciso de uma cópia daquele 
e-mail que te mandei fazendo um esboço (ou um esqueleto) do trabalho, 
eu perdi a minha cópia. Preciso também que você me encaminhe uma espécie 
de "tutorial" para me explicar como eu rodo estas aplicações que você me 
manda, eu não me lembro como fizemos para rodar aquelas do ano passado...

 

Um abraço."

