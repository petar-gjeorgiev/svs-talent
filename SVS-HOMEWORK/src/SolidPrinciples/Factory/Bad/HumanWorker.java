package SolidPrinciples.Factory.Bad;

public class HumanWorker implements Worker {

    @Override
    public void work() {
        System.out.println("HumanWorker.work");
    }

    @Override
    public void stopWorking() {
        System.out.println("HumanWorker.stopWorking");
    }

    @Override
    public void eat() {
        System.out.println("HumanWorker.eat");
    }
}
