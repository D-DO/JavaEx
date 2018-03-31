package Net;


import java.io.*;
import java.net.*;

public class FirstPage {
    public static void main(String args[]) {
        try {
            URL url = new URL("http://vyvozmusora-lyubercy.ru");
            LineNumberReader r = new LineNumberReader(new InputStreamReader(url.openStream()));
            String s = r.readLine();
            while (s != null) {
                System.out.println(s);
                s = r.readLine();
            }
            System.out.println(r.getLineNumber());
            r.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//      Классы, работающие с сетевыми протоколами, располагаются в пакете java.net,
//        и простейшим из них является класс URL. С его помощью можно сконструировать
//        uniform resource locator (URL), который имеет следующий формат:
//
//        protocol://host:port/resource
//
//        Здесь protocol – название протокола, используемого для связи;
//      host – IP-адрес, или DNS-имя сервера, к которому производится обращение;
//      port – номер порта сервера (если порт не указан, то используется значение
//        по умолчанию для указанного протокола); resource – имя запрашиваемого
//        ресурса, причем, оно может быть составным, например:
//
//        ftp://myserver.ru/pub/docs/Java/JavaCourse.txt
//
//        Затем можно воспользоваться методом openStream(), который возвращает
//        InputStream, что позволяет считать содержимое ресурса. Например,
//        следующая программа при помощи LineNumberReader считывает первую
//        страницу сайта http://www.ru и выводит ее на консоль.


//<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
//<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ru-ru" lang="ru-ru">
//
//<head>
//
//<meta http-equiv="content-type" content="text/html; charset=utf-8" />
//<meta name="yandex-verification" content="407d0d80933e187e" />
//<meta name="keywords" content="вывоз мусора Люберцы контейнером строительного" />
// ...

//        Из примера мы видим, что работа с сетью, как и работа с потоками,
//        требует дополнительной работы с исключительными ситуациями.
//        Ошибка MalformedURLException появляется в случае, если строка
//        c URL содержит ошибки.
//
//        Более функциональным классом является URLConnection,
//        который можно получить с помощью метода класса URL.openConnection().
//        У этого класса есть два метода – getInputStream() (именно с его
//        помощью работает URL.openStream() ) и getOutputStream(), который
//        можно использовать для передачи данных на сервер, если он
//        поддерживает такую операцию (многие публичные web-серверы
//        закрыты для таких действий).
//
//        Класс URLConnection является абстрактным. Виртуальная машина
//        предоставляет реализации этого класса для каждого протокола,
//        например, в том же пакете java.net определен класс HttpURLConnection.
//        Понятно, что классы URL и URLConnection предоставляют возможность
//        работы через сеть на прикладном уровне с помощью высокоуровневых протоколов.