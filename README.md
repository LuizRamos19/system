# system

Sistema para cadastros de chamados do service desk

Link para o site: https://webapp-171205154119.azurewebsites.net/index.xhtml

PARA BAIXAR DO GITHUB E IMPORTAR PARA O ECLIPSE

Uma vez feito o download do projeto no GitHub, basta importá-lo para o eclipse e aguardar alguns minutos para que o eclipse realize a configuração do workspace. O projeto foi criado com maven, então por isso é necessário aguardar para que o maven faça o download das dependências necessárias para conseguir abrir o projeto no eclipse. Caso o eclipse apresente algum erro informando que não conseguiu fazer o download das dependências, pode ser que a sua conexão de internet esteja impossibilitando o maven de realizar os downloads necessários. Neste caso é necessário fazer a configuração com outra conexão a internet.

INICIANDO O SISTEMA

	O sistema já possui 3 usuários cadastrados que podem se logar.
	São eles: 
		User: "admin"  Password: "123456"
		User: "admin2" Password: "senha"
		User: "admin3" Password: "teste"

Caso tente acessar com outro que não seja estes 3, não será possível acessar o sistema. Não foi criada a funcionalidade de cadastro para acesso ao sistema, pois como se trata de uma empresa, o cadastro dos novos funcionários é feito diretamente pelo banco de dados e o username e senha são enviados diretamente ao gerente imediato do novo funcionário.

APÓS TELA DE LOGIN

OBS: Em todas as telas, caso haja dúvida por parte do usuário do que inserir em cada campo, basta deixar o cursor do mouse em cima do texto que se pede ou até mesmo em cima da caixa de texto.

No canto superior direito tem o botão de logout, que serve para que o sistema encerre a sessão daquele usuário logado. Caso tente copiar o endereço de umas das páginas quando estiver logado no sistema, para que depois que efetuar o logout tenta acessar essa mesma página, o browser irá redirecionar automaticamente para a tela de login solicitando que o usuário se logue novamente.

Atentar-se de que o tempo para expirar a sessão, caso o usuário não efetue nenhuma ação dentro da página do sistema, é de 30 minutos. Após isso caso o usuário tente mexer no sistema, o mesmo será redirecionado para a tela de login para que entre novamente com o usuário e senha.
Um usuário pode ter mais de uma sessão logada dentro do sistema, isso se faz necessário devido a possibilidade do usuário ter que se logar em browsers diferentes.

DENTRO DO SISTEMA

TICKETS > TELA DO GRÁFICO: Esta tela deverá aparecer em branco sem nenhuma informação caso não haja nenhum ticket registrado no sistema. O gráfico só poderá aparecer assim que pelo menos um ticket seja registrado no sistema.

CADASTROS > TELA DE EMPRESA: Esta tela traz uma tabela com todas as empresas cadastradas no sistema. Nesta tabela, é possível editar os dados da empresa escolhida ou excluir a empresa. Em cima da tabela tem um botão para cadastrar nova empresa. Este botão serve para registrar uma empresa no sistema. Na tela de nova empresa, o usuário pode escolher a identificação da empresa, que pode ser uma abreviação do nome da empresa e colocar o nome completo da mesma, caso o usuário insira dados em ambos os campos que já existam no banco de dados do sistema, aparecerá mensagem informando que não é possível gravar aquela empresa, pois já existe uma empresa com aqueles dados inseridos no banco. Esse registro se faz necessário para que as funcionalidades de cadastrar localidades e funcionários possam ser efetuadas com sucesso.  

CADASTROS > TELA DE LOCALIDADES: Esta tela traz uma tabela com todas as localidades cadastradas no sistema. Nesta tabela, é possível editar os dados da localidade escolhida ou excluir a localidade. Em cima da tabela tem um botão para cadastrar nova localidade. Este botão serve para registrar uma nova localidade no sistema. Na tela de nova localidade, é necessário escolher primeiro a identificação da empresa a qual pertence aquela localidade, colocar o endereço da localidade e o último campo informa se aquela localidade é crítica ou não, caso ocorra um incidente. Como mencionado antes, caso o usuário tenha dúvidas, basta passar o cursor do mouse por cima do componentes para verificar a dica do que cada campo significa.

CADASTROS > TELA DE FUNCIONÁRIOS: Esta tela traz uma tabela com todOs os funcionários cadastrados no sistema. Nesta tabela, é possível editar os dados do funcionário escolhido ou excluir o registro do funcionário. Nesta tabela, pode-se filtrar por CPF ou por Nome do funcionário. Em cima da tabela tem um botão para cadastrar um novo funcionário. Na tela de novo funcionário, deve-se preencher os campos e escolher em qual localidade e em qual empresa o funcionário trabalha. Caso o usuário tente cadastrar um CPF que já possui o banco de dados, o sistema irá retornar uma mensagem informando sobre o erro.

TICKETS > TELA DE NOVO TICKET: Esta é a funcionalidade principal do sistema. Nesta tela o usuário irá inserir o CPF do funcionário que está entrando em contato para reportar sobre o problema e logo em seguida o sistema já valida se o CPF está cadastrado no banco de dados, caso não esteja retorna uma mensagem informando que o funcionário não está cadastrado. Caso encontre, o sistema irá preencher os campos de Telefone, Nome, Empresa, e Localidade automaticamente. Quando o usuário clicar em salvar, aparecerá uma mensagem informando que o ticket foi registrado com sucesso e o número do ticket, para que o usuário possa fornecer para o funcionário por telefone. Como mencionado antes, caso o usuário tenha alguma dúvida na inserção de dados dos campos, basta passar o cursor do mouse por cima para verificar a dica.

TICKETS > TELA DE CONSULTAR TICKET: Esta tela traz uma tabela com todos os tickets registrados no sistema. Nesta tabela, é possível apenas visualizar os tickets, pois todos os tickets precisam ficar registrados no sistema, não sendo possível alterar e nem excluir. Nesta tabela, pode-se filtrar por Número do ticket ou por Nome do funcionário.

TICKETS > TELA DE LIGAÇÕES CURTAS: Esta tela serve para que o usuário registre ligações de curta duração, como Consulta de chamado(ticket), transferência de ligação, queda de ligação ou engano. Essa funcionalidade se faz necessária para que o usuário não tenha que inserir todas as informações que precisam ser registradas em um ticket comum. Nesta tela existe dois campos, o primeiro é o motivo pelo qual o usuário está registrando como uma ligação curta, sendo estas as informadas acima, e outro campo perguntando sobre o número do ticket. Este campo serve apenas para quando o motivo for consulta de chamado, caso o usuário insira um número de ticket que não esteja cadastrado no sistema e tente salvar, o sistema mesmo mostrarará um alerta informando que aquele número de ticket não existe no sistema e deixará salvar quando o usuário insira um número de ticket válido.