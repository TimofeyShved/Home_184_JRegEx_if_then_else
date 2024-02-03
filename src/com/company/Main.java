package com.company;

import jregex.Matcher;
import jregex.Pattern;

public class Main {

    public static void main(String[] args) {
        // Так как в Regex нету условий, то необходимо скачать и поставить библиотеку JRegex

        // код выглядит следующим образом:
        // (?условие да/нет)
        // (?условие да)
        // (?условие (да/да/да)/(нет/нет/нет))
        // (первое значение)?второе значение(?(нашлось первое) да/нет)
        Pattern p = new Pattern("(a)?b(?(1)c|d)");
        /*
        Matcher m = p.matcher("bd");  // не найдет "а", значит после символа "b", будет искать "d"
        Matcher m = p.matcher("abc"); // найдет "а", значит после символа "b", будет искать "с"
        Matcher m = p.matcher("bc"); // не найдет "а", значит после символа "b", будет искать "d"
         */
        Matcher m = p.matcher("abd"); // найдет "а", значит после символа "b", будет вначале искать "с", хотя позже и "d" тоже найдёт
        while (m.find()){
            System.out.println(m.start()+" "+m);
        }
    }
}
