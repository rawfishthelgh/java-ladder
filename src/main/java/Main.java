import controller.BlockController;
import java.util.Scanner;
import strategy.PassGenerator;
import strategy.RandomPassGenerator;
import view.InputView;
import view.OutputView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        OutputView outputView = new OutputView();
        PassGenerator passGenerator = new RandomPassGenerator();

        BlockController blockController = new BlockController(inputView, outputView, passGenerator);
        blockController.run();
    }

}
