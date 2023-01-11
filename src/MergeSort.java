public class MergeSort {
    public static void main(String[] args) {
        Nota[] notas = {
            new Nota("Mariana", 5),
            new Nota("Carlos", 8.5),
            new Nota("Jonas", 3),
            new Nota("Ana", 10),
            new Nota("André", 4),
            new Nota("Guilherme", 7),
            new Nota("Paulo", 9),
            new Nota("Lúcia", 9.3),
            new Nota("Juliana", 6.7)
        };

        ordenar(notas, 0, notas.length);

        for (Nota nota : notas) {
            System.out.println(nota.getAluno() + " " + nota.getNota());
        }
    }

    private static void ordenar(Nota[] notas, int inicio, int fim) {
        int quantidade = fim - inicio;

        if (quantidade > 1) {
            int meio = (inicio + fim) / 2;
    
            ordenar(notas, inicio, meio);
            ordenar(notas, meio, fim);
            intercalar(notas, inicio, meio, fim);
        }
        
    }
    
    private static void intercalar(Nota[] notas, int inicio, int miolo, int fim) {
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
    }
}
