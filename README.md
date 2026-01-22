# 📚 Sistema de Gerenciamento de Biblioteca

Um projeto acadêmico de sistema de gerenciamento de biblioteca desenvolvido em **Java**, aplicando conceitos fundamentais de **Programação Orientada a Objetos (POO)**, **Collections** e **boas práticas de design**.

---

## 🎯 O Que Foi Criado

### **Sistema Completo de Biblioteca com:**

#### 📖 **Gerenciamento de Livros**
- Cadastro de livros com informações: título, autor, ISBN, ano de publicação e quantidade em estoque
- Listagem de todos os livros disponíveis
- Controle automático de estoque ao emprestar/devolver

#### 👥 **Gerenciamento de Usuários**
- Cadastro de usuários com dados pessoais (nome, email, telefone)
- Listagem de todos os usuários registrados
- IDs únicos gerados automaticamente (UUID)

#### 📤 **Sistema de Empréstimos**
- Empréstimo de livros com validações automáticas:
  - ✅ Máximo de 3 livros por usuário
  - ✅ Validação de estoque disponível
  - ✅ Verificação se usuário e livro existem
- Rastreamento automático de datas de empréstimo e devolução
- Registro de devoluções com atualização de estoque

#### 📊 **Relatórios Detalhados**
1. **Livros em Estoque** - Lista todos os livros com quantidade disponível
2. **Livros Emprestados** - Mostra todos os empréstimos ativos com datas
3. **Empréstimos Atrasados** - Identifica automaticamente livros não devolvidos no prazo (14 dias)

#### 🖥️ **Interface de Usuário (Menu Interativo)**
- Menu principal com 6 opções
- Submenu de relatórios
- Tratamento de erros com mensagens claras
- Entrada validada via Scanner

---

## 💻 Tecnologias e Tópicos Utilizados

### **Linguagem e Plataforma**
- **Java 25** - Linguagem de programação orientada a objetos
- **JDK (Java Development Kit)** - Ferramentas de compilação e execução

### **Programação Orientada a Objetos (POO)**
- ✅ **Classes e Objetos** - Estrutura base do sistema
- ✅ **Encapsulamento** - Atributos privados com getters e setters
- ✅ **Separação de Responsabilidades** - Single Responsibility Principle (SRP)
- ✅ **Construtores** - Inicialização de objetos com e sem parâmetros
- ✅ **Métodos** - Comportamento e operações das classes

### **Java Collections Framework**
- **HashMap** - Armazenamento de livros e usuários com acesso rápido por ID
- **ArrayList** - Lista de empréstimos com ordem preservada
- **Map<String, T>** - Estrutura chave-valor para dados
- **List<T>** - Coleção ordenada para histórico

