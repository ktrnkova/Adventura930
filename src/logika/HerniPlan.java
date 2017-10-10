package logika;


/**
 * Class HerniPlan - třída představující mapu a stav adventury.
 * 
 * Tato třída inicializuje prvky ze kterých se hra skládá:
 * vytváří všechny prostory, propojuje je vzájemně pomocí východů
 * a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 * @author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova, Jan Riha, Katerina Trnkova
 * @version    ZS 2016/2017
 */
public class HerniPlan {

    private Prostor aktualniProstor;
    private Batoh batoh;
    private Prostor pomocny;
	
    /**
     *  Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví halu.
     */
    public HerniPlan() {
        zalozProstoryHry();
        this.batoh = new Batoh();
    }
    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví muzeum.
     *  Vkládá a vytváří v prostorech věci i postavy.
     */
    private void zalozProstoryHry() {
        // vytvářejí se jednotlivé prostory
        Prostor muzeum = new Prostor("muzeum","Muzeum, ze kterého bylo ukradeno několik věcí");
        Prostor ulice = new Prostor("ulice","Dlouhá ulice");
        Prostor zahrada = new Prostor("zahrada","Botanická zahrada s jedinou květinou");
        Prostor antikvariat = new Prostor("antikvariat","Obchod se starými věcmi");
        Prostor namesti = new Prostor("namesti","Místo pro setkání s nejrůznějšími lidmi");
        Prostor hrbitov = new Prostor("hrbitov","Místo klidu a odpočinku");
        Prostor park = new Prostor("park","Park u náměstí se starým stromem");
        Prostor hriste = new Prostor("hriste","Hřiště s pískovištěm a houpačkami");

        // přiřazují se průchody mezi prostory (sousedící prostory)
        muzeum.setVychod(zahrada);
        muzeum.setVychod(ulice);
        zahrada.setVychod(muzeum);
        ulice.setVychod(muzeum);
        ulice.setVychod(namesti);
        ulice.setVychod(antikvariat);
        antikvariat.setVychod(ulice);
        namesti.setVychod(ulice);
        namesti.setVychod(hrbitov);
        namesti.setVychod(park);
        hrbitov.setVychod(namesti);
        park.setVychod(namesti);
        park.setVychod(hriste);
        hriste.setVychod(park);

        // vytvoříme několik věcí ("nazev", "popis", true=sebratelna/false=neprenositelna)
        //Vec zlateVejce = new Vec ("zlateVejce","Zlaté vejce snesené obyčejnou slepicí",true);
        //Vec prsten = new Vec ("prsten","snubní prsten šesté manželky Jindřicha VIII.",true);
        //Vec indianskaCelenka = new Vec ("indianskaCelenka","Pravá indiánská čelenka z dob Husitů",true);
        //Vec trilobit = new Vec ("trilobit","Opravdu hodně starý kus zkameněliny",true);
        //Vec globus = new Vec ("globus","Docela kulatá miniatura Země",true);
        //Vec mince = new Vec ("mince","Mince z roku 1606",true);
        
        //Vec klic = new Vec ("klic","Klíč k otevření dveří antikvariátu",true);
        
        //Vec babovicka = new Vec ("babovicka","Hračka na pískoviště ve tvaru autíčka",true);
        //Vec potvrzeni = new Vec ("potvrzeni","Potvrzení co se bude hodit",true);
        //Vec kytice = new Vec ("kytice","",false);
        //Vec socha = new Vec ("socha","Fakt zvláštní socha",false);
        //Vec letadlo = new Vec ("letadlo","1. letadlo, které kdy vzlétlo...alespoň to co z něj zbylo",false);
        //Vec strom = new Vec ("strom","999 let starý dub",false);
        //Vec piskoviste = new Vec ("piskoviste","Pískoviště skrývá mnoho věcí",false);

        // umístíme věci do prostorů
        muzeum.vlozVec(new Vec ("letadlo","1. letadlo, které kdy vzlétlo...alespoň to co z něj zbylo",false));
        muzeum.vlozVec(new Vec ("potvrzeni","Potvrzení co se bude hodit",true));
        antikvariat.vlozVec(new Vec ("globus","Docela kulatá miniatura Země",true));
        antikvariat.vlozVec(new Vec ("socha","Fakt zvláštní socha",false));
        namesti.vlozVec(new Vec ("babovicka","Hračka na pískoviště ve tvaru autíčka",true));
        hrbitov.vlozVec(new Vec ("kytice","Kytice se z hrobu neodnašejí!",false));
        hrbitov.vlozVec(new Vec ("mince","Mince z roku 1606",true));
        zahrada.vlozVec(new Vec ("zlateVejce","Zlaté vejce snesené obyčejnou slepicí",true));
        park.vlozVec(new Vec ("trilobit","Opravdu hodně starý kus zkameněliny",true));
        park.vlozVec(new Vec ("strom","999 let starý dub",false));
        hriste.vlozVec(new Vec ("piskoviste","Pískoviště skrývá mnoho věcí",false));
        
        
        
        //vytvoření postav
        Postava zlodej = new Postava("zlodej","\n Jo jo něco takového jsem viděl, vydržte chviličku...PRÁSK");
        Postava prekupnik = new Postava ("prekupnik","\n Vyměním co hledáš, ale nebude to zadarmo");
        Postava majitelObchodu = new Postava ("majitelObchodu","\n Nemůžu věřit každému kdo řekne že je vyšetřovatel" + "\ntohle jsou stašné časy. Nějak se mi prokaž.");
        Postava bambino = new Postava ("bambino","\n Oko za oko, hračku za hračku!!!");
        
        //umístění postav do prostoru
        hrbitov.vlozPostavu(zlodej);
        namesti.vlozPostavu(prekupnik);
        ulice.vlozPostavu(majitelObchodu);
        hriste.vlozPostavu(bambino);
        muzeum.vlozPostavu(new Postava ("vratnik"," Prý ti mám připomenout co vlatně hledáš. \n"
                                        + "je to: zlaté vejce, indiánská čelenka, prsten, trilobit a globus. \n"
                                        + "tak hodně štěstí při hledání!"));
        
        //zamknutá místnost
        antikvariat.setUzamcen(true);
        
        //přiřazení klíče k prostoru/místnosti
        //antikvariat.nastavKlic (klic);
        
        //pomocná promněnná pro prostor antikvariat
        pomocny = antikvariat;
        
        aktualniProstor = muzeum;  // hra začíná v muzeu
        
    }
    
    /**
     * Metoda kterou získáme batoh pro hPlan
     * 
     * @return objekt batoh
     */
    public Batoh getBatoh() {
        return this.batoh;
    }
    
    /**
     *  Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     *@return aktuální prostor
     */
    
    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }
    
    /**
	* Pmocná metoda, uchová nám hodnotu prostor antikvariát.
	*/
	public Prostor getAntikvariat(){
        return pomocny;
    }
    
    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     *@param  prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
       aktualniProstor = prostor;
    }

    /**
     * Metoda řekne zda byla hra vyhrána nebo ne
     * 
     * @return true - hráč vyhrál
     * @return false - hráč nevyhral
	 */
    public boolean hracVyhral() {
              
        return false;
    }
}
