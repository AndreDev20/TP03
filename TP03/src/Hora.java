import java.util.InputMismatchException;
import java.util.Scanner;

public class Hora {

    private int hora;
    private int min;
    private int seg;

    private static final Scanner scanner = new Scanner(System.in);

    public Hora() {
        System.out.println("Configuração Hora");
        setHor();
        setMin();
        setSeg();
        System.out.println("Hora inicializada com sucesso!");

    }
    public Hora(int h, int m, int s) {
        setHor(h);
        setMin(m);
        setSeg(s);
    }

    public void setHor(int h) {
        if (h >= 0 && h <= 23) {
            this.hora = h;
        }else{
            System.out.println("Hora invalida! Hora deve ser entre 0 e 23!");
            this.hora = h;
        }
    }
    public void setHor() {
        int h;
        boolean entradaValida = false;
        while(!entradaValida) {
            try {
                System.out.print("Digite a hora(0-23): ");
                h = scanner.nextInt();
                if (h >= 0 && h <= 23) {
                    this.hora = h;
                    entradaValida = true;
                } else {
                    System.out.println("Hora inválida. Por favor, digite um número entre 0 e 23.");
                }
            } catch(InputMismatchException e){
                System.out.println("Entrada inválida. Por favor, digite um número inteiro para a hora.");
                scanner.next();
                }
            }
        }

    public void setMin(int m) {
        if(m >= 0 && m <= 59) {
            this.min = m;}
        else {
            System.err.println("Minuto invalido! Minuto deve ser entre 0 e 59!");
            this.min = 0;
        }
    }
    public void setMin(){
        int m;
        boolean entradaValida = false;
        while(!entradaValida) {
            try {
                System.out.print("Digite o minuto(0-59): ");
                m = scanner.nextInt();
                if (m >= 0 && m <= 59) {
                    this.min = m;
                    entradaValida = true;
                } else {
                    System.out.println("Minuto invalido. Por favor, digite um valor entre 0 e 59!");
                }
            }catch(InputMismatchException e){
                    System.out.println("Entrada inválida. Por favor, digite um número inteiro para o minuto.");
                    scanner.next();
                }
        }
    }
    public void setSeg(int s) {
        if (s >= 0 && s <= 59) {
            this.seg = s;
        } else {
            System.err.println("Erro: Segundo inválido (" + s + "). Deve ser entre 0 e 59. Definindo para 0.");
            this.seg = 0;
        }
    }
    public void setSeg() {
        int s;
        boolean entradaValida = false;
        while(!entradaValida) {
            try{
                System.out.print("Digite o segundo(0-59): ");
                s = scanner.nextInt();
                if (s >= 0 && s <= 59) {
                    this.seg = s;
                    entradaValida = true;
                } else{
                    System.out.println("Segundo invalido. Por favor, digite um valor entre 0 e 59!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro para o segundo.");
                scanner.next();
            } finally {
                if (entradaValida) {
                    scanner.nextLine();
                }
            }
        }
    }

    public int getHor() {
        return hora;
    }
    public int getMin(){
        return min;
    }
    public int getSeg() {
        return seg;
    }

    public String getHora1(){
        return String.format("%02d:%02d:%02d", hora, min, seg);
    }
    public String getHora2(){
        int hora12 = hora % 12;
        if (hora12 == 0) {
            hora12 = 12;
        }
        String amPm = (hora< 12) ? "AM" : "PM";
        return String.format("%02d:%02d:%02d %s", hora12, min, seg, amPm);
    }

    public int getSegundos(){
        return hora * 3600 + min*60 + seg;
    }

    public static void fecharScanner(){
        if (scanner != null){
            scanner.close();
        }
    }

    public static void main(String[] args) {
        System.out.println("Testando construtor (entrada do usuario)");
        Hora horaUsuario = new Hora();
        System.out.println("\nHora do Usuario (Formato 1) : " + (horaUsuario.getHora1()));
        System.out.println("\nHora do Usuario (Formato 2) : " + (horaUsuario.getHora2()));
        System.out.println("\nTotal de segundos) : " + horaUsuario.getSegundos());

        System.out.println("Testando com parametros");
        Hora horaFixa = new Hora(14, 35, 20);
        System.out.println("\nHora Fixa (Formato 1) : " + (horaFixa.getHora1()));
        System.out.println("\nHora Fixa (Formato 2) : " + (horaFixa.getHora2()));
        System.out.println("\nTotal de segundos : " + (horaFixa.getSegundos()));

        Hora.fecharScanner();
    }
}
