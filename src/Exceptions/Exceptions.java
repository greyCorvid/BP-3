package Exceptions;

public class Exceptions {

    /*
    Обработка исключений, если нет трай-кэтч

    Пример, как раньше работала обработка ошибок
    Абстрактный код, так на жаве писать нельзя
    f = open ("a.txt")
    if (last.error != 0) { //0 - все хорошо
        print last.err.log(last.error (!))
        return //благодаря этому функция завершится и
                 не пойдет дальше, если все пойдет не так


    txt = read (f) { //0 - все хорошо
        print last.err.log(last.error (!))
        return
    }

    close(f) { //0 - все хорошо
        print last.err.log(last.error (!))
        return
    }

    вместо трех операций приходится делать три операции и три
    огромных кода на проверку ошибок

    может возникнуть исключение exeption
    если возникло - программа дальше не выполняется

    public void f (...) {
        появляется исключение
    }
    в джаве есть два варианта действий
    1) обработка исключения, например, сказать пользователю,
    что ошибка
    2) сказать, что мы не собираемся обрабатывать это исключение,
    явно отказываемся обработать

    как оно оформляется?
    2) если явно отказываемся, то дописываем, что оно кидает исключение
        public void f (...) throws exeption
        у всех функций в жава есть прописанные исключения,
        которые они могут кинуть. это отображается и в помощи
        по функциям. в заголовке функциии говорится, что
        может что-то сломаться
        если мы так пищем, мы отдаем ответственность кому-тодругому
        тот, кто вызывает F, сам теперь должен решить, что делать:
        обработать исключение или отказаться и передать дальше
        ответственность
        единственное, когда не надо решать, если в main
        тоже есть throws exeption
        тогда ответственность за обработку падает на джаву
        она вызывает e.printStackTrace()

    1) как обработать исключение?
        есть функция void f() {
            //место кода, где что-то может пойти не так
            //например, вызов функции с throws
            //иногда и без нее, но чаще всего из-за нее
        }

        можно воспользоваться трай-кетч
            void f() {
                try () {
                    //место, где может случиться ошибка
                }catch(Exeption e){ - выполняется, если внутри трай
                                      был эксепшон
                                      будто заводится переменная
                                      типа эксепшн, где хранится
                                      инОрмация об ошибках
                чаще всего пишут
                }catch(Exeption e){
                    e.ptintStackTrace(!)
                    или можно
                    e.getMessage
                    или можно что-то написать
                }


    throws делятся на: 1) error - то, что вы не решите
                                  например, закончилась память
                                  если закончилась память - ничего
                                  не спасет (OutOfMemoryError)
                       2) exeption - все остальное, то, что имеет смысл
                                  обработать и проверить
                                  делятся на
                                        - возникающие сами по себе: (runtime exeption)
                                                -деление на ноль, DivideByZeroExep
                                                - выход за пределы массива ArrayOutOfBorder
                                                - NullPointer - когда присвоили Null и воспользовались
                                        -еще есть IDExeption
                                                -FileNotFoundExeption (не найден файл)

    по сути, все ошибки - это классы и их наследники
    можем создать свой класс для ошибки
    жаву критикуют, потому что нужно обязательно писать
    exeption все проверки нужно прописывать, кроме runtime exeption и throws 
     */

    /*
    Полная форма try catch
    try { (можно круглые скобки, в них заводим переменную/е, они точно уже будут с вызванным close();)
    } catch (... Exception e) {
    } catch (... Exception e) {
    } finally {
    }

    ексепшены разные и перебираются по очереди. Обычно в конце про ексепшн
    финали выполняется внезависимо от того, было бы исключение.
    Раньше писали закрытия файлов там, но всё правильно обрабатывать трудно.
    */

    /*
    Оператор throw e;

    throw new Exception("ошибка");
    throw new Exception("");
    эксепшн есть просто класс
    Можно создать своё исключение:
    public class MyException extends Exception{
    }

    throw new MyException();
    catch (MyException e) {
    }
     */

    /*Задача 1
    Сделать функцию
    void f(int x) throws Exception (потом сделать MyException) {
    икс чёт - исключение, нечёт ничего
    }

    в main
    for (i от 1 до 100)
        f(i)
    вывести
    1 - нет исключения
    2 -  есть
    3 - нет



    Задача 2
    метод Integer.parseInt("242") есть. строку в число
    написать функцию
    readInt(String message) {

    }

    в main
    int x = readInt("Введите x");
    int y = ;
    sout("x + y =" + (x+y));

    чтобы делало "вы ввели не число, введите ещё раз." цикл.
    исключение по методу посмотреть.
    чтение с клавиатуры:
    s = new Scanner(System.in);
    s.nextLine();
     */
}