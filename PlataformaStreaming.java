import java.util.ArrayList;
import java.util.List;

public class PlataformaStreaming implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private String ultimoTitulo;
    private String ultimoGenero;

    public void adicionarLancamento(String titulo, String genero) {
        this.ultimoTitulo = titulo;
        this.ultimoGenero = genero;
        System.out.println("\n--- PLATAFORMA: Novo lançamento adicionado -> " + titulo + " (" + genero + ") ---");
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(ultimoTitulo, ultimoGenero);
        }
    }
}