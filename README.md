# Sistema de Biblioteca Universitária 📚

## Princípios SOLID

### 1. Princípio da Responsabilidade Única (SRP)

- **Indicação do Princípio:**
  - No código, o SRP é aplicado para garantir que uma classe tenha apenas uma razão para mudar.

- **Razão de Utilização:**
  - O SRP é utilizado para manter o código modular e fácil de entender, facilitando a manutenção e reduzindo o impacto de mudanças em uma única responsabilidade.

- **Como Utilizamos o Princípio:**
  - Cada classe do projeto tem uma única responsabilidade claramente definida. Se uma classe executa mais de uma tarefa, considero a reorganização do código para seguir o SRP.

### 2. Princípio Aberto-Fechado (OCP)

- **Indicação do Princípio:**
  - No código, o OCP é aplicado para garantir que as classes sejam abertas para extensão, mas fechadas para modificação.

- **Razão de Utilização:**
  - O OCP promove a extensibilidade do código, permitindo a adição de novas funcionalidades sem alterar o código existente.

- **Como Utilizamos o Princípio:**
  - Utilizo interfaces e abstrações para definir contratos que podem ser estendidos por implementações específicas. Isso permite a adição de novos recursos sem modificar o código existente.

### 3. Princípio da Substituição de Liskov (LSP)

- **Indicação do Princípio:**
  - No código, o LSP é aplicado para garantir que objetos de uma classe base possam ser substituídos por objetos de suas classes derivadas sem afetar a corretude do programa.

- **Razão de Utilização:**
  - O LSP assegura a consistência do sistema, permitindo a substituição de classes derivadas sem introduzir erros ou comportamentos inesperados.

- **Como Utilizamos o Princípio:**
  - Ao criar classes derivadas, certifico-me de que elas mantenham a mesma interface que a classe base. Isso significa que qualquer instância da classe base pode ser substituída por uma instância de uma classe derivada sem que o programa perca sua consistência.

### 4. Princípio da Segregação de Interface (ISP)

- **Indicação do Princípio:**
  - No código, o ISP é aplicado para garantir que uma classe não seja forçada a implementar interfaces que ela não utiliza.

- **Razão de Utilização:**
  - O ISP evita que as classes se tornem inchadas com métodos que não têm relevância para sua funcionalidade principal, melhorando a coesão do código.

- **Como Utilizamos o Princípio:**
  - Divido as interfaces em conjuntos específicos para cada classe, evitando interfaces genéricas que exijam a implementação de métodos não utilizados por determinadas classes. Cada classe implementa apenas as interfaces necessárias para sua funcionalidade.

### 5. Princípio da Inversão de Dependência (DIP)

- **Indicação do Princípio:**
  - No código, o DIP é aplicado para garantir que módulos de alto nível não dependam de módulos de baixo nível, mas ambos dependam de abstrações.

- **Razão de Utilização:**
  - O DIP reduz o acoplamento entre diferentes partes do sistema, tornando-o mais flexível e fácil de manter.

- **Como Utilizamos o Princípio:**
  - Utilizo interfaces e abstrações para criar camadas de abstração entre os diferentes componentes do sistema. Isso permite que as classes de alto nível dependam de abstrações em vez de implementações concretas, facilitando a substituição e extensão de componentes.

## Conclusão

A implementação destes princípios busca equilibrar flexibilidade e estabilidade no Sistema de Biblioteca Universitária, proporcionando uma base sólida para o desenvolvimento contínuo e evolução do software.
