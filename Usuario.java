import java.util.ArrayList;
import java.util.List;

public class Usuario implements Observer {
    private final String nome;
    private final List<String> generosInscritos;

    public Usuario(String nome) {
        this.nome = nome;
        this.generosInscritos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void inscreverGenero(String genero) {
        if (!generosInscritos.contains(genero.toLowerCase())) {
            generosInscritos.add(genero.toLowerCase());
        }
    }

    public void cancelarInscricaoGenero(String genero) {
        generosInscritos.remove(genero.toLowerCase());
    }

    @Override
    public void update(String titulo, String genero) {
        if (generosInscritos.contains(genero.toLowerCase())) {
            System.out.println("NOTIFICAÇÃO para " + nome + ": O título '" + titulo + "' da categoria '" + genero + "' já está disponível!");
        }
    }
}