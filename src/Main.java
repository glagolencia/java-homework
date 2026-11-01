public class Main {
    public static void main(String[] args) {
        BankAccount anna = new BankAccount(
                "100001",
                new Balance(100_000, Currency.RUB),
                50_000
        );

        BankAccount maria = new BankAccount(
                "100002",
                new Balance(50_000, Currency.RUB),
                30_000
        );

        System.out.println("Начальный баланс Анны: " + anna.getBalance());
        System.out.println("Начальный баланс Марии: " + maria.getBalance());

        anna.deposit(10_000);
        System.out.println("После пополнения Анны: " + anna.getBalance());

        anna.withdraw(5_000);
        System.out.println("После снятия денег: " + anna.getBalance());

        anna.transferTo(maria, 20_000);
        System.out.println("После перевода:");
        System.out.println("Анна: " + anna.getBalance());
        System.out.println("Мария: " + maria.getBalance());

        Balance dollars = new Balance(1_000, Currency.USD);
        System.out.println("1000 центов в рублях: " + dollars.convertTo(Currency.RUB));

        anna.setBlocked(true);

        try {
            anna.withdraw(1_000);
        } catch (IllegalStateException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}