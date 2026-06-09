import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PlataformaStreaming netflix = new PlataformaStreaming();
        List<Usuario> usuarios = new ArrayList<>();

        while (true) {
            System.out.println("\n--- MENU PLATAFORMA ---");
            System.out.println("1. Criar novo usuário");
            System.out.println("2. Inscrever usuário em um gênero");
            System.out.println("3. Cancelar inscrição de usuário em um gênero");
            System.out.println("4. Adicionar novo lançamento (Filme/Série)");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            if (opcao == 0) break;

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do usuário: ");
                    String nome = scanner.nextLine();
                    Usuario novoUsuario = new Usuario(nome);
                    usuarios.add(novoUsuario);
                    netflix.addObserver(novoUsuario);
                    System.out.println("Usuário criado e registrado na plataforma!");
                    break;

                case 2:
                    if (usuarios.isEmpty()) {
                        System.out.println("Nenhum usuário cadastrado. Crie um usuário primeiro.");
                        break;
                    }
                    System.out.print("Nome do usuário: ");
                    String nomeInscricao = scanner.nextLine();
                    System.out.print("Gênero para inscrever (ex: terror, anime, ação): ");
                    String generoInscricao = scanner.nextLine();

                    boolean encontrouInscricao = false;
                    for (Usuario u : usuarios) {
                        if (u.getNome().equalsIgnoreCase(nomeInscricao)) {
                            u.inscreverGenero(generoInscricao);
                            System.out.println("Inscrição realizada com sucesso!");
                            encontrouInscricao = true;
                            break;
                        }
                    }
                    if (!encontrouInscricao) System.out.println("Usuário não encontrado.");
                    break;

                case 3:
                    if (usuarios.isEmpty()) {
                        System.out.println("Nenhum usuário cadastrado.");
                        break;
                    }
                    System.out.print("Nome do usuário: ");
                    String nomeCancelamento = scanner.nextLine();
                    System.out.print("Gênero para cancelar: ");
                    String generoCancelamento = scanner.nextLine();

                    boolean encontrouCancelamento = false;
                    for (Usuario u : usuarios) {
                        if (u.getNome().equalsIgnoreCase(nomeCancelamento)) {
                            u.cancelarInscricaoGenero(generoCancelamento);
                            System.out.println("Inscrição cancelada com sucesso!");
                            encontrouCancelamento = true;
                            break;
                        }
                    }
                    if (!encontrouCancelamento) System.out.println("Usuário não encontrado.");
                    break;

                case 4:
                    System.out.print("Título do lançamento: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Gênero do lançamento: ");
                    String genero = scanner.nextLine();
                    netflix.adicionarLancamento(titulo, genero);
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        
        System.out.println("Encerrando o sistema...");
        scanner.close();
    }
}