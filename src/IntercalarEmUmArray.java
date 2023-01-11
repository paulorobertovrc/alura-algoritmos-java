public class IntercalarEmUmArray {
    public static void main(String[] args) {
        Nota[] notas = {
            new Nota("André", 4),
            new Nota("Mariana", 5),
            new Nota("Carlos", 8.5),
            new Nota("Paulo", 9),
            new Nota("Jonas", 3),
            new Nota("Juliana", 6.7),
            new Nota("Guilherme", 7),
            new Nota("Lúcia", 9.3),
            new Nota("Ana", 10)
        };

        Nota[] rank = intercalar(notas, 3, 3, 4);
        for (Nota nota : rank) {
            System.out.println(nota.getAluno() + " " + nota.getNota());
        }
    }

    private static Nota[] intercalar(Nota[] notas, int inicio, int miolo, int fim) {
        Nota[] resultado = new Nota[fim - inicio];
        int atual = 0;
        int atual1 = inicio;
        int atual2 = miolo;

        while(atual1 < miolo && atual2 < fim) {
            Nota nota1 = notas[atual1];
            Nota nota2 = notas[atual2];

            if (nota1.getNota() < nota2.getNota()) {
                resultado[atual] = nota1;
                atual1++;
            } else {
                resultado[atual] = nota2;
                atual2++;
            }

            atual++;
        }

        while(atual1 < miolo) {
            resultado[atual] = notas[atual1];
            atual++;
            atual1++;
        }

        while(atual2 < fim) {
            resultado[atual] = notas[atual2];
            atual++;
            atual2++;
        }

        for (int i = 0; i < atual; i++) {
            notas[inicio + i] = resultado[i];
        }

        return notas;
    }
}
