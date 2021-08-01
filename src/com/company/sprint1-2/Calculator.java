/*
https://contest.yandex.ru/contest/22781/run-report/52269616/

/*
-- ПРИНЦИП РАБОТЫ --
Я реализовал калькулятор, связанный с обратной польской нотацией.
На вход получаем строку, разбиваем ее на массив из строк и крутим в цикле.
Если текущий элемент цикла это операнд, то добавляем в стек.
Если это знаковый оператор (+, -, *, /), то производим соответсвующую операцию над двумя числами в порядке их добавления в стек.
Если на вход подан массив строк, не имеющего не одного знакового оператора, происходит вывод последнего элемента данного массива.
Когда все элементы массива со строками прокручены в цикле, выводим единственное оставшееся число.


-- ДОКАЗАТЕЛЬСТВО КОРРЕКТНОСТИ --
Из описания следует, что алгоритм способен распозновать и обрабатывать строки с обратной польской нотацией. Алгоритм работает и корректно и проходит все тесты.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Алгоритм имеет временную сложность O(n), т.к основан на цикле, проверяющем все элементы массива по очереди.

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Входной стек содержит k элементов и имеет сложность O(k), на выходе получается стек с 1 элементом и имеющим сложность O(1).
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Calculator {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        String expression = reader.readLine();
        String[] splitExpression = expression.split(" ");
        boolean hasOperator = false; // если в строке нет знака операции, то в выводе будет последнее число в строке
        for (int i = 0; i < splitExpression.length; i++) {
            if (isDigit(splitExpression[i])) {
                int number = Integer.parseInt(splitExpression[i]);
                if (Math.abs(number) < 10000) { // числа на вход должны быть меньше 10000 по модулю
                    stack.push(number);
                }
            }
            else {
                hasOperator = true;
                doProcessing(splitExpression[i], stack);
            }
        }
        if (hasOperator) {
            System.out.println(stack.get(0));
        }
        else {
            System.out.println(splitExpression[splitExpression.length - 1]);
        }

    }

    public static boolean isDigit(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void doProcessing(String s, Stack<Integer> stack) throws Exception {
        int secondOperand = stack.pop();
        int firstOperand = stack.pop();
        switch (s) {
            case "+": {
                int result = firstOperand + secondOperand;
                if (Math.abs(result) < 50000) // "гарантируется, что значение промежуточных выражений в тестовых данных по модулю не больше 50000." проверка
                {
                    stack.push(result);
                    break;
                }
                else {
                    throw new Exception();
                }
            }
            case "-": {
                int result = firstOperand - secondOperand;
                if (Math.abs(result) < 50000)
                {
                    stack.push(result);
                    break;
                }
                else {
                    throw new Exception();
                }
            }
            case "*": {
                int result = firstOperand * secondOperand;
                if (Math.abs(result) < 50000)
                {
                    stack.push(result);
                    break;
                }
                else {
                    throw new Exception();
                }
            }
            case "/": {
                // перевод числе в тип double для использования Math.floor и округления вниз
                double result = (double) firstOperand / (double) secondOperand;
                if (Math.abs(result) < 50000  && secondOperand > 0) // проверка деления на отрицательное число
                {
                    stack.push((int) Math.floor(result));
                    break;
                }
                else {
                    throw new Exception();
                }
            }
        }
}
}
