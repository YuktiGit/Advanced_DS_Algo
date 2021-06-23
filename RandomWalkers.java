public class RandomWalkers {
 public static void main(String [] args) {
    int r = Integer.parseInt(args[0]);
    int trials = Integer.parseInt(args[1]);
    int x = 0;
    int y = 0;
    int distance = 0;
    int sumOfSteps = 0;
    double averageSteps = 0;
    int steps = 0;
    for(int i = 1; i <= trials; i++) {
        while(distance!=r) {
            double random = Math.random();
            if(random > 0 && random < 0.25) {
                x = x + 1;
                steps++;
            }
            if(random > 0.25 && random < 0.50) {
                x = x - 1;
                steps++;
            }
            if(random > 0.50 && random < 0.75) {
                y = y + 1;
                steps++;
            }
            if(random > 0.75 && random < 1) {
                y = y - 1;
                steps++;

            }
            distance = Math.abs(x + y);
        }
        sumOfSteps = sumOfSteps + steps;
    }
    averageSteps = (double)(sumOfSteps / trials);
    System.out.println("average steps" + averageSteps);
 } 
}