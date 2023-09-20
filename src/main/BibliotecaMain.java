package main;

import biblioteca.controllers.*;
import biblioteca.models.*;
import biblioteca.models.Itens.Book;
import biblioteca.models.Itens.CD;
import biblioteca.models.Itens.DVD;
import biblioteca.models.Itens.Ebook;
import biblioteca.models.Itens.Item;
import biblioteca.models.Itens.OtherMedia;
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
                    menuGerenciamentoMembros(scanner, membroView);
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
                    editarItem(scanner);
                    break;
                case 4:
                    removerItem(scanner);
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

    private static void menuGerenciamentoMembros(Scanner scanner, MembroView membroView) {
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
                    adicionarMembro(scanner);
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

        System.out.println("Digite o titulo:");
        String titulo = scanner.nextLine();
        System.out.println("Digite o autor:");
        String autor = scanner.nextLine();
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
                Book novoBook = new Book(titulo, autor, editora, anoPublicacao, genero, sinopse, lingua, 
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
                Ebook novoEbook = new Ebook(titulo, autor, editora, anoPublicacao, genero, sinopse, lingua, 
                capa, formato, numeroLicensas, url, requisitos, dataDisponivel, tamanhoArquivo, numeroCopias, 
                copiasDisponiveis);
                biblioteca.addItem(novoEbook);
                break;
            case 3:
                System.out.println("Digite as musicas:");
                String musicas = scanner.nextLine();
                System.out.println("Digite a duracao total:(em minutos)");
                int duracao = scanner.nextInt();
                scanner.nextLine();
                CD novoCD = new CD(titulo, autor, editora, anoPublicacao, genero, sinopse, lingua, 
                capa, musicas, duracao, numeroCopias, copiasDisponiveis);
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
                DVD novoDVD = new DVD(titulo, autor, editora, anoPublicacao, genero, sinopse, lingua, 
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
                OtherMedia novoOtherMedia = new OtherMedia(titulo, autor, editora, anoPublicacao, genero, sinopse, lingua, 
                capa, detalhes, tipo, formatoMidia, localizacaoMidia, conservacaoMidia, numeroCopias, copiasDisponiveis);
                biblioteca.addItem(novoOtherMedia);
                break;
            case 6:
                return;
            default:
                System.out.println("Opção inválida. Por favor, escolha novamente.");
        }
    }

    private static void editarItem(Scanner scanner) {
        // Lógica para editar um item existente
        System.out.println("Operação de Edição de Item");
    }

    private static void removerItem(Scanner scanner) {
        // Lógica para remover um item
        System.out.println("Operação de Remoção de Item");
    }

    private static void adicionarMembro(Scanner scanner) {
        // Lógica para adicionar um novo membro
        System.out.println("Operação de Adição de Membro");
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
