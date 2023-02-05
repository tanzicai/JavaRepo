package JavaSE;

public class Instrument{
    public void play(){
        System.out.println("Instrument is playing.....");
    }

    public static void main(String[] args) {

        Wind wind = new Wind();
        System.out.println("——————————————————————wind");
        wind.play();
        Instrument instrument = new Instrument();
        System.out.println("——————————————————————Instrument");
        instrument.play();
        instrument = wind;
        System.out.println("——————————————————————wind向上转型");
        instrument.play();
        Percussion percussion = new Percussion();
        System.out.println("——————————————————————percussion");
        percussion.play();
        instrument = percussion;
        System.out.println("——————————————————————percussion向上转型");
        instrument.play();
    }
}

class Wind extends Instrument{
    @Override
    public void play() {
        System.out.println("wind is playing......");
    }
}


class Percussion extends Instrument{
    @Override
    public void play() {
        System.out.println("Percussion is playing....");
    }
}

