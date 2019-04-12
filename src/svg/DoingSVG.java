package svg;

import java.io.IOException;

public class DoingSVG {
    public static void main(String[] args) {
        task4();
    }

    private static void task2() {
        Tag rect = new Tag("rect");
        rect.set("x", "10");
        rect.set("y", "10");
        rect.set("height", "100");
        rect.set("width", "100");
        rect.set("style", "stroke:#ff0000; fill: #0000ff");
        try (SVG svg = new SVG("rect.svg", 300, 300)){
            //В формате try with resource,
            //так как интерфейс AutoCloseable свг применяет метод close
            //и нам не надо его прописывать
            svg.addTag(rect);
        } catch (IOException e) {
            System.out.println("Ошибка создания SVG");
        }
    }

    private static void task4() {
        //Имплементирование вложенных тегов
        Tag rect1 = new Tag("rect");
        rect1.set("x", "10");
        rect1.set("y", "10");
        rect1.set("height", "100");
        rect1.set("width", "100");
        rect1.set("style", "stroke:#ff0000; fill: #0000ff");

        Tag rect2 = new Tag("rect");
        rect2.set("x", "20");
        rect2.set("y", "20");
        rect2.set("height", "100");
        rect2.set("width", "100");
        rect2.set("style", "stroke:#ff0000; fill: #00ff00");

        Tag g = new Tag("g", TagType.OPEN);
        g.set("transform", "translate(150, 150)");

        Tag gClose = new Tag("g", TagType.CLOSE);

        try (SVG svg = new SVG("a.svg", 300, 300)) {
            svg.addTag(rect1);
            svg.addTag(rect2);
            svg.addTag(g);
            svg.addTag(rect1);
            svg.addTag(rect2);
            svg.addTag(gClose);
        } catch (IOException e) {
            System.out.println("Ошибка создания SVG");
        }
    }
}
