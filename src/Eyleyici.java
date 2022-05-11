import api.Service;
import ui.Yazici;

/**
 * Eyleyici sinif ayni zamanda Dependency Inversion un uygulandigi yerdir service classini alir
 */
public class Eyleyici implements IEyleyici // Eyleyici sınıfı
{
    private final Service service;
    private final Yazici p;

    public Eyleyici(Service service, Yazici p) {
        this.service = service;
        this.p = p;
    }

    @Override
    public void sogutucuAc() {
        boolean open = service.sogutucuDurumu();
        if (open)
            p.EkranaYaz("Cihaz acilamadi! \nCihaz zaten acik");
        else {
            service.sogutucuGuncelle(true);
            p.EkranaYaz("Cihaz acildi.");
        }
    }

    @Override
    public void sogutucuKapat() {
        boolean open =service.sogutucuDurumu();
        if(!open)
            p.EkranaYaz("Cihaz Kapanmadi! \nCihaz zaten kapali");
        else
        {
            service.sogutucuGuncelle(false);
            p.EkranaYaz("Cihaz Kapandi.");
        }
    }
}
