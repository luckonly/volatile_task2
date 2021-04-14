public class Main {
    public static void main(String[] args) {


        Long[] shop1receipts = {200L, 500L, 1100L, 460L, 590L};
        Long[] shop2receipts = {160L, 2560L, 39660L, 4580L, 57570L};
        Long[] shop3receipts = {100L,2000L,300L,4000L,500L};

        Shop shop1 = new Shop(shop1receipts);
        Shop shop2 = new Shop(shop2receipts);
        Shop shop3 = new Shop(shop3receipts);

        Thread threadShop1 = new Thread(null, shop1, "Магазин 1");
        Thread threadShop2 = new Thread(null, shop2, "Магазин 2");
        Thread threadShop3 = new Thread(null, shop3, "Магазин 3");

        threadShop1.start();
        threadShop2.start();
        threadShop3.start();

        try {
            threadShop3.join();
            threadShop2.join();
            threadShop1.join();

            System.out.println("Общая сумма чеков за весь день составила " + shop1.getSum() + " рублей");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
