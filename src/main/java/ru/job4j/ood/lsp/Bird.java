package ru.job4j.ood.lsp;

class Bird {
    public void fly() {
        System.out.println("Птица летит");
    }
}

class Ostrich extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Страусы не летают!");
    }
}
