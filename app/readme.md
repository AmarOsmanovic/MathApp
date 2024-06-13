**Dokumentacija za MathApp**

### Opis rada aplikacije

MathApp je obrazovna aplikacija namijenjena korisnicima svih uzrasta, s ciljem poboljšanja njihovih matematičkih vještina kroz interaktivne zadatke. Aplikacija pruža dinamično okruženje u kojem korisnici mogu vježbati osnovne matematičke operacije kao što su sabiranje i oduzimanje. Korisnici se kroz igru suočavaju s različitim zadacima, skupljaju bodove i prate svoj napredak. Aplikacija je dizajnirana da bude intuitivna i jednostavna za korištenje, pružajući korisnicima pozitivno iskustvo učenja.

### Glavne funkcionalnosti

#### Generisanje nasumičnih zadataka

Aplikacija nasumično generiše zadatke koristeći brojeve u rasponu od 0 do 9 i operacije sabiranja i oduzimanja. To osigurava da je svaki zadatak jedinstven i izazovan. Korisnici će se suočiti s različitim kombinacijama brojeva i operacija, što doprinosi raznovrsnosti i zanimljivosti vježbi.

#### Provjera tačnosti odgovora

Korisnici unose svoje odgovore putem intuitivnog korisničkog interfejsa, a aplikacija odmah provjerava tačnost odgovora i daje povratnu informaciju. Kada korisnik unese odgovor, aplikacija ga automatski upoređuje s tačnim rezultatom i prikazuje obavijest o tačnosti unosa.

#### Brojanje bodova

Svaki tačan odgovor donosi bodove. Rezultat se dinamički ažurira i prikazuje korisnicima, motivirajući ih da nastave rješavati zadatke. Korisnici mogu pratiti svoj napredak kroz bodove koje osvajaju za tačne odgovore, što stvara osjećaj postignuća i potiče ih na daljnje vježbanje.

#### Vremensko ograničenje

Svaki zadatak ima vremensko ograničenje od 10 sekundi. Ovaj element igre dodaje dodatni izazov, ohrabrujući korisnike da brzo razmišljaju i donose odluke. Vremensko ograničenje doprinosi dinamici igre i pomaže korisnicima u razvijanju brzine i preciznosti u rješavanju matematičkih problema.

#### Prikaz poruka o uspjehu ili greškama

Aplikacija pruža trenutne povratne informacije u obliku poruka koje obavještavaju korisnike da li su dali tačan ili netačan odgovor. Ove poruke su važne za motivaciju korisnika i pružaju im informacije o njihovom napretku i područjima koja treba poboljšati.

#### Mogućnost ponovnog pokretanja igre

Korisnici imaju opciju da ponovo pokrenu igru nakon završetka, sa svim parametrima resetiranim na početne vrijednosti. Ova funkcionalnost omogućava korisnicima da nastave vježbati bez potrebe za ponovnim pokretanjem aplikacije, pružajući kontinuirano iskustvo učenja.

#### Dijeljenje rezultata

Korisnici mogu podijeliti svoje rezultate sa prijateljima na društvenim mrežama putem integriranog gumba za dijeljenje. Ova funkcionalnost omogućava korisnicima da pokažu svoje postignuće i motiviraju druge da se pridruže igri i vježbaju matematiku.

### Ekrani aplikacije

#### Početni ekran

Ekran dobrodošlice sadrži dugme za pokretanje nove igre. Ovaj ekran pruža osnovne informacije o aplikaciji i njenim pravilima. Korisnicima je omogućeno da brzo započnu novu igru ili saznaju više o aplikaciji kroz opciju "O aplikaciji".

#### Ekran za vježbanje

Glavni ekran aplikacije na kojem se prikazuju matematički zadaci, preostalo vrijeme za rješavanje, trenutni rezultat i polje za unos odgovora. Ovaj ekran je centralno mjesto za interakciju korisnika sa aplikacijom. Dizajniran je tako da korisnicima omogućava jednostavno i fokusirano rješavanje zadataka.

#### Ekran za kraj igre

