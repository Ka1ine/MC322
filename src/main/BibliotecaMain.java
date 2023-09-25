package main;

import biblioteca.controllers.*;
import biblioteca.models.*;
import biblioteca.models.Itens.Book;
import biblioteca.models.Itens.CD;
import biblioteca.models.Itens.DVD;
import biblioteca.models.Itens.Ebook;
import biblioteca.models.Itens.Item;
import biblioteca.models.Itens.OtherMedia;
import biblioteca.models.Membros.AuthorizationLevel;
import biblioteca.models.Membros.Employee;
import biblioteca.models.Membros.Postgraduate;
import biblioteca.models.Membros.Teacher;
import biblioteca.models.Membros.Undergraduate;
import biblioteca.views.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class BibliotecaMain {
    private static BibliotecaController bibliotecaController;
    private static MembroController membroController;
    private static RelatorioController relatorioController;

    public static void main(String[] args) {
        bibliotecaController = new BibliotecaControllerImpl();
        membroController = new MembroControllerImpl();
        relatorioController = new RelatorioControllerImpl();

        BibliotecaView bibliotecaView = new BibliotecaViewImpl(bibliotecaController);
        MembroView membroView = new MembroViewImpl(membroController);
        // RelatorioView relatorioView = new RelatorioViewImpl(relatorioController);
        Library biblioteca = new Library();

        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("---- Menu Biblioteca ----");
            System.out.println();
            System.out.println("1. Gerenciamento de Itens");
            System.out.println("2. Gerenciamento de Membros");
            System.out.println("3. Geração de Relatórios e Estatísticas");
            System.out.println("4. Administração de Funcionários");
            System.out.println("5. Sair");
            System.out.println();
            System.out.println();
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    // Menu de Gerenciamento de Itens
                    menuGerenciamentoItens(scanner, bibliotecaView, biblioteca);
                    break;
                case 2:
                    // Menu de Gerenciamento de Membros
                    menuGerenciamentoMembros(scanner, membroView, biblioteca);
                    break;
                case 3:
                    // Menu de Geração de Relatórios e Estatísticas
                    // menuRelatoriosEstatisticas(scanner, relatorioView);
                    break;
                case 4:
                    // Menu de Administração de Funcionários
                    menuAdministracaoFuncionarios(scanner);
                    break;
                case 5:
                    System.out.println("Saindo do menu. Até logo!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }

    private static void menuGerenciamentoItens(Scanner scanner, BibliotecaView bibliotecaView, Library biblioteca) {
        while (true) {
            System.out.println("---- Menu Gerenciamento de Itens ----");
            System.out.println();
            System.out.println("1. Listar Itens Disponíveis");
            System.out.println("2. Adicionar Item");
            System.out.println("3. Editar Item");
            System.out.println("4. Remover Item");
            System.out.println("5. Empréstimo de Itens");
            System.out.println("6. Renovação de Empréstimos");
            System.out.println("7. Reservas de Itens");
            System.out.println("8. Voltar");
            System.out.println();
            System.out.println();
            System.out.print("Escolha uma opção: ");

            int opcaoItens = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoItens) {
                case 1:
                    biblioteca.printItemsList(biblioteca.getItems());
                    break;
                case 2:
                    adicionarItem(scanner, biblioteca);
                    break;
                case 3:
                    editarItem(scanner, biblioteca);
                    break;
                case 4:
                    removerItem(scanner, biblioteca);
                    break;
                case 5:
                    realizarEmprestimo(scanner);
                    break;
                case 6:
                    realizarRenovacao(scanner);
                    break;
                case 7:
                    fazerReserva(scanner);
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }

    private static void menuGerenciamentoMembros(Scanner scanner, MembroView membroView, Library biblioteca) {
        while (true) {
            System.out.println("---- Menu Gerenciamento de Membros ----");
            System.out.println();
            System.out.println("1. Listar Membros");
            System.out.println("2. Adicionar Membro");
            System.out.println("3. Editar Membro");
            System.out.println("4. Remover Membro");
            System.out.println("5. Voltar");
            System.out.println();
            System.out.println();
            System.out.print("Escolha uma opção: ");

            int opcaoMembros = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoMembros) {
                case 1:
                    List<Membro> membros = membroController.listarMembros();
                    membroView.mostrarListaMembros(membros);
                    break;
                case 2:
                    adicionarMembro(scanner, biblioteca);
                    break;
                case 3:
                    editarMembro(scanner);
                    break;
                case 4:
                    removerMembro(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }

    private static void menuRelatoriosEstatisticas(Scanner scanner, RelatorioView relatorioView) {
        while (true) {
            System.out.println("---- Menu Relatórios e Estatísticas ----");
            System.out.println();
            System.out.println("1. Gerar Relatório de Atividades de Membros");
            System.out.println("2. Gerar Relatório de Uso de Itens Multimídia");
            System.out.println("3. Gerar Relatório de Multas e Pagamentos");
            System.out.println("4. Gerar Relatório de Disponibilidade de Itens");
            System.out.println("5. Gerar Estatísticas de Uso por Perfil de Membro");
            System.out.println("6. Gerar Relatório de Itens Mais Populares");
            System.out.println("7. Voltar");
            System.out.println();
            System.out.println();
            System.out.print("Escolha uma opção: ");

            int opcaoRelatorios = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoRelatorios) {
                case 1:
                    gerarRelatorioAtividadesMembros();
                    break;
                case 2:
                    gerarRelatorioUsoItens();
                    break;
                case 3:
                    gerarRelatorioMultas();
                    break;
                case 4:
                    gerarRelatorioDisponibilidadeItens();
                    break;
                case 5:
                    gerarEstatisticasUsoPorPerfil();
                    break;
                case 6:
                    gerarRelatorioItensPopulares();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }

    private static void menuAdministracaoFuncionarios(Scanner scanner) {
        while (true) {
            System.out.println("---- Menu Administração de Funcionários ----");
            System.out.println();
            System.out.println("1. Administradores");
            System.out.println("2. Atendentes");
            System.out.println("3. Gerentes");
            System.out.println("4. Voltar");
            System.out.println();
            System.out.println();
            System.out.print("Escolha uma opção: ");

            int opcaoFuncionarios = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoFuncionarios) {
                case 1:
                    // Menu de Administração de Administradores
                    menuAdministradores(scanner);
                    break;
                case 2:
                    // Menu de Administração de Atendentes
                    menuAtendentes(scanner);
                    break;
                case 3:
                    // Menu de Administração de Gerentes
                    menuGerentes(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }

    private static void menuAdministradores(Scanner scanner) {
        // Lógica para administração de administradores
    }

    private static void menuAtendentes(Scanner scanner) {
        // Lógica para administração de atendentes
    }

    private static void menuGerentes(Scanner scanner) {
        // Lógica para administração de gerentes
    }

    // Métodos para realizar empréstimo, renovação e reserva
    private static void realizarEmprestimo(Scanner scanner) {
        // Lógica para realizar um empréstimo
        System.out.println("Operação de Empréstimo de Itens");
    }

    private static void realizarRenovacao(Scanner scanner) {
        // Lógica para realizar uma renovação de empréstimo
        System.out.println("Operação de Renovação de Empréstimos");
    }

    private static void fazerReserva(Scanner scanner) {
        // Lógica para fazer uma reserva de item
        System.out.println("Operação de Reserva de Itens");
    }

    // Métodos para adicionar, editar e remover itens e membros
    private static void adicionarItem(Scanner scanner, Library biblioteca) {
        System.out.println("---- Qual item deseja adicionar ----");
            System.out.println();
            System.out.println("1. Livro");
            System.out.println("2. Ebook");
            System.out.println("3. CD");
            System.out.println("4. DVD");
            System.out.println("5. Outro");
            System.out.println("6. Voltar");
            System.out.println();
            System.out.println();
            System.out.print("Escolha uma opção: ");
        int qualItem = scanner.nextInt();
        scanner.nextLine();

        if(qualItem == 6) return;

        System.out.println("Digite o titulo:");
        String titulo = scanner.nextLine();
        System.out.println("Digite o autor:");
        String autor = scanner.nextLine();
        System.out.println("Digite o codigo do item:");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite a editora:");
        String editora = scanner.nextLine();
        System.out.println("Digite o ano de publicacao:");
        int anoPublicacao = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o genero:");
        String genero = scanner.nextLine();
        System.out.println("Digite o sinopse:");
        String sinopse = scanner.nextLine();
        System.out.println("Digite a lingua:");
        String lingua = scanner.nextLine();
        System.out.println("Insira a capa:");
        String capa = scanner.nextLine();
        System.out.println("Digite o numero de copias:");
        int numeroCopias = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite quantas copias estao disponiveis:");
        int copiasDisponiveis = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite os detalhes:");
        String detalhes = scanner.nextLine();

        switch(qualItem){
            case 1:
                System.out.println("Digite o ISBN:");
                String isbn = scanner.nextLine();
                System.out.println("Digite a Edicao:");
                String edicao = scanner.nextLine();
                System.out.println("Digite a localizacao na biblioteca:");
                String localizacao = scanner.nextLine();
                System.out.println("Digite o estado de conservacao:");
                String conservacao = scanner.nextLine();
                Book novoBook = new Book(titulo, autor, codigo, editora, anoPublicacao, genero, sinopse, lingua, 
                capa, detalhes, isbn, edicao, numeroCopias, copiasDisponiveis, localizacao, conservacao);
                biblioteca.addItem(novoBook);
                break;
            case 2:
                System.out.println("Digite o formato:");
                String formato = scanner.nextLine();
                System.out.println("Digite o numero de licensas:");
                int numeroLicensas = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Digite o URL:");
                String url = scanner.nextLine();
                System.out.println("Digite os requisitos da maquina:");
                String requisitos = scanner.nextLine();
                System.out.println("Digite a data disponível:(dia/mes/ano)");
                int dia = scanner.nextInt();
                int mes = scanner.nextInt();
                int ano = scanner.nextInt();
                LocalDate dataDisponivel = LocalDate.of(ano, mes, dia);
                System.out.println("Digite o tamanho do arquivo:(kb)");
                double tamanhoArquivo = scanner.nextDouble();
                scanner.nextLine();
                Ebook novoEbook = new Ebook(titulo, autor, codigo, editora, anoPublicacao, genero, sinopse, lingua, 
                capa, detalhes, formato, numeroLicensas, url, requisitos, dataDisponivel, tamanhoArquivo, numeroCopias, 
                copiasDisponiveis);
                biblioteca.addItem(novoEbook);
                break;
            case 3:
                System.out.println("Digite as musicas:");
                String musicas = scanner.nextLine();
                System.out.println("Digite a duracao total:(em minutos)");
                int duracao = scanner.nextInt();
                scanner.nextLine();
                CD novoCD = new CD(titulo, autor, codigo, editora, anoPublicacao, genero, sinopse, lingua, 
                capa, detalhes, musicas, duracao, numeroCopias, copiasDisponiveis);
                biblioteca.addItem(novoCD);
                break;
            case 4:
                System.out.println("Digite o elenco:");
                String elenco = scanner.nextLine();
                System.out.println("Digite a duracao total:(em minutos)");
                int duracaoDVD = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Digite os audios disponiveis:");
                String audios = scanner.nextLine();
                System.out.println("Digite as legendas disponiveis:");
                String legendas = scanner.nextLine();
                System.out.println("Digite o diretor:");
                String diretor = scanner.nextLine();
                System.out.println("Digite o ano de lancamento");
                int anoLancamento = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Digite o estado de conservacao:");
                String conservacaoDVD = scanner.nextLine();
                DVD novoDVD = new DVD(titulo, autor, codigo, editora, anoPublicacao, genero, sinopse, lingua, 
                capa, detalhes, elenco, duracaoDVD, audios, legendas, diretor, anoLancamento, conservacaoDVD, 
                numeroCopias, copiasDisponiveis);
                biblioteca.addItem(novoDVD);
                break;
            case 5:
                System.out.println("Digite o tipo da midia:");
                String tipo = scanner.nextLine();
                System.out.println("Digite o formato da midia:");
                String formatoMidia = scanner.nextLine();
                System.out.println("Digite o local na biblioteca:");
                String localizacaoMidia = scanner.nextLine();
                System.out.println("Digite o estado de conservacao:");
                String conservacaoMidia = scanner.nextLine();
                OtherMedia novoOtherMedia = new OtherMedia(titulo, autor, codigo, editora, anoPublicacao, genero, sinopse, lingua, 
                capa, detalhes, tipo, formatoMidia, localizacaoMidia, conservacaoMidia, numeroCopias, copiasDisponiveis);
                biblioteca.addItem(novoOtherMedia);
                break;
            default:
                System.out.println("Opção inválida. Por favor, escolha novamente.");
        }
    }

    private static void editarItem(Scanner scanner, Library biblioteca) {
        System.out.println("Digite o codigo do item que deseja editar:");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("---- O que deseja editar nesse item? ----");
            System.out.println();
            System.out.println("1. Titulo");
            System.out.println("2. Autor");
            System.out.println("3. Editora");
            System.out.println("4. Ano de publicacao");
            System.out.println("5. Genero");
            System.out.println("6. Sinopse");
            System.out.println("7. Lingua");
            System.out.println("8. Capa");
            System.out.println("9. Numero de copias");
            System.out.println("10. Copias disponiveis");
            System.out.println("11. detalhes");
            System.out.println("12. Voltar");
            System.out.println();
            System.out.println();
            System.out.print("Escolha uma opção: ");
        int atributo = scanner.nextInt();
        scanner.nextLine();
        if(atributo == 12) return;
        
        System.out.println("`Digite o novo valor desse atributo:");
        String novoValor = scanner.nextLine();

        for(Item item : biblioteca.getItems()){
            if(item.getCodigo() == codigo){
                switch(atributo){
                    case 1:
                        item.setTitle(novoValor);
                        break;
                    case 2:
                        item.setAuthor(novoValor);
                        break;
                    case 3:
                        item.setPublisher(novoValor);
                        break;
                    case 4:
                        item.setPublishmentYear(Integer.parseInt(novoValor));
                        break;
                    case 5:
                        item.setGenre(novoValor);
                        break;
                    case 6:
                        item.setSynopsis(novoValor);
                        break;
                    case 7:
                        item.setLanguage(novoValor);
                        break;
                    case 8:
                        item.setCover(novoValor);
                        break;
                    case 9:
                        item.setNumberCopies(Integer.parseInt(novoValor));
                        break;
                    case 10:
                        item.setAvaliableCopies(Integer.parseInt(novoValor));
                        break;
                    case 11:
                        item.setDetalhes(novoValor);
                        break;
                }
            }
        }
    }

    private static void removerItem(Scanner scanner, Library biblioteca) {
        System.out.println("Digite o codigo do item que deseja remover:");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        for(Item item : biblioteca.getItems()){
            if(item.getCodigo() == codigo){
                biblioteca.getItems().remove(item);
            }
        }

    }

    private static void adicionarMembro(Scanner scanner, Library biblioteca) {
        System.out.println("---- Qual tipo de membro deseja adicionar? ----");
            System.out.println();
            System.out.println("1. Aluno de graduação");
            System.out.println("2. Aluno de pos graduação");
            System.out.println("3. Funcionário");
            System.out.println("4. Professor");
            System.out.println("5. Voltar");
            System.out.println();
            System.out.println();
            System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        if(opcao == 5) return;

        System.out.println("Nome:");
        String nome = scanner.nextLine();

        System.out.println("Numero de identificação da faculdade:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Endereço:");
        String endereco = scanner.nextLine();

        System.out.println("Contato:");
        String contato = scanner.nextLine();

        switch(opcao){
            case 1:
                System.out.println("Curso:");
                String cursoGraduacao = scanner.nextLine();
                Undergraduate graduando = new Undergraduate(nome, id, endereco, contato, cursoGraduacao);
                biblioteca.addPerson(graduando);
                break;
            case 2:
                System.out.println("Curso:");
                String cursoPos = scanner.nextLine();
                Postgraduate posGraduando = new Postgraduate(nome, id, endereco, contato, cursoPos);
                biblioteca.addPerson(posGraduando);
                break;
            case 3:
                System.out.println("---- Selecione o cargo do funcionário ----");
                    System.out.println();
                    System.out.println("1. Administrador");
                    System.out.println("2. Atendente");
                    System.out.println("3. Gerente");
                    System.out.println("4. Voltar");
                    System.out.println();
                    System.out.println();
                    System.out.print("Escolha uma opção: ");
                int cargo = scanner.nextInt();
                scanner.nextLine();
                AuthorizationLevel nivel = AuthorizationLevel.ATTENDANT;
                switch(cargo){
                    case 1:
                        nivel = AuthorizationLevel.ADMINISTRATOR;
                        break;
                    case 2:
                        nivel = AuthorizationLevel.ATTENDANT;
                        break;
                    case 3:
                        nivel = AuthorizationLevel.MANAGER;
                        break;
                    default:
                        System.out.println("Opção não corresponde");
                        System.out.println();
                }
                Employee funcionario = new Employee(nome, id, endereco, contato, nivel);
                biblioteca.addPerson(funcionario);
                break;
            case 4:
                System.out.println("Área de atuação:");
                String area = scanner.nextLine();
                Teacher professor = new Teacher(nome, id, endereco, contato, area);
                biblioteca.addPerson(professor);
                break;
        }
    }

    private static void editarMembro(Scanner scanner) {
        // Lógica para editar um membro existente
        System.out.println("Operação de Edição de Membro");
    }

    private static void removerMembro(Scanner scanner) {
        // Lógica para remover um membro
        System.out.println("Operação de Remoção de Membro");
    }

    // Métodos para gerar relatórios e estatísticas
    private static void gerarRelatorioAtividadesMembros() {
        // Lógica para gerar o Relatório de Atividades de Membros
        System.out.println("Gerando Relatório de Atividades de Membros");
    }

    private static void gerarRelatorioUsoItens() {
        // Lógica para gerar o Relatório de Uso de Itens Multimídia
        System.out.println("Gerando Relatório de Uso de Itens Multimídia");
    }

    private static void gerarRelatorioMultas() {
        // Lógica para gerar o Relatório de Multas e Pagamentos
        System.out.println("Gerando Relatório de Multas e Pagamentos");
    }

    private static void gerarRelatorioDisponibilidadeItens() {
        // Lógica para gerar o Relatório de Disponibilidade de Itens
        System.out.println("Gerando Relatório de Disponibilidade de Itens");
    }

    private static void gerarEstatisticasUsoPorPerfil() {
        // Lógica para gerar as Estatísticas de Uso por Perfil de Membro
        System.out.println("Gerando Estatísticas de Uso por Perfil de Membro");
    }

    private static void gerarRelatorioItensPopulares() {
        // Lógica para gerar o Relatório de Itens Mais Populares
        System.out.println("Gerando Relatório de Itens Mais Populares");
    }
}
