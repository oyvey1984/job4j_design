package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void whenThisUnknown() {
        Box box = new Box(4, -2);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Unknown object")
                .isNotEmpty()
                .isNotNull()
                .isNotBlank()
                .containsIgnoringCase("OBject")
                .contains("Unknown", "object")
                .doesNotContain("javascript")
                .startsWith("U")
                .endsWith("t");
    }

    @Test
    void whenThisTetrahedron() {
        Box box = new Box(4, 5);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Tetrahedron")
                .isNotEmpty()
                .isNotNull()
                .isNotBlank()
                .containsIgnoringCase("tetra")
                .contains("Tetrahedron")
                .doesNotContain("javascript")
                .startsWith("Te")
                .endsWith("on");
    }

    @Test
    void whenVertexIsEight() {
        Box box = new Box(8, 9);
        int vertex = box.getNumberOfVertices();
        assertThat(vertex).isEqualTo(8)
                .isNotZero()
                .isPositive()
                .isEven()
                .isGreaterThan(1)
                .isLessThan(10);
    }

    @Test
    void whenVertexIsMinusOne() {
        Box box = new Box(6, 9);
        int vertex = box.getNumberOfVertices();
        assertThat(vertex).isEqualTo(-1)
                .isNotZero()
                .isNegative()
                .isGreaterThan(-2)
                .isLessThan(10);
    }

    @Test
    void whenIsExistIsTrue() {
        Box box = new Box(8, 9);
        assertThat(box.isExist()).isTrue()
                .isNotNull();
    }

    @Test
    void whenIsExistIsFalse() {
        Box box = new Box(6, 9);
        assertThat(box.isExist()).isFalse()
                .isNotNull();
    }

    @Test
    void whenAreaOfSphere() {
        Box box = new Box(0, 10);
        double area = 1256.637;
        double value = 0.0001d;
        assertThat(box.getArea()).isEqualTo(area, withPrecision(value))
                .isNotZero()
                .isPositive()
                .isGreaterThan(1)
                .isLessThan(1500);
    }

    @Test
    void whenAreaOfCube() {
        Box box = new Box(8, 10);
        double area = 600;
        double value = 0.0001d;
        assertThat(box.getArea()).isEqualTo(area, withPrecision(value))
                .isNotZero()
                .isPositive()
                .isGreaterThan(599.99d)
                .isLessThan(700.00d);
    }
}