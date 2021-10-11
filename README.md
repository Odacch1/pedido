# pedido
Desafio da Nexti para desenvolvedor Júnior

Aplicação Back-end feita em Spring, utilizando Java 11.

A aplicação consiste em um cadastro de clientes, produtos e pedidos.

Foram feitos os métodos GET, POST e PUT. Para utilizar a aplicação é necessário uma ferramenta para conseguir utilizar esse métodos, como o Postman, um banco de dados em MySQL, utilizando a porta 3306 e ter o usuário root e senha 12345678, sendo o nome do banco pedidos. Caso for utilizar outro banco, pode ser modificado o arquivo application.properties em resources.

Será iniciado uma aplicação localhost na porta 8080, sendo acessada pelo link http://localhost:8080.

Clientes:

Para cadastro deve ser utilizado o método POST no link: http://localhost:8080/cliente, com os parâmetros de nome, cpf e data de nascimento, sendo a data de nascimento no formato de "MM/DD/YYYY".
Ex: http://localhost:8080/cliente?nome=Thales&cpf=12345678912&dataNascimento=10/10/1996

Para listar os clientes, pode ser utilizado o GET em dois links, http://localhost:8080/cliente, nesse com o parâmetro de id, retornando apenas o cliente do id, ou no link http://localhost:8080/cliente/lista, esse sem parâmetros e retornará todos os clientes cadastrados.

Para exclusão foi utilizado um atributo da classe com o nome de "ativo", indicando se o o cadastro está ou não ativo. Para desativar deve ser utilizado o método PUT no link http://localhost:8080/cliente/desativar com o id do cliente como parâmetro, caso for desativado com sucesso, irá retornar uma mensagem de sucesso. Para ativar pode ser utilizado o mesmo método no link http://localhost:8080/cliente/ativar com o id do cliente como parâmetro. A listagem de clientes só retorna os clientes ativos, porém caso a consulta for por id, ele pode ser verificado mesmo desativado.

Para alterações, foram feitos alguns métodos, podendo ser alterado cada atributo separadamente. Pode se alterar o nome pelo link: http://localhost:8080/cliente/alterarNome (PUT), passando como parâmetro o id do cliente a ser alterado e o novo nome para ele. Para alterar o Cpf, pode-se usar o link: http://localhost:8080/cliente/alterarCpf (PUT), sendo o mesmo parâmetro id do anterior e o novo cpf do cliente. Para alterar a data de nascimento, pode-se usar o link: http://localhost:8080/cliente/alterarNascimento (PUT), passando o mesmo parâmetro id dos anteriores e a nova data de nascimento do cliente no formato "MM/DD/YYYY".

Produto:

Para cadastro do produto deve ser utilizado
