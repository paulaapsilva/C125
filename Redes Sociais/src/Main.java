import java.util.*;

public class Main {
    public static void main(String[] args) {

        RedeSocial[] novaRede = new RedeSocial[4];

        Usuario usuario1 = new Usuario(novaRede);
        usuario1.setNome("Chris");
        usuario1.setEmail("chrislima@gmail.com");

        Scanner entrada = new Scanner(System.in);

        int valorEntrada;

        for (int i = 0; i < novaRede.length; i++) {
            System.out.println("Em qual rede social você deseja logar?: ");
            do {
                System.out.println("1 - Instagram\n2 - Google Plus\n3 - Twitter\n4 - Facebook\n5- Sair");
                valorEntrada = entrada.nextInt();
                entrada.nextLine();
            } while (!(valorEntrada == 1 || valorEntrada == 2 || valorEntrada == 3 || valorEntrada == 4 || valorEntrada == 5)); //digita novamente se for diferente disso

                switch (valorEntrada) {
                    case 1:  //instagram
                        System.out.println("Insira sua senha: ");
                        String senha;
                        senha = entrada.nextLine();
                        System.out.println("Insira numero de seguidores");
                        int numAmigos;
                        numAmigos = entrada.nextInt();

                        Instragram instragram = new Instragram(senha, numAmigos);
                        usuario1.redes[i] = instragram;
                        break;
                    case 2: //google plus
                        System.out.println("Insira sua senha: ");
                        senha = entrada.nextLine();

                        System.out.println("Insira numero de amigos");
                        numAmigos = entrada.nextInt();

                        GooglePlus googlePlus = new GooglePlus(senha, numAmigos);
                        usuario1.redes[i] = googlePlus; // array de redes na Classe Usuario recebe a rede social GooglePlus
                        break;

                    case 3: //google plus
                        System.out.println("Insira sua senha: ");
                        senha = entrada.nextLine();

                        System.out.println("Insira numero de seguidores");
                        numAmigos = entrada.nextInt();

                        Twitter twitter = new Twitter(senha, numAmigos);
                        usuario1.redes[i] = twitter; // array de redes na Classe Usuario recebe a rede social GooglePlus
                        break;
                    case 4: //facebook
                        System.out.println("Insira sua senha: ");
                        senha = entrada.nextLine();

                        System.out.println("Insira numero de seguidores");
                        numAmigos = entrada.nextInt();

                        Facebook facebook = new Facebook(senha, numAmigos);
                        usuario1.redes[i] = facebook; // array de redes na Classe Usuario recebe a rede social GooglePlus
                        break;
                    default:
                        break;
                }
            }

            //mostrando nome de usuario e seu e-mail
            System.out.println("Nome: " + usuario1.getNome() + "\nE-mail: " + usuario1.getEmail());

            System.out.println("Ações do usuario: \n");
            for (int i = 0; i < usuario1.redes.length; i++) {
                if (usuario1.redes[i] != null) {
                    if (usuario1.redes[i] instanceof Facebook) {
                        System.out.println("\nFacebook:");
                        usuario1.redes[i].postarComentario();
                        usuario1.redes[i].postarFoto();
                        usuario1.redes[i].postarVideo();
                    }
                    if (usuario1.redes[i] instanceof GooglePlus) {
                        System.out.println("\nGoogle Plus:");
                        ((GooglePlus) usuario1.redes[i]).fazStreaming();
                        ((GooglePlus) usuario1.redes[i]).compartilhar();
                        usuario1.redes[i].curtirPublicacao();
                    }
                    if (usuario1.redes[i] instanceof Twitter) {
                        System.out.println("\nTwitter:");
                        usuario1.redes[i].curtirPublicacao();
                        usuario1.redes[i].postarFoto();
                        ((Twitter) usuario1.redes[i]).compartilhar();
                    }
                    if (usuario1.redes[i] instanceof Instragram) {
                        System.out.println("\nInstragram:");
                        usuario1.redes[i].postarFoto();
                        usuario1.redes[i].postarVideo();
                        usuario1.redes[i].curtirPublicacao();
                    }
                }
            }
    }
}