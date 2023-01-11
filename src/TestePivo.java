public class TestePivo {
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
    
        quebrarNoPivo(notas, 0, notas.length);

        for (Nota nota : notas) {
            System.out.println(nota.getAluno() + " " + nota.getNota());
        }
    }    

    private static int quebrarNoPivo(Nota[] notas, int inicial, int fim) {
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
