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
}
