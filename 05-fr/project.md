# System aukcyjny

## Wprowadzenie

Specyfikacja wymagań funkcjonalnych w ramach informatyzacji procesu sprzedaży produktów w oparciu o mechanizm aukcyjny. 

## Procesy biznesowe

---
<a id="bc1"></a>
### BC1: Sprzedaż aukcyjna 

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Opis:** Proces biznesowy opisujący sprzedaż za pomocą mechanizmu aukcyjnego. |

**Scenariusz główny:**
1. [Sprzedający](#ac1) wystawia produkt na aukcję. ([UC1](#uc1))
2. [Kupujący](#ac2) oferuje kwotę za produkt wyższą od aktualnie najwyższej oferty. ([BR1](#br1))
3. [Kupujący](#ac2) wygrywa aukcję ([BR2](#br2))
4. [Kupujący](#ac2) przekazuje należność Sprzedającemu.
5. [Sprzedający](#ac1) przekazuje produkt Kupującemu.

**Scenariusze alternatywne:** 

2.A. Oferta Kupującego została przebita, a [Kupujący](#ac2) pragnie przebić aktualnie najwyższą ofertę.
* 2.A.1. Przejdź do kroku 2.

3.A. Czas aukcji upłynął i [Kupujący](#ac2) przegrał aukcję. ([BR2](#br2))
* 3.A.1. Koniec przypadku użycia.

---

## Aktorzy

<a id="ac1"></a>
### AC1: Sprzedający

Osoba oferująca towar na aukcji.

<a id="ac2"></a>
### AC2: Kupujący

Osoba chcąca zakupić produkt na aukcji.


## Przypadki użycia poziomu użytkownika

### Aktorzy i ich cele

[Sprzedający](#ac1):
* [UC1](#uc1): Wystawienie produktu na aukcję
* [UC3](#uc3): Transfer należności po zakończeniu aukcji
* [UC4](#uc4): Transfer produktu po zakończeniu aukcji
* [UC6](#uc6): Wycofanie produktu z aukcji

[Kupujący](#ac2):
* [UC2](#uc2): Zalicytowanie produktu na aukcji
* [UC3](#uc3): Transfer należności po zakończeniu aukcji
* [UC4](#uc4): Transfer produktu po zakończeniu aukcji
* [UC5](#uc5): Przegrana kupującego

---
<a id="uc1"></a>
### UC1: Wystawienie produktu na aukcję

**Aktorzy:** [Sprzedający](#ac1)

**Scenariusz główny:**
1. [Sprzedający](#ac1) zgłasza do systemu chęć wystawienia produktu na aukcję.
2. System prosi o podanie danych produktu i ceny wywoławczej.
3. [Sprzedający](#ac1) podaje dane produktu oraz cenę wywoławczą.
4. System weryfikuje poprawność danych.
5. System informuje o pomyślnym wystawieniu produktu na aukcję.

**Scenariusze alternatywne:** 

4.A. Podano niepoprawne lub niekompletne dane produktu.
* 4.A.1. System informuje o błędnie podanych danych.
* 4.A.2. Przejdź do kroku 2.

---

<a id="uc2"></a>
### UC2: Zalicytowanie produktu na aukcji

**Aktorzy:** [Kupujący](#ac2)

**Scenariusz główny:**
1. [Kupujący](#ac2) zgłasza do systemu chęć zalicytowania przedmiotu na aukcji.
2. System prosi o podanie kwoty.
3. [Kupujący](#ac2) wprowadza żądaną kwotę.
4. System weryfikuje podaną kwotę.
5. System informuje o pomyślnym zalicytowaniu.

**Scenariusze alternatywne:** 

4.A. 
* 4.A.1. System informuje o błędnym podaniu kwoty.
* 4.A.1. Przejdż do kroku 2.

---

<a id="uc3"></a>
### UC3: Transfer należności po zakończeniu aukcji

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**
1. [Kupujący](#ac2) wygrywa aukcję.
2. [Kupujący](#ac2) wpłaca należność do systemu.
3. System weryfikuje czy wpłynęła odpowiednia należność.
4. Należnosc zostaje wysłana do doręczenia [Sprzedającemu](#ac1).

**Scenariusze alternatywne:** 
3.A.
* 3.A.1 System informuje o wpłynięciu nieodpowiedniej należności.
* 3.A.2 Przejdź do kroku 2.

---

<a id="uc4"></a>
### UC4: Transfer produktu po zakończeniu aukcji

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**
1. [Kupujący](#ac2) wygrywa aukcję.
2. [Sprzedający](#ac1) oddaje produkt do systemu.
3. System weryfikuje czy oddany został prawidłowy produkt.
4. Produkt zostaje wysłany do doręczenie [Kupującemu](#ac2).

**Scenariusze alternatywne:** 
3.A.
* 3.A.1 System informuje o oddaniu nieprawidłowego przedmiotu.
* 3.A.2 System zwraca nieprawidłowy przedmiot.
* 3.A.3 Przejdź do kroku 2.

---

## Obiekty biznesowe (inaczej obiekty dziedzinowe lub informacyjne)

### BO1: Aukcja

Aukcja jest formą zawierania transakcji kupna-sprzedaży, w której Sprzedający określa cenę wywoławczą produktu, natomiast Kupujący mogą oferować własną ofertę zakupu każdorazowo proponując kwotę wyższą od aktualnie oferowanej kwoty. Aukcja kończy się po upływie określonego czasu. Jeśli złożona została co najmniej jedna oferta zakupy produkt nabywa ten Kupujący, który zaproponował najwyższą kwotę. 

### BO2: Produkt

Fizyczny lub cyfrowy obiekt, który ma zostać sprzedany w ramach aukcji.

## Reguły biznesowe

<a id="br1"></a>
### BR1: Złożenie oferty

Złożenie oferty wymaga zaproponowania kwoty wyższej niż aktualnie oferowana o minimum 1,00 PLN.


<a id="br2"></a>
### BR2: Rozstrzygnięcie aukcji

Aukcję wygrywa ten z [Kupujący](#ac2)ch, który w momencie jej zakończenia (upłynięcia czasu) złożył najwyższą ofertę.

## Macierz CRUDL


| Przypadek użycia                                  | Aukcja | Produkt | ... |
| ------------------------------------------------- | ------ | ------- | --- |
| UC1: Wystawienia produktu na aukcję               |    C   |    C    | ... |
| UC2: Zalicytowanie produktu na aukcji             |  U,R   |    U    | ... |
| UC3: Transfer należności po zakończeniu aukcji    |  U,D   |    U    | ... |
| UC4: Transfer produktu po zakończeniu aukcji      |  U,D   |    U,D  | ... |


