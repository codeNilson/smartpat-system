# Sistema SmartPat

🚀 Bem-vindo ao repositório do Sistema SmartPat!

Este projeto tem como objetivo oferecer uma solução inteligente para gerenciar e otimizar a administração de bens patrimoniais de órgãos públicos. A aplicação está sendo desenvolvida com foco em usabilidade, escalabilidade e eficiência.

🚧 **Status do Projeto:** Em Desenvolvimento. Algumas funcionalidades podem não estar completas ou podem sofrer alterações à medida que o projeto avança.

## Funcionalidades

✅ Gerenciamento de ativos patrimoniais com informações detalhadas.
✅ Categorização de bens para melhor organização.
✅ Interface gráfica intuitiva para facilitar o uso.
✅ Geração de relatórios básicos sobre os ativos (em desenvolvimento).
✅ Arquitetura modular visando a escalabilidade.

## Tecnologias Utilizadas

O SmartPat é construído utilizando as seguintes tecnologias:

*   **Java:** Linguagem de programação principal.
*   **JavaFX:** Framework para o desenvolvimento da interface gráfica do usuário.
*   **Maven:** Ferramenta de gerenciamento de dependências e build do projeto.
*   **Hibernate:** Framework ORM (Object-Relational Mapping) para persistência de dados.
*   **SQLite:** Banco de dados relacional leve e embarcado.

## Estrutura do Projeto

A estrutura do projeto segue uma arquitetura modular para facilitar a organização e manutenção do código. Os principais diretórios e seus propósitos são:

*   `src/main/java/`: Contém o código-fonte principal da aplicação.
    *   `io.github.codenilson.smartpat.App`: Classe principal que inicia a aplicação JavaFX.
    *   `io.github.codenilson.smartpat.controllers/`: Contém os controladores da interface gráfica.
    *   `io.github.codenilson.smartpat.modules/`: Módulos que encapsulam a lógica de negócio e a interconexão entre as camadas.
    *   `io.github.codenilson.smartpat.persistence/`: Camada de persistência de dados, incluindo entidades e repositórios.
    *   `io.github.codenilson.smartpat.application/`: Contém os casos de uso da aplicação.
    *   `io.github.codenilson.smartpat.tasks/`: Classes para tarefas assíncronas.
    *   `io.github.codenilson.smartpat.utils/`: Classes de utilidades.
*   `src/main/resources/`: Contém os recursos da aplicação.
    *   `META-INF/persistence.xml`: Configuração do Hibernate para persistência.
    *   `assets/`: Imagens e outros recursos visuais.
    *   `gui/`: Arquivos FXML que definem a interface gráfica.
    *   `styles/`: Arquivos CSS para estilização da interface.
*   `src/db/`: Diretório para o arquivo do banco de dados SQLite.
*   `pom.xml`: Arquivo de configuração do Maven.
*   `LICENSE`: Arquivo contendo os detalhes da licença.
*   `readme.md`: Este arquivo.

## Clonando o Repositório

Clone o repositório para explorar o projeto:
```bash
git clone https://github.com/codeNilson/smartpat-system.git
```

## Licença

📜 Este projeto está licenciado sob os termos da Licença MIT. Consulte o arquivo `LICENSE` para mais detalhes.

## Contato

📧 Para dúvidas ou suporte, entre em contato com [Denilson](mailto:fcodenilson@gmail.com).
