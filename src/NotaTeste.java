public class NotaTeste {
    public static void main(String[] args) {
        Nota[] notasDoAlberto = {
            new Nota("Jonas", 3),
            new Nota("Juliana", 6.7),
            new Nota("Guilherme", 7),
            new Nota("Lúcia", 9.3),
            new Nota("Ana", 10)
        };

        Nota[] notasDoMauricio = {
            new Nota("André", 4),
            new Nota("Mariana", 5),
            new Nota("Carlos", 8.5),
            new Nota("Paulo", 9)
        };


        Nota[] rank = intercalar(notasDoAlberto, notasDoMauricio);
        for (Nota nota : rank) {
            System.out.println(nota.getAluno() + " " + nota.getNota());
        }
    }

    private static Nota[] intercalar(Nota[] notas1, Nota[] notas2) {
        int tamanho = notas1.length + notas2.length;
        Nota[] resultado = new Nota[tamanho];

        int atual1 = 0;
        int atual2 = 0;
        int atualDoResultado = 0;

        while(atual1 < notas1.length && atual2 < notas2.length) {
            Nota nota1 = notas1[atual1];
            Nota nota2 = notas2[atual2];

            if (nota1.getNota() < nota2.getNota()) {
                resultado[atualDoResultado] = nota1;
                atual1++;
            } else {
                resultado[atualDoResultado] = nota2;
                atual2++;
            }

            atualDoResultado++;
        }

        while(atual1 < notas1.length) {
            resultado[atualDoResultado] = notas1[atual1];
            atual1++;
            atualDoResultado++;
        }

        while(atual2 < notas2.length) {
            resultado[atualDoResultado] = notas2[atual2];
            atual2++;
            atualDoResultado++;
        }

        return resultado;
    }
}
