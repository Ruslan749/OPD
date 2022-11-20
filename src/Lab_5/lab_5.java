package Lab_5;
import java.util.Scanner;
public class lab_5 {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        Methods methods = new Methods();
// Для тестового расчета будем считать, что согласно этой статистике, разработка и отладка требовала у программиста:

//        int [] screen = new int[]{2,20,4}; // для одного экрана
//        int [] event  = new int[]{4,32,8}; // для одного обработчика событий
//        int [] businessObject = new int[]{2,8,3}; // для одного бизнес объекта
//        int [] newBusinessMethod = new int[]{2,26,6}; // для одого нового бизнес метода

        int [] screen  = new int[3];
        int [] event  = new int[3];
        int [] businessObject = new int[3];
        int [] newBusinessMethod = new int[3];

        for (int j = 0; j <= 1; j++){
            System.out.println("трудозатраты для одного экрана");
            for (int i = 0; i< screen.length; i++){
                switch (i) {
                    case 0 -> System.out.print("минимально возможные трудозатраты: ");
                    case 1 -> System.out.print("пессимистическая оценка трудозатрат: ");
                    case 2 -> System.out.print("наиболее вероятная оценка трудозатрат: ");
                }
                screen[i] = in.nextInt();
            }
        }

        for (int j = 0; j<=1; j++){
            for (int i = 0; i< event.length; i++){
                System.out.println("трудозатраты для одного обработчика событий");
                switch (i) {
                    case 0 -> System.out.print("минимально возможные трудозатраты: ");
                    case 1 -> System.out.print("пессимистическая оценка трудозатрат: ");
                    case 2 -> System.out.print("наиболее вероятная оценка трудозатрат: ");
                }
                event[i] = in.nextInt();
            }
        }

        for (int j = 0; j<=1; j++){
            for (int i = 0; i< businessObject.length; i++){
                System.out.println("трудозатраты для одного бизнес объекта");
                switch (i) {
                    case 0 -> System.out.print("минимально возможные трудозатраты: ");
                    case 1 -> System.out.print("пессимистическая оценка трудозатрат: ");
                    case 2 -> System.out.print("наиболее вероятная оценка трудозатрат: ");
                }
                businessObject[i] = in.nextInt();
            }
        }

        for (int j = 0; j<=1; j++){
            for (int i = 0; i< newBusinessMethod.length; i++){
                System.out.println("трудозатраты для одого нового бизнес метода");
                switch (i) {
                    case 0 -> System.out.print("минимально возможные трудозатраты: ");
                    case 1 -> System.out.print("пессимистическая оценка трудозатрат: ");
                    case 2 -> System.out.print("наиболее вероятная оценка трудозатрат: ");
                }
                newBusinessMethod[i] = in.nextInt();
            }
        }

        System.out.print("Оценку средней трудоемкости кодирования по каждому элементарному пакету: \n");
        System.out.printf(" - трудоемкомть кодирования для экранов: %s \n",methods.meanLaborCod(screen)); // трудоемкомть кодирования для экранов
        System.out.printf(" - трудоемкомть кодирования для обработчиков событий: %s \n",methods.meanLaborCod(event)); // трудоемкомть кодирования для одного обработчиков событий
        System.out.printf(" - трудоемкомть кодирования для бизнес объектов: %s \n",methods.meanLaborCod(businessObject)); // трудоемкомть кодирования для бизнес объектов
        System.out.printf(" - трудоемкомть кодирования для бизнес методов: %s \n",methods.meanLaborCod(newBusinessMethod)); // трудоемкомть кодирования для бизнес методов

        System.out.println("Среднеквадратное отклонение:");
        System.out.printf(" - для экранов: %s \n" ,methods.meanDiviation(screen));
        System.out.printf(" - обработчиков событий: %s \n",methods.meanDiviation(event));
        System.out.printf(" - для бизнес объектов: %s \n",methods.meanDiviation(businessObject));
        System.out.printf(" - для новых бизнес методов: %s \n",methods.meanDiviation(newBusinessMethod));

        System.out.print("Суммарная трудоемкость проекта: ");
        System.out.println(methods.sumLabor(methods.meanLaborCod(screen),methods.meanLaborCod(event),methods.meanLaborCod(businessObject),methods.meanLaborCod(newBusinessMethod)));

        System.out.print("Среднеквадратичное отклонение для оценки суммарной трудоемкости кодирования: ");
        System.out.println(methods.sumMeanDiviation(methods.meanDiviation(screen),methods.meanDiviation(event),methods.meanDiviation(businessObject),methods.meanDiviation(newBusinessMethod)));

        System.out.print("Суммарной трудоемкости кодирования проекта: ");
        System.out.println(methods.sumDiviation());

        System.out.print("Относительная погрешность в оценке суммарной трудоемкости кодирования: ");
        System.out.println(methods.errorSumDiviation() + "%");

        System.out.print("Расчёт общей трудоёмкости: ");
        System.out.println(methods._sumDiviation());

        System.out.print("Пересчёт человеко-часов в человеко-месяцы: ");
        System.out.println(methods.recPeople());

        System.out.print("Закон Барии Боэма (Barry Boehm): ");
        System.out.println(methods.law());

        System.out.print("Средняя численность команды: ");
        System.out.println(methods.meanPeople());
    }
}

class Methods{
    private int meanLaborCod;
    private  int meanDiviation;
    private int sumLabor;
    private int sumMeanDiviation;
    private  int sumDiviation;
    private int errorSumDiviation;
    private int _sumDiviation;
    private int recPeople;
    private float law;
    private int meanPeople;

    // метод оценки средней трудоемкости кодирования по каждому элементарному пакету
    int  meanLaborCod (int[] num){
        for (int i = 0 ; i < num.length; i++){
            meanLaborCod = (num[0] + 4*num[1] + num[2])/6;
        }
        return meanLaborCod;
    }
    // метод среднеквадратного отклонения
    int meanDiviation (int [] num){
        for (int i = 0 ; i < num.length; i++){
            meanDiviation = (num[1] - num[0])/6;
        }
        return meanDiviation;
    }
    // метод суммарной трудоемкости проекта:
    int sumLabor(int a, int b, int c, int d){
        sumLabor = a + b + c + d;
        return sumLabor;
    }
    //Среднеквадратичное отклонение для оценки суммарной трудоемкости кодирования
    int sumMeanDiviation (int a, int b, int c, int d){
        int res = a+b+c+d;
        sumMeanDiviation = (int) Math.sqrt(Math.pow(res,2));
        return sumMeanDiviation;
    }
    // Cуммарной трудоемкости кодирования проекта,
    int sumDiviation (){
        sumDiviation = sumLabor + 2 * sumMeanDiviation;
        return sumDiviation;

    }
    // Относительная погрешность в оценке суммарной трудоемкости
    int errorSumDiviation (){
        errorSumDiviation = Math.round((float) sumMeanDiviation / sumLabor * 100);
        return errorSumDiviation;
    }

    // Расчёт общей трудоёмкости
    int _sumDiviation(){
        _sumDiviation = 4 * sumDiviation;
        return _sumDiviation;
    }
    // Пересчёт человеко-часов в человеко-месяцы
    int recPeople (){
        recPeople = _sumDiviation / 132;
        return recPeople;
    }
    // Закон Барии Боэма (Barry Boehm)
    float law (){
        law = (float) ((Math.pow(recPeople,0.33))*2.5);
        return law;
    }
    // Средняя численность команды:
    int meanPeople (){
        meanPeople = Math.round(recPeople / law);
        return meanPeople;
    }
}
