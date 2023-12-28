import java.util.Random;

public interface Player {
    boolean choiceAltered();
    default int initialChoice(){
        return new Random().nextInt(3);
    }
}
