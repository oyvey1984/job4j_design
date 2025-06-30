package ru.job4j.ood.lsp;

class BankAccount {
    protected double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Неверная сумма для снятия");
        }
        if (balance < amount) {
            throw new IllegalArgumentException("Недостаточно средств");
        }
        balance -= amount;
    }
}

class SavingsAccount extends BankAccount {

    public SavingsAccount(double balance) {
        super(balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Неверная сумма для снятия");
        }
        if (balance - amount < 1000) {
            throw new IllegalArgumentException("Минимальный остаток должен быть 1000");
        }
        balance -= amount;
    }
}