Nakon što korisnik dostigne maksimalan broj pokušaja ili istekne vrijeme, prikazuje se konačni rezultat i opcije za ponavljanje ili dijeljenje rezultata na društvenim mrežama. Ovaj ekran pruža korisnicima informacije o njihovom ukupnom učinku i omogućava im da podijele svoje postignuće ili započnu novu igru.

### Arhitektura aplikacije

Aplikacija je razvijena koristeći MVVM (Model-View-ViewModel) arhitekturu. Ovakav pristup omogućava jasnu podjelu odgovornosti, što dovodi do bolje organiziranog koda, lakšeg održavanja i bolje skalabilnosti aplikacije.

#### Model

Model predstavlja logiku aplikacije i upravlja podacima. U MathApp-u, model uključuje logiku za generiranje matematičkih problema, provjeru odgovora i upravljanje korisničkim rezultatima i pokušajima. Model je dizajniran da bude nezavisan od slojeva View i ViewModel, omogućavajući lakše testiranje i ponovnu upotrebu koda.

#### Pogled

View je odgovoran za prikazivanje podataka korisniku i odgovaranje na interakcije korisnika. U MathApp-u, View je implementiran pomoću Jetpack Compose, modernog alata za kreiranje korisničkih interfejsa u Android aplikacijama. Jetpack Compose pruža deklarativni pristup kreiranju UI komponenti, čineći kod čistijim i intuitivnijim.

#### ViewModel

ViewModel služi kao posrednik između modela i pogleda. U MathApp-u, ViewModel upravlja podacima igre, kao što su trenutni brojevi za zadatak, operacija, rezultat, preostalo vrijeme, broj pokušaja i poruka o rezultatu. ViewModel također rukuje poslovnom logikom kao što je provjera odgovora i upravljanje tajmerom.

### Opis funkcionalnosti pojedinih klasa

#### MathViewModel

MathViewModel je glavna klasa koja upravlja stanjem igre. Sadrži sve podatke relevantne za igru, kao što su trenutni brojevi za zadatak, operacija, rezultat, preostalo vrijeme, broj pokušaja i poruka o rezultatu. Ova klasa koristi LiveData da obavijesti korisnički interfejs o promjenama podataka, omogućavajući reaktivno programiranje. MathViewModel također upravlja logikom igre, kao što je provjera tačnosti odgovora i upravljanje vremenskim ograničenjem.

#### UI Components

#### ShareButton

ShareButton je složena funkcija koja prikazuje dugme za dijeljenje rezultata na društvenim mrežama. Koristeći klasu Intent, omogućava korisnicima da lako dijele svoje rezultate sa prijateljima i porodicom. Ova funkcionalnost povećava angažman korisnika i omogućava im da podijele svoja postignuća s drugima.

### Opis opštih koncepata Android framework-a

#### Activity

Activity je osnovna komponenta Android aplikacije koja pruža ekran s kojim korisnici mogu komunicirati. Aktivnost je odgovorna za kreiranje korisničkog interfejsa, upravljanje unosom korisnika i reagovanje na događaje kao što su klikovi i unosi. Svaka aplikacija može imati više aktivnosti koje se preklapaju i međusobno komuniciraju.

#### Life cycle activity

Android activity imaju definisan life cycle koji uključuje nekoliko stanja kao što su stvaranje (onCreate), početak (onStart), zaustavljanje (onStop) i uništenje (onDestroy). Razumijevanje životnog ciklusa aktivnosti ključno je za pravilno upravljanje resursima i izbjegavanje curenja memorije. Aktivnosti također mogu proći kroz stanja pauze (onPause) i nastavka (onResume), što omogućava aplikaciji da pohrani i vrati stanje kada korisnik izađe i vrati se u aplikaciju.

#### ViewModel

ViewModel je klasa koja je dizajnirana za skladištenje i upravljanje podacima vezanim za korisnički interfejs. ViewModel preživljava promjene konfiguracije kao što je rotacija ekrana, što omogućava izbjegavanje ponovnog učitavanja podataka i gubitka stanja aplikacije tokom tih promjena. ViewModel radi u kombinaciji sa LiveData kako bi obezbedio reaktivno programiranje, obavještavajući korisnički interfejs o promjenama podataka na efikasan način.

