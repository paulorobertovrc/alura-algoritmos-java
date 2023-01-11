public class QuickSort {
    public static void main(String[] args) {
        Nota guilherme = new Nota("Guilherme", 7);
        Nota[] notas = {
            new Nota("Mariana", 5),
            new Nota("Carlos", 8.5),
            new Nota("Jonas", 3),
            new Nota("Ana", 10),
            new Nota("Lúcia", 9.3),
            new Nota("André", 4),
            new Nota("Paulo", 9),
            new Nota("Juliana", 6.7),
            guilherme
        };

        ordenar(notas, 0, notas.length);
        int encontrei = buscar(notas, 0, notas.length - 1, 200);
        System.out.println(encontrei);

        for (Nota nota : notas) {
            System.out.println(nota.getAluno() + " " + nota.getNota());
        }
    }

    private static int buscar(Nota[] notas, int inicio, int fim, double buscando) {
        int meio = (inicio + fim) / 2;
        Nota nota = notas[meio];

        if (inicio > fim) return -1;

        if (buscando == nota.getNota()) return meio;
        if (buscando < nota.getNota()) return buscar(notas, inicio, meio - 1, buscando);

        return buscar(notas, meio + 1, fim, buscando);
    }

    private static void ordenar(Nota[] notas, int inicio, int fim) {
        int elementos = fim - inicio;
        if (elementos > 1) {
            int posicaoPivo = particionar(notas, inicio, fim);
            ordenar(notas, inicio, posicaoPivo);
            ordenar(notas, posicaoPivo + 1, fim);
        }
    }

    private static int particionar(Nota[] notas, int inicial, int fim) {
        int menoresEncontrados = 0;

        Nota pivo = notas[fim - 1];
        for (int analisando = 0; analisando < fim - 1; analisando++) {
            Nota atual = notas[analisando];
            if (atual.getNota() <= pivo.getNota()) {
                trocar(notas, analisando, menoresEncontrados);
                menoresEncontrados++;
            }
        }

        trocar(notas, fim - 1, menoresEncontrados);
        
        return menoresEncontrados;
    }

    private static void trocar(Nota[] notas, int de, int para) {
        Nota nota1 = notas[de];
        Nota nota2 = notas[para];
        notas[para] = nota1;
        notas[de] = nota2;
    }
}
