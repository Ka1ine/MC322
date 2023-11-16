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
import biblioteca.models.Membros.CReflection;
import biblioteca.models.Membros.Employee;
import biblioteca.models.Membros.People;
import biblioteca.models.Membros.Postgraduate;
import biblioteca.models.Membros.Teacher;
import biblioteca.models.Membros.Undergraduate;
import biblioteca.models.Membros.CReflection.Classes;
import biblioteca.views.*;

import java.time.LocalDate;
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
        Library biblioteca = Library.getInstance() ;
        
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("╔═════════════ Biblioteca Universitária ══════════╗");
            System.out.println("║                                                 ║");
            System.out.println("║ 1. Gerenciamento de Itens                       ║");
            System.out.println("║ 2. Gerenciamento de Membros                     ║");
            System.out.println("║ 3. Geração de Relatórios e Estatísticas         ║");
            System.out.println("║ 4. Administração de Funcionários                ║");
            System.out.println("║ 5. Sair                                         ║");
            System.out.println("║                                                 ║");
            System.out.println("║ Escolha uma opção:                              ║");
            System.out.println("╚═════════════════════════════════════════════════╝");
            
            
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
                    menuAdministracaoFuncionarios(scanner, biblioteca);
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
            System.out.println("╔═════════════ Gerenciamento de Itens ════════════╗");
            System.out.println("║                                                 ║");
            System.out.println("║ 1. Listar Itens Disponíveis                     ║");
            System.out.println("║ 2. Adicionar Item                               ║");
            System.out.println("║ 3. Editar Item                                  ║");
            System.out.println("║ 4. Remover Item                                 ║");
            System.out.println("║ 5. Empréstimo de Itens                          ║");
            System.out.println("║ 6. Renovação de Empréstimos                     ║");
            System.out.println("║ 7. Reservas de Itens                            ║");
            System.out.println("║ 8. Devolver Item                                ║");
            System.out.println("║ 9. Voltar                                       ║");
            System.out.println("║                                                 ║");
            System.out.println("║ Escolha uma opção:                              ║");
            System.out.println("╚═════════════════════════════════════════════════╝");
            
            

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
                    realizarEmprestimo(scanner, biblioteca);
                    break;
                case 6:
                    realizarRenovacao(scanner, biblioteca);
                    break;
                case 7:
                    fazerReserva(scanner, biblioteca);
                    break;
                case 8:
                    devolverItem(scanner, biblioteca);
                case 9:
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }

    private static void menuGerenciamentoMembros(Scanner scanner, MembroView membroView, Library biblioteca) {
        while (true) {
            System.out.println("╔════════════ Gerenciamento de Membros ═══════════╗");
            System.out.println("║ 1. Listar Membros                               ║");
            System.out.println("║ 2. Adicionar Membro                             ║");
            System.out.println("║ 3. Editar Membro                                ║");
            System.out.println("║ 4. Remover Membro                               ║");
            System.out.println("║ 5. Voltar                                       ║");
            System.out.println("║                                                 ║");
            System.out.println("║ Escolha uma opção:                              ║");
            System.out.println("╚═════════════════════════════════════════════════╝");

            int opcaoMembros = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoMembros) {
                case 1:
                    biblioteca.printPeopleList(biblioteca.getPeople());
                    break;
                case 2:
                    adicionarMembro(scanner, biblioteca);
                    break;
                case 3:
                    editarMembro(scanner, biblioteca);
                    break;
                case 4:
                    removerMembro(scanner, biblioteca);
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
            System.out.println("╔═══════════ Relatórios e Estatísticas ═══════════╗");
            System.out.println("║ 1. Relatório de Atividades de Membros           ║");
            System.out.println("║ 2. Relatório de Uso de Itens Multimídia         ║");
            System.out.println("║ 3. Relatório de Multas e Pagamentos             ║");
            System.out.println("║ 4. Relatório de Disponibilidade de Itens        ║");
            System.out.println("║ 5. Estatísticas de Uso por Perfil de Membro     ║");
            System.out.println("║ 6. Relatório de Itens Mais Populares            ║");
            System.out.println("║ 7. Voltar                                       ║");
            System.out.println("║                                                 ║");
            System.out.println("║ Escolha uma opção:                              ║");
            System.out.println("╚═════════════════════════════════════════════════╝");

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

    private static void menuAdministracaoFuncionarios(Scanner scanner, Library biblioteca) {
        while (true) {
            System.out.println("╔═════════ Administração de Funcionários ═════════╗");
            System.out.println("║ 1. Administradores                              ║");
            System.out.println("║ 2. Atendentes                                   ║");
            System.out.println("║ 3. Gerentes                                     ║");
            System.out.println("║ 4. Voltar                                       ║");
            System.out.println("║                                                 ║");
            System.out.println("║ Escolha uma opção:                              ║");
            System.out.println("╚═════════════════════════════════════════════════╝");

            int opcaoFuncionarios = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoFuncionarios) {
                case 1:
                    // Menu de Administração de Administradores
                    menuAdministradores(scanner, biblioteca);
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

    private static void menuAdministradores(Scanner scanner, Library biblioteca) {
        System.out.println("Digite seu acesso de Funcionário:");
        int acessoAdministrador = scanner.nextInt();
        scanner.nextLine();
        try{
            Employee pessoa = (Employee) biblioteca.getPersonById(acessoAdministrador);
            if (pessoa.getAuthorizationLevel() == AuthorizationLevel.ADMINISTRATOR) {
                System.out.println("╔═════════════ Menu do Administrador ═════════════╗");
                System.out.println("║ 1. Pegar Atributo de Professor                  ║");
                System.out.println("║ 2. Pegar Método de Professor                    ║");
                System.out.println("║ 3. Pegar Atributo de Funcionário                ║");
                System.out.println("║ 4. Pegar Método de Funcionário                  ║");
                System.out.println("║ 5. Pegar Atributo de Pos Graduando              ║");
                System.out.println("║ 6. Pegar Método de Pos Graduando                ║");
                System.out.println("║ 7. Pegar Atributo de Aluno de Graduação         ║");
                System.out.println("║ 8. Pegar Método de Aluno de Graduação           ║");
                System.out.println("║ 9. Voltar                                       ║");
                System.out.println("║                                                 ║");
                System.out.println("║ Escolha uma opção:                              ║");
                System.out.println("╚═════════════════════════════════════════════════╝");

                int opcaoAdministrador = scanner.nextInt();
                scanner.nextLine();

                switch (opcaoAdministrador) {
                    case 1:
                        System.out.println("\nAtributos de Professor:");
                        CReflection.imprimirAtributos(Classes.TEACHER);
                        break;
                    case 2:
                        System.out.println("\nMétodo de Professor::");
                        CReflection.imprimirMetodos(Classes.TEACHER);
                        break;
                    case 3:
                        System.out.println("\nAtributos de Funcionário:");
                        CReflection.imprimirAtributos(Classes.EMPLOYEE);
                        break;
                    case 4:
                        System.out.println("\nMétodo de Funcionário:");
                        CReflection.imprimirMetodos(Classes.EMPLOYEE);
                    case 5:
                        System.out.println("\nAtributos de Pos Graduando:");
                        CReflection.imprimirAtributos(Classes.POSTGRADUATE);
                        break;
                    case 6:
                        System.out.println("\nMétodo de Pos Graduando:");
                        CReflection.imprimirMetodos(Classes.POSTGRADUATE);
                    case 7:
                        System.out.println("\nAtributos de Graduando:");
                        CReflection.imprimirAtributos(Classes.UNDERGRADUATE);
                        break;
                    case 8:
                        System.out.println("\nMétodo de Graduando:");
                        CReflection.imprimirMetodos(Classes.UNDERGRADUATE);
                    case 9:
                        return;
                    default:
                        System.out.println("Opção inválida. Por favor, escolha novamente.");
                }
                    }
                    else{
                        System.out.println("Você não tem os acessos necessários");
                        return;
                    }
        } catch (Exception e){
            System.out.println("Acesso restrito");
            return;
        }
    }

    private static void menuAtendentes(Scanner scanner) {
        // Lógica para administração de atendentes
    }

    private static void menuGerentes(Scanner scanner) {
        // Lógica para administração de gerentes
    }

    // Métodos para realizar empréstimo, renovação e reserva
    private static void realizarEmprestimo(Scanner scanner, Library biblioteca) {
        System.out.println("Digite a identificação da pessoa que está emprestando:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o codigo do item:");
        int codigoItem = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite a identificação do funcionário que está emprestando:");
        int codigoFuncionario = scanner.nextInt();
        scanner.nextLine();
        People pessoa = null;
        Item objeto = null;
        People funcionario = null;
        for(People p : biblioteca.getPeople()){
            if(p.getUniversityIdentificationNumber() == id){
                pessoa = p;
                break;
            }
        }
        for(Item i : biblioteca.getItems()){
            if(i.getCodigo() == codigoItem){
                objeto = i;
                break;
            }
        }
        for(People f : biblioteca.getPeople()){
            if(f.getUniversityIdentificationNumber() == codigoFuncionario){
                funcionario = f;
                break;
            }
        }
        Borrow emprestimo = new Borrow(pessoa, objeto, funcionario);
        try{
            biblioteca.addBorrow(emprestimo);
        }catch (Exception e) {
            System.out.println("Erro ao adicionar o empréstimo");
        }
    }

    private static void realizarRenovacao(Scanner scanner, Library biblioteca) {
        System.out.println("Digite a identificação da pessoal que realizou o emprestimo:");
        int idPessoa = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o codigo do item:");
        int codigoItem = scanner.nextInt();
        scanner.nextLine();
        Borrow emprestimo = null;
        for(Borrow b : biblioteca.getBorrows()){
            if(b.getPerson().getUniversityIdentificationNumber() == idPessoa && b.getItem().getCodigo() == codigoItem){
                emprestimo = b;
                break;
            }
        }
        if(emprestimo != null){
            emprestimo.renew();
        }else{
            System.out.println("Erro! Emprestimo não encontrado.");
        }
    }

    private static void fazerReserva(Scanner scanner, Library biblioteca) {
        System.out.println("Digite a identificação da pessoa que está reservando o item:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o codigo do item a ser reservado:");
        int codigoItem = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite a identificação do funcionário que está reservando:");
        int codigoFuncionario = scanner.nextInt();
        scanner.nextLine();
        People pessoa = null;
        Item objeto = null;
        People funcionario = null;
        for(People p : biblioteca.getPeople()){
            if(p.getUniversityIdentificationNumber() == id){
                pessoa = p;
                break;
            }
        }
        for(Item i : biblioteca.getItems()){
            if(i.getCodigo() == codigoItem){
                objeto = i;
                break;
            }
        }
        for(People f : biblioteca.getPeople()){
            if(f.getUniversityIdentificationNumber() == codigoFuncionario){
                funcionario = f;
                break;
            }
        }
        objeto.addToReservedList(pessoa, funcionario);
    }

    private static void devolverItem(Scanner scanner, Library biblioteca){
        System.out.println("Digite a identificação da pessoa que está devolvendo o item:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o codigo do item a ser devolvido:");
        int codigoItem = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite a identificação do funcionário que está devolvendo:");
        int codigoFuncionario = scanner.nextInt();
        scanner.nextLine();
        Borrow emprestimo = null;
        for(Borrow b : biblioteca.getBorrows()){
            if(b.getItem().getCodigo() == codigoItem && b.getPerson().getUniversityIdentificationNumber() == id && b.getEmployee().getUniversityIdentificationNumber() == codigoFuncionario){
                emprestimo = b;
                break;
            }
        }
        emprestimo.returnItem(LocalDate.now());
    }

    // Métodos para adicionar, editar e remover itens e membros
    private static void adicionarItem(Scanner scanner, Library biblioteca) {
        System.out.println("╔═════════════════ Adicionar Item ════════════════╗");
        System.out.println("║ 1. Livro                                        ║");
        System.out.println("║ 2. Ebook                                        ║");
        System.out.println("║ 3. CD                                           ║");
        System.out.println("║ 4. DVD                                          ║");
        System.out.println("║ 5. Outro                                        ║");
        System.out.println("║ 6. Voltar                                       ║");
        System.out.println("║                                                 ║");
        System.out.println("║ Escolha uma opção:                              ║");
        System.out.println("╚═════════════════════════════════════════════════╝");
        
        int qualItem = scanner.nextInt();
        scanner.nextLine();

        if (qualItem == 6) return;

        System.out.println("╔══════════════════ Adicionar ═══════════════════╗");
        System.out.println("║ Insira as informações do Item                  ║");
        System.out.println("║                                                ║");
        System.out.print("║ Título: ");
        String titulo = scanner.nextLine();
        System.out.print("║ Autor: ");
        String autor = scanner.nextLine();
        System.out.print("║ Código do Item: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("║ Editora: ");
        String editora = scanner.nextLine();
        System.out.print("║ Ano de Publicação: ");
        int anoPublicacao = scanner.nextInt();
        scanner.nextLine();
        System.out.print("║ Gênero: ");
        String genero = scanner.nextLine();
        System.out.print("║ Sinopse: ");
        String sinopse = scanner.nextLine();
        System.out.print("║ Língua: ");
        String lingua = scanner.nextLine();
        System.out.print("║ URL da Capa: ");
        String capa = scanner.nextLine();
        System.out.print("║ Número de Cópias: ");
        int numeroCopias = scanner.nextInt();
        scanner.nextLine();
        System.out.print("║ Cópias Disponíveis: ");
        int copiasDisponiveis = scanner.nextInt();
        scanner.nextLine();
        System.out.print("║ Detalhes: ");
        String detalhes = scanner.nextLine();
        
        switch(qualItem){
            case 1:
                System.out.print("║ ISBN: ");
                String isbn = scanner.nextLine();
                System.out.print("║ Edição: ");
                String edicao = scanner.nextLine();
                System.out.print("║ Localização na Biblioteca: ");
                String localizacao = scanner.nextLine();
                System.out.print("║ Estado de Conservação: ");
                String conservacao = scanner.nextLine();
                System.out.println("║                                                 ║");
                System.out.println("╚═════════════════════════════════════════════════╝");
                        
                Book novoBook = new Book(titulo, autor, codigo, editora, anoPublicacao, genero, sinopse, lingua,
                        capa, detalhes, isbn, edicao, numeroCopias, copiasDisponiveis, localizacao, conservacao);
                biblioteca.addItem(novoBook);
                break;
            case 2:
                System.out.print("║ Formato: ");
                String formato = scanner.nextLine();
                System.out.print("║ Número de Licenças: ");
                int numeroLicencas = scanner.nextInt();
                scanner.nextLine();
                System.out.print("║ URL: ");
                String url = scanner.nextLine();
                System.out.print("║ Requisitos da Máquina: ");
                String requisitos = scanner.nextLine();
                System.out.print("║ Data Disponível (dia/mes/ano): ");
                int dia = scanner.nextInt();
                int mes = scanner.nextInt();
                int ano = scanner.nextInt();
                LocalDate dataDisponivel = LocalDate.of(ano, mes, dia);
                System.out.print("║ Tamanho do Arquivo (KB): ");
                double tamanhoArquivo = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("║                                                 ║");
                System.out.println("╚═════════════════════════════════════════════════╝");
            
                Ebook novoEbook = new Ebook(titulo, autor, codigo, editora, anoPublicacao, genero, sinopse, lingua,
                        capa, detalhes, formato, numeroLicencas, url, requisitos, dataDisponivel, tamanhoArquivo, numeroCopias,
                        copiasDisponiveis);
                
                biblioteca.addItem(novoEbook);
            
                break;
            case 3:
                System.out.print("║ Músicas: ");
                String musicas = scanner.nextLine();
                System.out.print("║ Duração Total (em minutos): ");
                int duracao = scanner.nextInt();
                scanner.nextLine();
                System.out.println("║                                                 ║");
                System.out.println("╚═════════════════════════════════════════════════╝");
                
                CD novoCD = new CD(titulo, autor, codigo, editora, anoPublicacao, genero, sinopse, lingua, 
                capa, detalhes, musicas, duracao, numeroCopias, copiasDisponiveis);
                biblioteca.addItem(novoCD);
                break;
            case 4:
                System.out.print("║ Elenco: ");
                String elenco = scanner.nextLine();
                System.out.print("║ Duração Total (em minutos): ");
                int duracaoDVD = scanner.nextInt();
                scanner.nextLine();
                System.out.print("║ Áudios Disponíveis: ");
                String audios = scanner.nextLine();
                System.out.print("║ Legendas Disponíveis: ");
                String legendas = scanner.nextLine();
                System.out.print("║ Diretor: ");
                String diretor = scanner.nextLine();
                System.out.print("║ Ano de Lançamento: ");
                int anoLancamento = scanner.nextInt();
                scanner.nextLine();
                System.out.print("║ Estado de Conservação: ");
                String conservacaoDVD = scanner.nextLine();
                System.out.println("║                                                 ║");
                System.out.println("╚═════════════════════════════════════════════════╝");
                
                DVD novoDVD = new DVD(titulo, autor, codigo, editora, anoPublicacao, genero, sinopse, lingua, 
                capa, detalhes, elenco, duracaoDVD, audios, legendas, diretor, anoLancamento, conservacaoDVD, 
                numeroCopias, copiasDisponiveis);
                biblioteca.addItem(novoDVD);
                break;
            case 5:
                System.out.print("║ Tipo da Mídia: ");
                String tipo = scanner.nextLine();
                System.out.print("║ Formato da Mídia: ");
                String formatoMidia = scanner.nextLine();
                System.out.print("║ Local na Biblioteca: ");
                String localizacaoMidia = scanner.nextLine();
                System.out.print("║ Estado de Conservação: ");
                String conservacaoMidia = scanner.nextLine();
                System.out.println("║                                                 ║");
                System.out.println("╚═════════════════════════════════════════════════╝");

                OtherMedia novoOtherMedia = new OtherMedia(titulo, autor, codigo, editora, anoPublicacao, genero, sinopse, lingua, 
                capa, detalhes, tipo, formatoMidia, localizacaoMidia, conservacaoMidia, numeroCopias, copiasDisponiveis);
                biblioteca.addItem(novoOtherMedia);
                break;
            default:
                System.out.println("Opção inválida. Por favor, escolha novamente.");
        }
    }

    private static void editarItem(Scanner scanner, Library biblioteca) {

        System.out.println("╔══════════════════ Editar Item ══════════════════╗");
        System.out.println("║ Digite o código do item a ser editado:          ║");
        System.out.print("║ ");
        int codigo = scanner.nextInt();
        scanner.nextLine();
        System.out.println("║ ------- O que deseja editar neste item? ------- ║");
        System.out.println("║                                                 ║");
        System.out.println("║ 1. Título                                       ║");
        System.out.println("║ 2. Autor                                        ║");
        System.out.println("║ 3. Editora                                      ║");
        System.out.println("║ 4. Ano de Publicação                            ║");
        System.out.println("║ 5. Gênero                                       ║");
        System.out.println("║ 6. Sinopse                                      ║");
        System.out.println("║ 7. Língua                                       ║");
        System.out.println("║ 8. Capa                                         ║");
        System.out.println("║ 9. Número de Cópias                             ║");
        System.out.println("║ 10. Cópias Disponíveis                          ║");
        System.out.println("║ 11. Detalhes                                    ║");
        System.out.println("║ 12. Voltar                                      ║");
        System.out.println("║                                                 ║");
        System.out.println("║ Escolha uma opção:                              ║");
        System.out.println("╚═════════════════════════════════════════════════╝");
        int atributo = scanner.nextInt();
        scanner.nextLine();
        if(atributo == 12) return;
        
        System.out.println("╔═════════════════════════════════════════════════╗");
        System.out.println("║ Digite o novo valor desse atributo:             ║");
        System.out.print("║ ");
        String novoValor = scanner.nextLine();
        System.out.println("╚═════════════════════════════════════════════════╝");


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
                System.out.println("Livro " + item.getTitle() + " removido");
                return;
            }
        }
    }

    private static void adicionarMembro(Scanner scanner, Library biblioteca) {
        System.out.println("╔═════════════════ Adicionar Membro ══════════════╗");
        System.out.println("║ Qual tipo de membro deseja adicionar?           ║");
        System.out.println("║                                                 ║");
        System.out.println("║ 1. Aluno de Graduação                           ║");
        System.out.println("║ 2. Aluno de Pós-Graduação                       ║");
        System.out.println("║ 3. Funcionário                                  ║");
        System.out.println("║ 4. Professor                                    ║");
        System.out.println("║ 5. Voltar                                       ║");
        System.out.println("║                                                 ║");
        System.out.println("║ Escolha uma opção:                              ║");
        System.out.println("╚═════════════════════════════════════════════════╝");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        if(opcao == 5) return;

        System.out.println("╔═════════════════ Adicionar Membro ══════════════╗");
        System.out.println("║ Insira as informações do Membro                 ║");
        System.out.print("║ Nome: ");
        String nome = scanner.nextLine();
        System.out.print("║ Número de Identificação da Faculdade: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("║ Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("║ Contato: ");
        String contato = scanner.nextLine();

        switch(opcao){
            case 1:
                System.out.print("║ Curso:");
                System.out.println("╚═════════════════════════════════════════════════╝");
                String cursoGraduacao = scanner.nextLine();
                Undergraduate graduando = new Undergraduate(nome, id, endereco, contato, cursoGraduacao);
                biblioteca.addPerson(graduando);
                break;
            case 2:
                System.out.print("║ Curso:");
                System.out.println("╚═════════════════════════════════════════════════╝");
                String cursoPos = scanner.nextLine();
                Postgraduate posGraduando = new Postgraduate(nome, id, endereco, contato, cursoPos);
                biblioteca.addPerson(posGraduando);
                break;
            case 3:
                System.out.println("║ ------- Selecione o Cargo do Funcionário ------ ║");
                System.out.println("║                                                 ║");
                System.out.println("║ 1. Administrador                                ║");
                System.out.println("║ 2. Atendente                                    ║");
                System.out.println("║ 3. Gerente                                      ║");
                System.out.println("║ 4. Voltar                                       ║");
                System.out.println("║                                                 ║");
                System.out.println("║ Escolha uma opção:                              ║");
                System.out.println("╚═════════════════════════════════════════════════╝");
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
                System.out.print("║ Área de atuação:");
                System.out.println("╚═════════════════════════════════════════════════╝");
                String area = scanner.nextLine();
                Teacher professor = new Teacher(nome, id, endereco, contato, area);
                biblioteca.addPerson(professor);
                break;
        }
    }

    private static void editarMembro(Scanner scanner, Library biblioteca) {
        System.out.println("╔════════════════ Editar Membro ══════════════════╗");
        System.out.print("║ Digite a identificação do membro: ");
        int identificacao = scanner.nextInt();
        scanner.nextLine();
        System.out.println("║ Operação de Edição de Membro                    ║");
        System.out.println("║ ---- O que deseja editar nesse item? ----       ║");
        System.out.println("║                                                 ║");
        System.out.println("║ 1. Nome                                         ║");
        System.out.println("║ 2. Endereço                                     ║");
        System.out.println("║ 3. Contato                                      ║");
        System.out.println("║ 4. Voltar                                       ║");
        System.out.println("║                                                 ║");
        System.out.println("║ Escolha uma opção:                              ║");
        System.out.println("╚═════════════════════════════════════════════════╝");

        int atributo = scanner.nextInt();
        scanner.nextLine();
        if(atributo == 4) return;

        System.out.println("╔═════════════════════════════════════════════════╗");
        System.out.println("║ Digite o novo valor desse atributo:             ║");
        System.out.print("║ ");
        String novoValor = scanner.nextLine();
        System.out.println("╚═════════════════════════════════════════════════╝");
        
        for(People pessoa : biblioteca.getPersons()){
            if(pessoa.getUniversityIdentificationNumber() == identificacao){
                switch(atributo){
                    case 1:
                        pessoa.setName(novoValor);
                        break;
                    case 2:
                        pessoa.setAddress(novoValor);;
                        break;
                    case 3:
                        pessoa.setContact(novoValor);
                        break;
                }
            }
        }
    }

    private static void removerMembro(Scanner scanner, Library biblioteca) {
        System.out.println("╔═════════════════════════════════════════════════╗");
        System.out.println("║ Digite a identificação do membro para remover:  ║");
        System.out.print("║ ");
        int identificacao = scanner.nextInt();
        System.out.println("╚═════════════════════════════════════════════════╝");
        
        scanner.nextLine();

        for(People pessoa : biblioteca.getPeople()){
            if(pessoa.getUniversityIdentificationNumber() == identificacao){
                biblioteca.getPeople().remove(pessoa);
                System.out.println(pessoa.getName() + " removido");
                return;
            }
        }
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