#### LiveData

LiveData je komponenta koja pruža vidljive podatke. LiveData prati promjene podataka i obavještava povezane komponente korisničkog sučelja kada se ti podaci promijene, omogućavajući reaktivno programiranje. Ova komponenta je korisna za osiguravanje da korisnički interfejs uvijek prikazuje ažurirane informacije bez potrebe za ručnim osvježavanjem.

#### Jetpack Compose

Jetpack Compose je moderan komplet alata za kreiranje korisnič

kih interfejsa u Android aplikacijama koristeći Kotlin. Pruža jednostavniji i intuitivniji način za kreiranje UI komponenti kroz deklarativni pristup. Jetpack Compose značajno pojednostavljuje proces razvoja korisničkog interfejsa, omogućavajući programerima da pišu manje koda i brže razvijaju funkcionalnost.

#### Kontekst

Kontekst je klasa koja omogućava pristup resursima i uslugama Android sistema. Kontekst se koristi za pristup resursima (kao što su stringovi, slike i stilovi), bazama podataka, dijeljenje podataka između aktivnosti i pokretanje novih aktivnosti. Postoje različite vrste konteksta, uključujući kontekst aktivnosti i kontekst aplikacije, koji se koriste ovisno o potrebama aplikacije.

### Zaključak

MathApp pruža obrazovno iskustvo kroz zabavne matematičke zadatke, koristeći modernu Android arhitekturu i komponente kao što su ViewModel i Jetpack Compose. Aplikacija je dizajnirana da bude intuitivna i jednostavna za korištenje, pružajući korisnicima pozitivno iskustvo učenja. Dokumentacija pokriva sve aspekte aplikacije, od osnovne funkcionalnosti do detaljnog pregleda arhitekture i pojedinih komponenti, pružajući sve potrebne informacije za razumijevanje i dalji razvoj aplikacije.

Ovaj dokument opisuje kako aplikacija radi, kako je organizovana i koje su njene glavne komponente. Kroz jasno objašnjene koncepte i strukturu, pruža se dubinski uvid u rad aplikacije, što olakšava dalji razvoj i održavanje. Koristeći najbolje prakse za razvoj Android aplikacija, MathApp je dizajniran da bude efikasan, skalabilan i jednostavan za korištenje, pružajući korisnicima pozitivno iskustvo učenja matematike.

MathApp je primjer kako moderna tehnologija može biti korištena za unapređenje obrazovnih procesa. Sa funkcionalnostima kao što su generisanje nasumičnih zadataka, provjera tačnosti odgovora, brojanje bodova, vremensko ograničenje, prikaz poruka o uspjehu ili greškama, mogućnost ponovnog pokretanja igre i dijeljenje rezultata, aplikacija nudi sveobuhvatno i interaktivno iskustvo učenja.

MVVM arhitektura osigurava modularnost i održivost koda, dok korištenje Jetpack Compose-a omogućava brzu i efikasnu izradu korisničkog interfejsa. Upotreba ViewModel i LiveData komponenti omogućava reaktivno programiranje i osigurava da su podaci uvijek ažurirani i dostupni korisničkom interfejsu.

MathApp ne samo da pomaže korisnicima da poboljšaju svoje matematičke vještine, već ih i motivira kroz interaktivne i izazovne zadatke, te mogućnost dijeljenja rezultata s prijateljima. Ova aplikacija predstavlja korak naprijed u obrazovnim tehnologijama, nudeći korisnicima alat koji je istovremeno edukativan i zabavan.

Dokumentacija MathApp-a pruža sve potrebne informacije za razumijevanje i dalji razvoj aplikacije. Detaljno opisuje funkcionalnosti, arhitekturu, komponente i opće koncepte Android framework-a, omogućavajući programerima da lako razumiju i rade na unapređenju aplikacije. Ovaj dokument je ključan resurs za sve koji žele doprinijeti razvoju MathApp-a ili naučiti više o razvoju Android aplikacija koristeći moderne tehnologije i najbolje prakse.