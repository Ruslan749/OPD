package Lab_5;
import java.util.Scanner;
public class lab_5 {

    public static void main(String[] args) {
        Methods methods = new Methods();
// Для тестового расчета будем считать, что согласно этой статистике, разработка и отладка требовала у программиста:

        int [] screen = new int[]{2,20,4}; // для одного экрана
        int [] event  = new int[]{4,32,8}; // для одного обработчика событий
        int [] businessObject = new int[]{2,8,3}; // для одного бизнес объекта
        int [] newBusinessMethod = new int[]{2,26,6}; // для одого нового бизнес метода
        methods.valueScaner();

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
        System.out.println(methods.sumLabor( methods.meanLaborCod(screen),  methods.meanLaborCod(event),  methods.meanLaborCod(businessObject), methods.meanLaborCod(newBusinessMethod)));

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
    static Scanner in = new Scanner(System.in);
//    int [] data = new int[]{20,60,16,40};
    int [] data = new int[4];
    public void valueScaner (){
        for (int j = 0; j < 1; j++){
            for (int i = 0; i< data.length; i++){
                System.out.println("новое разрабатываемое приложение содержит");
                switch (i) {
                    case 0 -> System.out.print("пользовательские экраны: ");
                    case 1 -> System.out.print("обработчики событий: ");
                    case 2 -> System.out.print("новые бизнес-объекты: ");
                    case 3 -> System.out.print("новые бизнесметоды: ");
                }
                data[i] = in.nextInt();
            }
        }
    }

    private double meanLaborCod;
    private double meanDiviation;
    private double sumLabor;
    private double sumMeanDiviation;
    private double sumDiviation;
    private long errorSumDiviation;
    private double _sumDiviation;
    private double recPeople;
    private double law;
    private int meanPeople;


    // метод оценки средней трудоемкости кодирования по каждому элементарному пакету
    double meanLaborCod (int[] num){
        for (int i = 0 ; i < num.length; i++){
            double value  = (double)(num[0] + 4*num[2] + num[1])/6;
            double scale = Math.pow(10, 2);
            meanLaborCod =  (Math.ceil(value * scale) / scale);
        }
        return meanLaborCod;
    }
    // метод среднеквадратного отклонения
    double meanDiviation (int [] num){
        for (int i = 0 ; i < num.length; i++){
            double value  = (double)(num[1] - num[0])/6;
            double scale = Math.pow(10, 2);
            meanDiviation = (Math.ceil(value * scale) / scale);
        }
        return meanDiviation;
    }
    // метод суммарной трудоемкости проекта:
    double sumLabor(double a, double b, double c, double d){
        for (int i = 0; i< data.length; i++){
            sumLabor = data[0]*a+data[1]*b+data[2]*c+data[3]*d;
        }
        return sumLabor;
    }
    //Среднеквадратичное отклонение для оценки суммарной трудоемкости кодирования
    double sumMeanDiviation (double a, double b, double c, double d){
        for (int i = 0; i< data.length; i++){
            double res = data[0]*Math.pow(a,2)+data[1]*Math.pow(b,2)+data[2]*Math.pow(c,2)+data[3]*Math.pow(d,2);
            double value  = Math.sqrt(res);
            double scale = Math.pow(10, 2);
            sumMeanDiviation =  (Math.ceil(value * scale) / scale);
        }
        return sumMeanDiviation;
    }
    // Cуммарной трудоемкости кодирования проекта,
    double sumDiviation (){
        double value  = sumLabor + 2 * sumMeanDiviation;
        double scale = Math.pow(10, 2);
        sumDiviation = (Math.ceil(value * scale) / scale);
        return sumDiviation;

    }
    // Относительная погрешность в оценке суммарной трудоемкости
    double errorSumDiviation (){
        errorSumDiviation = Math.round(sumMeanDiviation / sumLabor * 100);
        return errorSumDiviation;
    }
    // Расчёт общей трудоёмкости
    double _sumDiviation(){
        _sumDiviation = 4 * sumDiviation;
        return _sumDiviation;
    }
    // Пересчёт человеко-часов в человеко-месяцы
    double recPeople (){
        double value  = _sumDiviation / 132;
        double scale = Math.pow(10, 2);
        recPeople = (Math.ceil(value * scale) / scale);
        return recPeople;
    }
    // Закон Барии Боэма (Barry Boehm)
    double law (){
        double value  = ((Math.pow(recPeople,0.33))*2.5);
        double scale = Math.pow(10, 2);
        law = (Math.ceil(value * scale) / scale);
        return law;
    }
    // Средняя численность команды:
    int meanPeople (){
        meanPeople = (int) Math.round(recPeople / law);
        return meanPeople;
    }
}
