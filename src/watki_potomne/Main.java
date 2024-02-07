package watki_potomne;


class mojWatek implements Runnable
{
    int licznik;
    Thread wtk;

    //tworznie nowego watku
    mojWatek(String name)
    {
        wtk = new Thread(this, name);
        licznik = 0;
        wtk.start(); //rozpoczecie watku
    }

    //poczatek wykonywania nowego watku
    @Override
    public void main()
    {
        System.out.println(wtk.getName() + " startuje.");
        try
        {
            do {
                Thread.sleep(500);
                System.out.println(wtk.getName() + ", licznik = " + licznik);
                licznik++;
            }
            while(licznik < 10);
        }
        catch (InterruptedException exc)
        {
            System.out.println(wtk.getName() + " przerwany.");
        }
        System.out.println(wtk.getName() + " zakonczony.");
    }
}

public class Main {
    public static void main(String args)
    {
        System.out.println("Moj watek startuje.");

        //tworzenie i wykonywanie 3 watkow
        mojWatek mw1 = new mojWatek("watek 1");
        mojWatek mw2 = new mojWatek("watek 2");
        mojWatek mw3 = new mojWatek("watek 3");

        do
        {
            Thread.sleep(100);
        }
        catch(InterruptedException exc)
        {
            System.out.println("glowny watek zostal przerwany.");
        } while (mw1.licznik < 10 || mw2.licznik < 10 || mw3.licznik < 10);

        System.out.println("glowny watek zostal zakonczony.");
    }
}
