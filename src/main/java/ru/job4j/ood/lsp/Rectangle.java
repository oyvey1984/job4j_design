package ru.job4j.ood.lsp;

class Rectangle {
    protected int width, height;

    public void setWidth(int w) {
        this.width = w;
    }
    public void setHeight(int h) {
        this.height = h;
    }

    public int getArea() {
        return width * height;
    }
}

class Square extends Rectangle {
    @Override
    public void setWidth(int w) {
        this.width = w;
        this.height = w;
    }

    @Override
    public void setHeight(int h) {
        this.height = h;
        this.width = h;
    }
}
