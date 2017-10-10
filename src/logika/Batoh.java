/* Soubor je ulozen v kodovani UTF-8.
 * Kontrola kódování: Příliš žluťoučký kůň úpěl ďábelské ódy. */
package logika;

import java.util.*;

/*******************************************************************************
 * Instance třídy Batoh nám umožní dávat věci do batohu a z batohu,
 * maximální obsah batohu je 8 věcí.
 *
 * Tato třída je součástí jednoduché textové hry.
 *
 * @author    Katerina Trnkova
 * @version   ZS 2016
 */
public class Batoh
{
    //== Datové atributy (statické i instancí)======================================
    private List <Vec> seznamVeci; // Přestavuje seznam věcí v batohu.
    private static final int MAXIMALNI_KAPACITA = 8; // Maximální počet věcí nesených v batohu

    //== Konstruktory a tovární metody =============================================

    /***************************************************************************
     *  Konstruktor seznamu věcí v batohu
     */
    public Batoh()
    {
        seznamVeci = new ArrayList<Vec>();
    }

    //== Nesoukromé metody (instancí i třídy) ======================================
    /**
     * Pokud se věc vejde do batohu pak ji tam vloží
     * @param vec Je vec, kterou chceme přidat do batohu
     * @return vec Když se věc vloží do batohu
     * @return null Pokud se věc do batohu nevloží
     */
    public Vec vlozVec (Vec vec) {
        if (jeNaplnitelny() ) {
            seznamVeci.add(vec);
            return vec;
        }
		// pokud je batoh plný nevloží se 
		System.out.println("Batoh je plný, věc se nevložila");
        return null;
    }
    
    /**
     * Metoda, která kontroluje, zda je v batohu ještě místo pro přidání daší věci
     */
    public boolean jeNaplnitelny(){
        if (seznamVeci.size() < MAXIMALNI_KAPACITA){
            return true;
        }
        return false;
    }
    
    /**
     * Metoda vrátí informaci o tom, zda je daná věc v batohu či ne
	 *
     * @return true , jestliže daná věc v batohu je
     * @return false , jestliže daná věc v batohu není
     */
    public boolean vBatohuJe (String hledana) {
        for(Vec pridavana: seznamVeci){
            if(pridavana.getNazev().equals(hledana)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Metoda nám vypíše seznam všech věcí, které se nacházejí v batohu
     * @retun String (to co se v batohu nachází)
     */
	public String getSeznamVeci(){
        String seznam = "";
        for (Vec vypisovana : seznamVeci){
            if (!seznam.equals("")){
                seznam += ", ";
            }
            seznam += " " + vypisovana.getNazev();
        }
        return seznam;
    }
    
    /**
     * Vyndá věc z batohu
     * return vrátí název věci, která byla odebrána z batohu
     */
    public Vec vyndejVecZBatohu (String odstranovana){
        Vec vyndanaVec = null;
        for(Vec vec: seznamVeci){
            if (vec.getNazev().equals(odstranovana)){
                vyndanaVec = vec;
                seznamVeci.remove(vec);
                break;
            }
        }
        return vyndanaVec;
    }
        
    /**
     * Metoda, která vypíše (zadanou) věc, pokud se v batohu nachází
     * pokud v batohu věc není vrátí se null
     */
    public Vec getVec (String potrebnaVec){
        Vec hledana = null;
        for(Vec porovnavana: seznamVeci){
            if(porovnavana.getNazev().equals(potrebnaVec)){
                hledana = porovnavana;
                break;
            }
        }
        return hledana;
    }
        
        /**
     *  Metoda zjišťuje, zda se daná věc vyskytuje v batohu.
     *  
     *  @param  vec  Parametrem je věc, na kterou se ptáme.
     */   
    public boolean obsahujeVec (String nazev) {
        if (this.seznamVeci.contains(nazev)) {
            return true;
        }
        return false;
    }
    
    /**
     * Vypíše jaká je kapacita batohu
     */
    public int getMaximalniKapacita(){
        return MAXIMALNI_KAPACITA;
    }
    
    //== Soukromé metody (instancí i třídy) ========================================
    
    }