### **API Streams e Programação Funcional**
- **Stream API** - Processamento funcional de coleções
- **Filter** - Filtragem de empréstimos por condição
- **Map** - Transformação de dados
- **ForEach** - Iteração com lambdas
- **Method References** - Sintaxe moderna (`::``)
- **Collectors** - Agrupamento e transformação de dados

### **Tratamento de Data e Hora**
- **java.time.LocalDate** - Registro de datas de empréstimo e devolução
- **java.time.temporal.ChronoUnit** - Cálculo de diferença entre datas
- **Comparação de Datas** - Verificação automática de atrasos

### **Tratamento de Exceções**
- **IllegalArgumentException** - Exceções para validações de negócio
- **Try-Catch** - Captura e tratamento de erros
- **Throw** - Lançamento controlado de exceções

### **Utilitários Java**
- **java.util.UUID** - Geração de IDs únicos
- **java.util.Scanner** - Entrada de dados via console

### **Princípios de Design**
- **Validação de Entrada** - Verificação antes de operações críticas
- **Padrão MVC Simplificado** - Separação entre Model (entidades) e Controller (Biblioteca)
- **Injeção de Dados** - Uso de Maps centralizados
- **Consistência de Estado** - Sincronização entre estoque e empréstimos

---

## 📋 Estrutura do Projeto

```
src/
├── org/example/
│   ├── Main.java                 (Ponto de entrada da aplicação)
│   └── model/
│       ├── Biblioteca.java       (Controlador - Lógica de negócio)
│       ├── Livro.java            (Entidade - Representação de livro)
│       ├── Usuario.java          (Entidade - Representação de usuário)
│       └── Emprestimo.java       (Entidade - Representação de empréstimo)
```

---

## 🚀 Como Executar

### **Pré-requisitos**
- Java 25 instalado
- IDE (IntelliJ IDEA, Eclipse, VS Code) ou compilador Java
- Terminal/Prompt de comando

### **Passos**

1. **Clone ou baixe o repositório**
   ```bash
   git clone https://github.com/tiagosune/Biblioteca_Projeto_Academico.git
   cd Biblioteca_Projeto_Academico
   ```

2. **Compile o projeto**
   ```bash
   javac -d bin src/org/example/**/*.java
   ```

3. **Execute a aplicação**
   ```bash
   java -cp bin org.example.Main
   ```

4. **Ou, se usar IDE:**
   - Abra a pasta do projeto
   - Clique em "Run" na classe `Main.java`

---

## 🧪 Funcionalidades Principais

### **Menu Principal**

1. **Cadastrar Livro** - Adiciona novo livro ao acervo
2. **Cadastrar Usuário** - Registra novo usuário no sistema
3. **Retirar Livro** - Realiza empréstimo com validações
4. **Devolver Livro** - Processa devolução e atualiza estoque
5. **Relatórios** - Acessa submenu com 3 tipos de relatórios
6. **Sair** - Encerra a aplicação

### **Validações Implementadas**

- ✅ Máximo de 3 livros emprestados por usuário
- ✅ Validação de estoque disponível
- ✅ Verificação de existência de usuário
- ✅ Verificação de existência de livro
- ✅ Detecção automática de empréstimos atrasados (> 14 dias)
- ✅ Tratamento de erros com mensagens claras

---

## 📊 Exemplos de Uso

### **Exemplo 1: Cadastro de Livro**
```
1. Selecione opção 1
2. Digite título: "Clean Code"
3. Digite autor: "Robert Martin"
4. Digite ISBN: "978-0132350884"
5. Digite ano: 2008
6. Digite quantidade: 5
✅ Livro cadastrado com sucesso!
```

### **Exemplo 2: Empréstimo com Validação**
```
1. Selecione opção 3
2. Digite ID do usuário (exibido na lista)
3. Digite ID do livro (exibido na lista)
4. Sistema valida:
   - Usuário existe? ✅
   - Livro existe? ✅
   - Tem estoque? ✅
   - Usuário tem < 3 livros? ✅
✅ Livro retirado com sucesso! (Estoque: 5 → 4)
```

### **Exemplo 3: Relatório de Atrasos**
```
1. Selecione opção 5 (Relatórios)
2. Selecione opção 3 (Usuários em atraso)
3. Sistema lista empréstimos com data > 14 dias:
   - Usuário: João Silva
   - Livro: Clean Code
   - Vencimento: 2026-01-20
```

---

## 🏗️ Arquitetura do Sistema

### **Classes Principais**

#### **Biblioteca.java** (Controlador)
- Gerencia coleções de livros, usuários e empréstimos
- Implementa validações de negócio
- Controla menu e interação com usuário
- Responsável pelos relatórios

#### **Livro.java** (Entidade)
- Representa um livro individual
- Atributos: id, título, autor, ISBN, ano, quantidade
- Encapsulamento com getters/setters
- ID único via UUID

#### **Usuario.java** (Entidade)
- Representa um usuário individual
- Atributos: id, nome, email, telefone
- Encapsulamento com getters/setters
- ID único via UUID

#### **Emprestimo.java** (Entidade)
- Representa um empréstimo individual
- Atributos: id, usuarioId, livroId, datas
- Cálculo automático de atraso
- Rastreamento de devolução

---

## 📝 Tecnologias e APIs Utilizadas

| Tecnologia | Uso |
|-----------|-----|
| **HashMap** | Armazenamento de livros e usuários |
| **ArrayList** | Lista de empréstimos |
| **Stream API** | Filtragem e processamento de dados |
| **LocalDate** | Registro e comparação de datas |
| **UUID** | Geração de IDs únicos |
| **Scanner** | Entrada de dados do usuário |
| **Exception Handling** | Tratamento de erros |
| **Lambda Expressions** | Programação funcional |

---

## 📈 Requisitos Atendidos

- ✅ Cadastro e listagem de livros
- ✅ Cadastro e listagem de usuários
- ✅ Empréstimo de livros com validações
- ✅ Devolução de livros
- ✅ Atualização automática de estoque
- ✅ Rastreamento de datas
- ✅ Detecção de atrasos
- ✅ Relatórios diversos
- ✅ Tratamento de erros
- ✅ Interface interativa

---

## 🔧 Possíveis Extensões

- Persistência em arquivo (JSON/CSV)
- Integração com banco de dados (MySQL, PostgreSQL)
- Testes unitários (JUnit)
- Interface gráfica (Swing, JavaFX)
- API REST (Spring Boot)
- Sistema de multas por atraso

---

## 📄 Licença

Este projeto é de código aberto e disponível para fins educacionais.

---

## ✨ Conclusão

Sistema de gerenciamento de biblioteca desenvolvido com **Java**, demonstrando aplicação prática de **POO**, **Collections**, **Streams** e **boas práticas de desenvolvimento**.
