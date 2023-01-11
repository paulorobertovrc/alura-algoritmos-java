public class EncontrarMenores {
    public static void main(String[] args) {
        Nota guilherme = new Nota("Guilherme", 7);
        Nota[] notas = {
            new Nota("Mariana", 5),
            new Nota("Carlos", 8.5),
            new Nota("Jonas", 3),
            new Nota("Ana", 10),
            new Nota("André", 4),
            guilherme,
            new Nota("Paulo", 9),
            new Nota("Lúcia", 9.3),
            new Nota("Juliana", 6.7)
        };

        System.out.println(menores(guilherme, notas));
    }

    private static int menores(Nota busca, Nota[] notas) {
        int menores = 0;
        for (Nota nota : notas) {
            if (nota.getNota() < busca.getNota()) menores++;
        }

        return menores;
    }
}
