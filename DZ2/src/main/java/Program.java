import java.util.Random;

public class Program {
    public static void main(String[] args) {
        int teamSize = 10;
        Developer[] devTeam = new Developer[teamSize];
        Random random = new Random();
        for (int i = 0; i < teamSize; i++) {
            switch (random.nextInt(1, 4)) {
                case 1:
                    devTeam[i] = new BackEndDeveloper();
                    break;
                case 2:
                    devTeam[i] = new FrontEndDeveloper();
                    break;
                default:
                    devTeam[i] = new FullStackDeveloper();
            }
        }

        for (Developer developer :
                devTeam) {
            System.out.println(developer);
            if (developer instanceof Backender){
                ((Backender) developer).developServer();
            }
            if (developer instanceof Frontender) ((Frontender) developer).developGUI();
            System.out.println("-".repeat(20));
        }
    }
}
