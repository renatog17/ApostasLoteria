# ApostasLoteria

Esta API foi construída com o objetivo de colocar em prático os conhecimentos sobre o ambiente Spring Boot e suas demais ferramentas. <br>
O objetivo desta API é ser um gerenciador de apostas nos concursos da Mega Sena.

# Ferramentas e conceitos abordados

* Spring Data

* Consumo de API externa

* RESTful

### Endpoints

GET: aposta/{email} - lista todas as apostas em ordem de data de um determinado usuário

POST: aposta/ - realiza uma aposta randômica para o usuário.

POST: apostador/ - cadastra um novo usuário.

GET: resultado/ - retorna o último resultado.

GET: resultado/{concurso} - retorna o resultado correspondente ao concurso passado como parametro
